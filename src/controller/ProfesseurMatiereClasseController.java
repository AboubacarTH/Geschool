/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.MatiereClasse;
import bean.Professeur;
import bean.ProfesseurMatiereClasse;
import form.MainForm;
import java.sql.Connection;
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
public class ProfesseurMatiereClasseController {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private final MatiereClasseController matiereClasseController;
    private final ProfesseurController professeurController;
    public ProfesseurMatiereClasseController() {
        this.connection = MainForm.getConnection();
        this.matiereClasseController = new MatiereClasseController();
        this.professeurController = new ProfesseurController();
        
    }
    public ProfesseurMatiereClasseController(Connection connection) {
        this.connection = connection;
        this.matiereClasseController = new MatiereClasseController(connection);
        this.professeurController = new ProfesseurController(connection);
    }
    
    public void setConnection(Connection connection){
        this.connection = connection;
    }
    public void addProfesseurMatiereClasse(String matricule, String classe, String annee, String matiere, int volume_horaire, int coefficient){
        if(matiereClasseController.getMatiereClasse(classe, annee, matiere) == null){
            matiereClasseController.addMatiereClasse(classe, annee, matiere, volume_horaire, coefficient);
        }
        try {
            String req = "INSERT INTO professeur_matiere_classe (matricule, classe, annee, matiere) VALUES (?,?,?,?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, matricule);
            preparedStatement.setString(2, classe);
            preparedStatement.setString(3, annee);
            preparedStatement.setString(4, matiere);
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurMatiereClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addProfesseurMatiereClasse(Professeur professeur, MatiereClasse matiereClasse){
        if(matiereClasseController.getMatiereClasse(matiereClasse.getClasse().getClasse(), matiereClasse.getClasse().getAnnee(), matiereClasse.getMatiere().getMatiere()) == null){
            matiereClasseController.addMatiereClasse(matiereClasse);
        }
        try {
            String req = "INSERT INTO professeur_matiere_classe (matricule, classe, annee, matiere) VALUES (?,?,?,?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, professeur.getMatricule());
            preparedStatement.setString(2, matiereClasse.getClasse().getClasse());
            preparedStatement.setString(3, matiereClasse.getClasse().getAnnee());
            preparedStatement.setString(4, matiereClasse.getMatiere().getMatiere());
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(ProfesseurMatiereClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ProfesseurMatiereClasse getProfesseurMatiereClasse(String matricule, String classe, String annee, String matiere){
        try {
            String req = "SELECT * FROM professeur_matiere_classe WHERE matricule = ? AND classe = ? AND annee = ? AND matiere = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, matricule);
            preparedStatement.setString(2, classe);
            preparedStatement.setString(3, annee);
            preparedStatement.setString(4, matiere);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new ProfesseurMatiereClasse(professeurController.getProfesseur(resultSet.getString("matriucle")), matiereClasseController.getMatiereClasse(resultSet.getString("classe"), resultSet.getString("annee"), resultSet.getString("matiere")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurMatiereClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<ProfesseurMatiereClasse> getListProfesseurMatiereClasse(){
        ArrayList<ProfesseurMatiereClasse> listProfesseurMatiereClasse = new ArrayList<>();
        try {
            String req = "SELECT * FROM professeur_matiere_classe";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                listProfesseurMatiereClasse.add(new ProfesseurMatiereClasse(professeurController.getProfesseur(resultSet.getString("matricule")), matiereClasseController.getMatiereClasse(resultSet.getString("classe"), resultSet.getString("annee"), resultSet.getString("matiere"))));
            }
            return listProfesseurMatiereClasse;
        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurMatiereClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void setProfesseurMatiereClasse(String oldMatricule, String oldClasse, String oldAnnee, String oldMatiere, String matricule, String classe, String annee, String matiere, int volume_horaire, int coefficient){
        matiereClasseController.setMatiereClasse(oldClasse, oldAnnee, oldMatiere, classe, annee, matiere, volume_horaire, coefficient);
        try {
            String req = "UPDATE professeur_matiere_classe SET matricule = ?, classe = ?, annee = ?, matiere = ? WHERE matricule = ? AND classe = ? AND annee = ? AND matiere = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, matricule);
            preparedStatement.setString(2, classe);
            preparedStatement.setString(3, annee);
            preparedStatement.setString(4, matiere);
            preparedStatement.setString(5, oldMatricule);
            preparedStatement.setString(6, oldClasse);
            preparedStatement.setString(7, oldAnnee);
            preparedStatement.setString(8, oldMatiere);
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(ProfesseurMatiereClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void removeProfesseurMatiereClasse(String matriucle, String classe, String annee, String matiere){
        try {
            String req = "DELETE FROM professeur_matiere_classe WHERE matricule = ? AND classe = ? AND annee = ? AND matiere = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, matriucle);
            preparedStatement.setString(2, classe);
            preparedStatement.setString(3, annee);
            preparedStatement.setString(4, matiere);
            preparedStatement.executeUpdate();
            matiereClasseController.removeMatiereClasse(classe, annee, matiere);
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(ProfesseurMatiereClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void removeProfesseurMatiereClasse(Professeur professeur, MatiereClasse matiereClasse){
        try {
            String req = "DELETE FROM professeur_matiere_classe WHERE matricule = ? AND classe = ? AND annee = ? AND matiere = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, professeur.getMatricule());
            preparedStatement.setString(2, matiereClasse.getClasse().getClasse());
            preparedStatement.setString(3, matiereClasse.getClasse().getAnnee());
            preparedStatement.setString(4, matiereClasse.getMatiere().getMatiere());
            preparedStatement.executeUpdate();
            matiereClasseController.removeMatiereClasse(matiereClasse);
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(ProfesseurMatiereClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void success_information() {
        JOptionPane.showMessageDialog(null, "Opération effectuée avec succes ", "Réussie !", JOptionPane.INFORMATION_MESSAGE);
    }
    private void error_information(){
        JOptionPane.showMessageDialog(null, "Opération echouée ", "Echec !", JOptionPane.WARNING_MESSAGE);
    }
}
