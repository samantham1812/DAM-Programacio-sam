package com.exercici1302;

public class Botiga {
    
    private String nom;
    private String tipusProducte;
    
    public Botiga(String nom, String tipusProducte) {
        this.nom = nom;
        this.tipusProducte = tipusProducte;
    }

    public String getNom(){
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String gettipusProducte() {
        return tipusProducte;
    }

    public void settipusProducte(String tipusProducte) {
        this.tipusProducte = tipusProducte;
    }

    @Override
    public String toString() {
        return "Botiga[nom=" + nom + ", tipusProducte=" + tipusProducte + "]";
    }
}
