/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Semestre;
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
public class SemestreController {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    public SemestreController(Connection connection) {
        this.connection = connection;
    }
    public SemestreController() {
        this.connection = MainForm.getConnection();
    }
    public void setConnection(Connection connection){
        this.connection = connection;
    }
    //C
    public void addSemestre(Semestre semestre){
        try {
            String req = "INSERT INTO semestre (semestre) VALUES (?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, semestre.getSemestre());
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            Logger.getLogger(SemestreController.class.getName()).log(Level.SEVERE, null, ex);
            error_information();
        }
    }
    public void addSemestre(String semestre){
        try {
            String req = "INSERT INTO semestre (semestre) VALUES (?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, semestre);
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            Logger.getLogger(SemestreController.class.getName()).log(Level.SEVERE, null, ex);
            error_information();
        }
    }
    //R
    public Semestre getSemestre(String semestre){
        try {
            String req = "SELECT semestre FROM semestre WHERE semestre = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, semestre);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new Semestre(resultSet.getString("semestre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SemestreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Semestre getSemestre(Semestre semestre){
        try {
            String req = "SELECT semestre FROM semestre WHERE semestre = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, semestre.getSemestre());
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new Semestre(resultSet.getString("semestre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SemestreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Semestre> getListSemestre(){
        ArrayList<Semestre> listSemestre = new ArrayList<>();
        try {
            String req = "SELECT semestre FROM semestre";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                listSemestre.add(new Semestre(resultSet.getString("semestre")));
            }
            return listSemestre;
        } catch (SQLException ex) {
            Logger.getLogger(SemestreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //U
    public void setSemestre(Semestre o,Semestre n){
        try {
            String req = "UPDATE semestre SET semestre = ? WHERE semestre = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, n.getSemestre());
            preparedStatement.setString(2, o.getSemestre());
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(SemestreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setSemestre(String o, String n){
        try {
            String req = "UPDATE semestre SET semestre = ? WHERE semestre = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, n);
            preparedStatement.setString(2, o);
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(SemestreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //D
    public void removeSemestre(Semestre semestre){
        try {
            String req = "DELETE FROM semestre WHERE semestre = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, semestre.getSemestre());
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(SemestreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void removeSemestre(String semestre){
        try {
            String req = "DELETE FROM semestre WHERE semestre = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, semestre);
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(SemestreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void success_information() {
        JOptionPane.showMessageDialog(null, "Opération effectuée avec succes ", "Réussie !", JOptionPane.INFORMATION_MESSAGE);
    }
    private void error_information(){
        JOptionPane.showMessageDialog(null, "Opération echouée ", "Echec !", JOptionPane.WARNING_MESSAGE);
    }
}
