package globo.intermediarias;

import globo.filmes.Filme;
import globo.funcionarios.Ator;


//método Expert
public class AtorFilme {
    private Ator ator; 
    private Filme filme;

    public AtorFilme(Ator ator, Filme filme) {
        this.ator = ator;
        this.filme = filme;
    }

    public void exibirAtorNoFilme() {
        System.out.println(ator.getNome() + " atuou no filme " + filme.getNome());
    }

    public Ator getAtor() { 
        return ator;
    }

    public Filme getFilme() { 
        return filme;
    }
}
