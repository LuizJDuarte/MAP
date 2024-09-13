package instituicao;

public class Main {
    public static void main(String[] args) {
        // Criar instâncias de Horario
        Horario horario1 = new Horario("Segunda-feira", "10:00-12:00");
        Horario horario2 = new Horario("Quarta-feira", "14:00-16:00");

        // Criar instâncias de Professor
        Professor prof1 = new Professor("João Silva", "P001");
        Professor prof2 = new Professor("Maria Oliveira", "P002");

        // Criar instâncias de Aluno
        Aluno aluno1 = new Aluno("Carlos Souza", "A001");
        Aluno aluno2 = new Aluno("Ana Costa", "A002");

        // Criar instâncias de Disciplina
        Disciplina disc1 = new Disciplina("Matemática", "MAT101");
        Disciplina disc2 = new Disciplina("Física", "FIS102");

        // Associar professores às disciplinas
        prof1.adicionarDisciplina(disc1);
        prof2.adicionarDisciplina(disc2);

        // Associar disciplinas aos alunos
        aluno1.adicionarDisciplina(disc1);
        aluno2.adicionarDisciplina(disc2);

        // Associar horários aos professores e alunos
        prof1.adicionarHorario(horario1);
        prof2.adicionarHorario(horario2);
        aluno1.adicionarHorario(horario1);
        aluno2.adicionarHorario(horario2);

        // Exibir informações
        System.out.println("Disciplinas do Professor " + prof1 + ": " + prof1.obterDisciplinas());
        System.out.println("Horários do Professor " + prof1 + ": " + prof1.obterHorarios());

        System.out.println("Disciplinas do Aluno " + aluno1 + ": " + aluno1.obterDisciplinas());
        System.out.println("Horários do Aluno " + aluno1 + ": " + aluno1.obterHorarios());

        System.out.println("Alunos da Disciplina " + disc1 + ": " + disc1.obterAlunos());
        System.out.println("Número de Alunos na Disciplina " + disc1 + ": " + disc1.obterNumeroDeAlunos());
        System.out.println("Professor da Disciplina " + disc1 + ": " + disc1.obterProfessor());
    }
}

