package Formatif1.poirier_Jayson;

import static java.util.Arrays.setAll;

public class Etudiant implements Comparable<Etudiant> {

    private int da;
    private String nom;
    private float note;
    private boolean estValide;

    public Etudiant(String etudiant) {
        setAll(etudiant);
    }

    public boolean estValide() {
        return estValide;
    }

    private void setAll(String etudiant) {
        String[] infos;
        infos = etudiant.split(";");

        try {
            if (estValideDA(infos[0])) {
                setDa(Integer.parseInt(infos[0]));
                estValide = true;
            }
            if (estValideNom(infos[1])) {
                setNom(infos[1]);
                estValide = true;
            }
            if (estValideNote(infos[2])) {
                setNote(Float.parseFloat(infos[2]));
                estValide = true;
            }
        } catch (Exception e) {
            System.out.println("Ligne invalide : " + etudiant);
            estValide = false;
        }
    }

    private boolean estValideNom(String nom) throws Exception {
        if (!nom.equals("")) {
            return true;
        }
        throw new Exception("Exception");
    }

    public void setDa(int da) {
        this.da = da;
    }

    private boolean estValideDA(String da) throws Exception {
        if (da.length() == 7) {
            return true;
        }
        throw new Exception("Exception");
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public boolean estValideNote(String note) throws Exception {
        if (0 <= Float.parseFloat(note) && Float.parseFloat(note) <= 100.0) {
            return true;
        }
        throw new Exception("Exception");
    }

    public boolean estValideNote(float note) {
        if (0 <= note && note <= 100) {
            return true;
        }
        return false;
    }

    public void ajouterANote(Float note) {
        if (estValideNote((this.note + note))) {
            this.note += note;
        }
    }

    @Override
    public String toString() {
        return  da + "," + nom + "," + note;
    }

    @Override
    public int compareTo(Etudiant etudiant) {
        return this.nom.compareTo(etudiant.nom);
    }
}
