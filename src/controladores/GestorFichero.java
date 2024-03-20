package controladores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GestorFichero {

    private static final Random random = new Random();
    private String rutaFichero;
    private BufferedReader br;
    private List<String> nombreGeneral;
    private String nombreDeGeneral;

    public GestorFichero() {

    }

    public List<String> leerArchivo() throws IOException {
        nombreGeneral = new ArrayList<>();
        String linea;
        while ((linea = this.br.readLine()) != null) {
            nombreGeneral.add(linea);
        }
        return nombreGeneral;
    }

    /**
     * @param rutaFichero Ruta del fichero que se quiere leer
     */
    public static String obtenerNombreGeneral(String rutaFichero) throws IOException {

        File lector = new File(rutaFichero);

        List<String> nombreGeneral;
        try (FileReader fr = new FileReader(lector);
             BufferedReader br = new BufferedReader(fr)) {

            nombreGeneral = new ArrayList<>();
            String linea;
            while ((linea = br.readLine()) != null) {
                nombreGeneral.add(linea);
            }
        }


        int indiceGeneralAleatorio = random.nextInt(nombreGeneral.size());
        return nombreGeneral.get(indiceGeneralAleatorio);
    }
}
