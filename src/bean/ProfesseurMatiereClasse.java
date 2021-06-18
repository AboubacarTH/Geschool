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
public class ProfesseurMatiereClasse {
    private Professeur professeur;
    private MatiereClasse matiereClasse;

    public ProfesseurMatiereClasse() {
    }

    public ProfesseurMatiereClasse(Professeur professeur, MatiereClasse matiereClasse) {
        this.professeur = professeur;
        this.matiereClasse = matiereClasse;
    }
    

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    public MatiereClasse getMatiereClasse() {
        return matiereClasse;
    }

    public void setMatiereClasse(MatiereClasse matiereClasse) {
        this.matiereClasse = matiereClasse;
    }
    
}
