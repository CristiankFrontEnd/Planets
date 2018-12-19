/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Especie;

/**
 *
 * @author CRISTIAN
 */
public class Andoriano extends Especie {
//ATRIBUTOS
    private boolean aenar;

//CONSTRUCTOR
    public Andoriano(String nombreplaneta, String nombre, String tipo, boolean aenar) {
        super(nombreplaneta, nombre, tipo);
        this.aenar = aenar;
    }
 //GETTERS Y SETTERS
    public boolean isAenar() {
        return aenar;
    }

    public void setAenar(boolean aenar) {
        this.aenar = aenar;
    }

    @Override
    public String toString() {
        return getNombreplaneta() + " " + getNombre() + " " + getTipo() + " " + aenar;
    }
}
