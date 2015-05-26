package model;


import execption.JourNonOvreExecption;
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

    /**
     * Constructeur d'une liste de planning
     * Il permet de créer les planning des formations 
     * @param annee
     * L'année du planning que l'utilisateur souhaite créer
     * @param formation 
     * Le choix de la formation pour la création du planning
     */
    public Planning(int annee, Formation formation) {
        this(annee);
        this.formation = formation;
    }
    
    /**
     * Constructeur 
     * Le planning débute le 1er Septembre de l'année choisie et va générer automatiquement 
     * le calendrier de l'année scolaire.
     * Initialisation de notre calendrier au premier Septembre.
     * Initialisation du dernier jour du calendrier 
     * Tant que la date courante n'a pas atteint le dernier jour du calendrier 
     *  on ajoute un nouveau créneau qui possède le jour créé et une periode
     * Quand le dernier jour est créé la boucle s'arrete
     * @param annee 
     * l'année prise en paramètre est choisie par l'utilisateur, elle dédermine l'année du début du calendrier
     * Exemple: pour l'année scolaire 2014/2015 l'utilisateur va devoir entrer 2014
     */
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
        
    /**
     * Verification si le jour est ouvré ou pas
     * @param date
     * La date en paramètre que l'on souhaite marquer comme ouvré ou pas
     * @param b 
     * Le bouléen permet de dire si le jour est ouvré en mettant true et false sinon 
     */
    public void setOuvre(Date date, boolean b) {
        Creneau creneauMatin = new Creneau(new Jour(date),Periode.MATINEE);
        Cours coursMatin = this.get(creneauMatin);
        coursMatin.getCreneau().setOuvre(b);
        Creneau creneauAprem = new Creneau(new Jour(date),Periode.APREM);
        Cours coursAprem = this.get(creneauAprem);
        coursAprem.getCreneau().setOuvre(b);
    }
    

    /**
     * Sauvegarde du planning
     * L'utilisateur met en parametre le nom du fichier afin de le saugarder
     * @param planning_save
     * Le parametre est le nom du fichier à sauvegarder
     * @throws FileNotFoundException
     * Execption pour si le fichier n'existe pas 
     * @throws IOException 
     */
    public void save(String planning_save)throws FileNotFoundException, IOException {
        String PATH_BIN = "C://tmp//"+planning_save+".dat";
    // Flux de communication
    FileOutputStream fos = new FileOutputStream(PATH_BIN);
    // Branché sur un flux de traitement
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(this);
    oos.close();
  }
    
    /**
     * Récupération du fichier qui aura été au préalable sauvegardé
     * @param planning_save
     * Le nom du fichier à charger
     * @return
     * Retourne le fichier mis en paramètre
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
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

    /**
     * Ajout d'un cours
     * @param cours
     * L'utilisateur entre le cours à ajouter au planning
     * @throws JourNonOvreExecption 
     * Excepetion si le jour est marqué comme non ouvré
     */
    public void addCours(Cours cours) throws JourNonOvreExecption {
        throw new JourNonOvreExecption();
    }
  }
 
