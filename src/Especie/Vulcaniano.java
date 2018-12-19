/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Especie;

import Excepcion.ExcepcionPlanetas;

/**
 *
 * @author CRISTIAN
 */
public class Vulcaniano extends Especie {
//ATRIBUTOS 
    private int meditacion;

//CONSTRUCTOR
    public Vulcaniano(String nombreplaneta, String nombre, String tipo, int meditacion) throws ExcepcionPlanetas {
        super(nombreplaneta, nombre, tipo);
        if (!(meditacion < 0 && meditacion > 10)) {
            this.meditacion = meditacion;
        } else {
            throw new ExcepcionPlanetas(11);
        }
    }

//GETTERS Y SETTERS
    public int getMeditacion() {
        return meditacion;
    }

    public void setMeditacion(int meditacion) {
        this.meditacion = meditacion;
    }

    @Override
    public String toString() {
        return getNombreplaneta() + " " + getNombre() + " " + getTipo() + " " + meditacion;
    }
}
