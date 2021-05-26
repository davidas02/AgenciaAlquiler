/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.Controlador;

import com.sauces.Modelo.AgenciaAlquiler;
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
        String matricula, grupo,tipo;
        int plazas;
        float capacidad;
        Vehiculo v=null;
        matricula=vista.getMatricula();
        tipo=vista.getTipo();
        grupo=vista.getGrupo();
        if(v instanceof Turismo){
            plazas=vista.getPlazas();
        v=new Turismo(matricula,Grupo.valueOf(grupo),plazas);
        }
        if(v instanceof Furgoneta){
        capacidad=vista.getCapacidad();
        v=new Furgoneta(matricula, Grupo.valueOf(grupo), capacidad);
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
        String matricula;
        Vehiculo v;

        matricula = vista.getMatricula();
        v =agenciaAlquiler.consultarVehiculo(matricula) ;
        if (matricula != null) {
            vista.mostrarMatricula(v.getMatricula().toString());
            if (v instanceof Turismo) {
                vista.mostrarTipo("TURISMO");
                vista.mostrarPrecioAlquiler(((Turismo) v).getPrecioAlquiler());
            } else {
                vista.mostrarTipo("FURGONETA");
                vista.mostrarPrecioAlquiler((float) ((Furgoneta) v).getPrecioAlquiler());
                
            }
        } else {
            vista.mostrarMensaje("No existe empleado con ese DNI");
        }
    }

    public void modificarVehiculo() {

    }

    public void listarVehiculos() {

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
                n = agenciaAlquiler.guardarVehiculos();
                vista.mostrarMensaje("se ha guardado " + n + " Empleados");
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

                vista.mostrarMensaje("se ha cargado " + n + " Empleados");
            } catch (DaoException ex) {
                vista.mostrarMensaje(ex.getMessage());
            }
        }
    }

    public void buscarVehiculoMasBarato() {
        vista.mostrarMensaje(agenciaAlquiler.getVehiculoMasBarato().toString());
    }

    public void buscarVehiculoMasCaro() {
        vista.mostrarMensaje(agenciaAlquiler.listarVehiculosPorPrecio().toString());
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
