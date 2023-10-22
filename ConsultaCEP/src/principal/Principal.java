package principal;
import java.io.IOException;
import java.util.Scanner;

import metodos.Consulta;
import metodos.GeraArquivo;
import modelo.Endereco;

public class Principal {
	public static void main(String[] args) throws IOException {
		
		Scanner leitor = new Scanner(System.in);
		System.out.println("Insira o CEP para busca-lo: ");
		String cepBuscado = leitor.nextLine();
		
		Consulta consultaCep = new Consulta();
		
		try {
			Endereco novoEndereco = consultaCep.buscaEndereco(cepBuscado);
			System.out.println(novoEndereco);
			
			
			GeraArquivo gerador = new GeraArquivo();
			gerador.geraJson(novoEndereco);
			
			
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			System.out.println("Finalizando aplicação");
		}
	}
}
