package excepciones.personas;

public class GeneralMinimoException extends Exception {

    public GeneralMinimoException() {
    }

    public GeneralMinimoException(String message) {
        super(message);
    }

    public GeneralMinimoException(String message, Throwable cause) {
        super(message, cause);
    }

    public GeneralMinimoException(Throwable cause) {
        super(cause);
    }
}
