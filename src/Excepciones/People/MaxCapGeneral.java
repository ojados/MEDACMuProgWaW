package Excepciones.People;

public class MaxCapGeneral extends Exception {

    static int generalPeso = 1;
    public MaxCapGeneral(String message) {
        super(message);
    }

    public static void GeneralMaximo() throws MaxCapGeneral {
        if (generalPeso > 1);

        throw new MaxCapGeneral("Solo se permite un solo general");
    }
}