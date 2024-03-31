/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package batallas;

import componentes.Componentes;
import componentes.animales.Elefante;
import componentes.animales.Tigre;
import componentes.personas.Caballeria;
import componentes.personas.General;
import componentes.personas.Infanteria;
import excepciones.animales.MaxAnimalesException;
import excepciones.batallas.*;
import excepciones.personas.GeneralMinimoException;
import excepciones.personas.MaxCapGeneralException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * <p>Clase que representa un ejército.</p>
 *
 * @author Daniel Ojados
 * @author Daniel Romero
 * @version 1.0
 */
public class Ejercito {

    private static final int MAX_PESO = 50;
    private static final int MAX_ANIMALES = 3;
    private static final int MIN_UNIDADES = 2;
    private static final List<String> nombres = new ArrayList<>();
    private final ArrayList<Componentes> unidades = new ArrayList<>();
    private int contadorAnimales = 0;
    private boolean hayGeneral = false;
    private int ataque;
    private int defensa;
    private int salud;
    private int saldoPeso;
    private String nombre;

    public Ejercito() {

        nombre = "";
        saldoPeso = 0;
        restablecerAtributos();
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

    public String getNombre() {
        return nombre;
    }

    public int getSaldoPeso() {
        return saldoPeso;
    }

    private void menu() {
        Scanner scanner = new Scanner(System.in);
        String opcion;

        String[] opciones = {"Crear ID para ejército", "Añadir infantería",
                "Añadir caballería", "Añadir general", "Añadir elefante", "Añadir tigre",
                "Consultar saldo ejército", "Eliminar unidad", "Salir y confirmar"};

        do {

            char letra = 97; // Letra en código ASCII (a)
            for (String text : opciones) {
                System.out.println((letra) + ". " + text);
                letra++;
            }
            opcion = scanner.nextLine();

            switch (opcion) {
                case "a":
                    if (nombre.isBlank() || nombre.isEmpty()) {
                        System.out.print(System.lineSeparator() + "Asignale un nombre a tu ejército: ");

                        asignarNombre(scanner.nextLine());
                        if (!nombre.isEmpty()) {
                            System.out.println("Nombre del ejército: " + nombre + System.lineSeparator());
                        }
                    } else {
                        System.out.println(System.lineSeparator() + "El ejército ya tiene un nombre asignado.");
                        System.out.println("Nombre del ejército: " + nombre + System.lineSeparator());
                    }

                    break;
                case "b":

                    try {
                        if ((saldoPeso + Infanteria.PESO_INFANTERIA) < MAX_PESO) {

                            adicionarUnidad(new Infanteria());
                            imprimirInfo(unidades.getLast());
                        } else {
                            if (saldoPeso == MAX_PESO) {
                                throw new MaxCapPesoEjercitoException(Message.MAX_CAP_PESO_EJERCITO);
                            } else {
                                System.out.println(Message.UNIDAD_SUPERA_PESO + " " + Message.PESO_DISPONIBLE
                                        + (MAX_PESO - saldoPeso));
                            }
                        }
                    } catch (MaxCapPesoEjercitoException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case "c":

                    try {
                        if ((saldoPeso + Caballeria.PESO_CABALLERIA) < MAX_PESO) {

                            adicionarUnidad(new Caballeria());
                            imprimirInfo(unidades.getLast());
                        } else {
                            if (saldoPeso == MAX_PESO) {
                                throw new MaxCapPesoEjercitoException(Message.MAX_CAP_PESO_EJERCITO);
                            } else {
                                System.out.println(Message.UNIDAD_SUPERA_PESO + " " + Message.PESO_DISPONIBLE
                                        + (MAX_PESO - saldoPeso));
                            }
                        }
                    } catch (MaxCapPesoEjercitoException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case "d":
                    try {
                        if (((saldoPeso + General.PESO_GENERAL) < MAX_PESO) && !hayGeneral) {
                            adicionarUnidad(new General());
                            imprimirInfo(unidades.getLast());
                        } else {
                            if (saldoPeso == MAX_PESO) {
                                throw new MaxCapPesoEjercitoException(Message.MAX_CAP_PESO_EJERCITO);
                            } else {
                                throw new MaxCapGeneralException(Message.GENERAL_EXISTENTE);
                            }
                        }
                    } catch (MaxCapPesoEjercitoException | MaxCapGeneralException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case "e":
                    try {
                        if (((saldoPeso + Elefante.PESO_ELEFANTE) < MAX_PESO) && contadorAnimales < MAX_ANIMALES) {
                            adicionarUnidad(new Elefante());
                            imprimirInfo(unidades.getLast());
                        } else {
                            if (saldoPeso == MAX_PESO) {
                                throw new MaxCapPesoEjercitoException(Message.MAX_CAP_PESO_EJERCITO);
                            } else if (MAX_ANIMALES == contadorAnimales) {
                                throw new MaxAnimalesException(Message.MAX_ANIMALES);
                            } else {
                                System.out.println(Message.UNIDAD_SUPERA_PESO + " " + Message.PESO_DISPONIBLE
                                        + (MAX_PESO - saldoPeso));
                            }
                        }
                    } catch (MaxCapPesoEjercitoException e) {

                    } catch (MaxAnimalesException e) {
                        throw new RuntimeException(e);
                    }

                    break;
                case "f":
                    try {
                        if ((saldoPeso + Tigre.PESO_TIGRE) < MAX_PESO && contadorAnimales < MAX_ANIMALES) {
                            adicionarUnidad(new Tigre());
                            imprimirInfo(unidades.getLast());
                        } else {
                            if (saldoPeso == MAX_PESO) {
                                throw new MaxCapPesoEjercitoException(Message.MAX_CAP_PESO_EJERCITO);
                            } else if (MAX_ANIMALES == contadorAnimales) {
                                throw new MaxAnimalesException(Message.MAX_ANIMALES);
                            } else {
                                System.out.println(Message.UNIDAD_SUPERA_PESO + " " + Message.PESO_DISPONIBLE
                                        + (MAX_PESO - saldoPeso));
                            }
                        }
                    } catch (MaxAnimalesException | MaxCapPesoEjercitoException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case "g":
                    System.out.println(Message.SALDO_ACTUAL + getSaldoPeso());
                    break;
                case "h":
                    try {
                        if (!unidades.isEmpty()) {
                            System.out.println("Eliminar unidad del ejército: ");
                            informacionEjercito();

                            System.out.println("Nombre de la unidad a eliminar: ");
                            String nombreUnidad = scanner.nextLine();

                            eliminarUnidad(nombreUnidad);
                        } else {
                            throw new EjercitoVacioException(Message.EJERCITO_VACIO);
                        }
                    } catch (EjercitoVacioException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case "i":
                    try {
                        if (saldoPeso >= MIN_UNIDADES && hayGeneral) {
                            System.out.println(System.lineSeparator() + "Su Ejército está formado por: "
                                    + System.lineSeparator());

                            informacionEjercito();

                            actualizarEjercito();
                            break;
                        }

                        if (nombre == null || nombre.isEmpty() || nombre.isBlank()) {
                            throw new EjercitoNombreException(Message.EJERCITO_SIN_NOMBRE);
                        }

                        if (saldoPeso < MIN_UNIDADES) {
                            throw new UnidadMinimaException(Message.UNIDADES_MINIMAS);
                        } else {
                            throw new GeneralMinimoException(Message.GENERAL_MINIMO);
                        }
                    } catch (EjercitoNombreException | UnidadMinimaException | GeneralMinimoException e) {
                        System.out.println(e.getMessage());
                    }

                    menu();

                    break;
                default:
                    System.out.println(Message.OPCION_INAVLIDA);
                    break;
            }
        } while (!opcion.equals("i"));
    }

    private void imprimirInfo(Componentes componente) {
        System.out.println(Message.ADICIONAR_COMPONENTE + System.lineSeparator() + componente);
        System.out.println(System.lineSeparator() + Message.SALDO_ACTUAL + getSaldoPeso());
    }

    public void recibirDano(int dano) {
        Iterator<Componentes> iterador = unidades.iterator();

        while (dano > 0 && iterador.hasNext()) {
            Componentes componente = iterador.next();
            componente.recibirDano(dano);

            if (componente.getSalud() < 0) {

                dano = Math.abs(componente.getSalud());
                iterador.remove();
                unidades.remove(componente);

                System.out.println("El componente " + componente.getNombre() + " ha sido eliminado del ejército " +
                        nombre + " por falta de salud");
            }

            restablecerAtributos();
            actualizarEjercito();
        }
    }

    private void actualizarEjercito() {
        for (Componentes componente : unidades) {
            ataque += componente.getAtaque();
            defensa += componente.getDefensa();
            salud += componente.getSalud();
        }
    }

    private void restablecerAtributos() {
        ataque = 0;
        defensa = 0;
        salud = 0;
    }

    private void adicionarUnidad(Componentes componentes) {
        if (componentes instanceof Infanteria || componentes instanceof Caballeria) {
            unidades.add(componentes);
            saldoPeso += componentes.getPeso();
        } else if (componentes instanceof General) {
            unidades.add(componentes);
            saldoPeso += componentes.getPeso();
            hayGeneral = true;
        } else if (componentes instanceof Elefante || componentes instanceof Tigre) {
            unidades.add(componentes);
            saldoPeso += componentes.getPeso();
            contadorAnimales++;
        }
    }

    private void eliminarUnidad(String nombreUnidad) {

        try {
            for (Componentes unidad : unidades) {
                if (unidad.getNombre().equalsIgnoreCase(nombreUnidad)) {
                    if (unidad instanceof General) {
                        hayGeneral = false;
                    } else if (unidad instanceof Elefante || unidad instanceof Tigre) {
                        contadorAnimales--;
                    }

                    unidades.remove(unidad);
                    saldoPeso -= unidad.getPeso();

                    System.out.println(unidad.getNombre() + ": " + Message.UNIDAD_ELIM_SATIS);

                    break;
                } else {
                    throw new UnidadInexistenteException(Message.UNIDAD_INEXISTENTE);
                }
            }
        } catch (UnidadInexistenteException e) {
            System.out.println(e.getMessage());
        }
    }

    private void informacionEjercito() {
        for (Componentes unidad : unidades) {
            System.out.println(unidad);
        }
    }

    private void asignarNombre(String nombre) {
        try {
            if (!nombres.contains(nombre)) {
                nombres.add(nombre);
                this.nombre = nombre;
            } else {
                throw new NombreExistenteException(Message.NOMBRE_EXISTENTE);
            }
        } catch (NombreExistenteException e) {
            System.out.println(e.getMessage());
        }
    }
}