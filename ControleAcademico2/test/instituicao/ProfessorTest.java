package instituicao;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import instituicao.Disciplina;
import instituicao.Professor;
import instituicao.intermediarias.ProfessorDisciplina;

public class ProfessorTest {
    private Professor professor;
    private Disciplina disciplina;

    @Before
    public void setUp() {
        professor = new Professor("Sabrina", "12345");
        disciplina = new Disciplina("Métodos avançados de programação", "MAP101");
    }

    @Test
    public void testProfessorValido() {
        assertTrue(professor.isValid());
    }

    @Test
    public void testProfessorInvalido() {
        Professor professorInvalido = new Professor("", "");
        assertFalse(professorInvalido.isValid());
    }

    @Test
    public void testAdicionarProfessorDisciplina() {
        ProfessorDisciplina professorDisciplina = new ProfessorDisciplina(professor, disciplina);
        professor.adicionarProfessorDisciplina(professorDisciplina);

        assertEquals(1, professor.getProfessorDisciplinas().size());
        assertTrue(professor.getProfessorDisciplinas().contains(professorDisciplina));
    }

    @Test
    public void testGetNome() {
        assertEquals("Sabrina", professor.getNome());
    }

    @Test
    public void testGetId() {
        assertEquals("12345", professor.getId());
    }
}
