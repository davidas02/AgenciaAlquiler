/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.Modelo;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.StreamException;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public List<Vehiculo> listar() throws DaoException{
     List<Vehiculo> listado=new ArrayList<>();
        XStream xstream=new XStream(new DomDriver());
        
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypeHierarchy(Turismo.class);
        xstream.allowTypeHierarchy(Furgoneta.class);
        try(BufferedReader archivo=Files.newBufferedReader(path)){
            listado=(List<Vehiculo>)xstream.fromXML(archivo);
        } catch (NoSuchFileException nsfe){
            throw new DaoException("Error en el nombre del fichero");
        }catch(StreamException se){
            throw new DaoException("Formato de datos incorrecto");
        }catch (IOException ex) {
            Logger.getLogger(VehiculoDaoXml.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listado;
    }

    @Override
     public int insertar(List<Vehiculo> vehiculos) throws DaoException {
        int n=0;
        XStream xstream=new XStream(new DomDriver());
        
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypeHierarchy(Turismo.class);
        xstream.allowTypeHierarchy(Furgoneta.class);
        
        try(BufferedWriter archivo=Files.newBufferedWriter(path)){
            xstream.toXML(vehiculos,archivo);
            n=vehiculos.size();
        } catch (NoSuchFileException nsfe){
            throw new DaoException("Error en el nombre del fichero");
        } catch (IOException ex) {
            throw new DaoException("Error de E/S");
        }
        return n;
    }
    
}
