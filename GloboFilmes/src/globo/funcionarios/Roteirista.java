package globo.funcionarios;

import globo.filmes.Filme;

public class Roteirista extends Funcionario implements Trabalhos {

	public Roteirista(String nome, String id) {
        super(nome, id);
    }
    
    public void adicionarFuncao(String funcao, Filme filme) {
        adicionarParticipacao(funcao, filme);
    }
    
    @Override
    public String getFuncao() {
        return "Roteirista";
    }

    @Override
    public String getNome() {
        return super.getNome();
    }
}
