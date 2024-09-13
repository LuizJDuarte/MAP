package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import globo.creator.Creator;
import globo.filmes.Filme;
import globo.funcionarios.Funcionario;

public class CreatorTest {
    
    private Creator creator;
    private Filme filme1, filme2;
    private Funcionario ator1, diretor1;

    @BeforeEach
    public void setUp() {
        creator = new Creator();
        filme1 = creator.criarFilme("UEPB o Filme", 2024, "Drama", "2h");
        filme2 = creator.criarFilme("A Grande Produção", 2026, "Aventura", "1h 45min");

        ator1 = creator.criarAtor("Luiz José", "001", filme1);
        diretor1 = creator.criarDiretor("Sabrina", "002", filme1);
    }

    @Test
    public void testCriarFilme() {
        assertNotNull(filme1);
        assertEquals("UEPB o Filme", filme1.getNome());
        assertEquals(2024, filme1.getAno());
    }

    @Test
    public void testCriarAtor() {
        assertNotNull(ator1);
        assertEquals("Luiz José", ator1.getNome());
    }

    @Test
    public void testAdicionarFuncao() {
        creator.adicionarFuncao(ator1, "Diretor", filme2);
        assertDoesNotThrow(() -> ator1.imprimirFilmografia());
    }
}
