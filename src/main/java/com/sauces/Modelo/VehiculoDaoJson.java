/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.Modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daw1
 */
public class VehiculoDaoJson implements VehiculoDao {

    Path path;

    public VehiculoDaoJson(String path) {
        this.path = Paths.get(path);
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    @Override
    public List<Vehiculo> listar() {
        List<Vehiculo> listado=new ArrayList<>();
        java.lang.reflect.Type tipo = new com.google.gson.reflect.TypeToken<List<Vehiculo>>(){}.getType();
        RuntimeTypeAdapterFactory<Vehiculo> vehiculoAdapter = RuntimeTypeAdapterFactory.of(Vehiculo.class, "type");
        vehiculoAdapter.registerSubtype(Turismo.class, "Turismo");
        vehiculoAdapter.registerSubtype(Furgoneta.class, "Furgoneta");
        GsonBuilder builder=new GsonBuilder();
        builder.setPrettyPrinting();
        builder.registerTypeAdapterFactory(vehiculoAdapter);
        Gson gson=builder.create();
        try(BufferedReader fichero=Files.newBufferedReader(path)){
        listado=gson.fromJson(fichero, tipo);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return listado;
    }    

    @Override
    public int insertar(List<Vehiculo> vehiculos) {
        int n=0;
    List<Vehiculo> listado=new ArrayList<>();
        java.lang.reflect.Type tipo = new com.google.gson.reflect.TypeToken<List<Vehiculo>>(){}.getType();
        RuntimeTypeAdapterFactory<Vehiculo> vehiculoAdapter = RuntimeTypeAdapterFactory.of(Vehiculo.class, "type");
        vehiculoAdapter.registerSubtype(Turismo.class, "Turismo");
        vehiculoAdapter.registerSubtype(Furgoneta.class, "Furgoneta");
        GsonBuilder builder=new GsonBuilder();
        builder.setPrettyPrinting();
        builder.registerTypeAdapterFactory(vehiculoAdapter);
        Gson gson=builder.create();
         try(BufferedWriter fichero=Files.newBufferedWriter(path)){
        gson.toJson(listado,tipo,fichero);
        n=listado.size();
        } catch (IOException ex) {
            System.out.println(ex);
        }
         return n;
        }
}
