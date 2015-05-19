package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Audrey
 */
class Creneau {
    Jour jour;
    Periode periode;

    public Creneau(Jour jour) {
        this.jour = jour;
    }

    Creneau(Jour jour, Periode periode) {
        this.jour = jour;
        this.periode = periode;
    }
    
    public boolean isOuvre(){
        return this.jour.isOuvre();
    }
    
}
