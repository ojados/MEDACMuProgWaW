/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Batallas;

import Componentes.Animales.Elefante;
import Componentes.Animales.Tigre;
import Componentes.Componentes;
import Componentes.Personas.Caballeria;
import Componentes.Personas.General;
import Componentes.Personas.Infanteria;

import java.util.*;

public class Ejercito {

    private final static int MAX_Peso = 50;
    private final static int MAX_Animales = 3;
    private final static int MAXMIN_General = 1;
    private final static int MIN_UNIDADES = 2;
    private final ArrayList<Componentes> unidades = new ArrayList<>();
    private boolean hayGeneral = false;
    private int contadorAnimales = 0;
    private int ataque;
    private int defensa;
    private int salud;
    private int saldoPeso;
    private String nombre;

    public Ejercito() {
        ataque = 0;
        defensa = 0;
        salud = 0;
        saldoPeso = 0;
        menu();
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getSaldoPeso() {
        return saldoPeso;
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        String opcion;
        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("a) Crear ID para Ejército");
            System.out.println("b) Añadir Infanteria");
            System.out.println("c) Añadir Caballería");
            System.out.println("d) Añadir General");
            System.out.println("e) Añadir Elefante");
            System.out.println("f) Añadir Tigre");
            System.out.println("g) Consultar Saldo Ejercito");
            System.out.println("h) Salir y confirmar");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "b":
                    if ((saldoPeso + Infanteria.PESO_INFANTERIA) < MAX_Peso) {
                        unidades.add(new Infanteria());
                        saldoPeso += Infanteria.PESO_INFANTERIA;
                        imprimirInfo(unidades.getLast());
                    } else {
                        //EXCEPCION
                    }

                    break;
                case "c":
                    if ((saldoPeso + Caballeria.PESO_CABALLERIA) < MAX_Peso) {
                        unidades.add(new Caballeria());
                        saldoPeso += Caballeria.PESO_CABALLERIA;
                        imprimirInfo(unidades.getLast());
                    } else {
                        //EXCEPCION
                    }
                    break;
                case "d":
                    if (((saldoPeso + General.PESO_GENERAL) < MAX_Peso) && !hayGeneral) {
                        unidades.add(new General());
                        saldoPeso += General.PESO_GENERAL;
                        hayGeneral = true;
                        imprimirInfo(unidades.getLast());
                    } else if (hayGeneral) {
                        System.out.println("Error: No puedes tener más de un general.");
                    } else {
                        // Manejar otras condiciones o lanzar excepción si lo prefieres
                    }
                    break;
                case "e":
                    if (((saldoPeso + Elefante.PESO_ELEFANTE) < MAX_Peso)
                            && contadorAnimales < MAX_Animales) {
                        unidades.add(new Elefante());
                        saldoPeso += Elefante.PESO_ELEFANTE;
                        contadorAnimales += 1;
                        imprimirInfo(unidades.getLast());
                    } else {
                        //EXCEPCION
                    }
                    break;
                case "f":
                    if (((saldoPeso + Tigre.PESO_TIGRE) < MAX_Peso)
                            && contadorAnimales < MAX_Animales) {
                        unidades.add(new Tigre());
                        saldoPeso += Tigre.PESO_TIGRE;
                        contadorAnimales += 1;
                        imprimirInfo(unidades.getLast());
                    } else {
                        //EXCEPCION
                    }
                    break;
                case "a":
                    if ((nombre == null) || (nombre == "")) {
                        nombre = scanner.nextLine();
                        System.out.println("Nombre del Ejército: " + nombre);
                    } else {
                        System.out.println("Nombre del Ejército: " + nombre);
                    }

                    break;
                case "g":
                    System.out.println("Saldo actual del Ejército: " + getSaldoPeso());
                    break;
                case "h":
                    if (saldoPeso >= MIN_UNIDADES && hayGeneral) {
                        Iterator<Componentes> iterador = unidades.iterator();

                        System.out.println(System.lineSeparator() + "Su Ejército está formado por: " + System.lineSeparator());
                        while (iterador.hasNext()) {
                            System.out.println(iterador.next());
                        }

                        actualizarEjercito();

                        break;
                    }

                    if (saldoPeso < MIN_UNIDADES) {
                        System.out.println("El Ejército debe tener al menos 2 unidades");
                    } else if (!hayGeneral) {
                        System.out.println("El Ejército debe tener al menos 1 General");
                    }

                    menu();

                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!opcion.equals("h"));
    }

    private void imprimirInfo(Componentes componente) {
        System.out.println(
                "Nuevo Componente Añadido al Ejército: " + System.lineSeparator() + componente);
        System.out.println(System.lineSeparator() + "Saldo actual del Ejército: " + getSaldoPeso()
        );
    }

    public void recibirDano(int dano) {
        Iterator<Componentes> iterador = unidades.iterator();
        Collections.sort(unidades, new Comparator<Componentes>() {
            @Override
            public int compare(Componentes c1, Componentes c2) {
                return Integer.valueOf(c1.getSalud()).compareTo(Integer.valueOf(c2.getSalud()));
            }
        });
        while ((dano > 0) && dano < getSalud()) {
            while (iterador.hasNext()) {
                if (iterador.next().getSalud() != 0) {
                    if (iterador.next().getSalud() > dano) {
                        setSalud(getSalud() - dano);
                        dano = 0;
                        break;
                    } else {
                        setSalud(0);
                        dano -= getSalud();
                        actualizarEjercito(); // o eliminar elemento
                    }
                }
            }
        }
    }

    private void actualizarEjercito() {
        Iterator<Componentes> iterador = unidades.iterator();
        while (iterador.hasNext()) {
            Componentes componente = iterador.next();
            if (componente.getSalud() != 0) {
                ataque = ataque + componente.getAtaque();
                defensa = defensa + componente.getDefensa();
                salud = salud + componente.getSalud();
            }
        }
    }
}
