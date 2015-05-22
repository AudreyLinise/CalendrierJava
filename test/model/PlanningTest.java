package model;


import com.sun.istack.internal.logging.Logger;
import execption.JourNonOvreExecption;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.GregorianCalendar;
import org.junit.Assert;
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
public class PlanningTest{

    public PlanningTest() {
    }
    
    /**
     * Test : "Une fois l'année choisie, les jours sont créés automatiquement."
     */
    @Test
    public void initPlanningTest(){
       Planning planning = new Planning(2014);
       assertNotNull(planning);
       assertEquals(2*365L,(long) planning.getNombreDeJour());
    }
    
    /**
     * Test : "Prise en compte d-es années bisextiles."
     */
    @Test
    public void initBisextilesPlanningTest(){
        Planning planning = new Planning(2015);
        assertNotNull(planning);
        assertEquals(2*366L,(long) planning.getNombreDeJour());
    }
    
    /**
     * Test : "Pouvoir marquer comme non ouvré/ouvré des jours et des colonnes (samedi et dimanche).
     * Les jours non ouvrés ne pourront pas recevoir de cours."
     */
    @Test
    public void setJourOuvreeTest(){
        Planning planning = new Planning(2014);
        GregorianCalendar calendar = new GregorianCalendar(2015, 5, 17);
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
        try{
            planning.addCours(new Cours(creneau));
            Assert.fail();
        }catch(JourNonOvreExecption e){
            Logger.getLogger(PlanningTest.class).info("Insertion impossible pour une date non ouvré");
        }
    }
    
    /**
     * Test : "Le planning peut être sauvé dans un fichier (stockage binaire)."
     */
    @Test
    public void savePlanningTest() throws IOException{
        Planning planning = new Planning(2015);
        planning.save("planning_save_2015");
        assertTrue(new File("C://tmp//planning_save_2015.dat").isFile());  //isFile verifie si le fichier le fichier est de type file 
    }
    
    /**
     * Test : "Les jours non ouvrés sont récupérés quand on rouvre ce planning."
     */
    @Test
    public void loadPlanningTest() throws IOException, FileNotFoundException, ClassNotFoundException{
        Planning planning = new Planning(2014);
        GregorianCalendar calendar = new GregorianCalendar(2015, 05, 17);
        Creneau creneau = new Creneau(new Jour(calendar.getTime()),Periode.MATINEE);
        planning.setOuvre(calendar.getTime(), false);
        planning.save("planning_save1");
        Planning planningLoaded = Planning.load("planning_save1");
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
    public void saveDonneesPlanning() throws IOException, FileNotFoundException, ClassNotFoundException{
        Planning planning = new Planning(2014);
        GregorianCalendar calendar = new GregorianCalendar(2015, 05, 18);
        Creneau creneau = new Creneau(new Jour(calendar.getTime()),Periode.MATINEE);

        planning.save("planning_save_2");
        Planning planningLoaded = Planning.load("planning_save_2");
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
    public void saveDonneesEtPlanning() throws IOException, FileNotFoundException, ClassNotFoundException{
        Planning planning = new Planning(2014);
        GregorianCalendar calendar = new GregorianCalendar(2015, 05, 18);
        Creneau creneau = new Creneau(new Jour(calendar.getTime()),Periode.MATINEE);
        Module.init();
        
        planning.save("planning_save_3");
         Planning planningLoaded = Planning.load("planning_save_3");
         
        // On vérifie que le planning n'est pas vide et ainsi confirme que les données sont sauvegardées
        assertNotNull(planningLoaded);
        
    }
}
