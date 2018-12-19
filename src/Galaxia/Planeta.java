/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Galaxia;

import Especie.Especie;
import Excepcion.ExcepcionPlanetas;
import java.util.ArrayList;


/**
 *
 * @author CRISTIAN
 */
public abstract class Planeta {

//ATRIBUTOS
    private String nombre_Planeta;
    private ArrayList<Especie> listaCensados = new ArrayList<>();

//CONSTRUCTOR
    public Planeta(String nombre_Planeta) {
        this.nombre_Planeta = nombre_Planeta;
    }

//METODOS
    public String getNombre_Planeta() {
        return nombre_Planeta;
    }

    public void setNombre_Planeta(String nombre_Planeta) {
        this.nombre_Planeta = nombre_Planeta;
    }

    public ArrayList<Especie> getListaCensados() {
        return listaCensados;
    }

    public void setListaCensados(ArrayList<Especie> listaCensados) {
        this.listaCensados = listaCensados;
    }

 

    public void comprobarExistencia(Especie especie, Planeta planet) throws ExcepcionPlanetas {

        listaCensados = planet.getListaCensados();
        if (listaCensados.contains(especie)) {
            throw new ExcepcionPlanetas(6);

        }
    }

    public boolean compatibilidadEspeciePlaneta(Especie especie) throws ExcepcionPlanetas {

        if (especie.getTipo().equalsIgnoreCase("vulcaniano") && (especie.getNombreplaneta().equalsIgnoreCase("Andoria"))) {
            throw new ExcepcionPlanetas(5);
        } else if (especie.getTipo().equalsIgnoreCase("Andoriano") && (especie.getNombreplaneta().equalsIgnoreCase("Vulcano"))) {
            throw new ExcepcionPlanetas(5);
        } else if (especie.getTipo().equalsIgnoreCase("Klingon") && (especie.getNombreplaneta().equalsIgnoreCase("Vulcano"))) {
            throw new ExcepcionPlanetas(5);
        } else if (especie.getTipo().equalsIgnoreCase("Nibiriano") && (!especie.getNombreplaneta().equalsIgnoreCase("Nibiru"))) {
            throw new ExcepcionPlanetas(5);
        }
        return true;
    }

   

//SOBREESCRITURA DE METODOS
    @Override
    public String toString() {
        return "nombre_Planeta=" + nombre_Planeta + "listaCensados=" + listaCensados;
    }

}
