package Formatif1.poirier_Jayson;

import java.io.*;
import java.util.ArrayList;

public class ListeEtudiant {
    private static char bSlash = File.separatorChar;
    private static String path = System.getProperty("user.dir") + bSlash + "src" + bSlash + "Formatif1" + bSlash + "poirier_Jayson" + bSlash;

    private ArrayList<String> listeEtudiants;

    public ListeEtudiant() {

    }

    public void lireEtudiants(String nomFichier) {
        String ligne;

        try {
            BufferedReader entree = new BufferedReader(new FileReader(nomFichier));
            ligne = entree.readLine();
            while (ligne != null) {
                System.out.println(ligne);
                listeEtudiants.add(ligne);
                ligne = entree.readLine();
            }
            entree.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fichier non trouvé" + nomFichier);
        } catch (IOException e) {
            System.out.println("Problème de lecture");
        }
    }
}
