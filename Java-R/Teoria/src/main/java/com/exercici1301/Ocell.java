package com.exercici1301;

public class Ocell extends Animal {
    
    protected String colorPlomatge;

    public Ocell(String nom, Integer edat, String colorPlomatge) {
        super(nom, edat);
        this.colorPlomatge = colorPlomatge;
    }

    public String getColorPlomatge() {
        return colorPlomatge;
    }

    public void setColorPlomatge(String colorPlomatge) {
        this.colorPlomatge = colorPlomatge;
    }
    
    @Override 
    public String getInformacióAnimal(){
        return super.getInformacióAnimal() + ", Color plumatge: " + colorPlomatge;
    }


}
