package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import globo.creator.Creator;
import globo.filmes.Filme;
import globo.funcionarios.Funcionario;
import globo.intermediarias.FuncionarioFilme;

public class FuncionarioFilmeTest {
    
    private FuncionarioFilme funcionarioFilme;
    private Funcionario funcionario;
    private Filme filme;
    private Creator creator;

    @BeforeEach
    public void setUp() {
        creator = new Creator();
        filme = creator.criarFilme("A Grande Produção", 2026, "Aventura", "1h 45min");
        funcionario = creator.criarAtor("Luiz José", "001", filme);
        funcionarioFilme = new FuncionarioFilme(funcionario, filme); // Ajustar o construtor
    }

    @Test
    public void testExibirFuncionarioNoFilme() {
        assertDoesNotThrow(() -> funcionarioFilme.exibirFuncionarioNoFilme());
    }
}
