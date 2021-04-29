/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.AgenciaAlquiler;


import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daw1
 */
public class VehiculoDaoObj implements VehiculoDao{
    Path path;

    public VehiculoDaoObj(String path) {
        this.path =Paths.get(path);
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    @Override
    public List<Vehiculo> listar() {
        List<Vehiculo> lista = new ArrayList<>();
        Vehiculo vehiculo;
        try(InputStream inputS=Files.newInputStream(path);
                ObjectInputStream entrada = new ObjectInputStream(inputS);){
            while(inputS.available() > 0){
                vehiculo=(Vehiculo)entrada.readObject();
                lista.add(vehiculo);
            }
        }catch(EOFException eofe){
            System.out.println("Fin de fichero");
        }catch(ClassNotFoundException cnfe){
            System.out.println("Objeto no esperado");
        }catch(FileNotFoundException fnfe){
            System.out.println("No existe el fichero");
        }catch(IOException ioe){
            System.out.println("Error de entrada/salida");
        }  
        return lista;    }

    @Override
    public int insertar(List<Vehiculo> vehiculos) {
        int n=0;
        try(ObjectOutputStream fichero=new ObjectOutputStream(Files.newOutputStream(path))){
            for(Vehiculo v: vehiculos){
                fichero.writeObject(v);
                n++;
            }
        } catch (IOException ex) {
         System.out.println(ex);
     }
        return n;    }
    
}
