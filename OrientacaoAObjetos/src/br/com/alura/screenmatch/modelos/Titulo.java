package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;

//interface comparable para usar o collections
public class Titulo  implements Comparable<Titulo>{
	private String nome;
	
	//@SerializedName("Year")
	private int anoDeLancamento;
	
	private boolean incluidoNoPlano;
	//private: apenas a própria classe tem acesso
	private double somaDasAvalicoes;
	private int totalDeAvaliacoes;
	private int duracaoEmMinutos;
	
	
	public Titulo(String nome, int anoDeLancamento) {
		this.nome = nome;
		this.anoDeLancamento = anoDeLancamento;
	}
	
	public Titulo(TituloOMDB meuTituloOMDB) throws ErroDeConversaoDeAnoException {
		this.nome = meuTituloOMDB.title();
		if(meuTituloOMDB.year().length() > 4) {
			throw new ErroDeConversaoDeAnoException("Ano com mais de 4 caracteres");
		}
		this.anoDeLancamento = Integer.valueOf(meuTituloOMDB.year());
		this.duracaoEmMinutos = Integer.valueOf(meuTituloOMDB.runtime().substring(0,3));
		
	}

	//método para que outra classe tenha acesso ao total de avaliacoes
	public int getTotalDeAvaliacoes() {
		return totalDeAvaliacoes;
	}
	public double pegaMedia() {
		return somaDasAvalicoes / totalDeAvaliacoes;
	}

	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getAnoDeLancamento() {
		return anoDeLancamento;
	}

	public void setAnoDeLancamento(int anoDeLancamento) {
		this.anoDeLancamento = anoDeLancamento;
	}

	public int getDuracaoEmMinutos() {
		return duracaoEmMinutos;
	}

	public void setDuracaoEmMinutos(int duracaoEmMinutos) {
		this.duracaoEmMinutos = duracaoEmMinutos;
	}

	public boolean isIncluidoNoPlano() {
		return incluidoNoPlano;
	}

	public void setIncluidoNoPlano(boolean incluidoNoPlano) {
		this.incluidoNoPlano = incluidoNoPlano;
	}
	
	
	public void exibeFichaTecnica() {
		System.out.println("Nome: " + getNome());
		System.out.println("Ano de lançamento: " + getAnoDeLancamento());
		System.out.println("Duração: "+getDuracaoEmMinutos() + " minutos");
		System.out.println("Incluído no plano: " + isIncluidoNoPlano());
	}

	public void avalia(double nota) {
		somaDasAvalicoes += nota;
		totalDeAvaliacoes++;
	}
//método da interface -- para rodar o collection no PrincipalComLista
	@Override
	public int compareTo(Titulo outroTitulo) {
		return this.getNome().compareTo(outroTitulo.getNome());
	}

	@Override
	public String toString() {
		return "Nome: " + nome + ", ano de lancamento: " + anoDeLancamento + ", " + "Tempo de duração: " + duracaoEmMinutos ;
	}
	
	
	

}
