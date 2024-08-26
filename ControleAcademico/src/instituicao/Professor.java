package instituicao;
import java.util.ArrayList;
import java.util.List;

public class Professor {
    private String nome;
    private String id;
    private List<Horario> horarios;
    private List<Disciplina> disciplinas;

    public Professor(String nome, String id) {
        this.nome = nome;
        this.id = id;
        this.horarios = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
    }
    
    public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}



	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}



	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}



	public void adicionarDisciplina(Disciplina disciplina) {
        if (!disciplinas.contains(disciplina)) {
            disciplinas.add(disciplina);
            disciplina.associarProfessor(this);
        }
    }

    public void removerDisciplina(Disciplina disciplina) {
        if (disciplinas.contains(disciplina)) {
            disciplinas.remove(disciplina);
            disciplina.desassociarProfessor();
        }
    }

    public void adicionarHorario(Horario horario) {
        horarios.add(horario);
    }

    public List<Disciplina> obterDisciplinas() {
        return new ArrayList<>(disciplinas);
    }

    public List<Horario> obterHorarios() {
        return new ArrayList<>(horarios);
    }

    @Override
    public String toString() {
        return "Professor [nome=" + nome + ", id=" + id + "]";
    }
    
}
