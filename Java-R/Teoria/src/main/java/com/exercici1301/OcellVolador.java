package com.exercici1301;

class OcellVolador extends Ocell implements Volador {

   /* private String nom;*/

    public OcellVolador(String nom, Integer edat, String colorPlotmage) {
        super(nom, edat, colorPlotmage);
    }
    
    @Override
    public void volar(){
        System.out.println(getInformacióAnimal() + " " + "està volant!");
    }

}
