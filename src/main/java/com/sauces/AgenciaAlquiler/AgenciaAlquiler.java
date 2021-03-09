/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.AgenciaAlquiler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author PC
 */
public class AgenciaAlquiler {

    private String nombre;
    private List<Vehiculo> flota;

    public AgenciaAlquiler(String nombre, List<Vehiculo> flota) {
        this.nombre = nombre;
        this.flota = flota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Vehiculo> getFlota() {
        return flota;
    }

    public void setFlota(List<Vehiculo> flota) {
        this.flota = flota;
    }

    public boolean incluirVehiculo(Vehiculo vehiculo) {
        boolean incluido = false;
        if (!flota.contains(vehiculo)) {
            flota.add(vehiculo);
            incluido = true;
        }
        return incluido;
    }

    public Vehiculo consultarVehiculo(String matricula) {
        Vehiculo vehiculo = null;
        Iterator<Vehiculo> iterador = flota.iterator();
        while (iterador.hasNext()) {
            vehiculo = iterador.next();
            if (vehiculo.getMatricula().equals(matricula)) {
                return vehiculo;
            }
        }
        return null;
    }

    public boolean eliminarVehiculo(Vehiculo vehiculo) {
        return flota.remove(vehiculo);
    }

    public List<Vehiculo> listarVehiculosPorPrecio() {
        List<Vehiculo> listado = new ArrayList<>();
        Collections.copy(flota, listado);
        Collections.sort(listado, new ComparadorPrecio());
        return listado;
    }

    public List<Vehiculo> listarVehiculos(Grupo grupo) {
        List<Vehiculo> listado = new ArrayList<>();
        for (Vehiculo vehiculo : flota) {
            if (grupo.equals(vehiculo.getGrupo())) {
                listado.add(vehiculo);
            }
        }
        return listado;
    }

    public Vehiculo getVehiculoMasBarato() {
        return Collections.min(flota, new ComparadorPrecio());
    }
}
