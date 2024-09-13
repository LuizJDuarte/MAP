package instituicao;

public class Horario {
    private String dia;
    private String hora;

    public Horario(String dia, String hora) {
        this.dia = dia;
        this.hora = hora;
    }

    public String obterDia() {
        return dia;
    }

    public String obterHora() {
        return hora;
    }

    @Override
    public String toString() {
        return "Horario [dia=" + dia + ", hora=" + hora + "]";
    }
}
