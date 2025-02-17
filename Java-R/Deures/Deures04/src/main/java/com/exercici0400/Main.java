package com.exercici0400;

import java.util.ArrayList;
import java.util.HashMap;

import javax.print.attribute.standard.MediaPrintableArea;
import javax.swing.plaf.MenuItemUI;

import main.java.com.exercici0400.Component;
import main.java.com.exercici0400.Container;
import main.java.com.exercici0400.Menu;
import main.java.com.exercici0400.*;

public class Main {
    public static void main(String[] args) {
        /* 
        Text txt0 = new Text(1, 0, 3, 4, "0123456789AB", 3, false, "left");
        Text txt1 = new Text(7, 2 , 3, 5, "(*)( )(-)( )(*)", 3, false, "left");
        Text txt2 = new Text(22, 6 , 4, 3, "abcdefghijkl", 3, false, "left");
        */

        HashMap<Integer, MenuItem> mapMnu = new HashMap<>();
        //String[] arr0 = {"Sortit", "sortir", "exit"};
        mapMnu.put(0, new MenuItem("Sortir", new String[] {"sortir","exit"}));
        mapMnu.put(1, new MenuItem("Alinear esquerra", new String[] {"esquerra","left"}));
        mapMnu.put(2, new MenuItem("Alinear dreta", new String[] {"dreta","right"}));
        mapMnu.put(3, new MenuItem("Alineació centrada", new String[] {"centrat","center"}));

        //String[] arr1 = {"Alinear esquerra", "esquerra", "left"};
        // mapMnu.put(1, arr1);
        /*String[] arr2 = {"Alinear dreta", "dreta", "right"};
        mapMnu.put(2, arr2);
        String[] arr3 = {"Alinear centrado", "centrado", "center"};
        mapMnu.put(3, arr3);*/

        Menu mnu0 = new Menu(1,1,20,8, "Titol Menu", mapMnu,false);
        Menu mnu1 = new Menu(22,1,25,8, "Titol Menu", mapMnu,true);

        ArrayList<Component> components = new ArrayList<>();
        components.add(mapMnu);
        //components.add(mnu1);
        /*components.add(txt2);*/

        Container container = new Container(50, 10, components);
        container.draw();
    }
}