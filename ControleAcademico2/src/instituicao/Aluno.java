package instituicao;

import instituicao.intermediarias.AlunoDisciplina;
import instituicao.exceptions.AssociacaoNaoEncontradaException;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nome;
    private String matricula;
    private List<AlunoDisciplina> alunoDisciplinas;

    public Aluno(String nome, String matricula) {
        if (nome == null || nome.isEmpty() || matricula == null || matricula.isEmpty()) {
            throw new IllegalArgumentException("Nome e matrícula não podem ser nulos ou vazios");
        }
        this.nome = nome;
        this.matricula = matricula;
        this.alunoDisciplinas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public List<AlunoDisciplina> getAlunoDisciplinas() {
        return alunoDisciplinas;
    }

    // Método para adicionar AlunoDisciplina
    public void adicionarAlunoDisciplina(AlunoDisciplina alunoDisciplina) {
        if (!alunoDisciplinas.contains(alunoDisciplina)) {
            alunoDisciplinas.add(alunoDisciplina);
        } else {
            throw new IllegalArgumentException("Disciplina já associada ao aluno");
        }
    }

    // Método isValid para validar o aluno
    public boolean isValid() {
        return nome != null && !nome.isEmpty() && matricula != null && !matricula.isEmpty();
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        AlunoDisciplina alunoDisciplina = new AlunoDisciplina(this, disciplina);
        this.adicionarAlunoDisciplina(alunoDisciplina);
    }

    public void removerDisciplina(Disciplina disciplina) throws AssociacaoNaoEncontradaException {
        AlunoDisciplina alunoDisciplina = new AlunoDisciplina(this, disciplina);
        if (!alunoDisciplinas.remove(alunoDisciplina)) {
            throw new AssociacaoNaoEncontradaException("Associação entre aluno e disciplina não encontrada!");
        }
    }
}
