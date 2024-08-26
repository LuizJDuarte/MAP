package instituicao.creator;

import instituicao.Aluno;
import instituicao.Disciplina;
import instituicao.Horario;
import instituicao.Professor;

public class EntityCreator {

    public static Professor criarProfessor(String nome, String id) {
        return new Professor(nome, id);
    }

    public static Aluno criarAluno(String nome, String matricula) {
        return new Aluno(nome, matricula);
    }

    public static Disciplina criarDisciplina(String nome, String codigo) {
        return new Disciplina(nome, codigo);
    }

    public static Horario criarHorario(String dia, String hora) {
        return new Horario(dia, hora);
    }
}
