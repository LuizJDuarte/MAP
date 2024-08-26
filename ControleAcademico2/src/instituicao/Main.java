package instituicao;

import instituicao.exceptions.DisciplinaInvalidaException;
import instituicao.exceptions.ProfessorNaoEncontradoException;
import instituicao.intermediarias.AlunoDisciplina;
import instituicao.intermediarias.ProfessorDisciplina;

public class Main {
    public static void main(String[] args) {
        ControleAcademico controle = new ControleAcademico();

        //adicionando Alunos
        Aluno aluno1 = new Aluno("Luiz José", "20230001");
        Aluno aluno2 = new Aluno("Raquel de Queiroz", "20230002");
        Aluno aluno3 = new Aluno("Luiz Duarte", "20230003");
        Aluno aluno4 = new Aluno("Raquel Melo", "20230004");

        controle.adicionarAluno(aluno1);
        controle.adicionarAluno(aluno2);
        controle.adicionarAluno(aluno3);
        controle.adicionarAluno(aluno4);

        //Adicionando Disciplinas
        Disciplina disciplina1 = new Disciplina("Métodos avançados de programação", "MAP101");
        Disciplina disciplina2 = new Disciplina("Sistemas operacionais", "SOP101");
        Disciplina disciplina3 = new Disciplina("Engenharia de Software", "ESW101");
        Disciplina disciplina4 = new Disciplina("Compiladores", "COP101");

        controle.adicionarDisciplina(disciplina1);
        controle.adicionarDisciplina(disciplina2);
        controle.adicionarDisciplina(disciplina3);
        controle.adicionarDisciplina(disciplina4);

        //add Professores
        Professor professor1 = new Professor("Sabrina", "12345");
        Professor professor2 = new Professor("Ana Isabella", "67890");
        Professor professor3 = new Professor("Kézia", "11223");
        Professor professor4 = new Professor("Fábio Leite", "44556");

        controle.adicionarProfessor(professor1);
        controle.adicionarProfessor(professor2);
        controle.adicionarProfessor(professor3);
        controle.adicionarProfessor(professor4);

        //add horários
        Horario horario1 = new Horario("Segunda-feira", "08:00 - 10:00");
        Horario horario2 = new Horario("Quarta-feira", "10:00 - 12:00");
        Horario horario3 = new Horario("Sexta-feira", "14:00 - 16:00");
        Horario horario4 = new Horario("Terça-feira", "08:00 - 10:00");

        controle.adicionarHorario(horario1);
        controle.adicionarHorario(horario2);
        controle.adicionarHorario(horario3);
        controle.adicionarHorario(horario4);

        //Horários + Disciplinas
        controle.associarHorarioADisciplina(disciplina1, horario1);
        controle.associarHorarioADisciplina(disciplina2, horario2);
        controle.associarHorarioADisciplina(disciplina3, horario3);
        controle.associarHorarioADisciplina(disciplina4, horario4);

        try {
            //Associando Disciplinas a Alunos
            controle.adicionarDisciplinaParaAluno(aluno1, disciplina1);
            controle.adicionarDisciplinaParaAluno(aluno2, disciplina2);
            controle.adicionarDisciplinaParaAluno(aluno3, disciplina3);
            controle.adicionarDisciplinaParaAluno(aluno4, disciplina4);

            controle.adicionarDisciplinaParaAluno(aluno1, disciplina2); // Aluno 1 em mais de uma disciplina
            controle.adicionarDisciplinaParaAluno(aluno2, disciplina3); // Aluno 2 em mais de uma disciplina

            //Associando Professores a Disciplinas
            controle.adicionarProfessorParaDisciplina(disciplina1, professor1);
            controle.adicionarProfessorParaDisciplina(disciplina2, professor2);
            controle.adicionarProfessorParaDisciplina(disciplina3, professor3);
            controle.adicionarProfessorParaDisciplina(disciplina4, professor4);

        } catch (DisciplinaInvalidaException | ProfessorNaoEncontradoException e) {
            //Removido o tratamento de erro para não interromper a execução
        	//System.out.println("Erro ao associar professor ou disciplina: " + e.getMessage());

        }

        //informações dos professores
        System.out.println("\n=== Informações dos Professores ===");
        for (Professor professor : controle.getProfessores()) {
            System.out.println("Professor: " + professor.getNome() + " | ID: " + professor.getId());
            System.out.println("Disciplinas ministradas:");
            for (ProfessorDisciplina pd : professor.getProfessorDisciplinas()) {
                System.out.println(" - " + pd.getDisciplina().getNome() + " (" + pd.getDisciplina().getCodigo() + ")");
            }
            System.out.println();
        }

        //informações das disciplinas
        System.out.println("=== Informações das Disciplinas ===");
        for (Disciplina disciplina : controle.getDisciplinas()) {
            System.out.println("Disciplina: " + disciplina.getNome() + " | Código: " + disciplina.getCodigo());
            System.out.println("Horário(s):");
            for (Horario horario : controle.getHorariosDaDisciplina(disciplina)) {
                System.out.println(" - " + horario.getDia() + ", " + horario.getHora());
            }
            System.out.println("Professor(es) responsável(is):");
            for (ProfessorDisciplina pd : disciplina.getProfessorDisciplinas()) {
                System.out.println(" - " + pd.getProfessor().getNome());
            }
            System.out.println("Alunos matriculados:");
            for (AlunoDisciplina ad : disciplina.getAlunoDisciplinas()) {
                System.out.println(" - " + ad.getAluno().getNome());
            }
            System.out.println();
        }

        //informações dos alunos
        System.out.println("=== Informações dos Alunos ===");
        for (Aluno aluno : controle.getAlunos()) {
            System.out.println("Aluno: " + aluno.getNome() + " | Matrícula: " + aluno.getMatricula());
            System.out.println("Disciplinas matriculadas:");
            for (AlunoDisciplina ad : aluno.getAlunoDisciplinas()) {
                System.out.println(" - " + ad.getDisciplina().getNome() + " (" + ad.getDisciplina().getCodigo() + ")");
            }
            System.out.println();
        }
    }
}
