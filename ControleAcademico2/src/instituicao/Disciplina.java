package instituicao;

import java.util.ArrayList;
import java.util.List;
import instituicao.intermediarias.AlunoDisciplina;
import instituicao.intermediarias.ProfessorDisciplina;

public class Disciplina {
    private String nome;
    private String codigo;
    private List<AlunoDisciplina> alunoDisciplinas;
    private List<ProfessorDisciplina> professorDisciplinas;

    public Disciplina(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
        this.alunoDisciplinas = new ArrayList<>();
        this.professorDisciplinas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void adicionarAlunoDisciplina(AlunoDisciplina alunoDisciplina) {
        if (alunoDisciplina != null && !alunoDisciplinas.contains(alunoDisciplina)) {
            alunoDisciplinas.add(alunoDisciplina);
        }
    }

    public void adicionarProfessorDisciplina(ProfessorDisciplina professorDisciplina) {
        if (professorDisciplina != null && !professorDisciplinas.contains(professorDisciplina)) {
            professorDisciplinas.add(professorDisciplina);
        }
    }

    public List<AlunoDisciplina> getAlunoDisciplinas() {
        return alunoDisciplinas;
    }

    public List<ProfessorDisciplina> getProfessorDisciplinas() {
        return professorDisciplinas;
    }

    public boolean isValid() {
        return nome != null && !nome.isEmpty() && codigo != null && !codigo.isEmpty();
    }
}
