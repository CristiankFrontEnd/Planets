/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

import Especie.Andoriano;
import Especie.Especie;
import Especie.Humano;
import Especie.Klingon;
import Especie.Nibiriano;
import Especie.Vulcaniano;
import Excepcion.ExcepcionPlanetas;
import Fichero.Fichero;
import Galaxia.Andoria;
import Galaxia.Kronos;
import Galaxia.Nibiru;
import Galaxia.Planeta;
import Galaxia.Vulcano;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author CRISTIAN
 */
public class Manager {

    static ArrayList<Especie> listaTODOS = new ArrayList<>();
    static Especie especie = new Especie("", "", "");
    static String datoBooleando = "";

    static Planeta Kronos;
    static Planeta Nibiru;
    static Planeta Andoria;
    static Planeta Vulcano;

    public static void crearPlanetas() throws ExcepcionPlanetas {
        Kronos = new Kronos("Kronos");
        Nibiru = new Nibiru("Nibiru");
        Andoria = new Andoria("Andoria");
        Vulcano = new Vulcano("Vulcano");
    }

    public static void RealizarAccionconFrase(String frase) throws ExcepcionPlanetas {

        String datos_separados[] = frase.split(" ");

        switch (datos_separados[0].charAt(0)) {

            case 'C':
                especie = crearSer(datos_separados);
                if (null == obtenerEspeciePorNombre(datos_separados[3])) {
                    censar(especie);
                    System.out.println("OK:" + especie.getNombre() + " censado correctamente en el planeta " + especie.getNombreplaneta());
                } else {
                    throw new ExcepcionPlanetas(6);
                }
                break;

            case 'B':
                Especie especieAborrar = obtenerEspeciePorNombre(datos_separados[1]);
                if (especieAborrar != null) {
                    borrarEspecie(especieAborrar);
                    System.out.println("<OK: Ser borrado correctamente >");
                } else {
                    throw new ExcepcionPlanetas(7);
                }
                break;
            case 'L':
                mostrarEspeciesporPlanetas();
                break;
            case 'M':
                Especie especieAmodificar = obtenerEspeciePorNombre(datos_separados[1]);
                if (especieAmodificar != null) {
                    if (esModificable(especieAmodificar.getTipo())) {
                        modificarEspecie(especieAmodificar);
                        System.out.println("<OK: Ser modificado correctamente >");
                    } else {
                        throw new ExcepcionPlanetas(8);
                    }
                } else {
                    throw new ExcepcionPlanetas(7);
                }
                break;

            case 'P':

                break;
            case 'X':

                break;

        }
    }

    public static Especie crearSer(String datos_separados[]) throws ExcepcionPlanetas {
        switch (datos_separados[1]) {

            case "Humano":
                especie = new Humano(datos_separados[2], datos_separados[3], datos_separados[1], Integer.parseInt(datos_separados[4]));

                break;
            case "Andoriano":
                if (datos_separados[4].equalsIgnoreCase("aenar")) {
                    datoBooleando = "aenar";
                } else {
                    datoBooleando = "noaenar";
                }
                especie = new Andoriano(datos_separados[2], datos_separados[3], datos_separados[1], datoBooleando);
                datoBooleando = "";
                break;
            case "Klingon":
                especie = new Klingon(datos_separados[2], datos_separados[3], datos_separados[1], Integer.parseInt(datos_separados[4]));

                break;
            case "Nibiriano":
                if (datos_separados[4].equalsIgnoreCase("vegetarian")) {
                    datoBooleando = "vegetarian";
                } else {
                    datoBooleando = "novegetarian";
                }
                especie = new Nibiriano(datos_separados[2], datos_separados[3], datos_separados[1], datoBooleando);
                datoBooleando = "";
                break;
            case "Vulcaniano":
                especie = new Vulcaniano(datos_separados[2], datos_separados[3], datos_separados[1], Integer.parseInt(datos_separados[4]));

                break;
        }
        return especie;
    }

    public static ArrayList<Especie> obtenerListadeTODOS() {
        listaTODOS.clear();
        listaTODOS.addAll(Andoria.getListaCensados());
        listaTODOS.addAll(Nibiru.getListaCensados());
        listaTODOS.addAll(Vulcano.getListaCensados());
        listaTODOS.addAll(Kronos.getListaCensados());
        return listaTODOS;
    }

