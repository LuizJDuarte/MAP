package instituicao;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import instituicao.Disciplina;
import instituicao.Professor;
import instituicao.intermediarias.ProfessorDisciplina;

public class DisciplinaTest {
    private Disciplina disciplina;
    private Professor professor;

    @Before
    public void setUp() {
        disciplina = new Disciplina("Métodos avançados de programação", "MAP101");
        professor = new Professor("Sabrina", "12345");
    }

    @Test
    public void testAdicionarProfessorDisciplina() {
        ProfessorDisciplina professorDisciplina = new ProfessorDisciplina(professor, disciplina);
        disciplina.adicionarProfessorDisciplina(professorDisciplina);

        assertEquals(1, disciplina.getProfessorDisciplinas().size());
        assertTrue(disciplina.getProfessorDisciplinas().contains(professorDisciplina));
    }


    @Test
    public void testDisciplinaValida() {
        assertTrue(disciplina.isValid());
    }

    @Test
    public void testDisciplinaInvalida() {
        Disciplina disciplinaInvalida = new Disciplina("", "");
        assertFalse(disciplinaInvalida.isValid());
    }
}
