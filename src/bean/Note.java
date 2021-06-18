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
public class Note {
    private Eleve eleve;
    private MatiereClasse matiereClasse;

    public Note() {
    }

    public Note(Eleve eleve, MatiereClasse matiereClasse) {
        this.eleve = eleve;
        this.matiereClasse = matiereClasse;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    public MatiereClasse getMatiereClasse() {
        return matiereClasse;
    }

    public void setMatiereClasse(MatiereClasse matiereClasse) {
        this.matiereClasse = matiereClasse;
    }
}
