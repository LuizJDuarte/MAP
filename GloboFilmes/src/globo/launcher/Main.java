package globo.launcher;

import globo.creator.Creator;
import globo.filmes.Filme;
import globo.filmes.ControleFilmes;
import globo.funcionarios.Funcionario;
import globo.exceptions.FilmeInvalidoException;
import globo.exceptions.FilmeNaoEncontradoException;

public class Main {
    public static void main(String[] args)  {
        Creator creator = new Creator();
		ControleFilmes controleFilmes = new ControleFilmes();

		//criar e cadastrar os filmes usando o Creator
		Filme filme1 = creator.criarFilme("UEPB o Filme", 2024, "Drama", "2h");
		Filme filme2 = creator.criarFilme("Alan Turing e Elon Musk", 2025, "Ficção Científica", "2h 30min");
		Filme filme3 = creator.criarFilme("A Grande Produção", 2026, "Aventura", "1h 45min");

		controleFilmes.cadastrarFilme(filme1);
		controleFilmes.cadastrarFilme(filme2);
		controleFilmes.cadastrarFilme(filme3);

		//criar funcionários e associar varias funções usando o Creator
		Funcionario ator1 = creator.criarAtor("Luiz José", "001", filme1);
		Funcionario diretor1 = creator.criarDiretor("Sabrina", "002", filme1);
		Funcionario cinegrafista1 = creator.criarCinegrafista("Raquel Melo", "003", filme2);
		Funcionario produtor1 = creator.criarProdutor("Paulo", "004", filme3);
		Funcionario roteirista1 = creator.criarRoteirista("Maxwell", "005", filme2);
		Funcionario ator2 = creator.criarAtor("Ana Isabella", "006", filme2);
		Funcionario diretor2 = creator.criarDiretor("Thiago", "007", filme3);
		Funcionario cinegrafista2 = creator.criarCinegrafista("Fábio Leite", "008", filme1);

		
		creator.adicionarFuncao(ator1, "Diretor", filme3); 
		creator.adicionarFuncao(ator1, "Produtor", filme3); 
		creator.adicionarFuncao(ator1, "Ator", filme3); 


		creator.adicionarFuncao(cinegrafista1, "Diretor", filme3);
		creator.adicionarFuncao(cinegrafista1, "Produtor", filme3);
		creator.adicionarFuncao(cinegrafista1, "Ator", filme1);


		creator.adicionarFuncao(roteirista1, "Roteirista", filme1);
		creator.adicionarFuncao(cinegrafista1, "Cinegrafista", filme1);
		creator.adicionarFuncao(diretor1, "Diretor", filme2); 
		creator.adicionarFuncao(produtor1, "Produtor", filme2);
		creator.adicionarFuncao(ator2, "Ator", filme3);
		creator.adicionarFuncao(diretor2, "Diretor", filme2); 
		creator.adicionarFuncao(cinegrafista2, "Cinegrafista", filme2);


		System.out.println("======================================");
		System.out.println("Filme: " + filme1.getNome() + " (" + filme1.getAno() + ")");
		System.out.println("Gênero: " + filme1.getGenero());
		System.out.println("Duração: " + filme1.getDuracao());
		System.out.println("Funcionários do filme:");
		System.out.println("    Ator:");
		System.out.println("         " + ator1.getNome());
		System.out.println("         " + cinegrafista1.getNome()); 
		System.out.println("    Diretor:");
		System.out.println("         " + diretor1.getNome());
		System.out.println("    Cinegrafista:");
		System.out.println("         " + cinegrafista2.getNome());
		System.out.println("    Roteirista:");
		System.out.println("         " + roteirista1.getNome());
		System.out.println("======================================");

		System.out.println("Filme: " + filme2.getNome() + " (" + filme2.getAno() + ")");
		System.out.println("Gênero: " + filme2.getGenero());
		System.out.println("Duração: " + filme2.getDuracao());
		System.out.println("Funcionários do filme:");
		System.out.println("    Ator:");
		System.out.println("         " + ator2.getNome());
		System.out.println("    Cinegrafista:");
		System.out.println("         " + cinegrafista1.getNome());
		System.out.println("         " + cinegrafista2.getNome());
		System.out.println("    Diretor:");
		System.out.println("         " + diretor2.getNome());
		System.out.println("    Roteirista:");
		System.out.println("         " + roteirista1.getNome());
		System.out.println("    Produtor:");
		System.out.println("         " + produtor1.getNome());
		System.out.println("======================================");

		System.out.println("Filme: " + filme3.getNome() + " (" + filme3.getAno() + ")");
		System.out.println("Gênero: " + filme3.getGenero());
		System.out.println("Duração: " + filme3.getDuracao());
		System.out.println("Funcionários do filme:");
		System.out.println("    Ator:");
		System.out.println("         " + ator1.getNome());
		System.out.println("         " + ator2.getNome());
		System.out.println("    Diretor:");
		System.out.println("         " + ator1.getNome()); 
		System.out.println("         " + cinegrafista1.getNome()); 
		System.out.println("    Produtor:");
		System.out.println("         " + ator1.getNome()); 
		System.out.println("         " + cinegrafista1.getNome()); 
		System.out.println("         " + produtor1.getNome());
		System.out.println("======================================");

		// imprimir  a filmografia dos funcionários
		System.out.println("Filmografias dos Funcionários:");
		ator1.imprimirFilmografia();
		ator2.imprimirFilmografia();
		cinegrafista1.imprimirFilmografia(); 
		cinegrafista2.imprimirFilmografia();
		diretor1.imprimirFilmografia();
		diretor2.imprimirFilmografia();
		produtor1.imprimirFilmografia();
		roteirista1.imprimirFilmografia();
    }
}
