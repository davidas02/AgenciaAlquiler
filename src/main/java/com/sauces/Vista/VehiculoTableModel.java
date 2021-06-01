/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.Vista;

import com.sauces.Modelo.Furgoneta;
import com.sauces.Modelo.Grupo;
import com.sauces.Modelo.Turismo;
import com.sauces.Modelo.Vehiculo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author daw1
 */
public class VehiculoTableModel extends AbstractTableModel{
    private List<Vehiculo> listadoVehiculos;
    private String[] columnas;

    public VehiculoTableModel() {
        this.listadoVehiculos = new ArrayList<>();
        this.columnas = new String[]{"MATRÍCULA","TIPO","GRUPO","PLAZAS","CAPACIDAD","PRECIO ALQUILER"};
    }
    public void setListadoVehiculos(List<Vehiculo> listado){
       this.listadoVehiculos = listado; 
   }

    public List<Vehiculo> getListadoVehiculos() {
        return listadoVehiculos;
    }

    public String[] getColumnas() {
        return columnas;
    }
   
    public int getRowCount(){
       return listadoVehiculos.size();
    }
   
     public int getColumnCount(){
       return columnas.length;
    }
   
    public Object getValueAt(int rowIndex, int columnIndex){
       Vehiculo v=listadoVehiculos.get(rowIndex);
        Object o=null;
        switch(columnIndex){
           case 0:o=v.getMatricula().toString();
            break;
           case 1:o=v.getClass().getSimpleName();
            break;
           case 2:o=v.getGrupo().toString();
           break;
           case 3: if(v instanceof Turismo){
               o=((Turismo) v).getPlazas();
           }
           else{
            o=0;
           }
           break;
           case 4: if(v instanceof Furgoneta){
                o=((Furgoneta)v).getCapacidad();
           }
           else{
            o=0.0f;
           }
           break;
           case 5: o=v.getPrecioAlquiler();
        }
        return o;
    }
   
    public boolean isCellEditable(int rowIndex, int columnIndex){
       return false;
    }
   
    public Class<?> getColumnClass(int columnIndex){
      Class<?> clase=null;
        switch(columnIndex){
            case 0: clase=String.class;
            break;
            case 1: clase=String.class;
            break;
            case 2: clase=String.class;
            break;
            case 3:clase=Integer.class;
            break;
            case 4:clase=Float.class;
            break;
            case 5:clase=Float.class;
            break;
        }
               return clase;

    }
   
    public String getColumnName(int column){
        return columnas[column];
    }
}
