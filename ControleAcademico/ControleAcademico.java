package instituicao;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import instituicao.Professor;

import java.util.List;

public class AcademicoTest {

	@Test
	public void testCriacaoProfessor() {
	    Professor professor = new Professor("João Silva", "P001");
	    assertNotNull(professor);
	    // Assumindo métodos de acesso (se disponíveis)
	    assertEquals("João Silva", professor.getNome());
	    assertEquals("P001", professor.getId());
	}

    @Test
    public void testAdicionarDisciplinaProfessor() {
        Professor professor = new Professor("Maria Oliveira", "P002");
        Disciplina disciplina = new Disciplina("Química", "QUI103");

        professor.adicionarDisciplina(disciplina);

        assertTrue(professor.obterDisciplinas().contains(disciplina));
        assertEquals(professor, disciplina.obterProfessor());
    }

    @Test
    public void testAdicionarAlunoDisciplina() {
        Aluno aluno = new Aluno("Carlos Souza", "A001");
        Disciplina disciplina = new Disciplina("Matemática", "MAT101");

        aluno.adicionarDisciplina(disciplina);

        assertTrue(aluno.obterDisciplinas().contains(disciplina));
        assertTrue(disciplina.obterAlunos().contains(aluno));
    }

    @Test
    public void testAdicionarHorarioProfessor() {
        Professor professor = new Professor("Ana Costa", "P003");
        Horario horario = new Horario("Terça-feira", "08:00-10:00");

        professor.adicionarHorario(horario);

        assertTrue(professor.obterHorarios().contains(horario));
    }

    @Test
    public void testNumeroDeAlunosDisciplina() {
        Disciplina disciplina = new Disciplina("Biologia", "BIO201");
        Aluno aluno1 = new Aluno("João Pereira", "A002");
        Aluno aluno2 = new Aluno("Laura Lima", "A003");

        disciplina.adicionarAluno(aluno1);
        disciplina.adicionarAluno(aluno2);

        assertEquals(2, disciplina.obterNumeroDeAlunos());
    }

    @Test
    public void testRemoverAlunoDisciplina() {
        Disciplina disciplina = new Disciplina("História", "HIS202");
        Aluno aluno = new Aluno("Lucas Mendes", "A004");

        disciplina.adicionarAluno(aluno);
        disciplina.removerAluno(aluno);

        assertFalse(disciplina.obterAlunos().contains(aluno));
        assertEquals(0, disciplina.obterNumeroDeAlunos());
    }
}
