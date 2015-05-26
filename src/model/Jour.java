/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

/**
 *
 * @author Audrey
 */
class Jour implements Serializable{
    Date date;
    boolean ouvre;
   
    /**
     * Numéro de l'objet qui sera sérialisé
     */
    private  static  final  long serialVersionUID =  135009288134535L;
    /**
     * Constructeur d'un jour. On initialise le week-end à false
     * Le jour est ouvré si son  numéro de jour est égale à 1 (pour dimanche) et 7 (pour samedi)
     * @param date 
     * La date en paramètre sera mise comme non ouvré
     */
    Jour(Date date) {
        this.date = date;
        int jour_semaine =  this.getDayOfWeek();
        //définition du week-end à false
        // Dimmanche = 1 et Samedi = 7
        this.ouvre = jour_semaine != 1 && jour_semaine != 7;
    }

    boolean isOuvre() {
        return this.ouvre;
    }

    public void setOuvre(boolean b) {
        this.ouvre = b;
    }
    
    /**
     * Definit le week-end
     * @return 
     * Retourn le jour du week-end
     */
    public final int getDayOfWeek(){
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(this.date);
        return calendar.get(GregorianCalendar.DAY_OF_WEEK);
    }

    //Surcharge de la méthode equals
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.date);
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
        final Jour other = (Jour) obj;
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }
    
    
}
