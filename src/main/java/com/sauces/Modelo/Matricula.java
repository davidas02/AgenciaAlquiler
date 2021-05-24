/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.Modelo;

import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author daw1
 */
public class Matricula implements Serializable{
     private String matricula;

    public Matricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return  matricula;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.matricula);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o== null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        final Matricula other = (Matricula) o;
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        return true;
    }
     public int compareTo(Matricula m){
     return this.matricula.compareTo(m.matricula);
     }
     public static boolean esValido(String matricula){
        char letra;
        String exRegular="([0-9]{4})([A-Z&&[[^AEIOUQ]]{3})";
        Pattern p=Pattern.compile(exRegular);       
        Matcher m=p.matcher(matricula);
        return m.matches();
    }
    
}
