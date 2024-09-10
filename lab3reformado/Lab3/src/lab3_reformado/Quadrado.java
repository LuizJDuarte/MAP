package lab3_reformado;

import excecoes.ExcecaoValorNegativo;
import excecoes.ExcecaoValorZero;

public class Quadrado implements FiguraGeometrica{
	
	private float lado;

	//construtor
	public Quadrado(float lado) throws ExcecaoValorZero, ExcecaoValorNegativo {
		if (lado == 0) throw new ExcecaoValorZero();
		if (lado < 0) throw new ExcecaoValorNegativo();
		this.lado = lado;
	}

	//getters and setters
	public float getLado() {
		return lado;
	}
	public void setLado(float lado) {
		this.lado = lado;
	}
	
	@Override
	public float calcularArea() {
		return lado*lado;
	}

	@Override
	public String nomeDaFigura() {
		return "Quadrado";
	}

	@Override
	public float calcularPerimetro() {
		return lado*4;
	}

}
