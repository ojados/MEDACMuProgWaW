package excepciones.batallas;

public class UnidadMinimaException extends Exception {

    public UnidadMinimaException() {
    }

    public UnidadMinimaException(String message) {
        super(message);
    }

    public UnidadMinimaException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnidadMinimaException(Throwable cause) {
        super(cause);
    }
}
