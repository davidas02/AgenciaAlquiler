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
public class Turismo extends Vehiculo {
    private int plazas;
    public Turismo(String matricula, Grupo grupo, int plazas) {
        super(matricula, grupo);
        this.plazas = plazas;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    @Override
    public String toString() {
        return super.toString()+" , "+ plazas;
    }
    public float getPrecioAlquiler(){
    float precioAlquiler=0;
    precioAlquiler=getGrupo().getPrecioA()+getGrupo().getPrecioB()*plazas;
    return precioAlquiler;
    }
    public float getPrecioAlquiler(int dias){
    float precioAlquilerDias;
     
    precioAlquilerDias=(int)((getGrupo().getPrecioA()+getGrupo().getPrecioB()*plazas)*dias);
    return precioAlquilerDias;
    }
}
