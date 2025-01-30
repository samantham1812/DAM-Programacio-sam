package com.exercici1301;

class Dofi extends Mamifer implements Nedador {

    /*private String nom;*/

    public Dofi(String nom, Integer edat, String tipusPelatge) {
        super(nom, edat, tipusPelatge);
       // this.nom = nom;*/
    }

    @Override
    public void nedar(){
        System.out.println(getInformacióAnimal() + " " + "està nedant!");
    }
}
