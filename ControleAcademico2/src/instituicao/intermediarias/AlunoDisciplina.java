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
}
