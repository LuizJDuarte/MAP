package instituicao;

import instituicao.intermediarias.ProfessorDisciplina;
import instituicao.exceptions.AssociacaoNaoEncontradaException;

import java.util.ArrayList;
import java.util.List;

public class Professor {
    private String nome;
    private String id;
    private List<ProfessorDisciplina> professorDisciplinas;

    public Professor(String nome, String id) {
        if (nome == null || nome.isEmpty() || id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Nome e ID não podem ser nulos ou vazios");
        }
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

    // Método para adicionar ProfessorDisciplina
    public void adicionarProfessorDisciplina(ProfessorDisciplina professorDisciplina) {
        if (!professorDisciplinas.contains(professorDisciplina)) {
            professorDisciplinas.add(professorDisciplina);
        } else {
            throw new IllegalArgumentException("Disciplina já associada ao professor");
        }
    }

    // Método isValid para validar o professor
    public boolean isValid() {
        return nome != null && !nome.isEmpty() && id != null && !id.isEmpty();
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        ProfessorDisciplina professorDisciplina = new ProfessorDisciplina(this, disciplina);
        this.adicionarProfessorDisciplina(professorDisciplina);
    }

    public void removerDisciplina(Disciplina disciplina) throws AssociacaoNaoEncontradaException {
        ProfessorDisciplina professorDisciplina = new ProfessorDisciplina(this, disciplina);
        if (!professorDisciplinas.remove(professorDisciplina)) {
            throw new AssociacaoNaoEncontradaException("Associação entre professor e disciplina não encontrada!");
        }
    }
}
