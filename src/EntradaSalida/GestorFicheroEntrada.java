package EntradaSalida;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import java.util.ArrayList;
import java.util.Random;

public class GestorFicheroEntrada {

    private String rutaFichero;
    private BufferedReader br;
    private ArrayList<String> nombreGeneral;
    private String nombreDeGeneral;

    public GestorFicheroEntrada() {

    }

    public ArrayList<String> leerArchivo() throws IOException {
        nombreGeneral = new ArrayList<>();
        String linea;
        while ((linea = this.br.readLine()) != null) {
            nombreGeneral.add(linea);
        }
        return nombreGeneral;
    }
    
    /**
     * @param rutaFichero
    */
    public static String obtenerNombreGeneral(String rutaFichero) throws IOException { 
        File lector = new File(rutaFichero);
        FileReader fr = new FileReader(lector);
        BufferedReader br = new BufferedReader(fr);

        ArrayList<String> nombreGeneral = new ArrayList<>();
        String linea;
        while ((linea = br.readLine()) != null) {
            nombreGeneral.add(linea);
        }

        Random random = new Random();
        int indiceGeneralAleatorio = random.nextInt(nombreGeneral.size());
        return nombreGeneral.get(indiceGeneralAleatorio);
    }
}
