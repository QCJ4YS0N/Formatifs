package Formatif1.poirier_Jayson;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class ListeEtudiants {
    private static char bSlash = File.separatorChar;
    private static String path = System.getProperty("user.dir") + bSlash + "src" + bSlash + "Formatif1" + bSlash + "poirier_Jayson" + bSlash;

    private ArrayList<Etudiant> listeEtudiants;

    public ListeEtudiants() {
        listeEtudiants = new ArrayList<>();
    }

    public void ajouterANote(float note) {
        for (int i = 0; i < listeEtudiants.size(); i++) {
            listeEtudiants.get(i).ajouterANote(note);
        }
    }

    public void trier() {
        listeEtudiants.sort(Comparator.naturalOrder());
    }

    public void lireEtudiants() {
        String ligne;
        String ficher = path + "etudiantsIn.csv";
        ArrayList<String> liste = new ArrayList<>();

        try {
            BufferedReader entree = new BufferedReader(new FileReader(ficher));
            ligne = entree.readLine();
            while (ligne != null) {
                liste.add(ligne);
                ligne = entree.readLine();
            }
            entree.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fichier non trouvé" + ficher);
        } catch (IOException e) {
            System.out.println("Problème de lecture");
        }

        for (int i = 0; i < liste.size(); i++) {
            Etudiant etudiant = new Etudiant(liste.get(i));
            if (etudiant.estValide()) {
                listeEtudiants.add(new Etudiant(liste.get(i)));
            }
        }
    }

    public void ecrireEtudiants() {
       String str = "";
       String fichier = path + "etudiantsOut.csv";

        try {
            PrintWriter sortie = new PrintWriter(new FileWriter(fichier));
            for (int i = 0; i < listeEtudiants.size(); i++) {
                str += listeEtudiants.get(i) + "\n";
            }
            sortie.println(str);
            sortie.flush();
            sortie.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        String str = "\n";

        for (int i = 0; i < listeEtudiants.size(); i++) {
            str += listeEtudiants.get(i) + "\n";
        }
        return str;
    }
}
