package excepciones.batallas;

public class NombreExistenteException extends Exception {

    public NombreExistenteException() {
    }

    public NombreExistenteException(String message) {
        super(message);
    }

    public NombreExistenteException(String message, Throwable cause) {
        super(message, cause);
    }

    public NombreExistenteException(Throwable cause) {
        super(cause);
    }
}
