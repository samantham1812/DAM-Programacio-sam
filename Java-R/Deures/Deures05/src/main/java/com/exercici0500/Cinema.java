package com.exercici0500;

import java.util.ArrayList;
import java.util.HashMap;
import java.sql.*;

public class Cinema {

    /**
     * Crea la taula "directors", si ja existeix primer l'esborra
     */
    public static void crearTaulaDirectors() {
        AppData db = AppData.getInstance();
        db.update("DROP TABLE IF EXISTS directors");
        String sql = """
            CREATE TABLE IF NOT EXISTS directors (
                id_director INTEGER PRIMARY KEY AUTOINCREMENT,
                nom TEXT,
                nacionalitat TEXT
            );
        """;
        db.update(sql);
    }

    public static void crearTaulaPelis() {
        AppData db = AppData.getInstance();
        db.update("DROP TABLE IF EXISTS pelis");
        String sql = """
            CREATE TABLE IF NOT EXISTS pelis (
                id_peli INTEGER PRIMARY KEY AUTOINCREMENT,
                titol TEXT,
                any_estrena INTEGER,
                durada INTEGER,
                id_director INTEGER,
                FOREIGN KEY(id_director) REFERENCES directors(id_director))
            );
        """;
        db.update(sql);
    }

    public static void crearTaulaSales() {
        AppData db = AppData.getInstance();
        db.update("DROP TABLE IF EXISTS sales");
        String sql = """
            CREATE TABLE IF NOT EXISTS sales (
                id_sala INTEGER PRIMARY KEY AUTOINCREMENT,
                nom_sala TEXT,
                capacitat INTEGER,
                id_peli INTEGER,
                FOREIGN KEY(id_peli) REFERENCES pelis(id_peli))
            );
        """;
        db.update(sql);
    }

    /**
     * Afegeix un nou director
     * @param nomDirector
     * @param nacionalitat
     * @return l'identificador del director afegit
     */
    public static int afegirDirector(String nomDirector, String nacionalitat) {
        return 0;
    }

    public static int afegirPeli(String titol, int any, int duracio, int idDirector) {
        return 0;
    }

    public static int afegirSala(String nomSala, int capacitat, int idPeli) {
        return 0;
    }

    /**
     * Mostra una taula amb informació dels directors:
     * ┌────────────┬──────────────┐
     * │ Nom        │ Nacionalitat │
     * ├────────────┼──────────────┤
     * │ Director A │ País X       │
     * │ Director B │ País Y       │
     * └────────────┴──────────────┘
     */
    public static void llistarTaulaDirectors() {
    }

    public static void llistarTaulaPelis() {
    }

    public static void llistarTaulaSales() {
    }

    /**
     * Mostra una fitxa amb informació de les pelis:
     * 
     * ┌─────────────────────────┐
     * │ Film A                  │
     * ├──────────┬──────────────┤
     * │ Id       │ 1            │
     * │ Direcció │ Director A   │
     * │ Any      │ 2020         │
     * │ Duració  │ 120 minuts   │
     * └──────────┴──────────────┘
     */
    public static void llistarInfoPeli(int idLlibre) {
    }

    /**
     * Guarda la informacio de les películes en un arxiu ".json"
     */
    public static void pelisToJSON(String path) {
    }
}
