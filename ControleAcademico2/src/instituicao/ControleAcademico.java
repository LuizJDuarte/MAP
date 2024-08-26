package instituicao;

import instituicao.exceptions.DisciplinaInvalidaException;
import instituicao.exceptions.ProfessorNaoEncontradoException;
import instituicao.intermediarias.AlunoDisciplina;
import instituicao.intermediarias.ProfessorDisciplina;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        if (aluno != null && !alunos.contains(aluno)) {
            alunos.add(aluno);
        }
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        if (disciplina != null && !disciplinas.contains(disciplina)) {
            disciplinas.add(disciplina);
        }
    }

    public void adicionarProfessor(Professor professor) {
        if (professor != null && !professores.contains(professor)) {
            professores.add(professor);
        }
    }

    public void adicionarHorario(Horario horario) {
        if (horario != null && !horarios.contains(horario)) {
            horarios.add(horario);
        }
    }

    public void associarHorarioADisciplina(Disciplina disciplina, Horario horario) {
        if (disciplina != null && horario != null) {
            disciplinaHorarios.computeIfAbsent(disciplina, k -> new ArrayList<>()).add(horario);
        }
    }

    public List<Horario> getHorariosDaDisciplina(Disciplina disciplina) {
        return disciplinaHorarios.getOrDefault(disciplina, new ArrayList<>());
    }

    public void adicionarDisciplinaParaAluno(Aluno aluno, Disciplina disciplina) throws DisciplinaInvalidaException {
        if (disciplina == null || !disciplina.isValid()) {
            throw new DisciplinaInvalidaException("Disciplina inválida!");
        }
        AlunoDisciplina alunoDisciplina = new AlunoDisciplina(aluno, disciplina);
        aluno.adicionarAlunoDisciplina(alunoDisciplina);
        disciplina.adicionarAlunoDisciplina(alunoDisciplina);
    }

    public void adicionarProfessorParaDisciplina(Disciplina disciplina, Professor professor) throws ProfessorNaoEncontradoException {
        if (professor == null || !professor.isValid()) {
            throw new ProfessorNaoEncontradoException("Professor não encontrado!");
        }
        ProfessorDisciplina professorDisciplina = new ProfessorDisciplina(professor, disciplina);
        professor.adicionarProfessorDisciplina(professorDisciplina);
        disciplina.adicionarProfessorDisciplina(professorDisciplina);
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
