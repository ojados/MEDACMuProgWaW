/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package medac_programacionbatalla;

import Componentes.*;
import Batallas.Batalla;
import EntradaSalida.ExploradorFicheros;
import static EntradaSalida.ExploradorFicheros.leerFichero;
import EntradaSalida.GestorFicheroEntrada;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author danie
 */
public class MEDAC_ProgramacionBatalla {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        GestorFicheroEntrada.obtenerNombreGeneral(leerFichero());
        Batalla batalla = new Batalla();

    }
}
