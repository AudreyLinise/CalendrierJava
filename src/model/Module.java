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
    
    /**
     * Création d'une hashmap de module et l'unicité du nom permet d'être définit comme clé
     */
    public static HashMap<String, Module> moduleList;
    
    protected String nomModule;
    protected String couleurModule;
    protected String abbModule;
    Integer nbHeure;
    Integer nbSeances;
    
    static void init() {}
    
    /**
     * Constructeur du module qui prendra en paramètre le nom, la couleur, l'abréviation du nom et du nombre de modules
     * @param n
     * Nom du module
     * @param c
     * Couleur du module
     * @param a
     * Abréviation du nom du module
     * @param nb 
     * Nombre de seances du module
     */
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
    // TODO UNICITE
}
