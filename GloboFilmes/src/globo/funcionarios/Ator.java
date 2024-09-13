package globo.funcionarios;

import java.util.List;

import globo.filmes.Filme; 

public class Ator extends Funcionario { // herança aqui
    public Ator(String nome, String id) {
        super(nome, id); 
    }

    public void adicionarFuncao(String funcao, Filme filme) { 
        adicionarParticipacao(funcao, filme); 
    }

    public List<Participacao> getParticipacoes() {
        return participacoes;
    }
}
