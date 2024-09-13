package instituicao;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import instituicao.*;
import instituicao.creator.EntityCreator;
import instituicao.exceptions.*;
import instituicao.intermediarias.AlunoDisciplina;
import instituicao.intermediarias.ProfessorDisciplina;

public class ControleAcademicoTest {
    private ControleAcademico controle;
    private Aluno aluno;
    private Disciplina disciplina;
    private Professor professor;
    private Horario horario;

    @Before
    public void setUp() {
        controle = new ControleAcademico();
        aluno = controle.adicionarAluno("Luiz José", "20230001");
        disciplina = controle.adicionarDisciplina("Compiladores", "COP101");
        professor = controle.adicionarProfessor("Sabrina", "12345");
        horario = controle.adicionarHorario("Segunda-feira", "08:00 - 10:00");
    }

    @Test
    public void testAdicionarDisciplinaParaAluno() {
        aluno.adicionarDisciplina(disciplina);

        assertEquals(1, aluno.getAlunoDisciplinas().size());
        assertTrue(aluno.getAlunoDisciplinas().get(0).getDisciplina().equals(disciplina));
    }

    @Test
    public void testAdicionarProfessorParaDisciplina() {
        professor.adicionarDisciplina(disciplina);

        assertEquals(1, professor.getProfessorDisciplinas().size());
        assertTrue(professor.getProfessorDisciplinas().get(0).getDisciplina().equals(disciplina));
    }

    @Test
    public void testAssociarHorarioADisciplina() {
        controle.associarHorarioADisciplina(disciplina, horario);
        assertEquals(1, disciplina.getHorarios().size());
    }

    @Test
    public void testRemoverAluno() throws AlunoNaoEncontradoException {
        controle.removerAluno(aluno);
        assertEquals(0, controle.getAlunos().size());
    }

    @Test(expected = AlunoNaoEncontradoException.class)
    public void testRemoverAlunoNaoExistente() throws AlunoNaoEncontradoException {
        Aluno alunoNaoExistente = EntityCreator.criarAluno("Raquel Melo", "20230002");
        controle.removerAluno(alunoNaoExistente);
    }

    @Test
    public void testRemoverDisciplina() throws DisciplinaNaoEncontradaException {
        controle.removerDisciplina(disciplina);
        assertEquals(0, controle.getDisciplinas().size());
    }

    @Test(expected = DisciplinaNaoEncontradaException.class)
    public void testRemoverDisciplinaNaoExistente() throws DisciplinaNaoEncontradaException {
        Disciplina disciplinaNaoExistente = EntityCreator.criarDisciplina("Engenharia de Software", "ESW101");
        controle.removerDisciplina(disciplinaNaoExistente);
    }

    @Test
    public void testRemoverProfessor() throws ProfessorNaoEncontradoException {
        controle.removerProfessor(professor);
        assertEquals(0, controle.getProfessores().size());
    }

    @Test(expected = ProfessorNaoEncontradoException.class)
    public void testRemoverProfessorNaoExistente() throws ProfessorNaoEncontradoException {
        Professor professorNaoExistente = EntityCreator.criarProfessor("Ana Isabella", "67890");
        controle.removerProfessor(professorNaoExistente);
    }

    @Test
    public void testRemoverAssociacaoAlunoDisciplina() throws AssociacaoNaoEncontradaException {
        aluno.adicionarDisciplina(disciplina);
        disciplina.removerAlunoDisciplina(new AlunoDisciplina(aluno, disciplina));
        assertEquals(0, aluno.getAlunoDisciplinas().size());
    }

    @Test(expected = AssociacaoNaoEncontradaException.class)
    public void testRemoverAssociacaoAlunoDisciplinaNaoExistente() throws AssociacaoNaoEncontradaException {
        disciplina.removerAlunoDisciplina(new AlunoDisciplina(aluno, disciplina));
    }

    @Test
    public void testRemoverAssociacaoProfessorDisciplina() throws AssociacaoNaoEncontradaException {
        professor.adicionarDisciplina(disciplina);
        disciplina.removerProfessorDisciplina(new ProfessorDisciplina(professor, disciplina));
        assertEquals(0, professor.getProfessorDisciplinas().size());
    }

    @Test(expected = AssociacaoNaoEncontradaException.class)
    public void testRemoverAssociacaoProfessorDisciplinaNaoExistente() throws AssociacaoNaoEncontradaException {
        disciplina.removerProfessorDisciplina(new ProfessorDisciplina(professor, disciplina));
    }
}
