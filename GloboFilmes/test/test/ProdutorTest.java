package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import globo.creator.Creator;
import globo.filmes.Filme;
import globo.funcionarios.Produtor;

public class ProdutorTest {
    
    private Creator creator;
    private Filme filme;
    private Produtor produtor;

    @BeforeEach
    public void setUp() {
        creator = new Creator();
        filme = creator.criarFilme("A Grande Produção", 2026, "Aventura", "1h 45min");
        produtor = new Produtor("Paulo", "004");
    }

    @Test
    public void testAdicionarFilmeAoProdutor() {
        produtor.adicionarParticipacao("Produtor", filme);  
        assertEquals(1, produtor.getParticipacoes().size());
    }

    @Test
    public void testGetNome() {
        assertEquals("Paulo", produtor.getNome());
    }
}
