package globo.intermediarias;

import globo.filmes.Filme;
import globo.funcionarios.Roteirista;

// Classe intermediária conectando Roteirista e Filme - método Expert
public class RoteiristaFilme {
    private Roteirista roteirista; // composição aqui
    private Filme filme; // composição aqui

    public RoteiristaFilme(Roteirista roteirista, Filme filme) {
        this.roteirista = roteirista;
        this.filme = filme;
    }

    public void exibirRoteiristaNoFilme() {
        System.out.println(roteirista.getNome() + " escreveu o roteiro do filme " + filme.getNome());
    }

    public Roteirista getRoteirista() { // encapsulamento aqui
        return roteirista;
    }

    public Filme getFilme() { // encapsulamento aqui
        return filme;
    }
}
