package excepciones.batallas;

public class EjercitoVacioException extends Exception {

    public EjercitoVacioException() {
    }

    public EjercitoVacioException(String message) {
        super(message);
    }

    public EjercitoVacioException(String message, Throwable cause) {
        super(message, cause);
    }

    public EjercitoVacioException(Throwable cause) {
        super(cause);
    }
}
