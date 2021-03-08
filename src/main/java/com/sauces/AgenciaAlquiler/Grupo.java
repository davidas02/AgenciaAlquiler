/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.AgenciaAlquiler;

/**
 *
 * @author daw1
 */
public enum Grupo {
    A(),
    B(),
    C();
    private final float precioA;
    private final float precioB;
    private final float precioC;

    private Grupo(float precioA, float precioB, float precioC) {
        this.precioA = precioA;
        this.precioB = precioB;
        this.precioC = precioC;
    }

    public static Grupo getA() {
        return A;
    }

    public static Grupo getB() {
        return B;
    }

    public static Grupo getC() {
        return C;
    }

    public float getPrecioA() {
        return precioA;
    }

    public float getPrecioB() {
        return precioB;
    }

    public float getPrecioC() {
        return precioC;
    }

}
