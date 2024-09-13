package globo.creator;

import globo.filmes.Filme;
import globo.funcionarios.Funcionario;

public class Creator {

    //criar um filme
    public Filme criarFilme(String nome, int ano, String genero, String duracao) {
        return new Filme(nome, ano, genero, duracao); 
    }

    //criar um Ator
    public Funcionario criarAtor(String nome, String id, Filme filme) {
        Funcionario ator = new Funcionario(nome, id); 
        ator.adicionarParticipacao("Ator", filme); 
        return ator;
    }

    //criar um Diretor
    public Funcionario criarDiretor(String nome, String id, Filme filme) {
        Funcionario diretor = new Funcionario(nome, id); 
        diretor.adicionarParticipacao("Diretor", filme); 
        return diretor;
    }

    //criar um Cinegrafista
    public Funcionario criarCinegrafista(String nome, String id, Filme filme) {
        Funcionario cinegrafista = new Funcionario(nome, id); 
        cinegrafista.adicionarParticipacao("Cinegrafista", filme);
        return cinegrafista;
    }

    //criar um Produtor
    public Funcionario criarProdutor(String nome, String id, Filme filme) {
        Funcionario produtor = new Funcionario(nome, id); 
        produtor.adicionarParticipacao("Produtor", filme); 
        return produtor;
    }

    //criar um Roteirista
    public Funcionario criarRoteirista(String nome, String id, Filme filme) {
        Funcionario roteirista = new Funcionario(nome, id); 
        roteirista.adicionarParticipacao("Roteirista", filme); 
        return roteirista;
    }

    // adicionar nova função funcionário existente
    public void adicionarFuncao(Funcionario funcionario, String funcao, Filme filme) {
        funcionario.adicionarParticipacao(funcao, filme);
    }
}
