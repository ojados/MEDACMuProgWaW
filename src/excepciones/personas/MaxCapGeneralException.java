package excepciones.personas;

public class MaxCapGeneralException extends Exception {

    public MaxCapGeneralException() {
    }

    public MaxCapGeneralException(String message) {
        super(message);
    }

    public MaxCapGeneralException(String message, Throwable cause) {
        super(message, cause);
    }

    public MaxCapGeneralException(Throwable cause) {
        super(cause);
    }
}