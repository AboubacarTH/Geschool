/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Nationalite;
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
public class NationaliteController {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    public NationaliteController(Connection connection) {
        this.connection = connection;
    }
    public NationaliteController(){
        this.connection = MainForm.getConnection();
    }
    public void setConnection(Connection connection){
        this.connection = connection;
    }
    //C
    public void addNationalite(Nationalite nationalite){
        try {
            String req = "INSERT INTO nationalite (nationalite) VALUES (?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, nationalite.getNationalite());
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            Logger.getLogger(NationaliteController.class.getName()).log(Level.SEVERE, null, ex);
            error_information();
        }
    }
    public void addNationalite(String nationalite){
        try {
            String req = "INSERT INTO nationalite (nationalite) VALUES (?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, nationalite);
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            Logger.getLogger(NationaliteController.class.getName()).log(Level.SEVERE, null, ex);
            error_information();
        }
    }
    //R
    public Nationalite getNationalite(Nationalite nationalite){
        try {
            String req = "SELECT nationalite FROM nationalite WHERE nationalite = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, nationalite.getNationalite());
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return  new Nationalite(resultSet.getString("nationalite"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NationaliteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Nationalite getNationalite(String nationalite){
        try {
            String req = "SELECT nationalite FROM nationalite WHERE nationalite = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, nationalite);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return  new Nationalite(resultSet.getString("nationalite"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NationaliteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<Nationalite> getListNationalite(){
        ArrayList<Nationalite> listNationalite = new ArrayList<>();
        try {
            String req = "SELECT nationalite FROM nationalite";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                listNationalite.add(new Nationalite(resultSet.getString("nationalite")));
            }
            return listNationalite;
        } catch (SQLException ex) {
            Logger.getLogger(NationaliteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //U
    public void setNationalite(Nationalite oldValue, Nationalite newValue){
        try {
            String req = "UPDATE nationalite SET nationalite = ? WHERE nationalite = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, newValue.getNationalite());
            preparedStatement.setString(2, oldValue.getNationalite());
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(NationaliteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setNationalite(String oldValue, String newValue){
        try {
            String req = "UPDATE nationalite SET nationalite = ? WHERE nationalite = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, newValue);
            preparedStatement.setString(2, oldValue);
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(NationaliteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //D
    public void removeNationalite(Nationalite nationalite){
        try {
            String req = "DELETE FROM nationalite WHERE nationalite = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, nationalite.getNationalite());
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(NationaliteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void removeNationalite(String nationalite){
        try {
            String req = "DELETE FROM nationalite WHERE nationalite = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, nationalite);
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(NationaliteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void success_information() {
        JOptionPane.showMessageDialog(null, "Opération effectuée avec succes ", "Réussie !", JOptionPane.INFORMATION_MESSAGE);
    }
    private void error_information(){
        JOptionPane.showMessageDialog(null, "Opération echouée ", "Echec !", JOptionPane.WARNING_MESSAGE);
    }
}
