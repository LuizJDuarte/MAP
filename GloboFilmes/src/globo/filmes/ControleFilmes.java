package globo.filmes;

import java.util.ArrayList;
import java.util.List;

public class ControleFilmes {
    private List<Filme> filmes; 

    public ControleFilmes() {
        this.filmes = new ArrayList<>();
    }

    //Cadastrar um novo filme
    public void cadastrarFilme(Filme filme) {
        filmes.add(filme); 
    }

    //Buscar filme pelo nome
    public Filme buscarFilme(String nome) {
        for (Filme filme : filmes) {
            if (filme.getNome().equalsIgnoreCase(nome)) {
                return filme;
            }
        }
        return null;
    }

    // Listar todos os filmes cadastrados
    public List<Filme> listarFilmes() {
        return new ArrayList<>(filmes); 
    }
}
