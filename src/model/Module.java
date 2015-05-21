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
    Integer nbHeure;
    Integer nbSeances;
    
    static void init() {}
    
    public Module(String n, String c, String a,Integer nb){
        this.nomModule = n;
        this.couleurModule = c;
        this.abbModule = a;
        this.nbSeances = nb;
    }
    
    public int getNbHeure(){
        return this.nbHeure;
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
    
    public Integer getNbSeances(){
        return this.nbSeances;
    }
    
}
