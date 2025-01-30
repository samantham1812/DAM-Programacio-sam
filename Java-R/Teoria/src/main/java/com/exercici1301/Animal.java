package com.exercici1301;

public abstract class Animal {
    
    protected String nom; 
    protected Integer edat;

    public Animal(String nom, Integer edat) {
        this.nom = nom;
        this.edat = edat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getEdat() {
        return edat;
    }

    public void setEdat(Integer edat) {
        this.edat = edat;
    }

    public String getInformacióAnimal(){
        return "Nom: " + this.nom + ", Edad: " + this.edat;
    }

}