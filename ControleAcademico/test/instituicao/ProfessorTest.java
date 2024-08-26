package instituicao;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ProfessorTest {
    private Professor professor;
    private Disciplina disciplina1;
    private Disciplina disciplina2;
    private Horario horario1;
    private Horario horario2;

    @BeforeEach //esse metdo tem que ser executado antes dos testes
    public void setUp() {
        professor = new Professor("Sabrina", "P001");
        disciplina1 = new Disciplina("MAP", "MAP101");
        disciplina2 = new Disciplina("Paradigmas", "PAR101");
        horario1 = new Horario("Segunda-feira", "08:00 - 10:00");
        horario2 = new Horario("Quarta-feira", "10:00 - 12:00");
    }
    
    //gets e sets
    @Test 
    public void testGetNome() {
        assertEquals("Sabrina", professor.getNome());
    }

    @Test
    public void testSetNome() {
        professor.setNome("Ana Isabella");
        assertEquals("Ana Isabella", professor.getNome());
    }

    @Test
    public void testGetId() {
        assertEquals("P001", professor.getId());
    }

    @Test
    public void testSetId() {
        professor.setId("P002");
        assertEquals("P002", professor.getId());
    }
    
    @Test
    //testando adicionar professor a disciplina
    public void testAdicionarDisciplina() {
        professor.adicionarDisciplina(disciplina1);
        List<Disciplina> disciplinas = professor.obterDisciplinas();
        assertEquals(1, disciplinas.size());
        assertTrue(disciplinas.contains(disciplina1));
        assertEquals(professor, disciplina1.obterProfessor());
    }

    @Test
  //testando remover professor da disciplina
    public void testRemoverDisciplina() {
        professor.adicionarDisciplina(disciplina1);
        professor.removerDisciplina(disciplina1);
        List<Disciplina> disciplinas = professor.obterDisciplinas();
        assertEquals(0, disciplinas.size());
        assertFalse(disciplinas.contains(disciplina1));
        assertNull(disciplina1.obterProfessor());
    }

    @Test
    public void testAdicionarHorario() {
        professor.adicionarHorario(horario1);
        professor.adicionarHorario(horario2);
        List<Horario> horarios = professor.obterHorarios();
        assertEquals(2, horarios.size());
        assertTrue(horarios.contains(horario1));
        assertTrue(horarios.contains(horario2));
    }

    @Test
    public void testObterDisciplinas() {
        professor.adicionarDisciplina(disciplina1);
        professor.adicionarDisciplina(disciplina2);
        List<Disciplina> disciplinas = professor.obterDisciplinas();
        assertEquals(2, disciplinas.size());
        assertTrue(disciplinas.contains(disciplina1));
        assertTrue(disciplinas.contains(disciplina2));
    }

    @Test
    public void testObterHorarios() {
        professor.adicionarHorario(horario1);
        List<Horario> horarios = professor.obterHorarios();
        assertEquals(1, horarios.size());
        assertTrue(horarios.contains(horario1));
    }

    @Test
    public void testToString() {
    	String expected = "Professor [nome=Sabrina, id=P001]";
    	assertEquals(expected, professor.toString());
    }

    
}