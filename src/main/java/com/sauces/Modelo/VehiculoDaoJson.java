/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.Modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daw1
 */
public class VehiculoDaoJson implements VehiculoDao{
    public Path path;

    public VehiculoDaoJson(String path) {
        this.path=Paths.get(path);
    }
    @Override
    public List<Vehiculo> listar() throws DaoException {
        List<Vehiculo> listado = new ArrayList<>();
        //Definir tipo para poder trabajar con colecciones
        java.lang.reflect.Type tipo = new TypeToken<List<Vehiculo>>(){}.getType();
        //Registrar clases hijas
        RuntimeTypeAdapterFactory<Vehiculo> vehiculoAdapter = RuntimeTypeAdapterFactory.of(Vehiculo.class, "type");
        vehiculoAdapter.registerSubtype(Turismo.class, "Turismo");
        vehiculoAdapter.registerSubtype(Furgoneta.class, "Furgoneta");
        //Crear objeto GsonBuilder y configurarlo
        GsonBuilder builder=new GsonBuilder();
        builder.setPrettyPrinting();
        builder.registerTypeAdapterFactory(vehiculoAdapter);
        
        Gson gson=builder.create();
        
        try(BufferedReader archivo =Files.newBufferedReader(path)){
            listado=gson.fromJson(archivo, tipo);
            
        } catch (NoSuchFileException nsfe){
            throw new DaoException("Error en el nombre del fichero");
        } catch (JsonParseException jpe) {
            throw new DaoException("Formato de datos incorrecto");
        } catch (IOException ex) {
            throw new DaoException(ex.toString());
        }
        
        return listado;
    }

    @Override
    public int insertar(List<Vehiculo> vehiculos) throws DaoException {
        int n=0;
        //Definir tipo para poder trabajar con colecciones
        java.lang.reflect.Type tipo = new TypeToken<List<Vehiculo>>(){}.getType();
        //Registrar clases hijas
        RuntimeTypeAdapterFactory<Vehiculo> vehiculoAdapter = RuntimeTypeAdapterFactory.of(Vehiculo.class, "type");
        vehiculoAdapter.registerSubtype(Turismo.class, "Turismo");
        vehiculoAdapter.registerSubtype(Furgoneta.class, "Furgoneta");
        //Crear objeto GsonBuilder y configurarlo
        GsonBuilder builder=new GsonBuilder();
        builder.setPrettyPrinting();
        builder.registerTypeAdapterFactory(vehiculoAdapter);
        
        Gson gson=builder.create();
        
        try(BufferedWriter archivo =Files.newBufferedWriter(path)){
            gson.toJson(vehiculos, tipo, archivo);
            n=vehiculos.size();
        } catch (NoSuchFileException nsfe){
            throw new DaoException("Error en el nombre del fichero");
        }  catch (IOException ex) {
            throw new DaoException(ex.toString());
        }
        return n;
    }
}
