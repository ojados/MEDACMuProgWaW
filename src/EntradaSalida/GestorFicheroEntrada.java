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

    public GestorFicheroEntrada(String rutaFichero) throws FileNotFoundException {
        this.rutaFichero = rutaFichero;
        File lector = new File(rutaFichero);
        FileReader fr = new FileReader(lector);
        this.br = new BufferedReader(fr);
    }

    public ArrayList<String> leerArchivo() throws IOException {
        nombreGeneral = new ArrayList<>();
        String linea;
        while ((linea = this.br.readLine()) != null) {
            nombreGeneral.add(linea);
        }
        return nombreGeneral;
    }

    public void obtenerNombreGeneral() {

        Random random = new Random();
        int indiceGeneralAleatorio = random.nextInt(nombreGeneral.size());
        nombreGeneral.get(indiceGeneralAleatorio);
        nombreDeGeneral = nombreGeneral.get(indiceGeneralAleatorio);

    }
}
