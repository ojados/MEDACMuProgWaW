
package EntradaSalida;
import java.io.*;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class ExploradorFicheros{

    // JLabel para mostrar los archivos seleccionados por el usuario
    String ruta;

    public ExploradorFicheros()
    {
    }
    public String getNombreFichero(){
        return ruta;
    }
    public static String leerFichero(){

        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(fileChooser) == JFileChooser.APPROVE_OPTION){
            try {
                return fileChooser.getSelectedFile().getAbsolutePath();                                        

            } catch (NullPointerException e) {
                System.out.println("No se ha seleccionado ningún fichero");
                return null;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }    
        }
        else {
                return null;
                }
    }
    
    public static String escribirFichero(){
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(fileChooser) == JFileChooser.APPROVE_OPTION){
            try {
                return fileChooser.getSelectedFile().getAbsolutePath();                                        

            } catch (NullPointerException e) {
                System.out.println("No se ha seleccionado ningún fichero");
                return null;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }    
        }
        else {
                return null;
                }
            
    }    
}
