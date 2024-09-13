package globo.intermediarias;

import globo.filmes.Filme;
import globo.funcionarios.Diretor;

// Classe intermediária conectando Diretor e Filme - método Expert
public class DiretorFilme {
    private Diretor diretor; // composição aqui
    private Filme filme; // composição aqui

    public DiretorFilme(Diretor diretor, Filme filme) {
        this.diretor = diretor;
        this.filme = filme;
    }

    public void exibirDiretorNoFilme() {
        System.out.println(diretor.getNome() + " dirigiu o filme " + filme.getNome());
    }

    public Diretor getDiretor() { // encapsulamento aqui
        return diretor;
    }

    public Filme getFilme() { // encapsulamento aqui
        return filme;
    }
}
