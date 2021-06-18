/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Classe;
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
public class ClasseController {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    
    public ClasseController(Connection connection) {
        this.connection = connection;
    }
    public ClasseController() {
        this.connection = MainForm.getConnection();
    }
    public void setConnection(Connection connection){
        this.connection = connection;
    }
    //C
    public void addClasse(String classe, String annee, String cycle){
        try {
            String req = "INSERT INTO classe (classe,annee,cycle) VALUES (?,?,?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, classe);
            preparedStatement.setString(2, annee);
            preparedStatement.setString(3, cycle);
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            Logger.getLogger(ClasseController.class.getName()).log(Level.SEVERE, null, ex);
            error_information();
        }
    }
    public void addClasse(Classe classe){
        try {
            String req = "INSERT INTO classe (classe,annee,cycle) VALUES (?,?,?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, classe.getClasse());
            preparedStatement.setString(2, classe.getAnnee());
            preparedStatement.setString(3, classe.getCycle());
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            Logger.getLogger(ClasseController.class.getName()).log(Level.SEVERE, null, ex);
            error_information();
        }
    }
    //R
    public Classe getClasse(String classe, String annee){
        try {
            String req = "SELECT cycle FROM classe WHERE classe = ? AND annee = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, classe);
            preparedStatement.setString(2, annee);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new Classe(classe, annee, resultSet.getString("cycle"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<Classe> getListClasse(String annee, String cycle){
        ArrayList<Classe> listClasse = new ArrayList<>();
        try {
            String req = "SELECT * FROM classe WHERE annee = '" + annee +"' ";
            if(cycle != null && !"Tous".equals(cycle)){
                req += "AND cycle = '" + cycle +"' ";
            }
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                Classe c = new Classe();
                c.setClasse(resultSet.getString("classe"));
                c.setAnnee(resultSet.getString("annee"));
                c.setCycle(resultSet.getString("cycle"));
                listClasse.add(c);
            }
            return listClasse;
        } catch (SQLException ex) {
            Logger.getLogger(ClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //U
    public void setClasse(String oldClasse, String oldAnnee, String classe, String annee,String cycle){
        try {
            String req = "UPDATE classe SET classe = ?, annee = ?, cycle = ? WHERE classe = ? AND annee = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, classe);
            preparedStatement.setString(2, annee);
            preparedStatement.setString(3, cycle);
            preparedStatement.setString(4, oldClasse);
            preparedStatement.setString(5, oldAnnee);
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(ClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setClasse(Classe o, Classe n){
        try {
            String req = "UPDATE classe SET classe = ?, annee = ?, cycle = ? WHERE classe = ? AND annee = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, n.getClasse());
            preparedStatement.setString(2, n.getAnnee());
            preparedStatement.setString(3, n.getCycle());
            preparedStatement.setString(4, o.getClasse());
            preparedStatement.setString(5, o.getAnnee());
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(ClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //D
    public void removeClasse(String classe, String annee){
        try {
            String req = "DELETE FROM classe WHERE classe = ? AND annee = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, classe);
            preparedStatement.setString(2, annee);
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(ClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void removeClasse(Classe classe){
        try {
            String req = "DELETE FROM classe WHERE classe = ? AND annee = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, classe.getClasse());
            preparedStatement.setString(2, classe.getAnnee());
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(ClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void success_information() {
        JOptionPane.showMessageDialog(null, "Opération effectuée avec succes ", "Réussie !", JOptionPane.INFORMATION_MESSAGE);
    }
    private void error_information(){
        JOptionPane.showMessageDialog(null, "Opération echouée ", "Echec !", JOptionPane.WARNING_MESSAGE);
    }
}
