package lab3_reformado;

import excecoes.ExcecaoValorNegativo;
import excecoes.ExcecaoValorZero;

public class Circulo implements FiguraGeometrica {
	
	private float raio;

	public float getRaio() {
		return raio;
	}

	public void setRaio(float raio) {
		this.raio = raio;
	}

	public Circulo (float raio) throws ExcecaoValorZero, ExcecaoValorNegativo {
		if (raio == 0) throw new ExcecaoValorZero();
		if (raio < 0) throw new ExcecaoValorNegativo();
		this.raio = raio;
	}

	@Override
	public float calcularArea() {
		//a = pi *r²
		return (float) (3.14 * (raio*raio));
	}

	@Override
	public String nomeDaFigura() {
		return "Círculo";
	}

	@Override
	public float calcularPerimetro() {
		//p = 2*pi*r
		return (float) (2*3.14*raio);
	}

}
