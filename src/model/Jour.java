/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Audrey
 */
class Jour {
    Date date;
    boolean ouvre;

    Jour(Date date) {
        this.date = date;
        //TODO définir week-end à false
        this.ouvre = true;
    }

    boolean isOuvre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
