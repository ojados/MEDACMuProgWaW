/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Componentes.Animales;

import Componentes.Animales.Animal;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author danie
 */
public class Elefante extends Animal{
public static final int PESO_ELEFANTE = 10;    
    public Elefante(){
        super();
        Random random = new Random(); 
        setMultiplicador(2f);   
        setPeso(10);        
        ArrayList<Integer> atributos = generarAtributos(150);
        setAtaque((int) Math.ceil(atributos.get(0)*getMultiplicador()));
        setDefensa((int) Math.ceil(atributos.get(1)*getMultiplicador()));
        setSalud((int) Math.ceil(atributos.get(2)*getMultiplicador()));    
    }
    
    @Override
public String toString() {
        return "Elefante {" +
                "Nombre='" + this.getNombre() + '\'' +
                ", Ataque='" + this.getAtaque() + '\'' +
                ", Defensa='" + this.getDefensa() + '\'' +
                ", Salud='" + this.getSalud() + '\'' +                
                ", Peso='" + this.getPeso() + '\'' +
                '}';
    }       
}
