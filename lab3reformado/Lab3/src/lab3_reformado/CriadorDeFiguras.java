package lab3_reformado;

import excecoes.ExcecaoValorNegativo;
import excecoes.ExcecaoValorZero;

//Creator
public class CriadorDeFiguras {
    public Circulo criarCirculo(float raio) throws ExcecaoValorZero, ExcecaoValorNegativo {
        return new Circulo(raio);
    }

    public Quadrado criarQuadrado(float lado) throws ExcecaoValorZero, ExcecaoValorNegativo {
        return new Quadrado(lado);
    }

    public Retangulo criarRetangulo(float base, float altura) throws ExcecaoValorZero, ExcecaoValorNegativo {
        return new Retangulo(base, altura);
    }
}
