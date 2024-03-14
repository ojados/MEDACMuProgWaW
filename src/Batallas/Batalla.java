/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Batallas;

import java.util.ArrayList;
import java.util.Random;

/**
 * <p>Clase que representa una batalla entre dos ejércitos.</p>
 *
 * @author Daniel Ojados
 * @author Daniel Romero
 * @version 1.0
 */
public class Batalla {
    private static final int MAX_Rondas = 5;
    private final Ejercito ejercito1;
    private final Ejercito ejercito2;
    private int numRondas;
    private Ejercito ganador;
    private final ArrayList<Ronda> rondas;

    public Batalla() {
        ejercito1 = new Ejercito();
        ejercito2 = new Ejercito();
        numRondas = 0;
        rondas = new ArrayList<>();
        luchar();
    }

    private void luchar() {
        Random random = new Random();

        Ejercito atacante;
        Ejercito defensor;

        if (random.nextInt(1, 2) == 1) {
            atacante = ejercito1;
            defensor = ejercito2;
        } else {
            atacante = ejercito2;
            defensor = ejercito1;
        }

        if (ejercito1.getSalud() > 0 && ejercito2.getSalud() > 0) {
            for (numRondas = 0; numRondas < MAX_Rondas; numRondas++) {
                rondas.add(new Ronda(numRondas, atacante, defensor));
                int resultado = rondas.getLast().getResultado();
                if (resultado > 0) {
                    atacante.recibirDano(resultado);
                } else {
                    defensor.recibirDano(Math.abs(resultado));
                }

                if (chequearGanador()) {
                    break;
                }

                if (atacante == ejercito1) {
                    atacante = ejercito2;
                    defensor = ejercito1;
                } else {
                    atacante = ejercito1;
                    defensor = ejercito2;
                }
            }
        }
    }

    private boolean chequearGanador() {
        if (ejercito1.getSalud() == 0) {
            System.out.println(System.lineSeparator() + "El ganador es el ejército " +
                    ejercito2.getNombre());
            return true;
        } else if (ejercito2.getSalud() == 0) {
            System.out.println(System.lineSeparator() + "El ganador es el ejército " +
                    ejercito1.getNombre());
            return true;
        }

        return false;
    }

}
