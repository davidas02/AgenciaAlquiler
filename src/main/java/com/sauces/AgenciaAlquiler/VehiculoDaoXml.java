/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.AgenciaAlquiler;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daw1
 */
public class VehiculoDaoXml implements VehiculoDao{
Path path;

    public VehiculoDaoXml(String path) {
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
     List<Vehiculo> vehiculos=new ArrayList<>();
        return vehiculos;    
    }

    @Override
    public int insertar(List<Vehiculo> vehiculos) {
       int n=0;
        XStream xstream=new XStream(new DomDriver());
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypeHierarchy(Furgoneta.class);
        xstream.allowTypeHierarchy(Turismo.class);
        try(BufferedWriter fichero=Files.newBufferedWriter(path)){
        xstream.toXML(vehiculos,fichero);
                n=vehiculos.size();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return n; 
    }
    
}
