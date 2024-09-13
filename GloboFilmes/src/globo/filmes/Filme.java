package globo.filmes;

public class Filme { 
    private String nome; 
    private int ano; 
    private String genero; 
    private String duracao; 

    public Filme(String nome, int ano, String genero, String duracao) { 
        this.nome = nome;
        this.ano = ano;
        this.genero = genero;
        this.duracao = duracao;
    }

    public String getNome() {
        return nome;
    }

    public int getAno() { 
        return ano;
    }

    public String getGenero() { 
        return genero;
    }

    public String getDuracao() { 
        return duracao;
    }
}
