/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.Modelo;

import java.nio.file.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author daw1
 */
public class VehiculoDaoCsv implements VehiculoDao{
Path path;

    public VehiculoDaoCsv(String path) {
        this.path = Paths.get(path);
    }

    @Override
    public List<Vehiculo> listar() {
        List<Vehiculo> vehiculos=new ArrayList<>();
        Vehiculo vehiculo=null;
        String linea;
        String matricula,grupo,tipo;
        int plazas;
        float capacidad;
        String[] tokens;
        try (BufferedReader fichero = Files.newBufferedReader(path)) {
            linea = fichero.readLine(); 
            while (linea != null) {
            tokens = linea.split(",");
            tipo=tokens[0];
            matricula=tokens[1];
            grupo=tokens[2];
            switch (tipo){
                case"turismo":
                    plazas=Integer.parseInt(tokens[4]);
                    vehiculo= new Turismo(matricula, Grupo.valueOf(grupo), plazas);
                    break;
                    case"furgoneta":
                        capacidad=Float.parseFloat(tokens[4]);
                        vehiculo=new Furgoneta(matricula,Grupo.valueOf(grupo), capacidad);
                        break;
            }
            vehiculos.add(vehiculo);
                linea = fichero.readLine();
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return vehiculos;
    }

    @Override
    public int insertar(List<Vehiculo> vehiculos) {
        try(BufferedWriter salida=Files.newBufferedWriter(path)){
            for(Vehiculo v: vehiculos){
                salida.write(v.getClass().getSimpleName()+","+v.toString());
                salida.newLine();
            }
        }catch(IOException ioe){
            System.out.println("Error entrada salida");
        }
        return vehiculos.size();    
    }
    
}
