package com.exercici1302;

public class Atraccio {
    
    private String nom;
    private String tipus;
    private Integer alturaMinima;

    public Atraccio(String nom, String tipus, Integer alturaMinima) {
        this.nom = nom;
        this.tipus = tipus;
        this.alturaMinima = alturaMinima;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }
    
    public Integer getAlturaMinima() {
        return alturaMinima;
    }

    public void setAltutraMinima(Integer altutraMinima) {
        this.alturaMinima = altutraMinima;
    }

    @Override
    public String toString() {
        return "Atraccio [nom=" + nom + ", tipus=" + tipus + ", alturaMinima=" + alturaMinima + "]";
    }

}