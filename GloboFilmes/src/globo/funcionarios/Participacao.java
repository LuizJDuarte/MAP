package globo.funcionarios;

import java.util.ArrayList; // composição aqui
import java.util.List; // composição aqui
import globo.filmes.Filme; // composição aqui

public class Participacao {
    private Filme filme; // composição aqui
    private List<String> funcoes; // composição aqui

    public Participacao(Filme filme) {
        this.filme = filme;
        this.funcoes = new ArrayList<>(); // composição aqui
    }

    public Filme getFilme() { // encapsulamento aqui
        return filme;
    }

    public List<String> getFuncoes() { // encapsulamento aqui
        return funcoes;
    }

    public void adicionarFuncao(String funcao) { // interface aqui
        if (!funcoes.contains(funcao)) {
            funcoes.add(funcao); // composição aqui
        }
    }
}
