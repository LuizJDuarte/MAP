package instituicao;

import java.util.ArrayList;
import java.util.List;
import instituicao.intermediarias.ProfessorDisciplina;

public class Professor {
    private String nome;
    private String id;
    private List<ProfessorDisciplina> professorDisciplinas;

    public Professor(String nome, String id) {
        this.nome = nome;
        this.id = id;
        this.professorDisciplinas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }

    public List<ProfessorDisciplina> getProfessorDisciplinas() {
        return professorDisciplinas;
    }

    public void adicionarProfessorDisciplina(ProfessorDisciplina professorDisciplina) {
        if (professorDisciplina != null && !professorDisciplinas.contains(professorDisciplina)) {
            professorDisciplinas.add(professorDisciplina);
        }
    }

    public boolean isValid() {
        return nome != null && !nome.isEmpty() && id != null && !id.isEmpty();
    }
}
