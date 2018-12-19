/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Especie;

import java.util.Objects;

/**
 *
 * @author CRISTIAN
 */
public class Especie {

//ATRIBUTOS
    private String nombreplaneta;
    private String tipo;
    private String nombre;

//CONSTRUCTOR
    public Especie(String nombreplaneta, String nombre, String tipo) {

        this.nombreplaneta = nombreplaneta;
        this.nombre = nombre;
        this.tipo = tipo;

    }

//MÉTODOS
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombreplaneta() {
        return nombreplaneta;
    }

    public void setNombreplaneta(String nombreplaneta) {
        this.nombreplaneta = nombreplaneta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   
//
//    @Override
//    public int compareTo(Object especie) {
//        if (especie instanceof Especie || especie instanceof Especie2){
//            Especie especiecast = (Especie) especie;
//        return nombre.compareToIgnoreCase((especiecast.getNombre()));
//        }
//        return 0;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.tipo);
        hash = 17 * hash + Objects.hashCode(this.nombreplaneta);
        hash = 17 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Especie)) {
            return false;
        }
        final Especie other = (Especie) obj;
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.nombreplaneta, other.nombreplaneta)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

}
