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
public class EvaluationClasse {
    private Classe classe;
    private Eleve eleve;
    private Semestre semestre;

    public EvaluationClasse() {
    }

    public EvaluationClasse(Classe classe, Eleve eleve, Semestre semestre) {
        this.classe = classe;
        this.eleve = eleve;
        this.semestre = semestre;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
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
