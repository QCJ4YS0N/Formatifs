package Formatif1.poirier_Jayson;

public class ListeEtudiantsTest {
    public ListeEtudiantsTest() {
        ListeEtudiants listeEtudiants = new ListeEtudiants();

        listeEtudiants.lireEtudiants();  //lit un fichier
        listeEtudiants.trier(); //trie les éléments de la structure par nom ascendant
        System.out.println(listeEtudiants); //affiche les données de la structure
        listeEtudiants.ajouterANote(10); //ajoute la note passée en argument aux étudiants de la structure
        listeEtudiants.ecrireEtudiants(); //écrit le fichier
    }

    public static void main(String[] args) {
        new ListeEtudiantsTest();
    }

}
