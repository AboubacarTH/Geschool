/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.AbsenceRetard;
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
public class AbsenceRetardController {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private final EleveController eleveController;
    
    public AbsenceRetardController(Connection connection) {
        this.connection = connection;
        this.eleveController = new EleveController();
    }
    public AbsenceRetardController() {
        this.connection = MainForm.getConnection();
        this.eleveController = new EleveController();
    }
    public void setConnection(Connection connection){
        this.connection = connection;
    }
    //C
    public void addAbsenceRetard(Date date, String matricule, String commentaire, String absence_retard){
        try {
            String req = "INSERT INTO absence_retard (date,matricule,commentaire,absence_retard) VALUES (?,?,?,?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setDate(1, date);
            preparedStatement.setString(2, matricule);
            preparedStatement.setString(2, commentaire);
            preparedStatement.setString(2, absence_retard);
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            Logger.getLogger(AbsenceRetardController.class.getName()).log(Level.SEVERE, null, ex);
            error_information();
        }
    }
    //R
    public AbsenceRetard getAbsenceRetard(int id){
        try {
            String req = "SELECT * FROM absence_retard WHERE id = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new AbsenceRetard(resultSet.getInt("id"),resultSet.getDate("date"), eleveController.getEleve(resultSet.getString("matricule")), resultSet.getString("commentaire"), resultSet.getString("absence_retard"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AbsenceRetardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<AbsenceRetard> getListAbsenceRetard(String annee, String cycle, String classe, String type, String rechercher){
        ArrayList<AbsenceRetard> listAbsenceRetard = new ArrayList<>();
        try {
            String req = "SELECT * FROM absence_retard JOIN eleve ON "
                    + "absence_retard.matricule = eleve.matricule WHERE etat = ? ";
            if(annee != null && !"Toutes".equals(annee)){
                req += "AND annee = '" + annee + "' ";
            }
            if(cycle != null && !"Tous".equals(cycle)){
                req += "AND cycle = '" + cycle + "' ";
            }
            if(classe != null && !"Toutes".equals(classe)){
                req += "AND classe = '" + classe + "' ";
            }
            if(type != null && !"Tous".equals(type)){
                req += "AND absence_retard = '" + type + "' ";
            }
            if(rechercher != null){
                req += "AND nom_prenom LIKE '%" + rechercher + "%' ";
            }
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setBoolean(1, true);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                listAbsenceRetard.add(new AbsenceRetard(resultSet.getInt("id"),resultSet.getDate("date"), eleveController.getEleve(resultSet.getString("matricule")), resultSet.getString("commentaire"), resultSet.getString("absence_retard")));
            }
            return listAbsenceRetard;
        } catch (SQLException ex) {
            Logger.getLogger(AbsenceRetardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //D
    public void removeAbsenceRetard(int id){
        try {
            String req = "DELETE FROM absence_retard WHERE id = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(AbsenceRetardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void removeAbsenceRetard(AbsenceRetard ar){
        try {
            String req = "DELETE FROM absence_retard WHERE id = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, ar.getId());
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(AbsenceRetardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void success_information() {
        JOptionPane.showMessageDialog(null, "Opération effectuée avec succes ", "Réussie !", JOptionPane.INFORMATION_MESSAGE);
    }
    private void error_information(){
        JOptionPane.showMessageDialog(null, "Opération echouée ", "Echec !", JOptionPane.WARNING_MESSAGE);
    }
}
