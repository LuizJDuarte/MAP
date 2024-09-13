package excecoes;

public class ExcecaoValorNegativo extends Exception {

	public ExcecaoValorNegativo() {
		super("Valor não pode ser negativo", new Throwable("valor < 0"));
	}
	
	public ExcecaoValorNegativo (String mensagem) {
		super(mensagem);
	}
	
}