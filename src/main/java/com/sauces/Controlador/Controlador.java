/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.Controlador;

import com.sauces.Modelo.AgenciaAlquiler;
import com.sauces.Modelo.DaoException;
import com.sauces.Modelo.Grupo;
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

    public Controlador(Ventana vista, AgenciaAlquiler agenciaAlquiler) {
        this.vista = vista;
        this.agenciaAlquiler = agenciaAlquiler;
    }

    public void crearVehiculo() {

    }

    public void borrarVehiculo() {

    }

    public void buscarVehiculo() {

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
