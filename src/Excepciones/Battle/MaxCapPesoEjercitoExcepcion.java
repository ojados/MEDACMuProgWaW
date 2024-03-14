package Excepciones.Battle;

public class MaxCapPesoEjercitoExcepcion extends Exception {

    static int capacidadMax = 50;

    public MaxCapPesoEjercitoExcepcion(String message) {
        super(message);
    }

    public static void PesoMaximo() throws MaxCapPesoEjercitoExcepcion {
        if (capacidadMax > 50) ;
        throw new MaxCapPesoEjercitoExcepcion("La capacidad del ejercito excede el limite");

    }

}
