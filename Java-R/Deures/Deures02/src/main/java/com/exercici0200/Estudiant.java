package com.exercici0200;

public class Estudiant {

    private String nom;
    private String id;
    
    // Constructor
    public Estudiant(String nom, String id) {
        this.nom = nom;
        this.id = id;
    }

    // Mètodes públics estàtics
    public static int getComptadorEstudiants() {
        return -1;
    }

    public static boolean hiHaCapacitat() {
        return false;
    }
}
