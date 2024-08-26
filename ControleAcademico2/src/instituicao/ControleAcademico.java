package instituicao;

import instituicao.creator.EntityCreator;
import instituicao.exceptions.*;
import instituicao.intermediarias.AlunoDisciplina;
import instituicao.intermediarias.ProfessorDisciplina;

import java.util.ArrayList;
import java.util.List;

public class ControleAcademico {

    private List<Aluno> alunos;
    private List<Disciplina> disciplinas;
    private List<Professor> professores;
    private List<Horario> horarios;

    public ControleAcademico() {
        this.alunos = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
        this.professores = new ArrayList<>();
        this.horarios = new ArrayList<>();
    }

    public Professor adicionarProfessor(String nome, String id) {
        Professor professor = EntityCreator.criarProfessor(nome, id);
        professores.add(professor);
        return professor;
    }

    public Aluno adicionarAluno(String nome, String matricula) {
        Aluno aluno = EntityCreator.criarAluno(nome, matricula);
        alunos.add(aluno);
        return aluno;
    }

    public Disciplina adicionarDisciplina(String nome, String codigo) {
        Disciplina disciplina = EntityCreator.criarDisciplina(nome, codigo);
        disciplinas.add(disciplina);
        return disciplina;
    }

    public Horario adicionarHorario(String dia, String hora) {
        Horario horario = EntityCreator.criarHorario(dia, hora);
        horarios.add(horario);
        return horario;
    }

    public void removerProfessor(Professor professor) throws ProfessorNaoEncontradoException {
        if (!professores.remove(professor)) {
            throw new ProfessorNaoEncontradoException("Professor não encontrado!");
        }
    }

    public void removerAluno(Aluno aluno) throws AlunoNaoEncontradoException {
        if (!alunos.remove(aluno)) {
            throw new AlunoNaoEncontradoException("Aluno não encontrado!");
        }
    }

    public void removerDisciplina(Disciplina disciplina) throws DisciplinaNaoEncontradaException {
        if (!disciplinas.remove(disciplina)) {
            throw new DisciplinaNaoEncontradaException("Disciplina não encontrada!");
        }
    }

    public void associarHorarioADisciplina(Disciplina disciplina, Horario horario) {
        if (disciplina == null || horario == null) {
            throw new IllegalArgumentException("Disciplina e Horário não podem ser nulos");
        }
        disciplina.adicionarHorario(horario);
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }
}
