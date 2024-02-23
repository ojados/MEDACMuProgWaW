/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Componentes;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author danie
 */
public class Componentes {
    private String nombre;
    private int ataque;
    private int defensa;
    private int salud;
    private int peso;
    private float multiplicador;
    private static ArrayList<Integer> ids = new ArrayList<Integer>();
    
  
    public Componentes(){
        this.nombre = getID();
        this.ataque = 0;
        this.defensa = 0;
        this.salud = 0;
        this.peso = 0;
        this.multiplicador = 0f;
    }    
    
    public String getNombre(){
        return nombre;
    }
    
    public int getAtaque(){
        return ataque;
    }
    
    public int getDefensa(){
        return defensa;
    }
    
    public int getSalud(){
        return salud;
    }
    
    public int getPeso(){
        return peso;
    }    
    
        public float getMultiplicador(){
        return multiplicador;
    }   
    
    public void setSalud(int salud){
        this.salud = salud;
    }    
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setAtaque(int ataque){
        this.ataque = ataque;
    }
    
    public void setDefensa(int defensa){
        this.defensa = defensa;
    }
    
    
    public void setPeso(int peso){
        this.peso = peso;
    }   
    
    public void setMultiplicador(float multiplicador){
        this.multiplicador = multiplicador;
    }      
    
    public int recibirDano(int dano){
        if ( dano > this.salud ) {
            salud = 0;
            ataque = 0;
            defensa = 0;
            return ( dano - salud );
        } else {
            salud = salud - dano;
            return 0;
        }
    }
    
    public static String getID(){
        Integer rID = 0;
        Random random = new Random();        
        while (1 == 1) {

        rID = random.nextInt(1000);
            if (ids.contains(rID)){
              continue; 
            }
            else {
                ids.add(rID);
                break;
            }
        }
        return Integer.toString(rID);
    }
    
    public ArrayList<Integer> generarAtributos(int limiteSuperior){
        ArrayList<Integer> atributos = new ArrayList<>();
        Random random = new Random();   
        
        atributos.add(random.nextInt(limiteSuperior));
        atributos.add(random.nextInt((limiteSuperior-atributos.getFirst())));
        atributos.add(limiteSuperior-(atributos.getFirst()+atributos.get(1)));
        
        return atributos;
    }    
    
    @Override
public String toString() {
        return "Componente{" +
                "Nombre='" + this.getNombre() + '\'' +
                ", Ataque='" + this.getAtaque() + '\'' +
                ", Defensa='" + this.getDefensa() + '\'' +
                ", Peso='" + this.getPeso() + '\'' +
                '}';
    }
}
