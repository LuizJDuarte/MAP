package instituicao;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import instituicao.Horario;

public class HorarioTest {
    private Horario horario;

    @Before
    public void setUp() {
        horario = new Horario("Segunda-feira", "08:00 - 10:00");
    }

    @Test
    public void testGetDia() {
        assertEquals("Segunda-feira", horario.getDia());
    }

    @Test
    public void testGetHora() {
        assertEquals("08:00 - 10:00", horario.getHora());
    }

    @Test
    public void testToString() {
        String expected = "Horario [dia=Segunda-feira, hora=08:00 - 10:00]";
        assertEquals(expected, horario.toString());
    }
}
