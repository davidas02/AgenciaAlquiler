package com.sauces.AgenciaAlquiler;
import com.sauces.Modelo.VehiculoDaoXml;
import com.sauces.Modelo.DaoException;
import com.sauces.Modelo.Furgoneta;
import com.sauces.Modelo.Grupo;
import com.sauces.Modelo.Turismo;
import com.sauces.Modelo.Vehiculo;
import com.sauces.Modelo.VehiculoDaoJson;
import com.sauces.Modelo.VehiculoDaoObj;
import com.sauces.Modelo.VehiculoDaoCsv;
import com.sauces.Modelo.VehiculoDao;
import com.sauces.Modelo.AgenciaAlquiler;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 

/**
 *
 * @author daw1
 */
public class AppAgenciaAlquiler {
  
    public static void main (String[] args){
        AgenciaAlquiler aa=new AgenciaAlquiler();
    Scanner teclado=new Scanner (System.in);
        int opcion, opcion2,opcion1;
        String matricula, grupo;
        int plazas;
        float capacidad;
        Vehiculo v=null;
        VehiculoDao vehiculoDao=null;
        String nombreArchivo;
        String extension;
        List<Vehiculo> listado=null;
    do{
        System.out.println("1.- Añadir Vehiculo");
        System.out.println("2.- Consultar vehiculo");
        System.out.println("3.- Eliminar vehiculo");
        System.out.println("4.- Listado de vehículos");
        System.out.println("5.- Consultar alquiler más barato");
        System.out.println("6.- Guardar Vehiculos");
        System.out.println("7.- Cargar Vehiculos");
        System.out.println("0- Salir");
        System.out.println("Introduzca opcion: ");
        opcion=teclado.nextInt();
        teclado.nextLine();
         switch(opcion){
            case 1:System.out.println("1.- Añadir turismo");
                   System.out.println("2.- Añadir furgoneta");
                   System.out.println("Introduzca opcion: ");
                   opcion2=teclado.nextInt();
                   teclado.nextLine();
                   System.out.println("Introduce matricula: ");
                   matricula=teclado.nextLine();
                   System.out.println("Introduce el grupo: "+Arrays.toString(Grupo.values()));
                   grupo=teclado.nextLine();
                    switch(opcion2){
                        case 1:
                               System.out.println("Introduzca numero de plazas: ");
                               plazas=teclado.nextInt();
                               teclado.nextLine();
                               v=new Turismo(matricula,Grupo.valueOf(grupo),plazas);
                            break;
                        case 2: System.out.println("Introduzca capacidad: ");
                               capacidad=teclado.nextFloat();
                               teclado.nextLine();
                               v=new Furgoneta(matricula,Grupo.valueOf(grupo),capacidad);
                             break;
                    }
                        if(aa.incluirVehiculo(v)){
                           System.out.println("Vehiculo incluido");
                        }else{
                            System.out.println("No se ha podido incluir el vehiculo");
                        }
                             break;
                    
            case 2:System.out.println("Introduce la matricula del vehiculo");
                    matricula=teclado.nextLine();
                    v=aa.consultarVehiculo(matricula);
                    if(v!=null){
                        System.out.println(v);
                    }else{
                        System.out.println("No existe un vehiculo con esa matricula");
                    }
                break;
            case 3: System.out.println("Introduce la matricula del vehiculo");
                    matricula=teclado.nextLine();
                    if(v!=null){
                        if(aa.eliminarVehiculo(v)){
                            System.out.println("Vehiculo eliminado");
                        }else{
                             System.out.println("No se ha `podido elminar el vehiculo");
                        }
                    }else{
                        System.out.println("No existe un vehiculo con esa matricula");
                    }
                break;
            case 4: System.out.println("1.- Listado de vehículos por precio");
                    System.out.println("2-  Listado de turismos");
                    System.out.println("3- Listado de furgonetas");
                    System.out.println("Introduzca opcion: ");
                    opcion1  =teclado.nextInt();
                    teclado.nextLine();
                         switch(opcion1){
                            case 1: listado=aa.listarVehiculosPorPrecio();
                                System.out.println(listado.toString());
                                break;
                            case 2: for(Vehiculo veh:aa.getFlota()){
                                        if(veh instanceof Turismo){
                                            listado.add(veh);
                                            System.out.println(veh.toString());
                                        }
                                     }
                            break;
                            case 3: for(Vehiculo veh:aa.getFlota()){
                                        if(veh instanceof Furgoneta){
                                        listado.add(veh);
                                        System.out.println(veh.toString());
                                        }
                                     }
                            break;
                         }
                    
                break;
            case 5: System.out.println(aa.getVehiculoMasBarato());
                break;
            case 6:
                System.out.println("Introduce nombre de archivo: ");
                        nombreArchivo=teclado.nextLine();
                        aa.setVehiculoDao(getDao(nombreArchivo));
                        try {
                            aa.guardarVehiculos();
                        }catch (DaoException de) {
                            System.out.println(de.getMessage());
                        }                
                        break;
            case 7:
                System.out.println("Introduce nombre de archivo: ");
                        nombreArchivo=teclado.nextLine();
                        aa.setVehiculoDao(getDao(nombreArchivo));
                        try {
                            aa.cargarVehiculos();
                            System.out.println(aa.cargarVehiculos());
                        }catch (DaoException de) {
                            System.out.println(de.getMessage());
                        }
                        break;
            case 0: System.out.println("¡Adios!");
                break;
            default: System.out.println("Error en la seleccion");
        
        }
    }while(opcion!=0);
        }
     public static VehiculoDao getDao(String archivo){
        String extension=archivo.substring(archivo.lastIndexOf(".")+1);
        switch(extension){
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
