package globo.funcionarios;

import java.util.ArrayList; 
import java.util.List; 
import globo.filmes.Filme; 

public class Funcionario {
    private String nome; 
    private String id; 
    protected List<Participacao> participacoes; 

    public Funcionario(String nome, String id) {
        this.nome = nome;
        this.id = id;
        this.participacoes = new ArrayList<>(); 
    }

    // Adicionar uma função para um determinado filme
    public void adicionarParticipacao(String funcao, Filme filme) { 
        Participacao participacao = buscarParticipacao(filme); 
        if (participacao == null) {
            participacao = new Participacao(filme); 
            participacoes.add(participacao);
        }
        participacao.adicionarFuncao(funcao); 
    }

    private Participacao buscarParticipacao(Filme filme) {
        for (Participacao p : participacoes) {
            if (p.getFilme().equals(filme)) {
                return p;
            }
        }
        return null;
    }

    public String getNome() { 
        return nome;
    }

    public void imprimirFilmografia() { 
        System.out.println("Funcionario " + nome + " participações em filmes:");
        for (Participacao p : participacoes) {
            System.out.println("    Participou em " + p.getFilme().getNome() + " (" + p.getFilme().getAno() + ") como:");
            for (String funcao : p.getFuncoes()) {
                System.out.println("        " + funcao);
            }
        }
        System.out.println();
    }
}
