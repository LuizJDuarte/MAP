package excecoes;

public class ExcecaoValorZero extends Exception {

	public ExcecaoValorZero() {
		super("Valor precisa ser diferente de 0", new Throwable("valor == 0"));

	}
	
	public ExcecaoValorZero (String mensagem) {
		super(mensagem);
	}

}
