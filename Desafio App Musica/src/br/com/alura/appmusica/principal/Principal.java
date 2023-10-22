package br.com.alura.appmusica.principal;

import br.com.alura.appmusica.modelos.MinhasPreferidas;
import br.com.alura.appmusica.modelos.Musica;
import br.com.alura.appmusica.modelos.Podcast;


public class Principal {
	public static void main(String[] args) {
		Musica minhaMusica = new Musica();
		minhaMusica.setTitulo("Forever");
		minhaMusica.setCantor("Kiss");
		for(int i = 0; i < 1000; i++) {
			minhaMusica.reproduz();
		}
	
		
		Podcast newpod = new Podcast();
		newpod.setTitulo("Nome do pod");
		newpod.setApresentador("Apresentador");
		for(int i = 0; i< 1000; i++){
			newpod.curte();
		}
				
		MinhasPreferidas preferidas = new MinhasPreferidas();
		preferidas.inclui(minhaMusica);
		preferidas.inclui(newpod);
		
		
		
	}
}
