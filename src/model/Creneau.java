package model;

import java.io.Serializable;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Audrey
 */
class Creneau implements Serializable {
    Jour jour;
    Periode periode;
    /**
     * Numérode l'objet à serialiser
     */
    private  static  final  long serialVersionUID =  1350092881346723535L;

    /**
     * Constructeur d'un créneau
     * @param jour
     * Le jour du créneau
     * @param periode 
     * La période du créneau qui sera soit le matin ou l'après-midi
     */
    Creneau(Jour jour, Periode periode) {
        this.jour = jour;
        this.periode = periode;
    }
    
    public Jour getJour(){
        return this.jour;
    }
    
    public void setJour(Jour j){
        this.jour = j;
    }
    
    public Periode getPeriode(){
        return this.periode;
    }
    
    public void setPeriode(Periode p){
        this.periode = p;
    }
    
    public boolean isOuvre(){
        return this.jour.isOuvre();
    }

    public void setOuvre(boolean b) {
        this.jour.setOuvre(b);
    }

    // Surcharge de la méthode equals
    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Creneau other = (Creneau) obj;
        if (!Objects.equals(this.jour, other.jour)) {
            return false;
        }
        if (this.periode != other.periode) {
            return false;
        }
        return true;
    }   
}