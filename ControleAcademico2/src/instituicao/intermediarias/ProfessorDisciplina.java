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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProfessorDisciplina that = (ProfessorDisciplina) o;

        if (!professor.equals(that.professor)) return false;
        return disciplina.equals(that.disciplina);
    }

    @Override
    public int hashCode() {
        int result = professor.hashCode();
        result = 31 * result + disciplina.hashCode();
        return result;
    }
}
