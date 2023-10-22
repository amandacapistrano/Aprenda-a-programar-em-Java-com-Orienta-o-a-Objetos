package br.com.alura.screenmatch.principal;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOMDB;

public class PrincipalComBusca {
	public static void main(String[] args) throws IOException, InterruptedException{
		Scanner leitura = new Scanner(System.in);
		
		String busca ="";
		List<Titulo> titulos = new ArrayList<>();
		
		Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();		//Titulo meuTitulo = gson.fromJson(json, Titulo.class);

		while(!busca.equalsIgnoreCase("sair")) {
			
			System.out.println("Digite um filme para busca: ");
			busca = leitura.nextLine();
			
			if(busca.equalsIgnoreCase("sair")) {
				break;
			}
			
			String endereco = "http://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=7354e8c";
			
			try {
				HttpClient client = HttpClient.newHttpClient();
				HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
			
				HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		
				String json = response.body();
				System.out.println(json);
								
				TituloOMDB meuTituloOMDB = gson.fromJson(json, TituloOMDB.class);
		
				System.out.println(meuTituloOMDB);
				
			//tratamento de excessoes
			//try {
				Titulo meuTitulo = new Titulo(meuTituloOMDB);
				System.out.println("Meu Titulo:");
				System.out.println(meuTitulo);
				
				//FileWriter escrita =  new FileWriter("filmes.txt");
				//escrita.write(meuTitulo.toString());
				//escrita.close();
				titulos.add(meuTitulo);
				
			} catch(NumberFormatException e) {
				System.out.println("Aconteceu um erro");
				System.out.println(e.getMessage());
			} catch(IllegalArgumentException e){
				System.out.println("Erro no endereço");
			} catch (ErroDeConversaoDeAnoException e) {
	            System.out.println(e.getMessage());
	        }
			
		}
		System.out.println(titulos);
		
		FileWriter escrita = new FileWriter("filmes.json");
		escrita.write(gson.toJson(titulos));
		escrita.close();

		System.out.println("Programa Finalizado");

	}
}
