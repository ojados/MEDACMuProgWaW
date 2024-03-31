package excepciones.batallas;

import java.io.Serial;

public class MaxCapPesoEjercitoException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    public MaxCapPesoEjercitoException() {
    }

    public MaxCapPesoEjercitoException(String message) {
        super(message);
    }

    public MaxCapPesoEjercitoException(Throwable cause) {
        super(cause);
    }

    public MaxCapPesoEjercitoException(String message, Throwable cause) {
        super(message, cause);
    }
}
