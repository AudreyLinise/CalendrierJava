package model;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
public class Planning implements Serializable{
    int annee;
    Formation formation;
    
    // Map<Année,Planning>
    public static HashMap<Integer, Planning> planningList = new HashMap<>();
    // Map<Creneau,Cours>
    protected HashMap<Creneau, Cours> seanceList;

    public Planning(int annee, Formation formation) {
        this(annee);
        this.formation = formation;
    }
    
    public Planning(int annee) {
        GregorianCalendar currentCalendar = new GregorianCalendar(annee,9,1);
        GregorianCalendar lastDay = new GregorianCalendar(annee+1,8,31);
        this.seanceList = new HashMap<>();
        
        while(!currentCalendar.equals(lastDay)){
            Date currentDate = currentCalendar.getTime();
            Jour currentDay = new Jour(currentDate);
            Creneau currentCreneau = new Creneau(currentDay, Periode.MATINEE);
            this.seanceList.put(currentCreneau,new Cours(currentCreneau));
            currentCreneau = new Creneau(currentDay, Periode.APREM);
            this.seanceList.put(currentCreneau,new Cours(currentCreneau));
            currentCalendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        
        Planning.planningList.put(annee, this);
    }
    
    protected Integer getNombreDeJour() {
        return seanceList.size();
    }
    
        public Cours get(Creneau creneau) {
        return seanceList.get(creneau);
    }

    public void setOuvre(Date date, boolean b) {
        Creneau creneauMatin = new Creneau(new Jour(date),Periode.MATINEE);
        Cours coursMatin = this.get(creneauMatin);
        coursMatin.getCreneau().setOuvre(b);
        Creneau creneauAprem = new Creneau(new Jour(date),Periode.APREM);
        Cours coursAprem = this.get(creneauAprem);
        coursAprem.getCreneau().setOuvre(b);
    }
    

    public void save(String planning_save)throws FileNotFoundException, IOException {
        String PATH_BIN = "C://tmp//"+planning_save+".dat";
    // Flux de communication
    FileOutputStream fos = new FileOutputStream(PATH_BIN);
    // Branché sur un flux de traitement
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(planningList);
    oos.close();
  }
    
    public static Planning load(String planning_save) throws FileNotFoundException, IOException, ClassNotFoundException {
    
        String PATH_BIN = "C://tmp//"+planning_save+".dat";
    Planning instance;
    // Flux de communication
    FileInputStream fichier = new FileInputStream(PATH_BIN);
    // Branche sur un flux de traitement
    ObjectInputStream ois = new ObjectInputStream(fichier);
    instance = (Planning) ois.readObject();
    ois.close();
    return instance;
    }
  }
 
