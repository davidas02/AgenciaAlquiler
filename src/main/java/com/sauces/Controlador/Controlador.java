/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.Controlador;

import com.sauces.Modelo.AgenciaAlquiler;
import com.sauces.Modelo.ComparadorPrecio;
import com.sauces.Modelo.DaoException;
import com.sauces.Modelo.Furgoneta;
import com.sauces.Modelo.Grupo;
import com.sauces.Modelo.Turismo;
import com.sauces.Modelo.Vehiculo;
import com.sauces.Modelo.VehiculoDao;
import com.sauces.Modelo.VehiculoDaoCsv;
import com.sauces.Modelo.VehiculoDaoJson;
import com.sauces.Modelo.VehiculoDaoObj;
import com.sauces.Modelo.VehiculoDaoXml;
import com.sauces.Vista.Ventana;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author daw1
 */
public class Controlador {

    private Ventana vista;
    private AgenciaAlquiler agenciaAlquiler;

    public Controlador(AgenciaAlquiler agenciaAlquiler,Ventana vista) {
        this.vista = vista;
        this.agenciaAlquiler = agenciaAlquiler;
    }

    public void crearVehiculo() {
        Vehiculo v=null;
        String matricula=vista.getMatricula();
        Grupo grupo=Grupo.valueOf(vista.getGrupo());
        String tipo=vista.getTipo();
        
        if(tipo.equals("TURISMO")){
            
                int plazas=vista.getPlazas();
                v=new Turismo(matricula,grupo,plazas);
        }    
        else{
                float capacidad=vista.getCapacidad();
                v=new Furgoneta(matricula,grupo,capacidad);
            
        }
        vista.actualizarTabla();
        if(agenciaAlquiler.incluirVehiculo(v)){
            vista.mostrarPrecioAlquiler(v.getPrecioAlquiler());
            vista.mostrarMensaje("Vehículo incluido");
        }
        else{
            vista.mostrarMensaje("No se ha podido incluir el vehículo");
        }
    }

    public void borrarVehiculo() {
        String matricula = vista.getMatricula();
        Vehiculo v;
        v = agenciaAlquiler.consultarVehiculo(matricula);
        if (v != null) {
            if (agenciaAlquiler.eliminarVehiculo(v)) {
                vista.mostrarMensaje("Vehiculo Eliminado");
            } else {
                vista.mostrarMensaje("No se ha podido eliminar el vehiculo");
            }
        }else{
            vista.mostrarMensaje("No existe el vehiculo");
        }
    }

    public void buscarVehiculo() {
        String matricula=null;
        Vehiculo v;
        matricula=vista.getMatricula().toString();
        v=agenciaAlquiler.consultarVehiculo(matricula);
        if(v!=null){
            vista.mostrarMensaje(v.toString());
        }else{
        vista.mostrarMensaje("Vehiculo no encontrado");
        }
              
    }

    public void modificarVehiculo() {
       
    }

    public void listarVehiculos() {
       List<Vehiculo> listado=new ArrayList<>();
        for(Vehiculo v:agenciaAlquiler.getFlota()){
        String grupo=vista.getFiltroGrupo();
        String tipo=vista.getFiltroTipo();
        if(tipo.equals("TODOS") || v.getClass().getSimpleName().toUpperCase().equals(tipo)){
            if(grupo.equals("TODOS")||v.getGrupo().equals(Grupo.valueOf(grupo))){
            listado.add(v);
            }
        }
        }
        Collections.sort(listado);
         vista.listarVehiculos(listado);
    }

    public void guardarVehiculos() {
        String archivo;
        List<Vehiculo> listado;
        VehiculoDao vehiculoDao;
        int n = 0;
        archivo = vista.getArchivo();
        vehiculoDao = getDao(archivo);
        
        if (vehiculoDao != null) {
            try {
                agenciaAlquiler.setVehiculoDao(vehiculoDao);
                n=agenciaAlquiler.guardarVehiculos();
                if(n>0){
                vista.mostrarMensaje("se ha guardado " + n + " Vehiculos");
                }
            } catch (DaoException ex) {
                vista.mostrarMensaje(ex.getMessage());
            }
        }
    }

    public void cargarVehiculos() {
        String archivo;
        List<Vehiculo> listado;
        VehiculoDao vehiculoDao;
        int n = 0;
        archivo = vista.getArchivo();
        vehiculoDao = getDao(archivo);

        if (vehiculoDao != null) {
            try {
               agenciaAlquiler.setVehiculoDao(vehiculoDao);
                n =agenciaAlquiler.cargarVehiculos();
               if(n>0){
                vista.mostrarMensaje("Se han cargado " + n + " Vehiculos");
                }
            } catch (DaoException ex) {
                vista.mostrarMensaje(ex.getMessage());
            }
        }
    }

    public void buscarVehiculoMasBarato() {
        vista.mostrarMensaje(agenciaAlquiler.getVehiculoMasBarato().toString());
    }

    public void buscarVehiculoMasCaro() {
       Vehiculo v= Collections.max(agenciaAlquiler.getFlota(), new ComparadorPrecio());
        vista.mostrarMensaje(v.toString());
    }

    public void iniciar() {
        vista.mostrar();
    }

    public static VehiculoDao getDao(String archivo) {
        String extension = archivo.substring(archivo.lastIndexOf(".") + 1);
        switch (extension) {
            case "obj":
                return (new VehiculoDaoObj(archivo));
            case "csv":
                return (new VehiculoDaoCsv(archivo));
            case "json":
                return (new VehiculoDaoJson(archivo));
            case "xml":
                return (new VehiculoDaoXml(archivo));
        }
        return null;
    }
}
