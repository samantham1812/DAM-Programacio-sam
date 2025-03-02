package com.exercicis;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import javax.management.ObjectName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

public class Exercici0202 {

    public static Scanner scanner;
    public static Locale defaultLocale;
    
    // ./run.sh com.exercicis.Exercici0202
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        defaultLocale = Locale.getDefault();
        Locale.setDefault(Locale.US);

        // showJSONAstronautes("./data/astronautes.json");

        // showEsportistesOrdenatsPerMedalla("./data/esportistes.json", "or");
        // showEsportistesOrdenatsPerMedalla("./data/esportistes.json", "plata");

        mostrarPlanetesOrdenats("./data/planetes.json", "nom");
        mostrarPlanetesOrdenats("./data/planetes.json", "radi");
        mostrarPlanetesOrdenats("./data/planetes.json", "massa");
        mostrarPlanetesOrdenats("./data/planetes.json", "distància");

        /* 
        ArrayList<HashMap<String, Object>> dades = new ArrayList<>();

        ArrayList<String> caracteristiquesPacific = new ArrayList<>();
        caracteristiquesPacific.add("És l'oceà més gran del món");
        caracteristiquesPacific.add("Conté la fossa de les Marianes, la més profunda del món");
        caracteristiquesPacific.add("Conté una illa de plàstics contaminants.");

        ArrayList<String> caracteristiquesAtlantic = new ArrayList<>();
        caracteristiquesAtlantic.add("Separa Amèrica d'Europa i Àfrica");
        caracteristiquesAtlantic.add("Conté el famós Triangle de les Bermudes");

        ArrayList<String> caracteristiquesMediterrani = new ArrayList<>();
        caracteristiquesMediterrani.add("És un mar gairebé tancat");
        caracteristiquesMediterrani.add("Connecta amb l'oceà Atlàntic a través de l'estret de Gibraltar");

        dades.add(crearMassaAigua("Oceà Pacífic", "oceà", 168723000, 10924, caracteristiquesPacific));
        dades.add(crearMassaAigua("Oceà Atlàntic", "oceà", 85133000, 8486, caracteristiquesAtlantic));
        dades.add(crearMassaAigua("Oceà Índic", "oceà", 70560000, 7450, new ArrayList<>()));
        dades.add(crearMassaAigua("Oceà Àrtic", "oceà", 15558000, 5450, new ArrayList<>()));
        dades.add(crearMassaAigua("Mar Mediterrani", "mar", 2500000, 5121, caracteristiquesMediterrani));
        dades.add(crearMassaAigua("Mar Carib", "mar", 2754000, 7686, new ArrayList<>()));
        dades.add(crearMassaAigua("Mar de la Xina Meridional", "mar", 3500000, 5560, new ArrayList<>()));

        try {
            generarJSON(dades, "./data/aigua.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        */
        Locale.setDefault(defaultLocale);
        scanner.close();
    }

    /**
     * Llegeix l'arxiu de 'filePath' i mostra per consola les dades dels astronautes.
     * 
     * El format és:
     * > Astronauta 0:
     *   Nom: Yuri Gagarin
     *   Naixement: 1934
     * > Astronauta 1:
     *   Nom: Neil Armstrong
     *   Naixement: 1930
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0202#testShowJSONAstronautes
     */
    public static void showJSONAstronautes(String filePath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject jSONObject = new JSONObject(content); 
            JSONArray datos = jSONObject.getJSONArray("astronautes"); 
            
            for (int i = 0; i < datos.length(); i++) {
                JSONObject astronauta = datos.getJSONObject(i);
                System.out.println("> Astronauta " + i + ":");
                System.out.println("  Nom: " + astronauta.getString("nom"));
                System.out.println("  Naixement: " + astronauta.getInt("any_naixement"));
            }       
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Llegeix l'arxiu de 'filePath', retorna un ArrayList amb les dades dels astronautes
     * Les dades han d'estar en un HashMap amb les claus "nom" i "any_naixement"
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0202#testJSONAstronautesToArrayList
     */
    public static ArrayList<HashMap<String, Object>> JSONAstronautesToArrayList(String filePath) {
        ArrayList<HashMap<String, Object>> rst = new ArrayList<>();

        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject jSONObject = new JSONObject(content); //Passar a objecte
            JSONArray jSONArray = jSONObject.getJSONArray("astronautes"); //Passar a array

            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject astronauta = jSONArray.getJSONObject(i);
                HashMap<String, Object> astronautaHM = new HashMap<>(); 
                astronautaHM.put("nom", astronauta.getString("nom"));
                astronautaHM.put("any_naixement", astronauta.getInt("any_naixement"));
                rst.add(astronautaHM);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rst;
    }
    

    /**
     * Llegeix l'arxiu de 'filePath', retorna un ArrayList amb les dades dels esportistes
     * Les dades han d'estar en un HashMap amb: nom, any_naixement, pais i medalles
     * Les medalles de la clau 'medalles' han d'estar en un HashMap amb les claus "or", "plata" i "bronze"
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0202#JSONEsportistesToArrayList
     */
    public static ArrayList<HashMap<String, Object>> JSONEsportistesToArrayList(String filePath) {
        ArrayList<HashMap<String, Object>> rst = new ArrayList<>();

        try{
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONArray jSONArray = new JSONArray(content);

            for (int i = 0; i < jSONArray.length();i = i + 1){
                JSONObject datos = jSONArray.getJSONObject(i);
                HashMap<String,Object> esportistes = new HashMap<>();
                esportistes.put("nom", datos.getString("nom"));
                esportistes.put("naixement", datos.getInt("any_naixement"));
                esportistes.put("pais", datos.getString("pais"));

                JSONObject jsonmedallas = datos.getJSONObject("medalles_olimpiques");
                HashMap<String, Object> medalles = new HashMap<>();
                medalles.put("or", jsonmedallas.getInt("or"));
                medalles.put("plata", jsonmedallas.getInt("plata"));
                medalles.put("bronze", jsonmedallas.getInt("bronze"));

                esportistes.put("medallas", medalles);

                rst.add(esportistes);
            }   

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rst;
    }

    /**
     * Llegeix l'arxiu JSON i retorna una llista d'esportistes ordenada per una medalla específica (or, plata o bronze).
     *
     * Si el tipus no és "or", "plata" o "bronze" llança una excepció IllegalArgumentException. Amb el text:
     * "Tipus de medalla invàlid: {tipusMedalla}. Tipus vàlids: 'or', 'plata' o 'bronze'."
     * 
     * @param filePath Ruta de l'arxiu JSON amb les dades dels esportistes.
     * @param tipusMedalla Tipus de medalla per ordenar: "or", "plata" o "bronze".
     * @return Llista ordenada d'esportistes segons el nombre de medalles especificat.
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0202#testOrdenarEsportistesPerMedalla
     */
    public static ArrayList<HashMap<String, Object>> ordenarEsportistesPerMedalla(String filePath, String tipusMedalla) {
        // Obtenir la llista d'esportistes des del fitxer JSON
        ArrayList<HashMap<String, Object>> esportistes = JSONEsportistesToArrayList(filePath);

        if (!tipusMedalla.equals("or") && !tipusMedalla.equals("plata") && !tipusMedalla.equals("bronze")){
            throw new IllegalArgumentException("Tipus de medalla invàlid" + tipusMedalla + ". Tipus válids: 'or', 'plata', 'bronze'.");
        }
        // Ordenar por medalla especifica
        esportistes.sort((esportista0 ,esportista1) -> {
            HashMap<?, ?> medallas1 = (HashMap<?, ?>) esportista0.get("medalles");
            HashMap<?, ?> medallas2 = (HashMap<?, ?>) esportista1.get("medalles");
            
            Integer a = (Integer) medallas1.get(tipusMedalla);
            Integer b = (Integer) medallas2.get(tipusMedalla);

            // Ordenar en ordre descendent
            return b.compareTo(a);
        });
        return esportistes;
    }

    /**
     * Mostra una taula amb els esportistes ordenats per una medalla específica (or, plata o bronze).
     *
     * Les paraules "or", "plata" i "bronze" han de ser mostrades amb la 
     * primera lletra en majúscules i la resta en minúscules.
     * 
     * El format de la taula ha de fer servir els caràcters: "┌", "┬", "┐", "├", "┼", "┤", "└", "┴" i "┘".
     * 
     * Un exemple simplificat de la taula seria:
     * ┌──────────────────────┬─────────────────┬────────────┬────────┐
     * │ Nom                  │ País            │ Naixement  │ Plata  │
     * ├──────────────────────┼─────────────────┼────────────┼────────┤
     * │ Larisa Latynina      │ Unió Soviètica  │ 1934       │ 5      │
     * │ Michael Phelps       │ Estats Units    │ 1985       │ 3      │
     * └──────────────────────┴─────────────────┴────────────┴────────┘
     * 
     * @param filePath Ruta de l'arxiu JSON amb les dades dels esportistes.
     * @param tipusMedalla Tipus de medalla per ordenar: "or", "plata" o "bronze".
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0202#testShowEsportistesOrdenatsPerOr
     * @test ./runTest.sh com.exercicis.TestExercici0202#testShowEsportistesOrdenatsPerPlata
     * @test ./runTest.sh com.exercicis.TestExercici0202#testShowEsportistesOrdenatsPerBronze
     */
    public static void showEsportistesOrdenatsPerMedalla(String filePath, String tipusMedalla) {
        ArrayList<HashMap<String, Object>> esportistas = ordenarEsportistesPerMedalla(filePath, tipusMedalla); 

        String fijo = tipusMedalla.substring(0,1).toUpperCase() + tipusMedalla.substring(1).toLowerCase();

        System.out.println("┌──────────────────────┬─────────────────┬────────────┬────────┐");
        System.out.printf("| %-20s | %-15s | %-10s | %-6s |\n","Nom", "Pais","Naixement",fijo);
        System.out.println("├──────────────────────┼─────────────────┼────────────┼────────┤");

        for (HashMap<String,Object> esportista : esportistas) {
            String nom = (String) esportista.get("nom");
            String pais = (String) esportista.get("pais");
            int any_naixement = (Integer) esportista.get("any_naixement");

            HashMap<String, Integer> medallas = (HashMap<String, Integer>) esportista.get("medalles");
            int numMedalles = medallas.get(tipusMedalla);
            
            System.out.printf("| %-20s | %-15s | %-10d | %-6d |\n", nom, pais, any_naixement, numMedalles);
        }

        System.out.println("└──────────────────────┴─────────────────┴────────────┴────────┘");
    }

    /**
     * Llegeix l'arxiu JSON i converteix la informació dels planetes en una llista d'objectes HashMap.
     * 
     * Cada planeta es representa com un HashMap amb les claus:
     * - "nom" -> String amb el nom del planeta.
     * - "dades_fisiques" -> HashMap amb:
     *     - "radi_km" -> Double amb el radi en quilòmetres.
     *     - "massa_kg" -> Double amb la massa en kilograms.
     * - "orbita" -> HashMap amb:
     *     - "distancia_mitjana_km" -> Double amb la distància mitjana al Sol en quilòmetres.
     *     - "periode_orbital_dies" -> Double amb el període orbital en dies.
     * 
     * @param filePath Ruta de l'arxiu JSON amb les dades dels planetes.
     * @return Una ArrayList de HashMap amb la informació dels planetes.
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0202#testJSONPlanetesToArrayList
     */
    public static ArrayList<HashMap<String, Object>> JSONPlanetesToArrayList(String filePath) {
        ArrayList<HashMap<String, Object>> planetesList = new ArrayList<>();
        try {
            String contenido = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject jsonObject = new JSONObject(contenido);
            JSONArray planetes = jsonObject.getJSONArray("planetes");

            for (int i = 0; i < planetes.length(); i++) {
                JSONObject planeta = planetes.getJSONObject(i);
                HashMap<String, Object> mapPlaneta = new HashMap<>();
                mapPlaneta.put("nom", planeta.getString("nom"));

                // Dades físiques
                JSONObject dadesFisiques = planeta.getJSONObject("dades_fisiques");
                HashMap<String, Double> mapDadesFisiques = new HashMap<>();
                mapDadesFisiques.put("radi_km", dadesFisiques.getDouble("radi_km"));
                mapDadesFisiques.put("massa_kg", dadesFisiques.getDouble("massa_kg"));
                mapPlaneta.put("dades_fisiques", mapDadesFisiques);

                // Òrbita
                JSONObject orbita = planeta.getJSONObject("orbita");
                HashMap<String, Double> mapOrbita = new HashMap<>();
                mapOrbita.put("distancia_mitjana_km", orbita.getDouble("distancia_mitjana_km"));
                mapOrbita.put("periode_orbital_dies", orbita.getDouble("periode_orbital_dies"));
                mapPlaneta.put("orbita", mapOrbita);

                planetesList.add(mapPlaneta);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return planetesList;
    }

    /**
     * Mostra una taula amb els planetes ordenats segons una columna especificada.
     * 
     * Els valors vàlids per a la columna d'ordenació són:
     * - "nom" -> Ordena alfabèticament pel nom del planeta.
     * - "radi" -> Ordena numèricament pel radi del planeta.
     * - "massa" -> Ordena numèricament per la massa del planeta.
     * - "distància" -> Ordena numèricament per la distància mitjana al Sol.
     * 
     * El format de la taula ha de fer servir els caràcters: "┌", "┬", "┐", "├", "┼", "┤", "└", "┴" i "┘".
     * 
     * Ex.:
     * ┌──────────────┬────────────┬──────────────┬────────────────┐
     * │ Nom          │ Radi (km)  │ Massa (kg)   │ Distància (km) │
     * ├──────────────┼────────────┼──────────────┼────────────────┤
     * │ Mercuri      │ 2439.7     │ 3.3011e23    │ 57910000       │
     * │ Venus        │ 6051.8     │ 4.8675e24    │ 108200000      │
     * └──────────────┴────────────┴──────────────┴────────────────┘
     * 
     * @param filePath Ruta de l'arxiu JSON amb les dades dels planetes.
     * @param columnaOrdenacio La columna per la qual es vol ordenar ("nom", "radi", "massa", "distància").
     * 
     * @throws IllegalArgumentException si el paràmetre de columna és invàlid.
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0202#testMostrarPlanetesOrdenatsNom
     * @test ./runTest.sh com.exercicis.TestExercici0202#testMostrarPlanetesOrdenatsRadi
     * @test ./runTest.sh com.exercicis.TestExercici0202#testMostrarPlanetesOrdenatsMassa
     * @test ./runTest.sh com.exercicis.TestExercici0202#testMostrarPlanetesOrdenatsDistancia
     */
    public static void mostrarPlanetesOrdenats(String filePath, String columnaOrdenacio) {
        ArrayList<HashMap<String, Object>> planetes =  JSONPlanetesToArrayList(filePath);

        Comparator<HashMap<String, Object>> comparator;
        switch (columnaOrdenacio) {
            case "nom":
                comparator = Comparator.comparing(p -> (String) p.get("nom"));
                break;
            case "radi_km":
                comparator = Comparator.comparing(p -> ((HashMap<String, Double>) p.get("dades_fisiques")).get("radi_km"));
                break;
            case "massa_kg":
                comparator = Comparator.comparing(p -> ((HashMap<String, Double>) p.get("dades_fisiques")).get("massa_kg"));
                break;
            case "distancia_mitjana_km":
                comparator = Comparator.comparing(p -> ((HashMap<String, Double>) p.get("orbita")).get("distancia_mitjana_km"));
                break;
            default:
                throw new IllegalArgumentException("Columna d'ordenació invàlida");
        }

        planetes.sort(comparator);

        String format = "| %-12s | %-10s | %-12s | %-14s |%n";
        System.out.println("┌──────────────┬────────────┬──────────────┬────────────────┐");
        System.out.printf("| %-12s | %-10s | %-12s | %-14s |%n", "Nom", "Radi (km)", "Massa (kg)", "Distancia (km)");
        System.out.println("├──────────────┼────────────┼──────────────┼────────────────┤");

        for (HashMap<String, Object> planeta : planetes) {
            String nom = (String) planeta.get("nom");
            HashMap<String, Double> dadesFisiques = (HashMap<String, Double>) planeta.get("dades_fisiques");
            HashMap<String, Double> orbita = (HashMap<String, Double>) planeta.get("orbita");
    
            System.out.printf(format, 
                nom, 
                String.format("%.1f", dadesFisiques.get("radi_km")), 
                String.format("%.3e", dadesFisiques.get("massa_kg")), 
                String.format("%.0f", orbita.get("distancia_mitjana_km"))
            );
        }
    
        System.out.println("└──────────────┴────────────┴──────────────┴────────────────┘");
    }
        
       // String contenido = new String(Files.readAllBytes(Paths.get(filePath)));
       // JSONObject jsonObject = new JSONObject(contenido);
        // JSONArray planetes = jsonObject.getJSONArray("planetes");
        // ArrayList<String, Object> colValidas = Arrays.asList("nom", "radi", "massa", "distancia");

    /**
     * Crea un HashMap que representa una massa d'aigua amb característiques addicionals.
     * 
     * @param nom Nom del mar o oceà.
     * @param tipus Tipus (mar o oceà).
     * @param superficie_km2 Superfície en km².
     * @param profunditat_max_m Profunditat màxima en metres.
     * @param caracteristiques Llista d'informació addicional sobre el mar o oceà.
     * @return Un HashMap amb les dades del mar o oceà.
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0202#testCrearMassaAigua
     */
    public static HashMap<String, Object> crearMassaAigua(String nom, String tipus, double superficie_km2, double profunditat_max_m, ArrayList<String> caracteristiques) {
        HashMap<String, Object> massaAigua = new HashMap<>();
        massaAigua.put("nom", nom);
        massaAigua.put("tipus", tipus);
        massaAigua.put("superficie_km2", superficie_km2);
        massaAigua.put("profunditat_max_m", profunditat_max_m);
        massaAigua.put("caracteristiques", caracteristiques);
        return massaAigua;
    }

    /**
     * Genera un arxiu JSON amb la informació de mars i oceans. Identat amb "4 espais":
     * [
     *     {
     *         "nom": "Oceà Pacífic",
     *          "tipus": "oceà",
     *          "profunditat_max_m": 10924,
     *          "superficie_km2": 1.68723E8,
     *          "caracteristiques": [
     *              "És l'oceà més gran del món",
     *              "Conté la fossa de les Marianes, la més profunda del món",
     *              "Conté una illa de plàstics contaminants."
     *         ]
     *      },
     *      {
     *          "nom": "Oceà Atlàntic",
     *          "tipus": "oceà", ...
     * 
     * @param filePath Ruta de l'arxiu JSON a crear.
     * @throws IOException Si hi ha algun problema amb l'escriptura de l'arxiu.
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0202#testValidarFormatJSON
     */
    public static void generarJSON(ArrayList<HashMap<String, Object>> dades, String filePath) throws IOException {
        
        JSONArray jsonArray = new JSONArray(dades);
        try (FileWriter file = new FileWriter(filePath)) {
                file.write(jsonArray.toString(4));
        } 
        System.out.println("Arxiu generat amb la informació de mars i oceans.");

    }
}