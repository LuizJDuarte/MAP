package instituicao;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String nome;
    private String codigo;
    private Professor professor;
    private List<Aluno> alunos;

    public Disciplina(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
        this.alunos = new ArrayList<>();
    }

    public void associarProfessor(Professor professor) {
        this.professor = professor;
    }

    public void desassociarProfessor() {
        this.professor = null;
    }

    public void adicionarAluno(Aluno aluno) {
        if (!alunos.contains(aluno)) {
            alunos.add(aluno);
            aluno.adicionarDisciplina(this);
        }
    }

    public void removerAluno(Aluno aluno) {
        if (alunos.contains(aluno)) {
            alunos.remove(aluno);
            aluno.removerDisciplina(this);
        }
    }

    public Professor obterProfessor() {
        return professor;
    }

    public List<Aluno> obterAlunos() {
        return new ArrayList<>(alunos);
    }

    public int obterNumeroDeAlunos() {
        return alunos.size();
    }

    @Override
    public String toString() {
        return "Disciplina [nome=" + nome + ", codigo=" + codigo + "]";
    }
}
