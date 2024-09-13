package instituicao;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import instituicao.Aluno;
import instituicao.Disciplina;
import instituicao.intermediarias.AlunoDisciplina;

public class AlunoTest {
    private Aluno aluno;
    private Disciplina disciplina;

    @Before
    public void setUp() {
        aluno = new Aluno("Luiz José", "20230001");
        disciplina = new Disciplina("Compiladores", "COP101");
    }

    @Test
    public void testAdicionarAlunoDisciplina() {
        AlunoDisciplina alunoDisciplina = new AlunoDisciplina(aluno, disciplina);
        aluno.adicionarAlunoDisciplina(alunoDisciplina);

        assertEquals(1, aluno.getAlunoDisciplinas().size());
        assertTrue(aluno.getAlunoDisciplinas().contains(alunoDisciplina));
    }

    @Test
    public void testAdicionarDisciplinaDuplicada() {
        AlunoDisciplina alunoDisciplina = new AlunoDisciplina(aluno, disciplina);
        aluno.adicionarAlunoDisciplina(alunoDisciplina);
        aluno.adicionarAlunoDisciplina(alunoDisciplina); //Tentativa de adicionar duplicado

        assertEquals(1, aluno.getAlunoDisciplinas().size()); //verifica que não há duplo
    }

}
