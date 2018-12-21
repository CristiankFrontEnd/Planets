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
public class Human extends Especie {
//ATRIBUTOS
    private int edad;

//CONSTRUCTOR
    public Human(String nombreplaneta, String nombre, String tipo, int edad) throws ExcepcionPlanetas {
        super(nombreplaneta, nombre, tipo);
        if (edad >= 0 && edad <= 130) {
            this.edad = edad;
        } else {
            throw new ExcepcionPlanetas(10);
        }
    }

 //GETTERS Y SETTERS
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return  getTipo()  + " " + getNombre() + " " + edad;
    }

}
