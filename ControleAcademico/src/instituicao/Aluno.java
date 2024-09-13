package instituicao;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nome;
    private String id;
    private List<Disciplina> disciplinas;
    private List<Horario> horarios;

    public Aluno(String nome, String id) {
        this.nome = nome;
        this.id = id;
        this.disciplinas = new ArrayList<>();
        this.horarios = new ArrayList<>();
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        if (!disciplinas.contains(disciplina)) {
            disciplinas.add(disciplina);
            disciplina.adicionarAluno(this);
        }
    }

    public void removerDisciplina(Disciplina disciplina) {
        if (disciplinas.contains(disciplina)) {
            disciplinas.remove(disciplina);
            disciplina.removerAluno(this);
        }
    }

    public void adicionarHorario(Horario horario) {
        horarios.add(horario);
    }

    public List<Disciplina> obterDisciplinas() {
        return new ArrayList<>(disciplinas);
    }

    public List<Horario> obterHorarios() {
        return new ArrayList<>(horarios);
    }

    @Override
    public String toString() {
        return "Aluno [nome=" + nome + ", id=" + id + "]";
    }
}
