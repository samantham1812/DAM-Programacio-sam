package com.exercicis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Exercici0000 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(addImaginaries("1+2i", "4+5i"));

        int[][] entrada = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
        transpose.matrix(entrada);

        scanner.close();
    }

    /**
     * Fes una funció que sumi números inmaginaris 
     * definits per una cadena de text
     * 
     *  "1+2i" + "4+5i" = "5+7i"
     * 
     * @param String el primer número imaginari
     * @param String el segon número imaginari
     * @return String el resultat de la suma
     */
    private static String addImaginaries(String num0, String num1) {
        return "";
    }

    /**
     * Fes un programa que dibuixi el triangle de pascal
     * 
     * @param int nivells del triangle (0 fins a n)
     */
    private static void drawPascal(int n) {
        ArrayList<ArrayList<Integer>> pascal = new ArrayList<>();
            pascal.add(new ArrayList<>(List.of(1)));


       /* Hacer listas y luego  ir ñadiendo + 1 para formar la torre  */
    }

    /**
     * Fes una funció que sumi els valors d'un ArrayList<double>
     * 
     * @param llista de valors
     * @return resultat de la suma
     */
    private static double addList(ArrayList<Double> list) {
       Double suma = 0.0;
        
       for (int i = 0; i < list.size(); i++){
            suma = suma + list.get(i);
       }
        return suma;
    }

    /** 
     * Fes una funció que dibuixi els valors d'una matriu
     * int[][] entrada = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
     * 
     * @param int[][] matriu a dibuixar
     */
    public static void printMatrix(int[][] matrix) {
    }

    /**
     * Fes una funció que retorni la trasposada d'una matriu
     * 
     * int[][] entrada = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
     * int[][] sortida = { {1, 4, 7}, {2, 5, 8}, {3, 6, 9} };
     * 
     * int[][] entrada = { 
     *      {1,  2,  3,  4,  5}, 
     *      {6,  7,  8,  9, 10}, 
     *      {11, 12, 13, 14, 15}, 
     *      {16, 17, 18, 19, 20} };
     * 
     * int[][] sortida = { 
     *     {1, 6, 11, 16},
     *     {2, 7, 12, 17},
     *     {3, 8, 13, 18},
     *     {4, 9, 14, 19},
     *     {5, 10, 15, 20}
     * };
     * 
     * @param int[][] matriu a transposar
     * @return int[][] matriu transposada
     */
    /*public static int[][] transpose(int[][] matrix) {
        int fils = matrix.length;
        int cols = matrix[0].length;
        int[][] transposedMatrix = new int[cols][fils];

        for (int i = 0; i < fils; i++) {
            for (int j = 0; j < cols; j++) {
            transposedMatrix[j][i] = matrix[i][j];
            }
        }

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < fils; j++) {
            System.out.print(transposedMatrix[i][j]);
            if (j != (fils - 1)) {
                System.out.print(",");
            }
            }
            System.out.println();
        }
    }*/

    /**
     * Fes una funció que troba el primer caràcter que
     * no es repeteix dins d'una cadena de text
     * 
     * Exemple:
     * 
     * Entrada: "swiss"
     * Sortida: 'w'
     * 
     * Entrada: "redivider"
     * Sortida: 'v'
     * 
     * Pseudocodi de l'algorisme:
     * 
     * 1. Inicialitzar una taula de freqüències (mapa) per comptar les ocurrències de cada caràcter.
     * 2. Iterar sobre cada caràcter de la cadena de text:
     *    a. Si el caràcter ja existeix en la taula de freqüències, incrementar el seu compte.
     *    b. Si el caràcter no existeix, afegir-lo a la taula amb un compte de 1.
     * 3. Iterar de nou sobre cada caràcter de la cadena de text en l'ordre original:
     *    a. Comprovar el compte del caràcter en la taula de freqüències.
     *    b. Si el compte és igual a 1, retornar aquest caràcter com el primer que no es repeteix.
     * 4. Si cap caràcter compleix la condició, retornar un valor que indiqui que no n'hi ha cap (per exemple, '_' o llançar una excepció).
     * 
     * @param String cadena de text
     * @return char primer caràcter que no es repeteix
     */
    public static char firstNonRepeated(String str) {
        for (char i = 0; i < car.length; i++){
            if (car ){
                car =+ 1;
            }
        }

        return '_';
    }

    /**
     * Fes una funció que inverteixi els caràcters
     * d'un número enter: 3645 > 5463
     * 
     * @param int número a invertir
     * @return int número resultant
     */
    public static int inverInt(int num) {
        String Numero = "";
        String numString = Integer.toString(num);
        for (int n = numString.length()-1; n >= 0; n--){
            Numero = Numero + numString.substring(n, n+1);
        }
        int nombre = Integer.parseInt(Numero);
        return nombre;
    }

    /**
     * Fes una funció que rebi una llista (`ArrayList`) amb 5 números
     * i calculi el número més petit i el número més gran
     * que es poden calcular sumant 4 dels 5 números rebuts.
     * 
     * Exemple:
     * 
     * Entrada: [3, 6, 1, 5, 0]
     * Sortida: [9, 15]
     * 
     * Explicació:
     *  9  = 0 + 1 + 3 + 5 (sumant els quatre números més petits)
     *  15 = 1 + 3 + 5 + 6 (sumant els quatre números més grans)
     * 
     * @param ArrayList<Integer> nums Llista de números d'entrada (exactament 5 números)
     * @return ArrayList<Integer> Llista amb els dos números de sortida [mínim, màxim]
     */
    public ArrayList<Integer> minMaxAdd(ArrayList<Integer> nums) {
        ArrayList<Integer> entrada = new ArrayList<>();

        ArrayList.sort(entrada);

        for (int n = 0; n < entrada.size(); n++){ }
        
        return new ArrayList<>(Arrays.asList(0, 0));
    }

    /**
     * Fes una funció que sumi dos números sense fer servir 
     * la operació de suma.
     * 
     * Exemple:
     * 
     * Entrada: 5, 7
     * Sortida: 12
     * 
     * Entrada: -3, 3
     * Sortida: 0
     * 
     * @param int a Primer número a sumar
     * @param int b Segon número a sumar
     * @return int Resultat de la suma de a i b sense utilitzar l'operació de suma
     */
    public int sumaSenseSumar(int a, int b) {
        String numa = numa.repeat(numa);
        String numb = numb.repeat(numb);

        String numstr = Integer.toString(a,b);
        String concat = concat(numa, numb);



        return 0;
    }

