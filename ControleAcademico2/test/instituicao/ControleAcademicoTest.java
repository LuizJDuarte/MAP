package instituicao;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import instituicao.*;
import instituicao.exceptions.*;

public class ControleAcademicoTest {
    private ControleAcademico controle;
    private Aluno aluno;
    private Disciplina disciplina;
    private Professor professor;
    private Horario horario;

    @Before
    public void setUp() {
        controle = new ControleAcademico();
        aluno = new Aluno("Luiz José", "20230001");
        disciplina = new Disciplina("Compiladores", "COP101");
        professor = new Professor("Sabrina", "12345");
        horario = new Horario("Segunda-feira", "08:00 - 10:00");

        controle.adicionarAluno(aluno);
        controle.adicionarDisciplina(disciplina);
        controle.adicionarProfessor(professor);
        controle.adicionarHorario(horario);
    }

    @Test
    public void testAdicionarDisciplinaParaAluno() throws DisciplinaInvalidaException {
        controle.adicionarDisciplinaParaAluno(aluno, disciplina);

        assertEquals(1, aluno.getAlunoDisciplinas().size());
        assertTrue(aluno.getAlunoDisciplinas().get(0).getDisciplina().equals(disciplina));
    }

    @Test(expected = DisciplinaInvalidaException.class)
    public void testAdicionarDisciplinaInvalidaParaAluno() throws DisciplinaInvalidaException {
        Disciplina disciplinaInvalida = new Disciplina("", "");
        controle.adicionarDisciplinaParaAluno(aluno, disciplinaInvalida);
    }

    @Test
    public void testAdicionarProfessorParaDisciplina() throws ProfessorNaoEncontradoException {
        controle.adicionarProfessorParaDisciplina(disciplina, professor);

        assertEquals(1, professor.getProfessorDisciplinas().size());
        assertTrue(professor.getProfessorDisciplinas().get(0).getDisciplina().equals(disciplina));
    }

    @Test(expected = ProfessorNaoEncontradoException.class)
    public void testAdicionarProfessorInvalidoParaDisciplina() throws ProfessorNaoEncontradoException {
        Professor professorInvalido = new Professor("", "");
        controle.adicionarProfessorParaDisciplina(disciplina, professorInvalido);
    }

    @Test
    public void testAssociarHorarioADisciplina() {
        controle.associarHorarioADisciplina(disciplina, horario);
        assertEquals(1, controle.getHorariosDaDisciplina(disciplina).size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdicionarDisciplinaDuplicadaParaAluno() throws DisciplinaInvalidaException {
        controle.adicionarDisciplinaParaAluno(aluno, disciplina);
        controle.adicionarDisciplinaParaAluno(aluno, disciplina); // Tentar adicionar novamente
    }

    @Test
    public void testRemoverAluno() throws AlunoNaoEncontradoException {
        controle.removerAluno(aluno);
        assertEquals(0, controle.getAlunos().size());
    }

    @Test(expected = AlunoNaoEncontradoException.class)
    public void testRemoverAlunoNaoExistente() throws AlunoNaoEncontradoException {
        Aluno alunoNaoExistente = new Aluno("Raquel Melo", "20230002");
        controle.removerAluno(alunoNaoExistente);
    }

    @Test
    public void testRemoverDisciplina() throws DisciplinaNaoEncontradaException {
        controle.removerDisciplina(disciplina);
        assertEquals(0, controle.getDisciplinas().size());
    }

    @Test(expected = DisciplinaNaoEncontradaException.class)
    public void testRemoverDisciplinaNaoExistente() throws DisciplinaNaoEncontradaException {
        Disciplina disciplinaNaoExistente = new Disciplina("Engenharia de Software", "ESW101");
        controle.removerDisciplina(disciplinaNaoExistente);
    }

    @Test
    public void testRemoverProfessor() throws ProfessorNaoEncontradoException {
        controle.removerProfessor(professor);
        assertEquals(0, controle.getProfessores().size());
    }

    @Test(expected = ProfessorNaoEncontradoException.class)
    public void testRemoverProfessorNaoExistente() throws ProfessorNaoEncontradoException {
        Professor professorNaoExistente = new Professor("Ana Isabella", "67890");
        controle.removerProfessor(professorNaoExistente);
    }

    @Test
    public void testRemoverAssociacaoAlunoDisciplina() throws AssociacaoNaoEncontradaException, DisciplinaInvalidaException {
        controle.adicionarDisciplinaParaAluno(aluno, disciplina);
        controle.removerAssociacaoAlunoDisciplina(aluno, disciplina);
        assertEquals(0, aluno.getAlunoDisciplinas().size());
    }

    @Test(expected = AssociacaoNaoEncontradaException.class)
    public void testRemoverAssociacaoAlunoDisciplinaNaoExistente() throws AssociacaoNaoEncontradaException {
        controle.removerAssociacaoAlunoDisciplina(aluno, disciplina);
    }

    @Test
    public void testRemoverAssociacaoProfessorDisciplina() throws AssociacaoNaoEncontradaException, ProfessorNaoEncontradoException {
        controle.adicionarProfessorParaDisciplina(disciplina, professor);
        controle.removerAssociacaoProfessorDisciplina(professor, disciplina);
        assertEquals(0, professor.getProfessorDisciplinas().size());
    }

    @Test(expected = AssociacaoNaoEncontradaException.class)
    public void testRemoverAssociacaoProfessorDisciplinaNaoExistente() throws AssociacaoNaoEncontradaException {
        controle.removerAssociacaoProfessorDisciplina(professor, disciplina);
    }
}
