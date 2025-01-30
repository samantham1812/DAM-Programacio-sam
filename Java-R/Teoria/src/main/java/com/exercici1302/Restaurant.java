package com.exercici1302;

public class Restaurant {
    
    private String nom;
    private String tipusCuina;
    private Integer capacitat;

    public Restaurant(String nom, String tipusCuina, Integer capacitat) {
        this.nom = nom;
        this.tipusCuina = tipusCuina;
        this.capacitat = capacitat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String gettipusCuina() {
        return tipusCuina;
    }

    public void settipusCuina(String tipusCuina){
        this.tipusCuina = tipusCuina;
    }

    public Integer getcapacitat(){
        return capacitat;
    }

    public void setcapacitat(Integer capacitat) {
        this.capacitat = capacitat;
    }

    @Override
    public String toString() {
        return "Restaurant [nom=" + nom + ", tipusCuina=" + tipusCuina + ", capacitat=" + capacitat + "]";
    }
    
}
