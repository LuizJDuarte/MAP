package instituicao.intermediarias;

import instituicao.Aluno;
import instituicao.Disciplina;

public class AlunoDisciplina {
    private Aluno aluno;
    private Disciplina disciplina;

    public AlunoDisciplina(Aluno aluno, Disciplina disciplina) {
        if (aluno == null || disciplina == null) {
            throw new IllegalArgumentException("Aluno e Disciplina não podem ser nulos");
        }
        this.aluno = aluno;
        this.disciplina = disciplina;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlunoDisciplina that = (AlunoDisciplina) o;

        if (!aluno.equals(that.aluno)) return false;
        return disciplina.equals(that.disciplina);
    }

    @Override
    public int hashCode() {
        int result = aluno.hashCode();
        result = 31 * result + disciplina.hashCode();
        return result;
    }
}
