package excepciones.animales;

public class MaxAnimalesException extends Exception {

    public MaxAnimalesException() {
    }

    public MaxAnimalesException(String message) {
        super(message);
    }

    public MaxAnimalesException(String message, Throwable cause) {
        super(message, cause);
    }

    public MaxAnimalesException(Throwable cause) {
        super(cause);
    }
}
