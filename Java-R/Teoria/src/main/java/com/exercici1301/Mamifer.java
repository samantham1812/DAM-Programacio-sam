package com.exercici1301;

public class Mamifer extends Animal {
    
    protected String tipusPelatge;

    public Mamifer(String nom, Integer edat, String tipusPelatge) {
        super(nom, edat);
        this.tipusPelatge = tipusPelatge;
    }
    
    public String getTipusPelatge() {
        return tipusPelatge;
    }

    public void setTipusPelatge(String tipusPelatge) {
        this.tipusPelatge = tipusPelatge;
    }

    @Override
    public String getInformacióAnimal(){
        return super.getInformacióAnimal() + ", Pelatge: " + tipusPelatge;
    }

}
