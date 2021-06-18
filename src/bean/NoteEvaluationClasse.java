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
public class NoteEvaluationClasse {
    private Eleve eleve;
    private Classe classe;
    private Semestre semestre;

    public NoteEvaluationClasse() {
    }

    public NoteEvaluationClasse(Eleve eleve, Classe classe, Semestre semestre) {
        this.eleve = eleve;
        this.classe = classe;
        this.semestre = semestre;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }
}
