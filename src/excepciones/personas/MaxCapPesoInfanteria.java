package excepciones.personas;

public class MaxCapPesoInfanteria extends Exception {

    static int infanteriaPesoMax = 1;
    public MaxCapPesoInfanteria(String message) {
        super(message);
    }

    public static void MaxCapPesoInfanteria () throws MaxCapPesoInfanteria {
        if (infanteriaPesoMax > 1);
        throw new MaxCapPesoInfanteria("Excede el peso de la caballeria");
    }
}
