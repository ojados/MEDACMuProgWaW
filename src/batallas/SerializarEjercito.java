
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

    public static void serializar(Ejercito ejercito, String archivo_ejercito) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo_ejercito))) {
            out.writeObject(ejercito);
        }

    }

    public static Ejercito deserializar(String archivo_ejercito) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo_ejercito))) {
            return (Ejercito) in.readObject();
        }
    }

}