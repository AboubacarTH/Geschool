/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.AnneeScolaire;
import form.MainForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ATH
 */
public class AnneeScolaireController {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    public AnneeScolaireController(Connection connection) {
        this.connection = connection;
    }
    public AnneeScolaireController(){
        this.connection = MainForm.getConnection();
    }
    public void setConnection(Connection connection){
        this.connection = connection;
    }
    public void setAnneeScolaireEnCours(AnneeScolaire annee){
        try {
            String req = "SELECT annee FROM parametre WHERE id_parametre = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, 1);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                req = "UPDATE parametre SET annee = ? WHERE id_parametre = ?";
                preparedStatement = connection.prepareStatement(req);
                preparedStatement.setString(1, annee.getAnnee());
                preparedStatement.setInt(2, 1);
                preparedStatement.executeUpdate();
            }else{
                req = "INSERT INTO parametre(id_parametre,annee) VALUES (?,?)";
                preparedStatement = connection.prepareStatement(req);
                preparedStatement.setInt(1, 1);
                preparedStatement.setString(2, annee.getAnnee());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnneeScolaireController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setAnneeScolaireEnCours(String annee){
        try {
            String req = "SELECT annee FROM parametre WHERE id_parametre = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, 1);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                req = "UPDATE parametre SET annee = ? WHERE id_parametre = ?";
                preparedStatement = connection.prepareStatement(req);
                preparedStatement.setString(1, annee);
                preparedStatement.setInt(2, 1);
                preparedStatement.executeUpdate();
            }else{
                req = "INSERT INTO parametre(id_parametre,annee) VALUES (?,?)";
                preparedStatement = connection.prepareStatement(req);
                preparedStatement.setInt(1, 1);
                preparedStatement.setString(2, annee);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnneeScolaireController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public AnneeScolaire getAnneeScolaireEnCours(){
        try {
            String req = "SELECT annee FROM parametre WHERE id_parametre = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, 1);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new AnneeScolaire(resultSet.getString("annee"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnneeScolaireController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //c
    public void addAnneeScolaire(AnneeScolaire annee){
        try {
            String req = "INSERT INTO annee_scolaire (annee) VALUES (?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, annee.getAnnee());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnneeScolaireController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addAnneeScolaire(String annee){
        try {
            String req = "INSERT INTO annee_scolaire (annee) VALUES (?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, annee);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnneeScolaireController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //r
    public AnneeScolaire getAnneeScolaire(AnneeScolaire annee){
        try {
            String req = "SELECT annee FROM annee_scolaire WHERE annee = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, annee.getAnnee());
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new AnneeScolaire(resultSet.getString("annee"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnneeScolaireController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public AnneeScolaire getAnneeScolaire(String annee){
        try {
            String req = "SELECT annee FROM annee_scolaire WHERE annee = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, annee);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new AnneeScolaire(resultSet.getString("annee"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnneeScolaireController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<AnneeScolaire> getListAnneeScolaire(){
        ArrayList<AnneeScolaire> listAnnee = new ArrayList<>();
        try {
            String req = "SELECT annee FROM annee_scolaire";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                listAnnee.add(new AnneeScolaire(resultSet.getString("annee")));
            }
            return listAnnee;
        } catch (SQLException ex) {
            Logger.getLogger(AnneeScolaireController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //u
    public void setAnneeScolaire(AnneeScolaire oldValue,AnneeScolaire newValue){
        try {
            String req = "UPDATE annee_scolaire SET annee = ? WHERE annee = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, newValue.getAnnee());
            preparedStatement.setString(2, oldValue.getAnnee());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnneeScolaireController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setAnneeScolaire(String oldValue,String newValue){
        try {
            String req = "UPDATE annee_scolaire SET annee = ? WHERE annee = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, newValue);
            preparedStatement.setString(2, oldValue);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnneeScolaireController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //d
    public void removeAnneeScolaire(AnneeScolaire annee){
        try {
            String req = "DELETE FROM annee_scolaire WHERE annee = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, annee.getAnnee());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnneeScolaireController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void removeAnneeScolaire(String annee){
        try {
            String req = "DELETE FROM annee_scolaire WHERE annee = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, annee);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnneeScolaireController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
