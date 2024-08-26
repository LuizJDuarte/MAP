package instituicao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HorarioTest {
    private Horario horario;

    @BeforeEach //esse metdo tem que ser executado antes dos testes
    public void setUp() {
        horario = new Horario("Segunda-feira", "08:00 - 10:00");
    }

    @Test
    public void testObterDia() {
        assertEquals("Segunda-feira", horario.obterDia());
    }

    @Test
    public void testObterHora() {
        assertEquals("08:00 - 10:00", horario.obterHora());
    }

    @Test
    public void testToString() {
        String expected = "Horario [dia=Segunda-feira, hora=08:00 - 10:00]";
        assertEquals(expected, horario.toString());
    }
}
