/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

import Especie.Andorian;
import Especie.Especie;
import Especie.Human;
import Especie.Klingon;
import Especie.Nibirian;
import Especie.Vulcan;
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

    public static boolean existeX = true;
    static String yellow = "\033[33m";
    static String reset = "\u001B[0m";
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
        comprobarOpcion(datos_separados[0].toUpperCase());
        switch (datos_separados[0].toUpperCase()) {

            case "C":
                larguraFrase(datos_separados);
                if (null == obtenerEspeciePorNombre(datos_separados[3])) {
                    especie = crearSer(datos_separados);
                    censar(especie);
                    System.out.println("OK:" + especie.getNombre() + " censado correctamente en el planeta " + especie.getNombreplaneta());
                } else {
                    throw new ExcepcionPlanetas(6);
                }
                break;

            case "B":
                larguraFrase(datos_separados);
                Especie especieAborrar = obtenerEspeciePorNombre(datos_separados[1]);
                if (especieAborrar != null) {
                    borrarEspecie(especieAborrar);
                    System.out.println("<OK: Ser borrado correctamente >");
                } else {
                    throw new ExcepcionPlanetas(7);
                }
                break;
            case "L":
                larguraFrase(datos_separados);
                mostrarEspeciesporPlanetas();
                break;
            case "M":
                larguraFrase(datos_separados);
                Especie especieAmodificar = obtenerEspeciePorNombre(datos_separados[1]);

                if (especieAmodificar != null) {
                    esModificable(especieAmodificar.getTipo(), Integer.parseInt(datos_separados[2]));
                    modificarEspecie(especieAmodificar, Integer.parseInt(datos_separados[2]));
                    System.out.println("<OK: Ser modificado correctamente >");

                } else {
                    throw new ExcepcionPlanetas(7);
                }
                break;

            case "P":
                larguraFrase(datos_separados);
                mostrarEspeciesporTipo(datos_separados[1]);

                break;
            case "X":
                existeX = false;
                break;

        }

    }

    public static void comprobarOpcion(String letra) throws ExcepcionPlanetas {
        if (letra.equals("C") || letra.equals("B") || letra.equals("M") || letra.equals("L") || letra.equals("P") || letra.equals("X")) {

        } else {
            throw new ExcepcionPlanetas(9);
        }
    }

    public static void larguraFrase(String datos_separados[]) throws ExcepcionPlanetas {

        switch (datos_separados[0].toUpperCase()) {
            case "C":

                if (5 != datos_separados.length) {
                    throw new ExcepcionPlanetas(1);
                }
                break;
            case "B":
                if (2 != datos_separados.length) {
                    throw new ExcepcionPlanetas(1);
                }
                break;
            case "L":
                if (1 != datos_separados.length) {
                    throw new ExcepcionPlanetas(1);
                }
                break;
            case "M":
                if (3 != datos_separados.length) {
                    throw new ExcepcionPlanetas(1);
                }
                break;
            case "P":
                if (2 != datos_separados.length) {
                    throw new ExcepcionPlanetas(1);
                }
                break;
        }
    }

    public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {

            resultado = false;
        }

        return resultado;
    }

    public static Especie crearSer(String datos_separados[]) throws ExcepcionPlanetas {
        comprobarExistenciaEspecie(datos_separados[1]);
        elegirPlanetaIguala(datos_separados[2]);

        switch (datos_separados[1].toUpperCase()) {

            case "HUMAN":
                if (!(isNumeric(datos_separados[4]))) {
                    throw new ExcepcionPlanetas(4);
                }
                especie = new Human(datos_separados[2], datos_separados[3], datos_separados[1], Integer.parseInt(datos_separados[4]));

                break;
            case "ANDORIAN":
                if (datos_separados[4].equalsIgnoreCase("aenar")) {
                    datoBooleando = "aenar";
                } else if (datos_separados[4].equalsIgnoreCase("noaenar")) {
                    datoBooleando = "noaenar";
                } else {
                    throw new ExcepcionPlanetas(4);
                }
                especie = new Andorian(datos_separados[2], datos_separados[3], datos_separados[1], datoBooleando);
                datoBooleando = "";
                break;
            case "KLINGON":
                if (!(isNumeric(datos_separados[4]))) {
                    throw new ExcepcionPlanetas(4);
                }
                especie = new Klingon(datos_separados[2], datos_separados[3], datos_separados[1], Integer.parseInt(datos_separados[4]));

                break;
            case "NIBIRIAN":
                if (datos_separados[4].equalsIgnoreCase("vegetarian")) {
                    datoBooleando = "vegetarian";
                } else if (datos_separados[4].equalsIgnoreCase("novegetarian")) {
                    datoBooleando = "novegetarian";
                } else {
                    throw new ExcepcionPlanetas(4);
                }
                especie = new Nibirian(datos_separados[2], datos_separados[3], datos_separados[1], datoBooleando);
                datoBooleando = "";
                break;
            case "VULCAN":
                if (!(isNumeric(datos_separados[4]))) {
                    throw new ExcepcionPlanetas(4);
                }

                especie = new Vulcan(datos_separados[2], datos_separados[3], datos_separados[1], Integer.parseInt(datos_separados[4]));

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

    public static void comprobarExist(String nombre) {

    }

    public static void censar(Especie especie) throws ExcepcionPlanetas {

        switch (especie.getNombreplaneta().toUpperCase()) {
            case "KRONOS":

                Kronos.compatibilidadEspeciePlaneta(especie);
                Kronos.getListaCensados().add(especie);
                Fichero.escribirFichero("Kronos", Kronos.getListaCensados());
                break;

            case "VULCANO":

                Vulcano.compatibilidadEspeciePlaneta(especie);
                Vulcano.getListaCensados().add(especie);
                Fichero.escribirFichero("Vulcano", Vulcano.getListaCensados());
                break;

            case "NIBIRU":

                Nibiru.compatibilidadEspeciePlaneta(especie);
                Nibiru.getListaCensados().add(especie);
                Fichero.escribirFichero("Nibiru", Nibiru.getListaCensados());
                break;

            case "ANDORIA":

                Andoria.compatibilidadEspeciePlaneta(especie);
                Andoria.getListaCensados().add(especie);
                Fichero.escribirFichero("Andoria", Andoria.getListaCensados());
                break;

        }

    }

    public static void borrarEspecie(Especie especie) {
        switch (especie.getNombreplaneta().toUpperCase()) {
            case "KRONOS":
                Kronos.getListaCensados().remove(especie);
                Fichero.escribirFichero("Kronos", Kronos.getListaCensados());
                break;

            case "VULCANO":

                Vulcano.getListaCensados().remove(especie);
                Fichero.escribirFichero("Vulcano", Vulcano.getListaCensados());
                break;

            case "NIBIRU":

                Nibiru.getListaCensados().remove(especie);
                Fichero.escribirFichero("Nibiru", Nibiru.getListaCensados());
                break;

            case "ANDORIA":

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

    public static void mostrarEspeciesporPlanetas() throws ExcepcionPlanetas {
        listaTODOS = obtenerListadeTODOS();

        if (listaTODOS.isEmpty()) {
            throw new ExcepcionPlanetas(14);
        } else {
            System.out.println("\n    *POPULATION BY PLANET*");

            if (!(Vulcano.getListaCensados().isEmpty())) {
                System.out.println("***********Vulcano************");
                Collections.sort(Vulcano.getListaCensados());
                imprimirListaOrdenada(Vulcano.getListaCensados());
                System.out.println("****************************");
            }
            if (!(Andoria.getListaCensados().isEmpty())) {
                System.out.println("***********Andoria************");
                Collections.sort(Andoria.getListaCensados());
                imprimirListaOrdenada(Andoria.getListaCensados());
                System.out.println("****************************");
            }
            if (!(Nibiru.getListaCensados().isEmpty())) {
                System.out.println("***********Nibiru************");
                Collections.sort(Nibiru.getListaCensados());
                imprimirListaOrdenada(Nibiru.getListaCensados());
                System.out.println("****************************");
            }
            if (!(Kronos.getListaCensados().isEmpty())) {
                System.out.println("***********Kronos************");
                Collections.sort(Kronos.getListaCensados());
                imprimirListaOrdenada(Kronos.getListaCensados());
                System.out.println("****************************\n");
            }
        }
    }

    public static void imprimirListaOrdenada(ArrayList lista) {
        for (int i = 0; i < lista.size(); i++) {
            String especimen = lista.get(i).toString();
            System.out.println(especimen);
        }
    }

    public static void esModificable(String tipo, int dato) throws ExcepcionPlanetas {
        if (!(tipo.equalsIgnoreCase("Human") || tipo.equalsIgnoreCase("Vulcan") || tipo.equalsIgnoreCase("Klingon"))) {
            throw new ExcepcionPlanetas(8);
        }
        if (tipo.equalsIgnoreCase("Human") && !(dato >= 0) && !(dato <= 130)) {
            throw new ExcepcionPlanetas(10);
        } else if (tipo.equalsIgnoreCase("Vulcan") && (!(dato < 0) && (dato > 10))) {
            throw new ExcepcionPlanetas(11);
        } else if (tipo.equalsIgnoreCase("Klingon") && (dato > 50) && (dato < 350)) {
            throw new ExcepcionPlanetas(12);
        }

    }

    public static void modificarEspecie(Especie especie, int valor) throws ExcepcionPlanetas {

        switch (especie.getTipo()) {
            case "Human":
                Human especieHumana = (Human) especie;
                especieHumana.setEdad(valor);
                String nombrePlaneta = especieHumana.getNombreplaneta();
                Planeta planeta = elegirPlanetaIguala(nombrePlaneta);
                Fichero.escribirFichero(nombrePlaneta, planeta.getListaCensados());
                break;
            case "Vulcan":
                Vulcan especieVulcaniana = (Vulcan) especie;
                especieVulcaniana.setMeditacion(valor);
                nombrePlaneta = especieVulcaniana.getNombreplaneta();
                planeta = elegirPlanetaIguala(nombrePlaneta);
                Fichero.escribirFichero("Vulcano", Vulcano.getListaCensados());

                break;
            case "Klingon":
                Klingon especieKlingon = (Klingon) especie;
                especieKlingon.setFuerza(valor);
                nombrePlaneta = especieKlingon.getNombreplaneta();
                planeta = elegirPlanetaIguala(nombrePlaneta);
                Fichero.escribirFichero("Vulcano", Vulcano.getListaCensados());
                break;

        }
    }

    public static Planeta elegirPlanetaIguala(String nombrePlaneta) throws ExcepcionPlanetas {

        if (nombrePlaneta.equalsIgnoreCase("Kronos")) {
            return Kronos;
        } else if (nombrePlaneta.equalsIgnoreCase("Vulcano")) {
            return Vulcano;
        } else if (nombrePlaneta.equalsIgnoreCase("Andoria")) {
            return Andoria;
        } else if (nombrePlaneta.equalsIgnoreCase("Nibiru")) {
            return Nibiru;
        } else {
            throw new ExcepcionPlanetas(3);
        }

    }

    public static void mostrarEspeciesporTipo(String tipo) throws ExcepcionPlanetas {
        comprobarExistenciaEspecie(tipo);
        System.out.println("\n< POPULATION BY RACE >");
        listaTODOS = obtenerListadeTODOS();

        switch (tipo.toUpperCase()) {

            case "HUMAN":
                for (Especie especies : listaTODOS) {
                    if (especies.getTipo().equalsIgnoreCase(tipo)) {
                        Human especieHumana = (Human) especies;
                        System.out.println(especieHumana.getTipo() + " " + especieHumana.getNombre() + " " + especieHumana.getEdad() + " " + especieHumana.getNombreplaneta());
                    }
                }
                break;

            case "KLINGON":
                for (Especie especies : listaTODOS) {
                    if (especies.getTipo().equalsIgnoreCase(tipo)) {
                        Klingon especieKlingon = (Klingon) especies;
                        System.out.println(especieKlingon.getTipo() + " " + especieKlingon.getNombre() + " " + especieKlingon.getFuerza() + " " + especieKlingon.getNombreplaneta());
                    }
                }

                break;
            case "NIBIRIAN":
                for (Especie especies : listaTODOS) {
                    if (especies.getTipo().equalsIgnoreCase(tipo)) {
                        Nibirian especieNibirian = (Nibirian) especies;
                        System.out.println(especieNibirian.getTipo() + " " + especieNibirian.getNombre() + " " + especieNibirian.isVegetariano() + " " + especieNibirian.getNombreplaneta());
                    }
                }

                break;
            case "VULCAN":
                for (Especie especies : listaTODOS) {
                    if (especies.getTipo().equalsIgnoreCase(tipo)) {
                        Vulcan especieVulcan = (Vulcan) especies;
                        System.out.println(especieVulcan.getTipo() + " " + especieVulcan.getNombre() + " " + especieVulcan.getMeditacion() + " " + especieVulcan.getNombreplaneta());
                    }
                }

                break;
            case "ANDORIAN":
                for (Especie especies : listaTODOS) {
                    if (especies.getTipo().equalsIgnoreCase(tipo)) {
                        Andorian especieAndorian = (Andorian) especies;
                        System.out.println(especieAndorian.getTipo() + " " + especieAndorian.getNombre() + " " + especieAndorian.isAenar() + " " + especieAndorian.getNombreplaneta());
                    }
                }

                break;

        }

        System.out.println("< ------------------- >\n");

    }

    public static void comprobarExistenciaEspecie(String tipo) throws ExcepcionPlanetas {
        if (tipo.equalsIgnoreCase("Human") || (tipo.equalsIgnoreCase("Klingon")) || (tipo.equalsIgnoreCase("Nibirian")) || (tipo.equalsIgnoreCase("Andorian")) || (tipo.equalsIgnoreCase("Vulcan"))) {

        } else {
            throw new ExcepcionPlanetas(2);
        }
    }
}
