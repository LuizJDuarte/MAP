package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import globo.creator.Creator;
import globo.filmes.Filme;
import globo.funcionarios.Ator;

public class AtorTest {
    
    private Creator creator;
    private Filme filme;
    private Ator ator;

    @BeforeEach
    public void setUp() {
        creator = new Creator();
        filme = creator.criarFilme("UEPB o Filme", 2024, "Drama", "2h");
        ator = new Ator("Luiz José", "001");
    }

//    @Test
//    public void testAdicionarFilmeAoAtor() {
//        ator.adicionarParticipacao("Ator", filme);  
//        assertEquals(1, ator.getParticipacoes().size());
//        assertEquals("Ator", ator.getParticipacoes().get(0).getFuncoes());
//    }

    @Test
    public void testGetNome() {
        assertEquals("Luiz José", ator.getNome());
    }
}
