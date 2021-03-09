/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.AgenciaAlquiler;


import java.util.List;
import java.util.Scanner;

/**
 *
 * @author David Aparicio
 */
public class AppAgenciaAlquiler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        int accion,accion1;
        String nombre="Hertz";
        List<Vehiculo> flota = null;
        AgenciaAlquiler aa=new AgenciaAlquiler(nombre, flota);
       
        String matricula;
        String grupo;
        int plazas,capacidad;
        do{
        System.out.println("1- Crear Vehiculo.");
        System.out.println("2- Consultar Vehiculo.");
        System.out.println("3- Eliminar Vehiculo.");
        System.out.println("4- Listar Vehiculo.");
        System.out.println("5- Consultar Alquiler mas Barato.");
        System.out.println("Introduzca la accion que quiera realizar.");
        accion=teclado.nextInt();
        teclado.nextLine();
        switch(accion){
            case 1:
                
                System.out.println("1- Crear Turismo");
                System.out.println("2- Crear Furgoneta");
                System.out.println("Introduzca la accion que quiera realizar.");
                accion1=teclado.nextInt();
                teclado.nextLine();
                switch(accion1){
                    case 1:
                        System.out.println("Introduce Matricula");
                        matricula=teclado.nextLine();
                        System.out.println("Introduce Grupo");
                        grupo=teclado.nextLine();
                        switch(grupo){
                            case "A":Grupo.getA();
                            break;
                            case "B":Grupo.getB();
                            break;
                            case "C":Grupo.getC();
                        }
                        Vehiculo vehiculo=new Vehiculo(matricula,grupo);
                        System.out.println("Introduce Nº de Plazas");
                        plazas=teclado.nextInt();
                        teclado.nextLine();
                        
                       Turismo t=new Turismo(matricula,grupo,plazas);
                       if(aa.incluirVehiculo(t)){
                          System.out.println("El Turismo se ha incluido correctamente");
                        }else{
                          System.out.println("El Turismo no se ha incluido");
                         }
                    break;
                    case 2:
                        System.out.println("Introduce Matricula");
                        matricula=teclado.nextLine();
                        System.out.println("Introduce Grupo");
                        grupo=teclado.nextLine();
                       Vehiculo vehiculo=new Vehiculo(matricula,grupo);
                        System.out.println("Introduce Nº de Plazas");
                        plazas=teclado.nextInt();
                        teclado.nextLine();
                        System.out.println("Introduce Capacidad");
                        capacidad = teclado.nextInt();
                        teclado.nextLine();
                        
                       Furgoneta f=new Furgoneta(matricula,grupo,capacidad);
                       if(aa.incluirVehiculo(f)){
                          System.out.println("El Turismo se ha incluido correctamente");
                        }else{
                          System.out.println("El Turismo no se ha incluido");
                         }
                    break;  
                }
            break;
            case 2:
                 System.out.println("Introduce Matricula");
                 matricula=teclado.nextLine();
                aa.consultarVehiculo(matricula);
                
            break;
            case 3:
                 System.out.println("Introduce Matricula");
                 matricula=teclado.nextLine();
                 aa.eliminarVehiculo(vehiculo);
            break;
            case 4:
                System.out.println("Introduzca la accion que quiera realizar.");
                accion1=teclado.nextInt();
                teclado.nextLine();
            break;
            case 5:
              aa.getVehiculoMasBarato();
            break;
            case 0:
                System.out.println("Adios.");     
            break;
        }
        }while(accion!=0);
    }
    
}
