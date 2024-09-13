package globo.intermediarias;

import globo.filmes.Filme;
import globo.funcionarios.Produtor;

// Classe intermediária conectando Produtor e Filme - método Expert
public class ProdutorFilme {
    private Produtor produtor; // composição aqui
    private Filme filme; // composição aqui

    public ProdutorFilme(Produtor produtor, Filme filme) {
        this.produtor = produtor;
        this.filme = filme;
    }

    public void exibirProdutorNoFilme() {
        System.out.println(produtor.getNome() + " produziu o filme " + filme.getNome());
    }

    public Produtor getProdutor() { // encapsulamento aqui
        return produtor;
    }

    public Filme getFilme() { // encapsulamento aqui
        return filme;
    }
}
