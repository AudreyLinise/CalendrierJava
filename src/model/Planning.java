package model;


import java.util.Date;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Audrey
 */
class Planning{
    
    // Map<Année,Planning>
    public static HashMap<Integer, Planning> planningList;
    // Map<Creneau,Sceance>
    protected static HashMap<Creneau, Sceance> sceanceList;

    static Planning load(String planning_2015_save) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Planning(int année) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    protected Object getNombreDeJour() {
        return sceanceList.size();
    }

    public void setOuvre(Date date, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Sceance get(Creneau creneau) {
        return sceanceList.get(creneau);
    }

    public void save(String planning_2015_save) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
