package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import excecoes.*;
import lab3_reformado.Retangulo;
import lab3_reformado.Circulo;
import lab3_reformado.FiguraGeometrica;
import lab3_reformado.Quadrado;

class FiguraGeometricaTest {

	@Test
	@DisplayName("Deve calcular area.")
	void CalcularArea() throws ExcecaoValorZero, ExcecaoValorNegativo {
		FiguraGeometrica retangulo;
			retangulo = new Retangulo(4.0f, 2.0f);
			assertEquals(8.0, retangulo.calcularArea(), 0f);
		
		try {
			FiguraGeometrica quadrado = new Quadrado(4.0f);
			assertEquals(16.0, quadrado.calcularArea(), 0f);
		} catch (ExcecaoValorZero e) {
			System.out.println("Erro: valor foi 0.");
		} catch (ExcecaoValorNegativo e) {
			System.out.println("Erro: valor foi negativo.");

		}

		FiguraGeometrica circulo;
		try {
			circulo = new Circulo(3.0f);
			assertEquals(28.26f, circulo.calcularArea(), 0f);
		} catch (ExcecaoValorZero | ExcecaoValorNegativo e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Test
	@DisplayName("Deve calcular perimetro.")
	void CalcularPerimetro() throws ExcecaoValorZero, ExcecaoValorNegativo {
		FiguraGeometrica figura;
		figura = new Retangulo(4.0f, 2.0f);
		assertEquals(12.0, figura.calcularPerimetro(), 0f);
		
		figura = new Quadrado(6.0f);
		assertEquals(24.0f, figura.calcularPerimetro(), 0f);
		
		figura = new Circulo(1.0f);
		assertEquals(6.28f, figura.calcularPerimetro(), 0f);
		
	}

	
	@Test
	@DisplayName("Não deve aceitar o valor zero.")
	void testaValorZero() {

		Exception exception = assertThrows(ExcecaoValorZero.class, () -> new Quadrado(0));
		assertEquals("Valor precisa ser diferente de 0", exception.getMessage());

		exception = assertThrows(ExcecaoValorZero.class, () -> new Retangulo(0, 8));
		assertEquals("Base não pode ser 0", exception.getMessage());
		
		exception = assertThrows(ExcecaoValorZero.class, () -> new Retangulo(8, 0));
		assertEquals("Altura não pode ser 0", exception.getMessage());
		
		exception = assertThrows(ExcecaoValorZero.class, () -> new Circulo(0));
		assertEquals("Valor precisa ser diferente de 0", exception.getMessage());
		
	}
	
	@Test
	@DisplayName("Não deve aceitar valores negativos.")
	void testaValorNegativo() {

		Exception exception = assertThrows(ExcecaoValorNegativo.class, () -> new Quadrado(-2));
		assertEquals("Valor não pode ser negativo", exception.getMessage());
		

		exception = assertThrows(ExcecaoValorNegativo.class, () -> new Retangulo(4, -2));
		assertEquals("Altura não pode ser negativa", exception.getMessage());
		
		exception = assertThrows(ExcecaoValorNegativo.class, () -> new Retangulo(-4, 2));
		assertEquals("Base não pode ser negativa", exception.getMessage());
		
		
		exception = assertThrows(ExcecaoValorNegativo.class, () -> new Circulo(-2));
		assertEquals("Valor não pode ser negativo", exception.getMessage());
		
	}
	
}
