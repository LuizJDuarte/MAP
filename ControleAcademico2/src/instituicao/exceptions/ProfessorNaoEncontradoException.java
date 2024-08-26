package instituicao.exceptions;

public class ProfessorNaoEncontradoException extends Exception {
    private static final long serialVersionUID = 1L;
    
    
    public ProfessorNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}

