/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.Date;

/**
 *
 * @author ATH
 */
public class Retard {
    private int id_retard = 0;
    private Date date = null;
    private Eleve eleve = null;
    private String commentaire = null;
    
    public Retard(){
        
    }

    public int getId_retard() {
        return id_retard;
    }

    public void setId_retard(int id_retard) {
        this.id_retard = id_retard;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
    
    
}
