package instituicao;

public class Horario {
    private String dia;
    private String hora;

    public Horario(String dia, String hora) {
        if (dia == null || dia.isEmpty() || hora == null || hora.isEmpty()) {
            throw new IllegalArgumentException("Dia e hora não podem ser nulos ou vazios");
        }
        this.dia = dia;
        this.hora = hora;
    }

    public String getDia() {
        return dia;
    }

    public String getHora() {
        return hora;
    }

    @Override
    public String toString() {
        return "Horario [dia=" + dia + ", hora=" + hora + "]";
    }
}
