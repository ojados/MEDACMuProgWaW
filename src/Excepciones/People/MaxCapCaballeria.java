package Excepciones.People;

public class MaxCapCaballeria extends Exception{
    static int caballeriaPeso = 2;
    public MaxCapCaballeria(String message) {
        super(message);
    }

    public static void MaxCapCaballeria () throws MaxCapCaballeria {
        if (caballeriaPeso > 2);
        throw new MaxCapCaballeria("Excede el peso de la caballeria");
    }
}
