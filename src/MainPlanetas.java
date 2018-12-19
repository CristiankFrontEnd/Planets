

import Fichero.Fichero;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author CRISTIAN
 */
public class MainPlanetas {

    public static void main(String[] args) {
        File documento = new File("documentoPlanetas.txt");
        try {

            Fichero.creacion_PlanetasTXT();
            Fichero.leerFicheroTXT(documento);

        } catch (IOException ex) {
            //PERSISTENCIA
            System.out.println(ex.getMessage());

        }
    }

}//HECTOR.FLORIDO@STUCOM.COM;
