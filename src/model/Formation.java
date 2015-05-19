/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author Audrey
 */
class Formation {
    String Nom;
    Integer Duree;
    List<Module> modules;
    
    public int duree(){
        int temp = 0;
        for (Module module: modules){
            temp += module.getNbHeure();
        }
        return temp;
    }
    
    
}
