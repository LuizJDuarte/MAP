package lab3_reformado;

import excecoes.ExcecaoValorNegativo;
import excecoes.ExcecaoValorZero;

public class Main {
    public static void main(String[] args) {
        CriadorDeFiguras criador = new CriadorDeFiguras();
        
        try {
            Circulo circulo = criador.criarCirculo(5);
            Quadrado quadrado = criador.criarQuadrado(4);
            Retangulo retangulo = criador.criarRetangulo(6, 3);

            System.out.println(circulo.nomeDaFigura() + " - Área: " + circulo.calcularArea() + ", Perímetro: " + circulo.calcularPerimetro());
            System.out.println(quadrado.nomeDaFigura() + " - Área: " + quadrado.calcularArea() + ", Perímetro: " + quadrado.calcularPerimetro());
            System.out.println(retangulo.nomeDaFigura() + " - Área: " + retangulo.calcularArea() + ", Perímetro: " + retangulo.calcularPerimetro());
            
        } catch (ExcecaoValorZero | ExcecaoValorNegativo e) {
            System.out.println("Erro ao criar figura: " + e.getMessage());
        }
    }
}
