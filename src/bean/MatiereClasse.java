/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author ATH
 */
public class MatiereClasse {
    private Classe classe;
    private Matiere matiere;
    private int volume_horaire;
    private int coefficient;

    public MatiereClasse() {
    }

    public MatiereClasse(Classe classe, Matiere matiere, int volume_horaire, int coefficient) {
        this.classe = classe;
        this.matiere = matiere;
        this.volume_horaire = volume_horaire;
        this.coefficient = coefficient;
    }
    public MatiereClasse(String classe, String annee, String matiere, int volume_horaire, int coefficient) {
        this.classe = new Classe();
        this.classe.setClasse(classe);
        this.classe.setAnnee(annee);
        this.matiere = new Matiere();
        this.matiere.setMatiere(matiere);
        this.volume_horaire = volume_horaire;
        this.coefficient = coefficient;
    }

    public int getVolume_horaire() {
        return volume_horaire;
    }

    public void setVolume_horaire(int volume_horaire) {
        this.volume_horaire = volume_horaire;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }   
}