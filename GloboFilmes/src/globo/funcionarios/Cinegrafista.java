package globo.funcionarios;

import globo.filmes.Filme; 

public class Cinegrafista extends Funcionario { 
    public Cinegrafista(String nome, String id) {
        super(nome, id); 
    }

    public void adicionarFuncao(String funcao, Filme filme) { 
        adicionarParticipacao(funcao, filme); 
    }
}
