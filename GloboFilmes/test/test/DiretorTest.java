package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import globo.creator.Creator;
import globo.filmes.Filme;
import globo.funcionarios.Diretor;

public class DiretorTest {
    
    private Creator creator;
    private Filme filme;
    private Diretor diretor;

    @BeforeEach
    public void setUp() {
        creator = new Creator();
        filme = creator.criarFilme("A Grande Produção", 2026, "Aventura", "1h 45min");
        diretor = new Diretor("Sabrina", "002");
    }

    @Test
    public void testAdicionarFilmeAoDiretor() {
        diretor.adicionarParticipacao("Diretor", filme);
        assertEquals(1, diretor.getParticipacoes().size());
    }

    @Test
    public void testGetNome() {
        assertEquals("Sabrina", diretor.getNome());
    }
}
