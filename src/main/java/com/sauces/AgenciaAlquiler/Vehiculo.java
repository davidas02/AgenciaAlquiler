/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.AgenciaAlquiler;

import java.util.Objects;

/**
 *
 * @author daw1
 */
public abstract class Vehiculo implements Comparable<Vehiculo> {

    String matricula;
    Grupo grupo;

    public Vehiculo(String matricula, Grupo grupo) {
        this.matricula = matricula;
        this.grupo = grupo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return matricula + " , " + grupo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.matricula);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o != null) {
            if (o instanceof Vehiculo) {
                Vehiculo v = (Vehiculo) o;
                if (this.matricula.equals(v.matricula)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    @Override
    public int compareTo(Vehiculo v) {
        return this.matricula.compareTo(v.matricula);
    }

    public abstract float getPrecioAlquiler();

    public abstract float getPrecioAlquiler(int dias);

}
