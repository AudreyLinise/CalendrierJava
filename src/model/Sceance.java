/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Audrey
 */
class Sceance {
    Creneau creneau;
    Formation formation;

    public Sceance() {
        //TODO
    }

    public Sceance(Creneau creneau, Formation formation) {
        this.creneau = creneau;
        this.formation = formation;
    }

    public Creneau getCreneau() {
        return creneau;
    }

    public Formation getFormation() {
        return formation;
    }
    
}
