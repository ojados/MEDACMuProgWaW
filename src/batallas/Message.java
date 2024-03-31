package batallas;

public final class Message {

    private Message() {
        throw new IllegalStateException("Utility class");
    }

    public static final String MAX_CAP_PESO_EJERCITO = "El peso del ejército ha alcanzado el límite máximo";
    public static final String EJERCITO_VACIO = "El ejército está vacío";
    public static final String MAX_ANIMALES = "El número de animales ha alcanzado el límite máximo";
    public static final String UNIDAD_SUPERA_PESO = "La unidad supera el peso máximo";
    public static final String PESO_DISPONIBLE = "El peso disponible es de ";
    public static final String EJERCITO_SIN_NOMBRE = "El ejército no tiene nombre";
    public static final String GENERAL_EXISTENTE = "El ejército ya tiene un general";
    public static final String ADICIONAR_COMPONENTE = "Se ha añadido un nuevo componente al ejercito: ";
    public static final String SALDO_ACTUAL = "Saldo actual del ejercito: ";
    public static final String UNIDADES_MINIMAS = "El Ejército debe tener al menos 2 unidades";
    public static final String GENERAL_MINIMO = "El Ejército debe tener al menos 1 General";
    public static final String OPCION_INAVLIDA = "Opción no válida";
    public static final String EJERCITO_GANADOR = "El ganador es el ejército ";
    public static final String NOMBRE_EXISTENTE = "El nombre ya existe";
    public static final String UNIDAD_INEXISTENTE = "No existe la unidad";
    public static final String UNIDAD_ELIM_SATIS = "Unidad eliminada satisfactoriamente";
    public static final String BATALLA_INICIO = "¡Comienza la batalla entre ";
}
