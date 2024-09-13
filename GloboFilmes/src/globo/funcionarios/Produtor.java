package globo.funcionarios;

import globo.filmes.Filme; 
import java.util.List;


public class Produtor extends Funcionario { 
    public Produtor(String nome, String id) {
        super(nome, id); 
    }

    public void adicionarFuncao(String funcao, Filme filme) { 
        adicionarParticipacao(funcao, filme); 
    }

    public List<Participacao> getParticipacoes() {
        return participacoes;
    }

}
