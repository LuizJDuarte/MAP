package instituicao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class DisciplinaTest {
    private Disciplina disciplina;
    private Aluno aluno1;
    private Aluno aluno2;
    private Professor professor;

    @BeforeEach //esse metdo tem que ser executado antes dos testes
    public void setUp() {
        disciplina = new Disciplina("Sistemas Operacionais", "SOP101");
        aluno1 = new Aluno("Luiz Duarte", "12345");
        aluno2 = new Aluno("Raquel Melo", "67890");
        professor = new Professor("Daniel", "PROF001");
    }

    @Test
    public void testAssociarProfessor() {
        disciplina.associarProfessor(professor);
        assertEquals(professor, disciplina.obterProfessor());
    }

    @Test
    public void testDesassociarProfessor() {
        disciplina.associarProfessor(professor);
        disciplina.desassociarProfessor();
        assertNull(disciplina.obterProfessor());
    }

    @Test
    public void testAdicionarAluno() {
        disciplina.adicionarAluno(aluno1);
        List<Aluno> alunos = disciplina.obterAlunos();
        assertEquals(1, alunos.size());
        assertTrue(alunos.contains(aluno1));
        assertTrue(aluno1.obterDisciplinas().contains(disciplina));
    }

    @Test
    public void testRemoverAluno() {
        disciplina.adicionarAluno(aluno1);
        disciplina.removerAluno(aluno1);
        List<Aluno> alunos = disciplina.obterAlunos();
        assertEquals(0, alunos.size());
        assertFalse(alunos.contains(aluno1));
        assertFalse(aluno1.obterDisciplinas().contains(disciplina));
    }

    @Test
    public void testObterNumeroDeAlunos() {
        disciplina.adicionarAluno(aluno1);
        disciplina.adicionarAluno(aluno2);
        assertEquals(2, disciplina.obterNumeroDeAlunos());
    }

    @Test
    public void testToString() {
        String expected = "Disciplina [nome=Sistemas Operacionais, codigo=SOP101]";
        assertEquals(expected, disciplina.toString());
    }
}
