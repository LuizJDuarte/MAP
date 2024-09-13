package globo.intermediarias;

import globo.filmes.Filme;
import globo.funcionarios.Funcionario;

// Classe intermediária conectando Funcionario e Filme - método Expert
public class FuncionarioFilme {
    private Funcionario funcionario; // composição aqui
    private Filme filme; // composição aqui
    private String funcao; // função que o funcionário exerce no filme

    public FuncionarioFilme(Funcionario funcionario, Filme filme) {
        this.funcionario = funcionario;
        this.filme = filme;
    }


    // Exibir a função do funcionário no filme
    public void exibirFuncionarioNoFilme() {
        System.out.println(funcionario.getNome() + " trabalhou como " + funcao + " no filme " + filme.getNome());
    }

    public Funcionario getFuncionario() { // encapsulamento aqui
        return funcionario;
    }

    public Filme getFilme() { // encapsulamento aqui
        return filme;
    }

    public String getFuncao() { // encapsulamento aqui
        return funcao;
    }
}
