/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componentes.animales;

import java.util.List;
import java.util.Random;

/**
 * @author danie
 */
public class Tigre extends Animal {
    public static final int PESO_TIGRE = 5;

    public Tigre() {
        super();
        setMultiplicador(1.5f);
        setPeso(PESO_TIGRE);

        List<Integer> atributos = generarAtributos(150);
        setAtaque((int) Math.ceil(atributos.get(0) * getMultiplicador()));
        setDefensa((int) Math.ceil(atributos.get(1) * getMultiplicador()));
        setSalud((int) Math.ceil(atributos.get(2) * getMultiplicador()));
    }

    @Override
    public String toString() {
        return "Tigre {" +
                "Nombre='" + this.getNombre() + '\'' +
                ", Ataque='" + this.getAtaque() + '\'' +
                ", Defensa='" + this.getDefensa() + '\'' +
                ", Salud='" + this.getSalud() + '\'' +
                ", Peso='" + this.getPeso() + '\'' +
                '}';
    }
}