    public static void censar(Especie especie) throws ExcepcionPlanetas {

        switch (especie.getNombreplaneta()) {
            case "Kronos":
                Kronos.comprobarExistencia(especie, Kronos);
                Kronos.compatibilidadEspeciePlaneta(especie);
                Kronos.getListaCensados().add(especie);
                Fichero.escribirFichero("Kronos", Kronos.getListaCensados());
                break;

            case "Vulcano":
                Vulcano.comprobarExistencia(especie, Vulcano);
                Vulcano.compatibilidadEspeciePlaneta(especie);
                Vulcano.getListaCensados().add(especie);
                Fichero.escribirFichero("Vulcano", Vulcano.getListaCensados());
                break;

            case "Nibiru":
                Nibiru.comprobarExistencia(especie, Nibiru);
                Nibiru.compatibilidadEspeciePlaneta(especie);
                Nibiru.getListaCensados().add(especie);
                Fichero.escribirFichero("Nibiru", Nibiru.getListaCensados());
                break;

            case "Andoria":
                Andoria.comprobarExistencia(especie, Andoria);
                Andoria.compatibilidadEspeciePlaneta(especie);
                Andoria.getListaCensados().add(especie);
                Fichero.escribirFichero("Andoria", Andoria.getListaCensados());
                break;

        }

    }

    public static void borrarEspecie(Especie especie) {
        switch (especie.getNombreplaneta()) {
            case "Kronos":

                Kronos.getListaCensados().remove(especie);
                Fichero.escribirFichero("Kronos", Kronos.getListaCensados());
                break;

            case "Vulcano":

                Vulcano.getListaCensados().remove(especie);
                Fichero.escribirFichero("Vulcano", Vulcano.getListaCensados());
                break;

            case "Nibiru":

                Nibiru.getListaCensados().remove(especie);
                Fichero.escribirFichero("Nibiru", Nibiru.getListaCensados());
                break;

            case "Andoria":

                Andoria.getListaCensados().remove(especie);
                Fichero.escribirFichero("Andoria", Andoria.getListaCensados());
                break;

        }
    }

    public static Especie obtenerEspeciePorNombre(String nombre) {

        listaTODOS = obtenerListadeTODOS();
        for (Especie especie : listaTODOS) {
            if (especie.getNombre().equalsIgnoreCase(nombre)) {
                return especie;
            }
        }
        return null;
    }

    public static void mostrarEspeciesporPlanetas() {
        System.out.println("    *POPULATION BY PLANET*");

        System.out.println("***********Vulcano************");
        Collections.sort(Vulcano.getListaCensados());
        imprimirListaOrdenada(Vulcano.getListaCensados());
        System.out.println("****************************");

        System.out.println("***********Andoria************");
        Collections.sort(Andoria.getListaCensados());
        imprimirListaOrdenada(Andoria.getListaCensados());
        System.out.println("****************************");

        System.out.println("***********Nibiru************");
        Collections.sort(Nibiru.getListaCensados());
        imprimirListaOrdenada(Nibiru.getListaCensados());
        System.out.println("****************************");

        System.out.println("***********Kronos************");
        Collections.sort(Kronos.getListaCensados());
        imprimirListaOrdenada(Kronos.getListaCensados());
        System.out.println("****************************");
    }

    public static void imprimirListaOrdenada(ArrayList lista) {
        for (int i = 0; i < lista.size(); i++) {
            String especimen = lista.get(i).toString();
            System.out.println(especimen);
        }
    }

    public static boolean esModificable(String tipo) {
        if (tipo.equalsIgnoreCase("Humano") || tipo.equalsIgnoreCase("Vulcaniano") || tipo.equalsIgnoreCase("Klingon")) {
            return true;
        }
        return false;
    }

    public static void modificarEspecie(Especie especie, int valor) throws ExcepcionPlanetas {
       
//ESTAS MODIFICANDO LA ESPECIE QUE SOLO PUEDE SER DE 3 TIPOS
//Y ADEMÁS DEBES GRABARLA DESPUÉS
//CUIDADO CON EL STATIC
       
        switch (especie.getTipo()) {
            case "Humano":
                for (Especie especie :  Vulcano.getListaCensados()) {
                    
                }
                humano.setEdad(valor);
                break;
            case "Vulcano":
                vulcaniano.setMeditacion(valor);
     Fichero.escribirFichero("Vulcano", Vulcano.getListaCensados());

                break;
            case "Kronos":
                klingon.setFuerza(valor);
                break;

        }
    }
}
