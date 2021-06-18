/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Matiere;
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
public class MatiereController {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    
    
    public MatiereController(Connection connection) {
        this.connection = connection;
    }
    public MatiereController() {
        this.connection = MainForm.getConnection();
    }
    public void setConnection(Connection connection){
        this.connection = connection;
    }
    //C
    public void addMatiere(String matiere, String type,int priorite){
        try {
            String req = "INSERT INTO matiere (matiere,type,priorite) VALUES (?,?,?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, matiere);
            preparedStatement.setString(2, type);
            preparedStatement.setInt(3, priorite);
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            Logger.getLogger(MatiereController.class.getName()).log(Level.SEVERE, null, ex);
            error_information();
        }
    }
    //R
    public Matiere getMatiere(String matiere){
        try {
            String req = "SELECT * FROM matiere WHERE matiere = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, matiere);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new Matiere(resultSet.getString("matiere"), resultSet.getString("type"), resultSet.getInt("priorite")) ;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MatiereController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<Matiere> getListMatiere(){
        ArrayList<Matiere> listMatiere = new ArrayList<>();
        try {
            String req = "SELECT * FROM matiere ORDER BY priorite ASC";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                listMatiere.add(new Matiere(resultSet.getString("matiere"), resultSet.getString("type"), resultSet.getInt("priorite")));
            }
            return listMatiere;
        } catch (SQLException ex) {
            Logger.getLogger(MatiereController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //U
    public void setMatiere(String oldMatiere, String matiere, String type, int priorite){
        try {
            String req = "UPDATE matiere SET matiere = ?, type = ?, priorite = ? WHERE matiere = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, matiere);
            preparedStatement.setString(2, type);
            preparedStatement.setInt(3, priorite);
            preparedStatement.setString(4, oldMatiere);
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(MatiereController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setMatiere(Matiere o, Matiere n){
        try {
            String req = "UPDATE matiere SET matiere = ?, type = ?, priorite = ? WHERE matiere = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, n.getMatiere());
            preparedStatement.setString(2, n.getType());
            preparedStatement.setInt(3, n.getPriorite());
            preparedStatement.setString(4, o.getMatiere());
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(MatiereController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //D
    public void removeMatiere(String matiere){
        try {
            String req = "DELETE FROM matiere WHERE matiere = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, matiere);
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(MatiereController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void removeMatiere(Matiere matiere){
        try {
            String req = "DELETE FROM matiere WHERE matiere = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, matiere.getMatiere());
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(MatiereController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void success_information() {
        JOptionPane.showMessageDialog(null, "Opération effectuée avec succes ", "Réussie !", JOptionPane.INFORMATION_MESSAGE);
    }
    private void error_information(){
        JOptionPane.showMessageDialog(null, "Opération echouée ", "Echec !", JOptionPane.WARNING_MESSAGE);
    }
}
