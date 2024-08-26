package instituicao;
import org.junit.Test;

import instituicao.exceptions.DisciplinaInvalidaException;
import instituicao.exceptions.ProfessorNaoEncontradoException;

import static org.junit.Assert.*;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import instituicao.*;
import instituicao.exceptions.DisciplinaInvalidaException;
import instituicao.exceptions.ProfessorNaoEncontradoException;

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


}
