package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import globo.creator.Creator;
import globo.filmes.Filme;

public class FilmeTest {
    
    private Creator creator;
    private Filme filme;

    @BeforeEach
    public void setUp() {
        creator = new Creator();
        filme = creator.criarFilme("UEPB o Filme", 2024, "Drama", "2h");
    }

    @Test
    public void testGetNome() {
        assertEquals("UEPB o Filme", filme.getNome());
    }

    @Test
    public void testGetAno() {
        assertEquals(2024, filme.getAno());
    }

    @Test
    public void testGetGenero() {
        assertEquals("Drama", filme.getGenero());
    }

    @Test
    public void testGetDuracao() {
        assertEquals("2h", filme.getDuracao());
    }
}
