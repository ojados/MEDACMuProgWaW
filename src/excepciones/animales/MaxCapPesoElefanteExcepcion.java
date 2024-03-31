package excepciones.animales;

public class MaxCapPesoElefanteExcepcion extends Exception {

    static int ElefantePesoMax = 10;

    public MaxCapPesoElefanteExcepcion(String message) {
        super(message);
    }

    public static void PesoMaxElefante() throws MaxCapPesoElefanteExcepcion {
        if (ElefantePesoMax > 10) ;
        throw new MaxCapPesoElefanteExcepcion("La capacidad excede el peso limite");

    }

}