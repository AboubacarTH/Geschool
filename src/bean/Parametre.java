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
public class Parametre {
    private int id_parametre;
    private AnneeScolaire annee;

    public Parametre() {
    }

    public Parametre(int id_parametre, AnneeScolaire annee) {
        this.id_parametre = id_parametre;
        this.annee = annee;
    }

    public int getId_parametre() {
        return id_parametre;
    }

    public void setId_parametre(int id_parametre) {
        this.id_parametre = id_parametre;
    }

    public AnneeScolaire getAnnee() {
        return annee;
    }

    public void setAnnee(AnneeScolaire annee) {
        this.annee = annee;
    }
    
}
