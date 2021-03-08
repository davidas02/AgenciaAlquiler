/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.AgenciaAlquiler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author PC
 */
public class AgenciaAlquiler {
    private String nombre;
    private List<Vehiculo> flota;
    public boolean incluirVehiculo(Vehiculo vehiculo){
    boolean incluido=false;
        if(!flota.contains(vehiculo)){
            flota.add(vehiculo);
            incluido=true;
        }
        return incluido;
    }
    public Vehiculo consultarVehiculo(String matricula){
    Collections.sort(Vehiculo);
        return Vehiculo;
    }
    public Vehiculo eliminarVehiculo(Vehiculo vehiculo){
        return flota.remove(vehiculo);
    }
    public List<Vehiculo> listarVehiculosPorPrecio(){
    
    }
    public List<Vehiculo> listarVehiculos(){
    
    }
    public Vehiculo getVehiculoMasBarato(){
    
    }
}
