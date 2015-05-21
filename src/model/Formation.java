/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Audrey
 */
class Formation {
    String nom;
    Integer duree;
    List<Module> modules;
    
    
    public Formation(String n, Integer d){
        this.nom = n;
        this.duree = d;
        this.modules = new ArrayList();
    }
    
    public void setNom(String n){
        this.nom = n;
    }
    
    public void setDuree(Integer d){
        this.duree = d;
    }
    
    public void setModules(List m){
        this.modules = m;
    }
    
    public String getNom(){
        return this.nom;
    }
    
    public Integer getDuree(){
        return this.duree;
    }
    
    public List<Module> getModules(){
        return this.modules;
    }
    
    public int duree(){
        int temp = 0;
        for (Module module: modules){
            temp += module.getNbHeure();
        }
        return temp;
    }
    
    
}
