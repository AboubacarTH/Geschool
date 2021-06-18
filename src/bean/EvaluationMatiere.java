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
public class EvaluationMatiere {
    private MatiereClasse matiereClasse;
    private Eleve eleve;
    private Semestre semestre;
    
    public EvaluationMatiere() {
    }

    public EvaluationMatiere(MatiereClasse matiereClasse, Eleve eleve, Semestre semestre) {
        this.matiereClasse = matiereClasse;
        this.eleve = eleve;
        this.semestre = semestre;
    }

    public MatiereClasse getMatiereClasse() {
        return matiereClasse;
    }

    public void setMatiereClasse(MatiereClasse matiereClasse) {
        this.matiereClasse = matiereClasse;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }
}
