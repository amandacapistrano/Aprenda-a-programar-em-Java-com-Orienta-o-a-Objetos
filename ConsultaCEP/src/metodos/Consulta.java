package metodos;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import modelo.Endereco;

public class Consulta {
	//REQUISIÇÃO PARA A API
	public Endereco buscaEndereco(String cep) {
		
		URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json/");

		   HttpRequest request = HttpRequest.newBuilder()
		         .uri(endereco)
		         .build();
		   
		
		try {
			HttpResponse<String> response = HttpClient.newHttpClient()
				     .send(request, HttpResponse.BodyHandlers.ofString());
			
		    return new Gson().fromJson(response.body(), Endereco.class);

		    
		} catch (Exception e) {
			throw new RuntimeException("Não consegui buscar o endereço com esse CEP");
	
		}

	}

}
