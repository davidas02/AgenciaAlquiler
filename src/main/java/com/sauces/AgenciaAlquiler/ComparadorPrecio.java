/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.AgenciaAlquiler;

import java.util.Comparator;

/**
 *
 * @author PC
 */
public class ComparadorPrecio implements Comparator<Vehiculo> {
    public int compare(Vehiculo v1, Vehiculo v2) {
        int salida = 0;
        float alquiler1, alquiler2;
        alquiler1 = v1.getPrecioAlquiler();
        alquiler2 = v2.getPrecioAlquiler();
        if (alquiler1 < alquiler2) {
            salida = -1;
        } else {
            if (alquiler1 > alquiler2) {
                salida = 1;
            }
        }
        return 0;
    }
}
