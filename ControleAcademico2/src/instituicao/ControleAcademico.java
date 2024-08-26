package instituicao;

import instituicao.exceptions.*;
import instituicao.intermediarias.AlunoDisciplina;
import instituicao.intermediarias.ProfessorDisciplina;

import java.util.*;

public class ControleAcademico {
    private List<Aluno> alunos;
    private List<Disciplina> disciplinas;
    private List<Professor> professores;
    private List<Horario> horarios;
    private Map<Disciplina, List<Horario>> disciplinaHorarios;

    public ControleAcademico() {
        this.alunos = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
        this.professores = new ArrayList<>();
        this.horarios = new ArrayList<>();
        this.disciplinaHorarios = new HashMap<>();
    }

    public void adicionarAluno(Aluno aluno) {
        if (aluno == null || alunos.contains(aluno)) {
            throw new IllegalArgumentException("Aluno não pode ser nulo ou duplicado");
        }
        alunos.add(aluno);
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        if (disciplina == null || disciplinas.contains(disciplina)) {
            throw new IllegalArgumentException("Disciplina não pode ser nula ou duplicada");
        }
        disciplinas.add(disciplina);
    }

    public void adicionarProfessor(Professor professor) {
        if (professor == null || professores.contains(professor)) {
            throw new IllegalArgumentException("Professor não pode ser nulo ou duplicado");
        }
        professores.add(professor);
    }

    public void adicionarHorario(Horario horario) {
        if (horario == null || horarios.contains(horario)) {
            throw new IllegalArgumentException("Horário não pode ser nulo ou duplicado");
        }
        horarios.add(horario);
    }

    public void associarHorarioADisciplina(Disciplina disciplina, Horario horario) {
        if (disciplina == null || horario == null) {
            throw new IllegalArgumentException("Disciplina e Horário não podem ser nulos");
        }
        disciplinaHorarios.computeIfAbsent(disciplina, k -> new ArrayList<>()).add(horario);
    }

    public List<Horario> getHorariosDaDisciplina(Disciplina disciplina) {
        return disciplinaHorarios.getOrDefault(disciplina, new ArrayList<>());
    }

    public void adicionarDisciplinaParaAluno(Aluno aluno, Disciplina disciplina) throws DisciplinaInvalidaException {
        if (disciplina == null || !disciplina.isValid()) {
            throw new DisciplinaInvalidaException("Disciplina inválida!");
        }
        AlunoDisciplina alunoDisciplina = new AlunoDisciplina(aluno, disciplina);
        if (!aluno.getAlunoDisciplinas().contains(alunoDisciplina)) {
            aluno.adicionarAlunoDisciplina(alunoDisciplina);
            disciplina.adicionarAlunoDisciplina(alunoDisciplina);
        } else {
            throw new IllegalArgumentException("Disciplina já está associada ao aluno");
        }
    }

    public void adicionarProfessorParaDisciplina(Disciplina disciplina, Professor professor) throws ProfessorNaoEncontradoException {
        if (professor == null || !professor.isValid()) {
            throw new ProfessorNaoEncontradoException("Professor não encontrado!");
        }
        ProfessorDisciplina professorDisciplina = new ProfessorDisciplina(professor, disciplina);
        if (!disciplina.getProfessorDisciplinas().contains(professorDisciplina)) {
            professor.adicionarProfessorDisciplina(professorDisciplina);
            disciplina.adicionarProfessorDisciplina(professorDisciplina);
        } else {
            throw new IllegalArgumentException("Professor já está associado à disciplina");
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

    public void removerProfessor(Professor professor) throws ProfessorNaoEncontradoException {
        if (!professores.remove(professor)) {
            throw new ProfessorNaoEncontradoException("Professor não encontrado!");
        }
    }

    public void removerAssociacaoAlunoDisciplina(Aluno aluno, Disciplina disciplina) throws AssociacaoNaoEncontradaException {
        AlunoDisciplina alunoDisciplina = new AlunoDisciplina(aluno, disciplina);
        if (!aluno.getAlunoDisciplinas().remove(alunoDisciplina) || !disciplina.getAlunoDisciplinas().remove(alunoDisciplina)) {
            throw new AssociacaoNaoEncontradaException("Associação entre aluno e disciplina não encontrada!");
        }
    }

    public void removerAssociacaoProfessorDisciplina(Professor professor, Disciplina disciplina) throws AssociacaoNaoEncontradaException {
        ProfessorDisciplina professorDisciplina = new ProfessorDisciplina(professor, disciplina);
        if (!disciplina.getProfessorDisciplinas().remove(professorDisciplina) || !professor.getProfessorDisciplinas().remove(professorDisciplina)) {
            throw new AssociacaoNaoEncontradaException("Associação entre professor e disciplina não encontrada!");
        }
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
