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
public class Matiere {
    private String matiere;
    private String type;
    private int priorite;

    public Matiere() {
    }

    public Matiere(String matiere, String type, int priorite) {
        this.priorite = priorite;
        this.matiere = matiere;
        this.type = type;
    }
    
    public int getPriorite() {
        return priorite;
    }

    public void setPriorite(int priorite) {
        this.priorite = priorite;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