/**
     * Fes una funció que retorni les distàncies mínimes
     * de cada lletra fins a un caràcter d'una cadena de text.
     * 
     * Exemple:
     * 
     * Entrada: "algoritmo", 'o'
     * Sortida: [3, 2, 1, 0, 1, 2, 2, 1, 0]
     * 
     * Entrada: "abcdefga", 'a'
     * Sortida: [0, 1, 2, 3, 3, 2, 1, 0]
     * 
     * Pseudocodi de l'algorisme:
     * 
     * 1. Crear una llista per emmagatzemar les distàncies mínimes.
     * 2. Iterar de l'esquerra a la dreta:
     *    a. Mantenir l'índex de l'última aparició del caràcter objectiu.
     *    b. Calcular la distància actual com la diferència entre l'índex actual i l'última aparició.
     *    c. Emmagatzemar la distància calculada en la llista.
     * 3. Iterar de la dreta a l'esquerra:
     *    a. Mantenir l'índex de la pròxima aparició del caràcter objectiu.
     *    b. Calcular la distància actual com la diferència entre l'índex actual i la pròxima aparició.
     *    c. Actualitzar la distància en la llista si la nova distància és menor que la actual.
     * 4. Retornar la llista de distàncies mínimes.
     * 
     * @param String text Cadena de text d'entrada
     * @param char target Caràcter objectiu
     * @return ArrayList<Integer> Llista de distàncies mínimes de cada lletra fins al caràcter objectiu
     */
    public ArrayList<Integer> minDistances(String text, char target) {
        ArrayList<Integer> distances = new ArrayList<>(text.length());

        for (int i = 0; i < distances.size(); i++){

        }
        return distances;
    }

    /**
     * A partir d'una llista de números on cada 
     * número es repeteix dos cops excepte un, troba
     * el número que no es repeteix.
     * 
     * Exemple:
     * 
     * Entrada: [2.0, 2.0, 1.0]
     * Sortida: 1.0
     * 
     * Entrada: [4.0, 1.0, 2.0, 1.0, 2.0]
     * Sortida: 4.0
     * 
     * Pseudocodi de l'algorisme:
     * 
     * 1. Crear un mapa (HashMap) per emmagatzemar les freqüències de cada número.
     * 2. Iterar sobre cada número en la llista:
     *    a. Si el número ja existeix al mapa, incrementar el seu compte.
     *    b. Si el número no existeix, afegir-lo al mapa amb un compte de 1.
     * 3. Iterar sobre les entrades del mapa:
     *    a. Si una entrada té un compte de 1, retornar aquest número com el que no es repeteix.
     * 4. Si cap número compleix la condició, retornar un valor indicatiu (per exemple, null o llançar una excepció).
     * 
     * @param ArrayList<Double> nums Llista de números d'entrada
     * @return Double Número que no es repeteix
     */
    public Double findUniqueNumber(ArrayList<Double> nums) {
        return null; // Implementació de la funció
    }

}
