package com.exercici0200;

public class Estudiant {

    private String nom;
    private String id;

    private static int comptadorEstudiants=0;
    private static int capacidadmax = 0;

    static public int CAPACITAT_MAXIMA = 5;

    
    /* Constructor */
    public Estudiant(String nom, String id) {
        this.nom = nom;
        this.id = id;
    }

    /* Getters i Setters */
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /* Mètodes públics estàtics */
    public static int getComptadorEstudiants() {
        
        return -1;
    }

    public static boolean hiHaCapacitat() {
        return false;
    }
}
