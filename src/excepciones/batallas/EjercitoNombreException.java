package excepciones.batallas;

public class EjercitoNombreException extends Exception {

    public EjercitoNombreException() {
    }

    public EjercitoNombreException(String message) {
        super(message);
    }

    public EjercitoNombreException(String message, Throwable cause) {
        super(message, cause);
    }

    public EjercitoNombreException(Throwable cause) {
        super(cause);
    }
}
