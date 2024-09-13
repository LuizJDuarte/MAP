//package test;
//
//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.Test;
//import globo.exceptions.FilmeInvalidoException;
//
//public class FilmeInvalidoExceptionTest {
//
//    @Test
//    public void testFilmeInvalidoException() {
//        FilmeInvalidoException e = assertThrows(FilmeInvalidoException.class, () -> {
//            throw new FilmeInvalidoException("Erro ao criar filme");
//        });
//        assertEquals("Erro ao criar filme", e.getMessage());
//    }
//}
