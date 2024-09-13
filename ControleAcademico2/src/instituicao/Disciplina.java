package instituicao;

import instituicao.intermediarias.ProfessorDisciplina;
import instituicao.intermediarias.AlunoDisciplina;
import instituicao.exceptions.AssociacaoNaoEncontradaException;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String nome;
    private String codigo;
    private List<AlunoDisciplina> alunoDisciplinas;
    private List<ProfessorDisciplina> professorDisciplinas;
    private List<Horario> horarios;

    public Disciplina(String nome, String codigo) {
        if (nome == null || nome.isEmpty() || codigo == null || codigo.isEmpty()) {
            throw new IllegalArgumentException("Nome e código não podem ser nulos ou vazios");
        }
        this.nome = nome;
        this.codigo = codigo;
        this.alunoDisciplinas = new ArrayList<>();
        this.professorDisciplinas = new ArrayList<>();
        this.horarios = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public List<AlunoDisciplina> getAlunoDisciplinas() {
        return alunoDisciplinas;
    }

    public List<ProfessorDisciplina> getProfessorDisciplinas() {
        return professorDisciplinas;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void adicionarHorario(Horario horario) {
        if (!horarios.contains(horario)) {
            horarios.add(horario);
        } else {
            throw new IllegalArgumentException("Horário já associado à disciplina");
        }
    }

    public void adicionarAlunoDisciplina(AlunoDisciplina alunoDisciplina) {
        if (!alunoDisciplinas.contains(alunoDisciplina)) {
            alunoDisciplinas.add(alunoDisciplina);
        } else {
            throw new IllegalArgumentException("Aluno já associado à disciplina");
        }
    }

    public void adicionarProfessorDisciplina(ProfessorDisciplina professorDisciplina) {
        if (!professorDisciplinas.contains(professorDisciplina)) {
            professorDisciplinas.add(professorDisciplina);
        } else {
            throw new IllegalArgumentException("Professor já associado à disciplina");
        }
    }

    public void removerAlunoDisciplina(AlunoDisciplina alunoDisciplina) throws AssociacaoNaoEncontradaException {
        if (!alunoDisciplinas.remove(alunoDisciplina)) {
            throw new AssociacaoNaoEncontradaException("Associação entre aluno e disciplina não encontrada!");
        }
    }

    public void removerProfessorDisciplina(ProfessorDisciplina professorDisciplina) throws AssociacaoNaoEncontradaException {
        if (!professorDisciplinas.remove(professorDisciplina)) {
            throw new AssociacaoNaoEncontradaException("Associação entre professor e disciplina não encontrada!");
        }
    }

    // Método isValid para validar a disciplina
    public boolean isValid() {
        return nome != null && !nome.isEmpty() && codigo != null && !codigo.isEmpty();
    }
}
