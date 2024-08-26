package instituicao;

import java.util.ArrayList;
import java.util.List;
import instituicao.intermediarias.AlunoDisciplina;

public class Aluno {
    private String nome;
    private String matricula;
    private List<AlunoDisciplina> alunoDisciplinas;

    public Aluno(String nome, String matricula) {
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

    public void adicionarAlunoDisciplina(AlunoDisciplina alunoDisciplina) {
        if (alunoDisciplina != null && !alunoDisciplinas.contains(alunoDisciplina)) {
            alunoDisciplinas.add(alunoDisciplina);
        }
    }

    public List<AlunoDisciplina> getAlunoDisciplinas() {
        return alunoDisciplinas;
    }
}
