package launcher;

import instituicao.*;
import instituicao.creator.EntityCreator;
import instituicao.intermediarias.AlunoDisciplina;
import instituicao.intermediarias.ProfessorDisciplina;

public class Main {
    public static void main(String[] args) {
        ControleAcademico controle = new ControleAcademico();

        // Criação de instâncias usando o padrão Creator
        Professor sabrina = controle.adicionarProfessor("Sabrina", "12345");
        Aluno luizJose = controle.adicionarAluno("Luiz José", "20230001");
        Disciplina metodosAvancados = controle.adicionarDisciplina("Métodos Avançados de Programação", "MAP101");
        Horario horario1 = controle.adicionarHorario("Segunda-feira", "08:00 - 10:00");

        // Associação de horários às disciplinas
        controle.associarHorarioADisciplina(metodosAvancados, horario1);

        // Adicionando disciplinas para professores e alunos
        sabrina.adicionarDisciplina(metodosAvancados);
        luizJose.adicionarDisciplina(metodosAvancados);

        // Exibindo as informações do sistema
        System.out.println("=== Informações dos Professores ===");
        for (Professor professor : controle.getProfessores()) {
            System.out.println("Professor: " + professor.getNome() + " | ID: " + professor.getId());
            System.out.println("Disciplinas ministradas:");
            for (ProfessorDisciplina pd : professor.getProfessorDisciplinas()) {
                System.out.println(" - " + pd.getDisciplina().getNome() + " (" + pd.getDisciplina().getCodigo() + ")");
            }
        }

        System.out.println("\n=== Informações dos Alunos ===");
        for (Aluno aluno : controle.getAlunos()) {
            System.out.println("Aluno: " + aluno.getNome() + " | Matrícula: " + aluno.getMatricula());
            System.out.println("Disciplinas matriculadas:");
            for (AlunoDisciplina ad : aluno.getAlunoDisciplinas()) {
                System.out.println(" - " + ad.getDisciplina().getNome() + " (" + ad.getDisciplina().getCodigo() + ")");
            }
        }

        System.out.println("\n=== Informações das Disciplinas ===");
        for (Disciplina disciplina : controle.getDisciplinas()) {
            System.out.println("Disciplina: " + disciplina.getNome() + " | Código: " + disciplina.getCodigo());
            System.out.println("Horário(s):");
            for (Horario h : disciplina.getHorarios()) {
                System.out.println(" - " + h.getDia() + ", " + h.getHora());
            }
            System.out.println("Professor(es) responsável(eis):");
            for (ProfessorDisciplina pd : disciplina.getProfessorDisciplinas()) {
                System.out.println(" - " + pd.getProfessor().getNome());
            }
            System.out.println("Alunos matriculados:");
            for (AlunoDisciplina ad : disciplina.getAlunoDisciplinas()) {
                System.out.println(" - " + ad.getAluno().getNome());
            }
        }
    }
}
