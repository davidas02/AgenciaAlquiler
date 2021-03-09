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
public class Turismo extends Vehiculo {
    int plazas;
    public Turismo(String matricula, Grupo grupo, int plazas) {
        super(matricula, grupo);
        this.plazas = plazas;
    }

    @Override
    public String toString() {
        return super.toString()+" , "+ plazas;
    }
    public float getPrecioAlquiler(){
    float precioAlquiler;
    if(grupo==Grupo.A){
     precioAlquiler=+1.5f*plazas; 
    }else{
    if(grupo==Grupo.B){
        precioAlquiler=+2*plazas;
    }else{
    precioAlquiler=2.5f*plazas;
    }
            }
    return precioAlquiler;
    }
    public float getPrecioAlquiler(int dias){
    float precioAlquiler;
        if(grupo==Grupo.A){
     precioAlquiler=50+1.5f*plazas; 
    }else{
    if(grupo==Grupo.B){
        precioAlquiler=55*2*plazas;
    }else{
    precioAlquiler=60*2.5f*plazas;
    }
    precioAlquiler=precioAlquiler*dias;
    
    }return precioAlquiler;
    }
}
