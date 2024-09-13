package instituicao;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import instituicao.Disciplina;
import instituicao.Professor;
import instituicao.intermediarias.ProfessorDisciplina;

public class ProfessorDisciplinaTest {
    private Professor professor;
    private Disciplina disciplina;
    private ProfessorDisciplina professorDisciplina;

    @Before
    public void setUp() {
        professor = new Professor("Sabrina", "12345");
        disciplina = new Disciplina("Métodos avançados de programação", "MAP101");
        professorDisciplina = new ProfessorDisciplina(professor, disciplina);
    }

    @Test
    public void testGetProfessor() {
        assertEquals(professor, professorDisciplina.getProfessor());
    }

    @Test
    public void testGetDisciplina() {
        assertEquals(disciplina, professorDisciplina.getDisciplina());
    }
    
    
    //Usando expected teste
    @Test(expected = IllegalArgumentException.class)
    public void testCriarProfessorDisciplinaComProfessorNulo() {
        new ProfessorDisciplina(null, disciplina);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCriarProfessorDisciplinaComDisciplinaNula() {
        new ProfessorDisciplina(professor, null);
    }
}
