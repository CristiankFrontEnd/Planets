/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Galaxia;

import Excepcion.ExcepcionPlanetas;

/**
 *
 * @author CRISTIAN
 */
public class Kronos extends Planeta {

    public Kronos(String nombre_Planeta) throws ExcepcionPlanetas {
        super(nombre_Planeta);
        
        if (getListaCensados().size() > 30) {
                throw new ExcepcionPlanetas(13);
            
        }
        
    }

    

}
