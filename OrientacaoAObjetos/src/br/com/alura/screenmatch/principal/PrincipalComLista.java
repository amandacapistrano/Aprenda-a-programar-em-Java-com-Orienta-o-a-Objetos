package br.com.alura.screenmatch.principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

public class PrincipalComLista {
	public static void main(String[] args) {
		Filme meuFilme = new Filme("Cargo", 1999);
		meuFilme.avalia(9);
		Filme filme2 = new Filme("Barbie", 2023);
		filme2.avalia(6);
		Serie lost = new Serie("Lost", 2000);
		
		//ArrayList<Titulo> listaDeAssistidos = new ArrayList<>();
		//pode se usar List
		//interface List
		List<Titulo> listaDeAssistidos = new LinkedList<>();	
		listaDeAssistidos.add(meuFilme);
		listaDeAssistidos.add(filme2);
		listaDeAssistidos.add(lost);
		
		//Filme f1 = meuFilme;
		//System.out.println("Teste " + f1.toString());
		
		//impressão dos itens listas
		for (Titulo item: listaDeAssistidos) {
			System.out.println(item.getNome());
			//para ter classificação nos filmes sem erro já que em série não tem
			if(item instanceof Filme filme && filme.getClassificacao()>2) {
				System.out.println("Classificação " + filme.getClassificacao());
			
			}
		}
		
		ArrayList<String> buscaPorArtista = new ArrayList<>();
		buscaPorArtista.add("Adam");
		buscaPorArtista.add("Paulo");
		buscaPorArtista.add("Amanda");
		System.out.println(buscaPorArtista);
		
		//Ordenação da lista
		Collections.sort(buscaPorArtista);
		System.out.println("Depois da ordenação: " + buscaPorArtista);
		
		
		System.out.println("Titulos ordenados");
		//É implementado o compareTo na classe Titulo para usar o sort
		Collections.sort(listaDeAssistidos);
		//É implementado o compareTo para usar o sort
		//O nome da série não é impresso pois não esta com o método toString implementado
		System.out.println(listaDeAssistidos);
		
		
		//comparação de anos - COMPARATOR para comparar os anos
		listaDeAssistidos.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
		System.out.println("Ordenando por ano: " + listaDeAssistidos);
	}
	
}
