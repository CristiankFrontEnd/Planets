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
public class Nibiriano extends Especie{
    
    
    private String vegetariano;
    
    public Nibiriano(String nombreplaneta, String nombre, String tipo, String vegetariano) {
        super(nombreplaneta, nombre, tipo);
        this.vegetariano=vegetariano;
    }

    public String isVegetariano() {
        return vegetariano;
    }

    public void setVegetariano(String vegetariano) {
        this.vegetariano = vegetariano;
    }
      @Override
    public String toString() {
        return  getTipo()  + " " + getNombre() + " " + vegetariano;
    }
}
