package instituicao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class AlunoTest {
    private Aluno aluno;
    private Disciplina disciplina1;
    private Disciplina disciplina2;
    private Horario horario1;
    private Horario horario2;

    @BeforeEach //esse metdo tem que ser executado antes dos testes
    public void setUp() {
        aluno = new Aluno("Raquel Melo", "12345");
        disciplina1 = new Disciplina("Estatística II", "EST101");
        disciplina2 = new Disciplina("Banco de Dados", "BDD101");
        horario1 = new Horario("Terça-feira", "11:00 - 13:00");
        horario2 = new Horario("Quinta-feira", "11:00 - 13:00");
    }

    @Test 
    public void testAdicionarDisciplina() {
        aluno.adicionarDisciplina(disciplina1);
        List<Disciplina> disciplinas = aluno.obterDisciplinas();
        assertEquals(1, disciplinas.size());
        assertTrue(disciplinas.contains(disciplina1));
    }

    @Test
    public void testRemoverDisciplina() {
        aluno.adicionarDisciplina(disciplina1);
        aluno.removerDisciplina(disciplina1);
        List<Disciplina> disciplinas = aluno.obterDisciplinas();
        assertEquals(0, disciplinas.size());
        assertFalse(disciplinas.contains(disciplina1));
    }

    @Test
    public void testAdicionarHorario() {
        aluno.adicionarHorario(horario1);
        aluno.adicionarHorario(horario2);
        List<Horario> horarios = aluno.obterHorarios();
        assertEquals(2, horarios.size());
        assertTrue(horarios.contains(horario1));
        assertTrue(horarios.contains(horario2));
    }

    @Test
    public void testToString() {
        String expected = "Aluno [nome=Raquel Melo, id=12345]";
        assertEquals(expected, aluno.toString());
    }
}

