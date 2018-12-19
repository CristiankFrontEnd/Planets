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
public class Klingon extends Especie {  
//ATRIBUTOS
    private int fuerza;
    
//CONSTRUCTOR
    public Klingon(String nombreplaneta, String nombre, String tipo, int fuerza) throws ExcepcionPlanetas {
        super(nombreplaneta, nombre, tipo);
        if (!(fuerza < 50 && fuerza > 350)) {
            this.fuerza = fuerza;
        } else {
            throw new ExcepcionPlanetas(12);
        }
    }
    
 //GETTERS Y SETTERS
    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }
    
     @Override
    public String toString() {
        return getNombreplaneta() + " " + getNombre() + " " + getTipo() + " " + fuerza;
    }
}
