/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.Modelo;

/**
 *
 * @author daw1
 */
public class Furgoneta extends Vehiculo {
    private float capacidad;
    
    public Furgoneta( String matricula, Grupo grupo ,float capacidad) {
        super(matricula, grupo);
        this.capacidad = capacidad;
    }

    public float getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(float capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return super.toString()+" "+ capacidad ;
    }
public float getPrecioAlquiler(){
    float precioAlquiler=0;
    precioAlquiler=getGrupo().getPrecioA()+getGrupo().getPrecioB()*capacidad;
    return precioAlquiler;
    }
    public float getPrecioAlquiler(int dias){
    float precioAlquilerDias;
    precioAlquilerDias=(int)((getGrupo().getPrecioA()+getGrupo().getPrecioB()*capacidad)*dias);
    return precioAlquilerDias;
    } 
}
