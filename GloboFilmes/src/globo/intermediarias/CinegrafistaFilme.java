package globo.intermediarias;

import globo.filmes.Filme;
import globo.funcionarios.Cinegrafista;

// Classe intermediária conectando Cinegrafista e Filme - método Expert
public class CinegrafistaFilme {
    private Cinegrafista cinegrafista; // composição aqui
    private Filme filme; // composição aqui

    public CinegrafistaFilme(Cinegrafista cinegrafista, Filme filme) {
        this.cinegrafista = cinegrafista;
        this.filme = filme;
    }

    public void exibirCinegrafistaNoFilme() {
        System.out.println(cinegrafista.getNome() + " trabalhou como cinegrafista no filme " + filme.getNome());
    }

    public Cinegrafista getCinegrafista() { // encapsulamento aqui
        return cinegrafista;
    }

    public Filme getFilme() { // encapsulamento aqui
        return filme;
    }
}
