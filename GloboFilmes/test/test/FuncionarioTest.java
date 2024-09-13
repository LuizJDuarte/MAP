package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import globo.funcionarios.Funcionario;
import globo.filmes.Filme;
import globo.creator.Creator;

public class FuncionarioTest {

    private Funcionario funcionario;
    private Filme filme1, filme2;
    private Creator creator;

    @BeforeEach
    public void setUp() {
        creator = new Creator();
        filme1 = creator.criarFilme("A Grande Produção", 2026, "Aventura", "1h 45min");
        filme2 = creator.criarFilme("UEPB o Filme", 2024, "Drama", "2h");
        funcionario = creator.criarAtor("Luiz José", "001", filme1);
    }

    @Test
    public void testAdicionarFuncao() {
        creator.adicionarFuncao(funcionario, "Diretor", filme1);
        assertDoesNotThrow(() -> funcionario.imprimirFilmografia());
    }

    @Test
    public void testNomeFuncionario() {
        assertEquals("Luiz José", funcionario.getNome());
    }

    @Test
    public void testParticipacoes() {
        assertDoesNotThrow(() -> funcionario.imprimirFilmografia());
    }

    @Test
    public void testAdicionarParticipacao() {
        creator.adicionarFuncao(funcionario, "Produtor", filme1);
        assertDoesNotThrow(() -> funcionario.imprimirFilmografia());
    }
}
