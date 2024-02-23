/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Componentes.Personas;

import java.util.ArrayList;

/**
 *
 * @author danie
 */
public class Caballeria extends Persona{
    public static final int PESO_CABALLERIA = 2;
    public Caballeria(){
        super();
        setMultiplicador(1.5f);   
        setPeso(PESO_CABALLERIA);        
        ArrayList<Integer> atributos = generarAtributos(100);
        setAtaque((int) Math.ceil(atributos.get(0)*getMultiplicador()));
        setDefensa((int) Math.ceil(atributos.get(1)*getMultiplicador()));
        setSalud((int) Math.ceil(atributos.get(2)*getMultiplicador()));

    }
    
    @Override
public String toString() {
        return "Soldado de Caballeria {" +
                "Nombre='" + this.getNombre() + '\'' +
                ", Ataque='" + this.getAtaque() + '\'' +
                ", Defensa='" + this.getDefensa() + '\'' +
                ", Salud='" + this.getSalud() + '\'' +                
                ", Peso='" + this.getPeso() + '\'' +
                '}';
    }    
}
