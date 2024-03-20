
package batallas;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author William Zapata
 */
public class SerializarEjercito  {

    public static void serializar(Ejercito ejercito, String archivoEjercito) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivoEjercito))) {
            out.writeObject(ejercito);
        }

    }

    public static Ejercito deserializar(String archivoEjercito) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivoEjercito))) {
            return (Ejercito) in.readObject();
        }
    }

}