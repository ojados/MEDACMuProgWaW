package Excepciones.Animals;

public class MaxCapPesoTigreExcepcion extends Exception {

    static int capacidadPesoMax = 5;

    public MaxCapPesoTigreExcepcion(String message) {
        super(message);
    }

    public static void PesoMaximoTigre() throws MaxCapPesoTigreExcepcion {
        if (capacidadPesoMax > 5) ;
        throw new MaxCapPesoTigreExcepcion("La capacidad excede el peso limite");
    }
}