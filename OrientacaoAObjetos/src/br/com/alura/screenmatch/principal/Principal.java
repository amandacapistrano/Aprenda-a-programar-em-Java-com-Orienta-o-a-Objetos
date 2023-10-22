package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

import java.util.ArrayList;

import br.com.alura.screenmatch.calculos.CalculadoradeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;

public class Principal {
	public static void main(String[] args) {
		Filme meuFilme = new Filme("Cargo", 1999);
		meuFilme.setDuracaoEmMinutos(120);
		meuFilme.setIncluidoNoPlano(true);

		meuFilme.exibeFichaTecnica();
		meuFilme.avalia(5);
		meuFilme.avalia(10);
		
		Filme filme2 = new Filme("Barbie", 2023);
		filme2.setDuracaoEmMinutos(120);
		filme2.avalia(10);
		
		//ARRAY LIST
		ArrayList<Filme> listaDeFilmes = new ArrayList<>();
		listaDeFilmes.add(meuFilme);
		listaDeFilmes.add(filme2);
		System.out.println("\nTamanho da lista de filmes: " + listaDeFilmes.size());
		System.out.println("\nPrimeiro filme da lista " + listaDeFilmes.get(0).toString());
		
		System.out.println("Todos os filmes: " + listaDeFilmes);
		
		
		
		System.out.println("\n\n");
		
		System.out.println("Total de avaliações: "+ meuFilme.getTotalDeAvaliacoes());
		System.out.println(meuFilme.pegaMedia());
		
		
		Serie lost = new Serie("Lost", 2000);
		lost.setIncluidoNoPlano(true);
		lost.setAtiva(true);
		lost.exibeFichaTecnica();
		lost.setTemporadas(10);
		lost.setEpisodiosPorTemporada(10);
		lost.setMinutosPorEpisodio(50);
		System.out.println("Duração para maratonar: " + lost.getDuracaoEmMinutos());
		
		CalculadoradeTempo calculadora = new CalculadoradeTempo();
		calculadora.inclui(meuFilme);
		calculadora.inclui(lost);
		System.out.println("Tempo total: " + calculadora.getTempoTotal());
		
		FiltroRecomendacao filtro = new FiltroRecomendacao();
		filtro.filtra(meuFilme);
		
		Episodio episodio = new Episodio();
		episodio.setNumero(1);
		episodio.setSerie(lost);
		episodio.setTotalVisualizacoes(300);
		filtro.filtra(episodio);
	}
}
