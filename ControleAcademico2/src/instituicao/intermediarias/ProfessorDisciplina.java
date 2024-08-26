package instituicao.intermediarias;

import instituicao.Disciplina;
import instituicao.Professor;

public class ProfessorDisciplina {
    private Professor professor;
    private Disciplina disciplina;

    public ProfessorDisciplina(Professor professor, Disciplina disciplina) {
        if (professor == null || disciplina == null) {
            throw new IllegalArgumentException("Professor e Disciplina não podem ser nulos");
        }
        this.professor = professor;
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }
}
