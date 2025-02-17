package com.exercicis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Exercici0201 {

    public static Scanner scanner;
    public static Locale defaultLocale;

    public static void main(String[] args) {
        
        scanner = new Scanner(System.in);
        defaultLocale = Locale.getDefault();
        Locale.setDefault(Locale.US);
        /*
        int[] arrEnters = generaArrayEnters(10);
        mostraArrayEstadistiques(arrEnters);

        ArrayList<Integer> lstEnters = generaLlistaEnters(10);
        mostraLlistaEstadistiques(lstEnters);

        filtraArrayParaulesAmbA();
        filtraLlistaParaulesAmbA();
        *//* 
        double[] arrDecimals = generaArrayDecimals(15);
        filtraArrayDecimalsSuperiors50(arrDecimals);*/
        /*
        ArrayList<Double> lstDecimals = generaLlistaDecimals(15);
        filtraLlistaDecimalsSuperiors50(lstDecimals);*/
        /* 
        HashMap<String, Integer> persones = new HashMap<>();
        persones.put("Anna", 25);
        persones.put("Joan", 30);
        persones.put("Marc", 20);
        mostrarLlistaOrdenadesPerEdat(persones);

        mostrarFrecuenciaParaules(); */
        invertirMapaClauValor();
        /*
        fusionarMapesSumantValors();
        ordenarMapaPerClaus();
        calcularEstadistiquesNotesEstudiants();
        */
        Locale.setDefault(defaultLocale);
        scanner.close();
    }

    /**
     * Genera un array d'enters aleatoris.
     *
     * @param mida la mida de l'array a generar
     * @return un array d'enters amb valors entre 0 i 99
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testGeneraArrayEnters
     */
    public static int[] generaArrayEnters(int mida) {
        int[] rst = new int[0];
        return rst;
    }

    /**
     * Calcula i mostra estadístiques d'un array d'enters.
     * 
     * Imprimeix per pantalla l'array, el valor màxim, el mínim i la mitjana.
     * Format d'output:
     * "Array: [valors]"
     * "Màxim: X  Mínim: Y  Mitjana: Z"
     *
     * @param array l'array d'enters sobre el qual calcular les estadístiques
     * @test ./runTest.sh com.exercicis.TestExercici0201#testMostraArrayEstadistiques
     */
    public static void mostraArrayEstadistiques(int[] array) {
    }

    /**
     * Genera una llista d'enters aleatoris.
     *
     * @param mida la mida de la llista a generar
     * @return una ArrayList d'enters amb valors entre 0 i 99
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testGeneraLlistaEnters
     */
    public static ArrayList<Integer> generaLlistaEnters(int mida) {
        ArrayList<Integer> rst = new ArrayList<>();
        return rst;
    }

    /**
     * Calcula i mostra estadístiques d'una llista d'enters.
     * 
     * Imprimeix per pantalla la llista, el valor màxim, el mínim i la mitjana.
     * Format d'output:
     * "Llista: [valors]"
     * "Màxim: X  Mínim: Y  Mitjana: Z"
     * 
     *
     * @param llista la llista d'enters sobre la qual calcular les estadístiques
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testMostraLlistaEstadistiques
     */
    public static void mostraLlistaEstadistiques(ArrayList<Integer> llista) {

    }

    /**
     * Demana a l'usuari que escrigui 5 paraules separades per ',' o ', ' 
     * i mostra aquelles que comencen amb 'a'.
     * 
     * Guarda la llista en un "String[] paraules"
     * 
     * Es mostra per pantalla:
     * "Escriu 5 paraules separades per ',' o ', ':" per sol·licitar les entrades,
     * i després "Paraules que comencen amb 'a':" seguit de les paraules filtrades.
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testFiltraArrayParaulesAmbA
     */
    public static void filtraArrayParaulesAmbA() {
        System.out.println("Escriu 5 paraules separades per ',' o ', ':");
        String words = scanner.nextLine();

        words = words.replace(", ", ",");
        String[] paraules = words.split(",");

        String filtrades = "";
        for (int cnt = 0; cnt < paraules.length; cnt++) {
            String paraula = paraules[cnt];
            if (paraula.toLowerCase().startsWith("a")){
                if (filtrades.length()<1){
                    filtrades = filtrades+paraula;
                }else{
                    filtrades = filtrades+", "+paraula;
                }
            }
        }
        System.out.println("Paraules que comencen amb 'a':" + filtrades);
    }
       
    /**
     * Demana a l'usuari que escrigui 5 paraules separades per ',' o ', ' 
     * i mostra aquelles que comencen amb 'a' en una sola línia separades per ", ".
     * 
     * Guarda la llista en un "ArrayList<String> paraules".
     * 
     * Es mostra per pantalla:
     * "Escriu 5 paraules separades per ',' o ', ':" per sol·licitar les entrades,
     * i després "Paraules que comencen amb 'a':" seguit de les paraules filtrades.
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testFiltraLlistaParaulesAmbA
     */
    public static void filtraLlistaParaulesAmbA() {
        System.out.print("Escriu 5 paraules separades per ',' o ', ':");
        String inipalabras = scanner.nextLine();

        inipalabras = inipalabras.replace(",", ", ");
        String cosas[] = split(",");
        ArrayList<String> paraules = new Array.asList(cosas);

        String filtro = "";
        for (int cnt = 0; cnt < paraules.size(); cnt = cnt + 1) {
            String paraula = paraules.get(cnt);
            if (paraula.toLowerCase().startsWith("a")) {
                if (filtro.size()<1){
                    filtro = filtro + paraula;
                } else {
                    filtro = filtro + ", " + paraula;
                }
            }
        }
        System.out.println("Paraules que comencen amb 'a' :" + filtro);

    }

    /**
     * Genera un array de decimals aleatoris.
     *
     * @param mida la mida de l'array a generar
     * @return un array de decimals amb valors entre 0.0 i 100.0
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testGeneraArrayDecimals
     */
    public static double[] generaArrayDecimals(int mida) {
        double[] array = new double[mida];
        Random num = new Random();
        for (int n = 0; n < mida; n = n + 1){
            array[n] = num.nextDouble() * 100;
        }
        return array;
    }

    /**
     * Genera una llista de decimals aleatoris.
     *
     * @param mida la mida de la llista a generar
     * @return una ArrayList de decimals amb valors entre 0.0 i 100.0
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testFiltraArrayDecimalsSuperiors50
     */
    public static ArrayList<Double> generaLlistaDecimals(int mida) {
        ArrayList<Double> rst = new ArrayList<>();
        for (int cnt = 0; cnt < mida; cnt++) {
            Random rd = new Random();
            rst.add(rd.nextDouble(100));
        }
        return rst;
    }

    /**
     * Filtra i mostra els decimals superiors a 50 d'un array.
     * 
     * Imprimeix per pantalla l'array original de decimals i, a continuació,
     * la llista dels decimals que són majors que 50.
     * Format d'output:
     * "Array original: [valors]"
     * "Valors majors que 50: [valors filtrats]"
     * 
     *
     * @param decimals l'array de decimals a filtrar
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testGeneraLlistaDecimals
     */
    public static void filtraArrayDecimalsSuperiors50(double[] decimals) {

        String array = "";
        String valors = "";

        for (int i = 0; i < decimals.length; i++) {
            array += String.format("%.2f, ", decimals[i]);
        }
        array = array.substring(0, array.length() - 2) + "]";

        for (int j = 0; j < decimals.length; j++) {
            if (decimals[j] > 50) {
                valors += String.format("%.2f, ", decimals[j]);
            }
        }

        valors = valors.substring(0, valors.length() - 2) + "]";

        System.out.println("Array original: [" + array);
        System.out.println("Valors majors que 50: [" +valors);
    }

    /**
     * Filtra i mostra els decimals superiors a 50 d'una llista.
     * 
     * Imprimeix per pantalla la llista original de decimals i, a continuació,
     * la llista dels decimals que són majors que 50.
     * Format d'output:
     * "Llista original: [valors]"
     * "Valors majors que 50: [valors filtrats]"
     *
     * @param decimals la llista de decimals a filtrar
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testFiltraLlistaDecimalsSuperiors50
     */
    public static void filtraLlistaDecimalsSuperiors50(ArrayList<Double> decimals) {
        String llista = "";
        String valors = "";

        for (int i = 0; i < decimals.size(); i++) {
            llista += String.format("%.2f, ", decimals.get(i));
        }
        llista = llista.substring(0, llista.length() - 2) + "]";

        for (int j = 0; j < decimals.size(); j++) {
            if (decimals.get(j) > 50) {
                valors += String.format("%.2f, ", decimals.get(j));
            }
        }
        valors = valors.substring(0, valors.length() - 2) + "]";

        System.out.println("Llista original: [" + llista);
        System.out.println("Valors majors que 50: [" + valors);
    }
    /**
     * Mostra per pantalla les persones ordenades per edat.
     * 
     * Recorre un HashMap de persones (nom i edat) i imprimeix cada persona en format "Nom (Edat)"
     * ordenat per edat de manera ascendent.
     *
     * @param persones un HashMap on la clau és el nom de la persona i el valor és la seva edat
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testMostrarLlistaOrdenadesPerEdat
     */
    public static void mostrarLlistaOrdenadesPerEdat(HashMap<String, Integer> persones) {
        Set<String> claus = persones.keySet();
        ArrayList<String> keys = new ArrayList<>(claus);
        keys.sort((name1, name2) -> {
            Integer a = persones.get(name1);
            Integer b = persones.get(name2);
            // String c = (String) name3.get("name");
            return a.compareTo(b);

            // for , string key = keys.get(for), print (key + "(" + personas.get(key) + ")")
            for (int i = 0; i < keys.size(); i = i + 1){
                String key = keys.get(i);
                System.out.println(key + "(" + personas.get(key) + ")");
            }
        });

    }

    /**
     * Demana a l'usuari que introdueixi una frase i mostra la freqüència de cada paraula.
     * 
     * L'usuari escriu una frase per la consola i el mètode separa les paraules usant els espais.
     * A continuació, es calcula la freqüència de cada paraula i es mostra per pantalla en format de HashMap.
     * 
     * 
     * Es mostra per pantalla:
     * "Introdueix una frase:" i després "Freqüència de paraules: {paraula=frequencia, ...}".
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testMostrarFrecuenciaParaules
     */
    public static void mostrarFrecuenciaParaules() {
        System.out.println("Introdueix una frase: ");
        String frase = scanner.nextLine();

        frase = frase.replace(",", "").replace(".", "");
        String[] paraules = frase.split(" ");
        HashMap<String, Integer> freq = new HashMap<>();
        for (String paraula : paraules) {
            if (freq.containsKey(paraula)) {
                freq.put(paraula, freq.get(paraula) + 1);
            } else {
                freq.put(paraula, 1);
            }
        }
        System.out.println("Freqüència de paraules: " + freq);
        
    }

    /**
     * Inverteix un HashMap intercanviant claus i valors.
     * 
     * Es crea un HashMap amb elements (A=1, B=2, C=3) i es construeix un nou HashMap on cada valor 
     * es converteix en clau i cada clau es converteix en valor.
     * 
     * 
     * Es mostra per pantalla:
     * "Mapa original: {A=1, B=2, C=3}" i "Mapa invertit: {1=A, 2=B, 3=C}".
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testInvertirMapaClauValor
     */
    public static void invertirMapaClauValor() {

        HashMap<String, Integer> ori = new HashMap<>();
        ori.put("A", 1);
        ori.put("B", 2);
        ori.put("C", 3);

        System.out.println("Mapa original: " + ori);

        HashMap<Integer, String> inverso = new HashMap<>();

        for (String pas : ori.keySet()) {
            inverso.put(ori.get(pas), pas);
        }

        System.out.println("Mapa invertit: " + inverso);

    } 

    /**
     * Fusiona dos HashMap sumant els valors de les claus comuns.
     * 
     * Es defineixen dos mapes:
     * <ul>
     *   <li>Mapa 1: {X=10, Y=20}</li>
     *   <li>Mapa 2: {Y=5, Z=15}</li>
     * </ul>
     * El mètode crea un nou HashMap on, per cada clau existent en ambdós mapes, es suma el valor.
     * 
     * 
     * Es mostra per pantalla:
     * "Mapa fusionat: {X=10, Y=25, Z=15}".
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testFusionarMapesSumantValors
     */
    public static void fusionarMapesSumantValors() {
        HashMap<String, Integer> mapa1 = new HashMap<>();
        mapa1.put("X", 10);
        mapa1.put("Y", 20);
        HashMap<String, Integer> mapa2 = new HashMap<>();
        mapa2.put("Y", 5);
        mapa2.put("Z", 15);
        
        HashMap<String, Integer> mapaFusionado = new HashMap<>(mapa1);
        
        for (String clau : mapa2.keySet()) {
            if (mapaFusionado.containsKey(clau)) {
                mapaFusionado.put(clau, mapaFusionado.get(clau) + mapa2.get(clau));
            } else {
                mapaFusionado.put(clau, mapa2.get(clau));
            }
        }
        System.out.println("Mapa fusionat: " + mapaFusionado);
    }
    /**
     * Ordena un HashMap per les clausi mostra el resultat.
     * 
     * Es crea un HashMap amb elements (Banana=3, Poma=5, Taronja=2) 
     * per obtenir un ordre natural de les claus (alfabètic).
     * 
     * 
     * Es mostra per pantalla:
     * "Mapa ordenat per claus: {Banana=3, Poma=5, Taronja=2}".
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testOrdenarMapaPerClaus
     */
    public static void ordenarMapaPerClaus() {
        HashMap<String, Integer> elements = new HashMap<>();
        elements.put("Banana", 3);
        elements.put("Poma", 5);
        elements.put("Taronja", 2);

        List<String> clavesOrdena = new ArrayList<>(elements.keySet());

    }

    /**
     * Calcula i mostra les estadístiques (mitjana, màxim i mínim) de les notes dels estudiants.
     * 
     * Es defineix un HashMap on la clau és el nom de l'estudiant i el valor la seva nota.
     * El mètode calcula la mitjana, la nota màxima i la nota mínima i les mostra per pantalla.
     * 
     * 
     * Es mostra per pantalla:
     * "Mitjana: [valor], Màxim: [valor], Mínim: [valor]".
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testCalcularEstadistiquesNotesEstudiants
     */
    public static void calcularEstadistiquesNotesEstudiants() {

    }
}
