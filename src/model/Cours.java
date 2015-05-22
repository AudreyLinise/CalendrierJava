/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Audrey
 */
class Cours implements Serializable {
    Creneau creneau;
    Seance seance;
    private  static  final  long serialVersionUID =  132539288134535L;

    public Cours(Creneau creneau) {
        this.creneau = creneau;
    }

    public Creneau getCreneau() {
        return creneau;
    }

    public void setCreneau(Creneau creneau) {
        this.creneau = creneau;
    }

    public Seance getSeance() {
        return seance;
    }

    public void setSeance(Seance seance) {
        this.seance = seance;
    }
    
}
