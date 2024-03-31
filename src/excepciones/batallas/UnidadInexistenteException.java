package excepciones.batallas;

public class UnidadInexistenteException extends Exception {

    public UnidadInexistenteException() {
    }

    public UnidadInexistenteException(String message) {
        super(message);
    }

    public UnidadInexistenteException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnidadInexistenteException(Throwable cause) {
        super(cause);
    }
}
