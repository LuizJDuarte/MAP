package lab3_reformado;

import excecoes.ExcecaoValorNegativo;
import excecoes.ExcecaoValorZero;

public class Retangulo implements FiguraGeometrica {
	
	private float base;
	private float altura;
	
	public Retangulo(float base, float altura) throws ExcecaoValorZero, ExcecaoValorNegativo {
		if (base == 0) throw new ExcecaoValorZero("Base não pode ser 0");
		if (altura == 0) throw new ExcecaoValorZero("Altura não pode ser 0");
		if (base < 0) throw new ExcecaoValorNegativo("Base não pode ser negativa");
		if (altura < 0) throw new ExcecaoValorNegativo("Altura não pode ser negativa");
		this.base = base;
		this.altura = altura;
	}
	
	@Override
	public float calcularArea() {
		return base*altura;
	}
	@Override
	public String nomeDaFigura() {
		return "Retangulo";
	}
	@Override
	public float calcularPerimetro() {
		return (base*2)+(altura*2);
	}
	public float getBase() {
		return base;
	}
	public void setBase(float base) {
		this.base = base;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	

}
