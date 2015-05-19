package model;


import java.io.File;
import java.util.GregorianCalendar;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Audrey
 */
class PlanningTest{
    
    /**
     * Test : "Une fois l'année choisie, les jours sont créés automatiquement."
     */
    @Test
    public void initPlanningTest(){
       Planning planning = new Planning(2015);
       assertNotNull(planning);
       assertEquals(365,planning.getNombreDeJour());
    }
    
    /**
     * Test : "Prise en compte d-es années bisextiles."
     */
    @Test
    public void initBisextilesPlanningTest(){
        Planning planning = new Planning(2012);
        assertNotNull(planning);
        assertEquals(366,planning.getNombreDeJour());
    }
    
    /**
     * Test : "Pouvoir marquer comme non ouvré/ouvré des jours et des colonnes (samedi et dimanche).
     * Les jours non ouvrés ne pourront pas recevoir de cours."
     */
    @Test
    public void setJourOuvreeTest(){
        Planning planning = new Planning(2015);
        GregorianCalendar calendar = new GregorianCalendar(2015, 05, 17);
        Creneau creneau = new Creneau(new Jour(calendar.getTime()),Periode.MATINEE);
        planning.setOuvre(calendar.getTime(), false);
        // Check if planning exist
        assertNotNull(planning);
        // Check if there is a sceance
        assertNotNull(planning.get(creneau));
        // Check if the sceance have a creaneau
        assertNotNull(planning.get(creneau).getCreneau());
        // Check if the creneau is ouvre
        assertFalse(planning.get(creneau).getCreneau().isOuvre()); 
    }
    
    /**
     * Test : "Le planning peut être sauvé dans un fichier (stockage binaire)."
     */
    @Test
    public void savePlanningTest(){
        Planning planning = new Planning(2015);
        planning.save("Planning_2015_save");
        assertTrue(new File("Planning_2015_save").isFile());   
    }
    
    /**
     * Test : "Les jours non ouvrés sont récupérés quand on rouvre ce planning."
     */
    @Test
    public void loadPlanningTest(){
        Planning planning = new Planning(2015);
        GregorianCalendar calendar = new GregorianCalendar(2015, 05, 17);
        Creneau creneau = new Creneau(new Jour(calendar.getTime()),Periode.MATINEE);
        planning.setOuvre(calendar.getTime(), false);
        planning.save("Planning_2015_save");
        Planning planningLoaded = Planning.load("Planning_2015_save");
         // Check if planning exist
        assertNotNull(planningLoaded);
        // Check if there is a sceance
        assertNotNull(planningLoaded.get(creneau));
        // Check if the sceance have a creaneau
        assertNotNull(planningLoaded.get(creneau).getCreneau());
        // Check if the creneau is ouvre
        assertFalse(planningLoaded.get(creneau).getCreneau().isOuvre()); 
    }
    
    /**
     * Test : "Sauver le planning de l'année sauve ces données."
     */
    @Test
    public void saveDonneesPlanning(){
        Planning planning = new Planning(2015);
        GregorianCalendar calendar = new GregorianCalendar(2015, 05, 18);
        Creneau creneau = new Creneau(new Jour(calendar.getTime()),Periode.MATINEE);

        planning.save("Planning_2015_save");
        Planning planningLoaded = Planning.load("Planning_2015_save");
         // Check if planning exist
        assertNotNull(planningLoaded);
        // Check if there is a sceance
        assertNotNull(planningLoaded.get(creneau));
        // Check if the sceance have a creaneau
        assertNotNull(planningLoaded.get(creneau).getCreneau());
        // Check if the creneau is ouvre
        assertFalse(planningLoaded.get(creneau).getCreneau().isOuvre()); 
    }

}
