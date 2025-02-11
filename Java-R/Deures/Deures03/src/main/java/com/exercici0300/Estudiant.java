package com.exercici0300;

public class Estudiant {

    private String nom;
    private String id;

    private static int comptadorEstudiants;
    private static int  CAPACITAT_MAXIMA = 5;
    
    // Constructor
    public Estudiant(String nom, String id) {
        if (comptadorEstudiants < CAPACITAT_MAXIMA){
        this.nom = nom;
        this.id = id;
        comptadorEstudiants = comptadorEstudiants + 1;
        } else {
            System.out.println("No se puede registrar, el curso que ha escogido ya no tiene plazas");
        }
    }

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

    // Mètodes públics estàtics
    public static int getComptadorEstudiants() {
        return comptadorEstudiants;
    }

    public static boolean hiHaCapacitat() {
        return comptadorEstudiants < CAPACITAT_MAXIMA;
    }
}
