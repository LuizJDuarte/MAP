package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import globo.filmes.ControleFilmes;
import globo.filmes.Filme;
import globo.creator.Creator;

public class ControleFilmesTest {

    private ControleFilmes controleFilmes;
    private Filme filme1, filme2;
    private Creator creator;

    @BeforeEach
    public void setUp() {
        controleFilmes = new ControleFilmes();
        creator = new Creator();
        filme1 = creator.criarFilme("UEPB o Filme", 2024, "Drama", "2h");
        filme2 = creator.criarFilme("A Grande Produção", 2026, "Aventura", "1h 45min");
        controleFilmes.cadastrarFilme(filme1);
        controleFilmes.cadastrarFilme(filme2);
    }

    @Test
    public void testCadastrarFilme() {
        assertEquals(2, controleFilmes.listarFilmes().size());
    }

    @Test
    public void testBuscarFilme() {
        Filme filme = controleFilmes.buscarFilme("UEPB o Filme");
        assertNotNull(filme);
        assertEquals("UEPB o Filme", filme.getNome());
    }

    @Test
    public void testListarFilmes() {
        assertEquals(2, controleFilmes.listarFilmes().size());
    }
}
