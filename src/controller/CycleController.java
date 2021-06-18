/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
public class CycleController {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public CycleController(Connection connection) {
        this.connection = connection;
    }
    public CycleController() {
        this.connection = MainForm.getConnection();
    }
    public void setConnection(Connection connection){
        this.connection = connection;
    }
    //C
    public void addCycle(String cycle){
        try {
            String req = "INSERT INTO cycle (cycle) VALUES (?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, cycle);
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            Logger.getLogger(CycleController.class.getName()).log(Level.SEVERE, null, ex);
            error_information();
        }
    }
    //R
    public String getCycle(String cycle){
        try {
            String req = "SELECT cycle FROM cycle WHERE cycle = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, cycle);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return resultSet.getString("cycle");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CycleController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    public ArrayList<String> getListCycle(){
        ArrayList<String> listCycle = new ArrayList<>();
        try {
            String req = "SELECT cycle FROM cycle";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                listCycle.add(resultSet.getString("cycle"));
            }
            return listCycle;
        } catch (SQLException ex) {
            Logger.getLogger(CycleController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //U
    public void setCycle(String oldValue,String newValue){
        try {
            String req = "UPDATE cycle SET cycle = ? WHERE cycle = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, newValue);
            preparedStatement.setString(2, oldValue);
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(CycleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //D
    public void removeCycle(String cycle){
        try {
            String req = "DELETE FROM cycle WHERE cycle = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, cycle);
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(CycleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void success_information() {
        JOptionPane.showMessageDialog(null, "Opération effectuée avec succes ", "Réussie !", JOptionPane.INFORMATION_MESSAGE);
    }
    private void error_information(){
        JOptionPane.showMessageDialog(null, "Opération echouée ", "Echec !", JOptionPane.WARNING_MESSAGE);
    }
}
