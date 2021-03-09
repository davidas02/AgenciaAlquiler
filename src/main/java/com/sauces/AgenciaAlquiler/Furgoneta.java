/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.AgenciaAlquiler;

/**
 *
 * @author daw1
 */
public class Furgoneta extends Vehiculo {
    float capacidad;
    
    public Furgoneta( String matricula, Grupo grupo ,float capacidad) {
        super(matricula, grupo);
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return super.toString()+" "+ capacidad ;
    }
    public float getPrecioAlquiler(){
    float precioAlquiler=0;
    if(grupo==Grupo.A){
     precioAlquiler=50+1.5f*capacidad; 
    }else{
    if(grupo==Grupo.B){
        precioAlquiler=55*2*capacidad;
    }else{
    precioAlquiler=60*2.5f*capacidad;
    }
            }
    return precioAlquiler;
    }
    public float getPrecioAlquiler(int dias){
    float precioAlquiler;
        if(grupo==Grupo.A){
     precioAlquiler=50+1.5f*capacidad; 
    }else{
    if(grupo==Grupo.B){
        precioAlquiler=55*2*capacidad;
    }else{
    precioAlquiler=60*2.5f*capacidad;
    }
    precioAlquiler=precioAlquiler*dias;
    
    }return precioAlquiler;
    }
    
}
