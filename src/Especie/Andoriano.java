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
    private String aenar;

//CONSTRUCTOR
    public Andoriano(String nombreplaneta, String nombre, String tipo, String aenar) {
        super(nombreplaneta, nombre, tipo);
        this.aenar = aenar;
    }
 //GETTERS Y SETTERS
    public String isAenar() {
        return aenar;
    }

    public void setAenar(String aenar) {
        this.aenar = aenar;
    }

    @Override
    public String toString() {
        return getTipo()  + " " +getNombre()  + " " + aenar;
    }
}
