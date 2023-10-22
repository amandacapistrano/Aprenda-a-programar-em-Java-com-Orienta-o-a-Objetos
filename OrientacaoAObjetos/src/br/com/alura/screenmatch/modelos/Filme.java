package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.calculos.Classificavel;
//classificavel como interface
public class Filme extends Titulo implements Classificavel{
		
	public Filme(String nome, int anoDeLancamento) {
		super(nome, anoDeLancamento);
		// TODO Auto-generated constructor stub
	}

		private String diretor;

		//construtor

		public String getDiretor() {
			return diretor;
		}

		public void setDiretor(String diretor) {
			this.diretor = diretor;
		}

		@Override
		public int getClassificacao() {
			//casting
			return (int) pegaMedia() / 2;
		}
		
		//Para imprimir o nome do filme
		@Override
		public String toString() {
			return "Filme : " + this.getNome() + " (" + this.getAnoDeLancamento() + ")";
			
		}
		
	}
 