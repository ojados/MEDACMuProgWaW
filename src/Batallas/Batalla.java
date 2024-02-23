/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Batallas;
import java.util.ArrayList;
/**
 *
 * @author danie
 */
public class Batalla {
    private final Ejercito ejercito1;
    private final Ejercito ejercito2;
    private int numRondas;
    private Ejercito ganador;
    private static final int MAX_Rondas = 5;
    private ArrayList<Ronda> rondas;
    public Batalla(){
        ejercito1 = new Ejercito();
        ejercito2 = new Ejercito();
        numRondas = 0;
        rondas = new ArrayList<>();
        luchar();
    }
    
    private void luchar(){
        Ejercito atacante = ejercito1;
        Ejercito defensor = ejercito2;
        
        for (numRondas=0; numRondas<MAX_Rondas; numRondas++){
            rondas.add(new Ronda(numRondas, atacante, defensor));
            int resultado = rondas.getLast().getResultado();
            if (resultado > 0) {
                atacante.recibirDano(resultado);
            } else {
                defensor.recibirDano(Math.abs(resultado));
            }
            if (atacante == ejercito1) {
                atacante = ejercito2;
                defensor = ejercito1;
            } else {
                atacante = ejercito1;
                defensor = ejercito2;
            }
            if (chequearGanador() != null) {
                ganador = chequearGanador();
                    break;
            } else {
                continue;
            }
            
        }
    }
    
    private Ejercito chequearGanador(){
        if (ejercito1.getSalud() == 0) {
            return ejercito1;
        } else if (ejercito2.getSalud() == 0) {
            return ejercito2;
    } else {
            return null;
            }
    }
    
}
