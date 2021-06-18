/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Professeur;
import form.MainForm;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ATH
 */
public class ProfesseurController {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public ProfesseurController(Connection connection) {
        this.connection = connection;
    }
    public ProfesseurController() {
        this.connection = MainForm.getConnection();
    }
    public void setConnection(Connection connection){
        this.connection = connection;
    }
    //C
    public void addProfesseur(String matricule, String nom_prenom, Date date_de_naissance, String lieu_de_naissance, String nationalite, String contact, String titre, String diplome, boolean  etat, String mot_de_passe, String sexe){
        try {
            String req = "INSERT INTO professeur (matricule, nom_prenom, date_de_naissance, lieu_de_naissance, nationalite, contact, titre, diplome, etat, mot_de_passe, sexe) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, matricule);
            preparedStatement.setString(2, nom_prenom);
            preparedStatement.setDate(3, date_de_naissance);
            preparedStatement.setString(4, lieu_de_naissance);
            preparedStatement.setString(5, nationalite);
            preparedStatement.setString(6, contact);
            preparedStatement.setString(7, titre);
            preparedStatement.setString(8, diplome);
            preparedStatement.setBoolean(9, etat);
            preparedStatement.setString(10, mot_de_passe);
            preparedStatement.setString(11, sexe);
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurController.class.getName()).log(Level.SEVERE, null, ex);
            error_information();
        }
    }
    //R
    public Professeur getProfesseur(String matricule){
        try {
            String req = "SELECT * FROM professeur WHERE matricule = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, matricule);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new Professeur(resultSet.getString("matricule"), resultSet.getString("nom_prenom"), resultSet.getDate("date_de_naissance"), resultSet.getString("lieu_de_naissance"), resultSet.getString("nationalite"), resultSet.getString("contact"), resultSet.getString("titre"), resultSet.getString("diplome"), resultSet.getBoolean("etat"), resultSet.getString("mot_de_passe"), resultSet.getString("sexe"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public int getProfesseurCount(){
        try {
            String req = "SELECT COUNT(matricule) AS effectif FROM professeur";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return resultSet.getInt("effectif");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public int getProfesseurCount(boolean  etat){
        try {
            String req = "SELECT COUNT(matricule) AS effectif FROM professeur WHERE etat = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setBoolean(1, etat);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return resultSet.getInt("effectif");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public ArrayList<Professeur> getListProfesseur(){
        ArrayList<Professeur> listProfesseur = new ArrayList<>();
        try {
            String req = "SELECT * FROM professeur WHERE etat = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setBoolean(1, true);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                listProfesseur.add(new Professeur(resultSet.getString("matricule"), resultSet.getString("nom_prenom"), resultSet.getDate("date_de_naissance"), resultSet.getString("lieu_de_naissance"), resultSet.getString("nationalite"), resultSet.getString("contact"), resultSet.getString("titre"), resultSet.getString("diplome"), resultSet.getBoolean("etat"), resultSet.getString("mot_de_passe"), resultSet.getString("sexe")));
            }
            return listProfesseur;
        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //U
    public void setProfesseur(String oldMatricule, String matricule, String nom_prenom, Date date_de_naissance, String lieu_de_naissance, String nationalite, String contact, String titre, String diplome, boolean  etat, String mot_de_passe, String sexe){
        try {
            String req = "UPDATE professeur SET matricule = ?, nom_prenom = ?, date_de_naissance = ?, lieu_de_naissance = ?, nationalite = ?, contact = ?, titre = ?, diplome = ?, etat = ?, mot_de_passe = ?, sexe = ? WHERE matricule = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, matricule);
            preparedStatement.setString(2, nom_prenom);
            preparedStatement.setDate(3, date_de_naissance);
            preparedStatement.setString(4, lieu_de_naissance);
            preparedStatement.setString(5, nationalite);
            preparedStatement.setString(6, contact);
            preparedStatement.setString(7, titre);
            preparedStatement.setString(8, diplome);
            preparedStatement.setBoolean(9, etat);
            preparedStatement.setString(10, mot_de_passe);
            preparedStatement.setString(11, sexe);
            preparedStatement.setString(12, oldMatricule);
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(ProfesseurController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setProfesseur(Professeur o, Professeur n){
        try {
            String req = "UPDATE professeur SET matricule = ?, nom_prenom = ?, date_de_naissance = ?, lieu_de_naissance = ?, nationalite = ?, contact = ?, titre = ?, diplome = ?, etat = ?, mot_de_passe = ?, sexe = ? WHERE matricule = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, n.getMatricule());
            preparedStatement.setString(2, n.getNom_prenom());
            preparedStatement.setDate(3, n.getDate_de_naissance());
            preparedStatement.setString(4, n.getLieu_de_naissance());
            preparedStatement.setString(5, n.getNationalite());
            preparedStatement.setString(6, n.getContact());
            preparedStatement.setString(7, n.getTitre());
            preparedStatement.setString(8, n.getDiplome());
            preparedStatement.setBoolean(9, n.isEtat());
            preparedStatement.setString(10, n.getMot_de_passe());
            preparedStatement.setString(11, n.getSexe());
            preparedStatement.setString(12, o.getMatricule());
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(ProfesseurController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //D
    public void removeProfesseur(String matricule){
        try {
            String req = "UPDATE professeur SET etat = ? WHERE matricule = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setBoolean(1, false);
            preparedStatement.setString(2, matricule);
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(ProfesseurController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void removeProfesseur(Professeur professeur){
        try {
            String req = "UPDATE professeur SET etat = ? WHERE matricule = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setBoolean(1, false);
            preparedStatement.setString(2, professeur.getMatricule());
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(ProfesseurController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void success_information() {
        JOptionPane.showMessageDialog(null, "Opération effectuée avec succes ", "Réussie !", JOptionPane.INFORMATION_MESSAGE);
    }
    private void error_information(){
        JOptionPane.showMessageDialog(null, "Opération echouée ", "Echec !", JOptionPane.WARNING_MESSAGE);
    }
}
