/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.AgenciaAlquiler;

import com.sauces.Controlador.Controlador;
import com.sauces.Modelo.AgenciaAlquiler;
import com.sauces.Vista.Ventana;

/**
 *
 * @author PC
 */
public class AppAgenciaAlquilerM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here 
        AgenciaAlquiler aa = new AgenciaAlquiler();
        Ventana vista=new Ventana();
      Controlador controlador=new Controlador(aa, vista);
      vista.setControlador(controlador);
        controlador.iniciar();
    }
        // TODO code application logic here
       
      
        
}
