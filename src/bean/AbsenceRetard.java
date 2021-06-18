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
public class AbsenceRetard {
    private Date date;
    private Eleve eleve;
    private String commentaire;
    private String absence_retard;
    private int id;

    public AbsenceRetard() {
    }

    public AbsenceRetard(int id, Date date, Eleve eleve, String commentaire, String absence_retard) {
        this.id = id;
        this.date = date;
        this.eleve = eleve;
        this.commentaire = commentaire;
        this.absence_retard = absence_retard;
    }

    public Date getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAbsence_retard() {
        return absence_retard;
    }

    public void setAbsence_retard(String absence_retard) {
        this.absence_retard = absence_retard;
    }
}
