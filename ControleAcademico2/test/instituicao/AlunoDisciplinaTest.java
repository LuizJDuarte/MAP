package instituicao;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import instituicao.Aluno;
import instituicao.Disciplina;
import instituicao.intermediarias.AlunoDisciplina;

public class AlunoDisciplinaTest {
    private Aluno aluno;
    private Disciplina disciplina;
    private AlunoDisciplina alunoDisciplina;

    @Before
    public void setUp() {
        aluno = new Aluno("Luiz José", "20230001");
        disciplina = new Disciplina("Compiladores", "COP101");
        alunoDisciplina = new AlunoDisciplina(aluno, disciplina);
    }

    @Test
    public void testGetAluno() {
        assertEquals(aluno, alunoDisciplina.getAluno());
    }

    @Test
    public void testGetDisciplina() {
        assertEquals(disciplina, alunoDisciplina.getDisciplina());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCriarAlunoDisciplinaComAlunoNulo() {
        new AlunoDisciplina(null, disciplina);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCriarAlunoDisciplinaComDisciplinaNula() {
        new AlunoDisciplina(aluno, null);
    }
}
