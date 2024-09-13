package instituicao;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import instituicao.Professor;

import java.util.List;

public class AcademicoTest {

	@Test
	//testa as classes professor
	public void testCriacaoProfessor() {
	    Professor professor = new Professor("Sabrina de Figueredo", "P001");
	    assertNotNull(professor);
	    // Assumindo métodos de acesso (se disponíveis)
	    assertEquals("Sabrina de Figueredo", professor.getNome());
	    assertEquals("P001", professor.getId());
	}

    @Test
    // testa as classes professor e disciplina
    public void testAdicionarDisciplinaProfessor() {
        Professor professor = new Professor("Daniel Scherer", "P002");
        Disciplina disciplina = new Disciplina("Engenharia de Software", "ESW103");

        professor.adicionarDisciplina(disciplina);

        assertTrue(professor.obterDisciplinas().contains(disciplina));
        assertEquals(professor, disciplina.obterProfessor());
    }

    @Test
    //testa as classes aluno e disciplina
    public void testAdicionarAlunoDisciplina() {
        Aluno aluno = new Aluno("Carlos Escobar", "A001");
        Disciplina disciplina = new Disciplina("Matemática I", "MAT101");

        aluno.adicionarDisciplina(disciplina);

        assertTrue(aluno.obterDisciplinas().contains(disciplina));
        assertTrue(disciplina.obterAlunos().contains(aluno));
    }

    @Test
    //testa as classes horario e professor
    public void testAdicionarHorarioProfessor() {
        Professor professor = new Professor("João José", "P003");
        Horario horario = new Horario("Terça-feira", "11:00-13:00");

        professor.adicionarHorario(horario);

        assertTrue(professor.obterHorarios().contains(horario));
    }

    @Test
    //testa as classes disciplina e aluno
    public void testNumeroDeAlunosDisciplina() {
        Disciplina disciplina = new Disciplina("Gerência de projeto", "GPR201");
        Aluno aluno1 = new Aluno("João Pereira", "A002");
        Aluno aluno2 = new Aluno("Laura Lima", "A003");

        disciplina.adicionarAluno(aluno1);
        disciplina.adicionarAluno(aluno2);

        assertEquals(2, disciplina.obterNumeroDeAlunos());
    }

    @Test
    //testa remover um aluno de determinwda disciplina
    public void testRemoverAlunoDisciplina() {
        Disciplina disciplina = new Disciplina("MAP", "MAP202");
        Aluno aluno = new Aluno("Lucas João", "A004");

        disciplina.adicionarAluno(aluno);
        disciplina.removerAluno(aluno);

        assertFalse(disciplina.obterAlunos().contains(aluno));
        assertEquals(0, disciplina.obterNumeroDeAlunos());
    }
}
