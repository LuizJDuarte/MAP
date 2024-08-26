package instituicao.exceptions;

public class DisciplinaInvalidaException extends Exception {
    private static final long serialVersionUID = 1L;
    //
    public DisciplinaInvalidaException(String mensagem) {
        super(mensagem);
    }
}
