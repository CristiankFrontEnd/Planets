package Fichero;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Excepcion.ExcepcionPlanetas;
import Funciones.Manager;
import Especie.Especie;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author CRISTIAN
 */
public class Fichero {

    static File VulcanoTXT;
    static File KronosTXT;
    static File NibiruTXT;
    static File AndoriaTXT;
    static String ruta = "CarpetaPlanetasTXT";

    public static void creacion_PlanetasTXT() throws IOException {

        File carpeta_Planetas = new File(ruta);
        if (!carpeta_Planetas.exists()) {
            carpeta_Planetas.mkdir();
        }
        VulcanoTXT = new File(ruta + File.separator + "Vulcano.txt");
        KronosTXT = new File(ruta + File.separator + "Kronos.txt");
        NibiruTXT = new File(ruta + File.separator + "Nibiru.txt");
        AndoriaTXT = new File(ruta + File.separator + "Andoria.txt");
        try {
            VulcanoTXT.createNewFile();

            KronosTXT.createNewFile();

            NibiruTXT.createNewFile();

            AndoriaTXT.createNewFile();
        } catch (IOException ex) {
            System.out.println("error al crear los Planetas");
        }
    }

    public static void leerFicheroTXT(File archivo) {

        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea = "";

            while ((linea = br.readLine()) != null) {
                String frase = linea.substring(0);
                try {
                    Manager.crearPlanetas();
                    Manager.RealizarAccionconFrase(frase);
                } catch (ExcepcionPlanetas ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("No existe el fichero.");
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e2) {
                System.out.println("No hay nada que cerrar.");
            }
        }
    }

    public static void escribirFichero(String nombreFile, List<Especie> listaEspecies) {

        File archivo = devolverFile(nombreFile);
        FileWriter lectura = null;
        PrintWriter documento = null;
        try {
            lectura = new FileWriter(archivo);
            documento = new PrintWriter(lectura);
            for (int i = 0; i < listaEspecies.size(); i++) {
                String especie = listaEspecies.get(i).toString();
                documento.println(especie);                          //recogemos cada paragrafo del texto(ALumno) y lo escribimos en el File
            }

        } catch (IOException e) {
            System.out.println("No se pudo escribir en el archivo");
        } finally {
            try {
                if (null != lectura) {
                    lectura.close();
                    documento.close();
                }
            } catch (IOException e2) {
                System.out.println("No se pudo abrir el archivo");
            }
        }
    }

    public static File devolverFile(String nombreFile) {

        File documento = new File("");
        switch (nombreFile) {

            case "Kronos":
                documento = KronosTXT;
                break;
            case "Nibiru":
                documento = NibiruTXT;
                break;
            case "Andoria":
                documento = AndoriaTXT;
                break;
            case "Vulcano":
                documento = VulcanoTXT;
                break;
        }
        return documento;
    }

}
