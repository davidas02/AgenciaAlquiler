/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.AgenciaAlquiler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author PC
 */
public class AgenciaAlquiler {
    private String nombre;
    private List<Vehiculo> flota;
    private VehiculoDao vehiculoDao;
    public AgenciaAlquiler() {
        flota=new ArrayList<>();
    }
    public AgenciaAlquiler(String nombre, List<Vehiculo> vehiculos) {
        this.nombre = nombre;
        flota=new ArrayList<>();
        this.flota = vehiculos;
    } 
    public VehiculoDao getVehiculoDao() {
        return vehiculoDao;
    }

    public void setVehiculoDao(VehiculoDao vehiculoDao) {
        this.vehiculoDao = vehiculoDao;
    }
    public String getNombre() {
        return nombre;
    }
    public List<Vehiculo> getVehiculos() {
        return flota;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.flota = vehiculos;
    }
    public List<Vehiculo> getFlota() {
        return List.copyOf(flota);
    }
    public void setFlota(List<Vehiculo> flota) {
        this.flota = flota;
    }
    public boolean incluirVehiculo(Vehiculo vehiculo){
      boolean incluido=false;
        
        if(!flota.contains(vehiculo)){
            incluido=flota.add(vehiculo);
        }
        return incluido;
    }
    public Vehiculo consultarVehiculo(String matricula){
        ListIterator<Vehiculo> iterador=flota.listIterator();
        Vehiculo vehiculo=null;
        
        while(iterador.hasNext()){
            vehiculo=iterador.next();
            if(vehiculo.getMatricula().equals(matricula)){
               return vehiculo;
             }
        }
    return null;
    }
     public boolean eliminarVehiculo(Vehiculo vehiculo){
        return flota.remove(vehiculo);
    }
    public List<Vehiculo> listarVehiculosPorPrecio(){
         List<Vehiculo> listado=new ArrayList<>(flota);
        
        Collections.copy(flota, listado);
        Collections.sort(listado, new ComparadorPrecio());
        
        return listado;
     } 
    public List<Vehiculo> listarVehiculos(Grupo grupo){
         List<Vehiculo> listado=new ArrayList<>();
         
         for(Vehiculo vehiculo: flota){
             if(grupo.equals(vehiculo.getGrupo())){
                 listado.add(vehiculo);
             }
         }
        return listado;
    }
    public Vehiculo getVehiculoMasBarato(){
       return Collections.min(flota, new ComparadorPrecio());  
    }
    public int guardarVehiculos()throws DaoException{
        int n=0;
        if(vehiculoDao!=null){
            return vehiculoDao.insertar(flota);
        }
        return n;
    } 
    public int cargarVehiculos()throws DaoException{
        int n=0;
        if(vehiculoDao!=null){
            List<Vehiculo> listado=vehiculoDao.listar();
            for(Vehiculo v:listado){
                if(this.incluirVehiculo(v));
                n++;
            }
        }
         return n;
    } 
}
