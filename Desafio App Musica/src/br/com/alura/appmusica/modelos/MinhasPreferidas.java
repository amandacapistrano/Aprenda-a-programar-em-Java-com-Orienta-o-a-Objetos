package br.com.alura.appmusica.modelos;

public class MinhasPreferidas {

    public void inclui(Audio audio) {
        if(audio.getClassificacao() > 9) {
            System.out.println(audio.getTitulo() + " nota: " +audio.getClassificacao() + ", é considerado sucesso absoluto" +
                    " e preferido por todos!");
        } else {
            System.out.println(audio.getTitulo() +" nota: "+audio.getClassificacao()+ ", também é um dos que todo mundo está " +
                    "curtindo");
        }
    }
}
