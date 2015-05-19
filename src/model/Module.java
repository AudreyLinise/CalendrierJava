/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;

/**
 *
 * @author Audrey
 */
class Module {
    public static HashMap<String, Module> moduleList;
    
    protected String nomModule;
    protected String couleurModule;
    protected String abbModule;
    
    Integer NbHeure;
    
    static void init() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getNbHeure(){
        return this.NbHeure;
    }

    public String getNomModule() {
        return this.nomModule;
    }

    public String getCouleurModule() {
        return this.couleurModule;
    }

    public String getAbbModule() {
        return this.abbModule;
    }
    
}
