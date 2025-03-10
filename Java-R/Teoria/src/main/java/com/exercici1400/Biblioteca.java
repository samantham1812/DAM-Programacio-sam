package com.exercici1400;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Locale;

public class Biblioteca {

    public static void crearTaulaEditorials() {
        AppData db = AppData.getInstance();

        db.update("DROP TABLE IF EXISTS Editorials");

        String sql = """
            CREATE TABLE IF NOT EXISTS Editorials (
                id_editorial INTEGER PRIMARY KEY AUTOINCREMENT,
                nom TEXT NOT NULL
            );
        """;
       db.update(sql);
    }

    public static void crearTaulaLlibres() {
        AppData db = AppData.getInstance();
        db.update("DROP TABLE IF EXISTS Llibres");

        String sql = "CREATE TABLE IF NOT EXISTS Llibres (" +
            " id_llibre INTEGER PRIMARY KEY AUTOINCREMENT," +
            " titol TEXT NOT NULL," +
            " autor TEXT," +
            " any_publicacio INTEGER," +
            " id_editorial INTEGER," +
            " FOREIGN KEY(id_editorial) REFERENCES Editorials(id_editorial))";
        AppData.getInstance().update(sql);
    }

    public static void afegirEditorial(String nom) {
        AppData db = AppData.getInstance();
        String sql = String.format("INSERT INTO Editorials (nom) VALUES ('%s')", nom);
        db.update(sql);
    }

    public static void afegirLlibre(String titol, String autor, int anyPublicacio, int idEditorial) {
        AppData db = AppData.getInstance();
        String sql = String.format("INSERT INTO Llibres (titol, autor, any_publicacio, id_Editorial) VALUES ('%s', '%s', %d, %d);", titol, autor, anyPublicacio, idEditorial);
        db.update(sql);
    }

    public static void llistarTaulaEditorials() {
        AppData db = AppData.getInstance();
        
        List<HashMap<String, Object>> Editorials = db.query("SELECT * FROM Editorials;");

        for (HashMap<String,Object> editorial : Editorials) {
            System.out.println(editorial.get("id_editorial") + ". " + editorial.get("nom"));
        }
    }

    public static void llistarTaulaLlibres() {
        AppData db = AppData.getInstance();

        List<HashMap<String, Object>> Llibres = db.query("SELECT * FROM Llibres;");

        for (HashMap<String,Object> llibre : Llibres) {
            System.out.println(llibre.get("id_llibre") + ". " + llibre.get("titol") + " " +  llibre.get("autor") + ", " + llibre.get("any_publicacio") + ", " + llibre.get("id_editorial"));
        }
    }

    public static void llistarInfoLlibre(int idLlibre) {
        // TODO 
    }
}
