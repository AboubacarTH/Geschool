/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.MatiereClasse;
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
public class MatiereClasseController {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private final ClasseController classeController;
    private final MatiereController matiereController;

    public MatiereClasseController() {
        this.connection = MainForm.getConnection();
        classeController = new ClasseController();
        matiereController = new MatiereController();
    }
    public MatiereClasseController(Connection connection) {
        this.connection = connection;
        classeController = new ClasseController(connection);
        matiereController = new MatiereController(connection);
    }
    
    public void setConnection(Connection connection){
        this.connection = connection;
    }
    public void addMatiereClasse(String classe, String annee, String matiere, int volume_horaire, int coefficient){
        try {
            String req = "INSERT INTO matiere_classe (classe, annee, matiere, volume_horaire, coefficient) VALUES (?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, classe);
            preparedStatement.setString(2, annee);
            preparedStatement.setString(3, matiere);
            preparedStatement.setInt(4, volume_horaire);
            preparedStatement.setInt(5, coefficient);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MatiereClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addMatiereClasse(MatiereClasse matiereClasse){
        try {
            String req = "INSERT INTO matiere_classe (classe, annee, matiere, volume_horaire, coefficient) VALUES (?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, matiereClasse.getClasse().getClasse());
            preparedStatement.setString(2, matiereClasse.getClasse().getAnnee());
            preparedStatement.setString(3, matiereClasse.getMatiere().getMatiere());
            preparedStatement.setInt(4, matiereClasse.getVolume_horaire());
            preparedStatement.setInt(5, matiereClasse.getCoefficient());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MatiereClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public MatiereClasse getMatiereClasse(String classe, String annee, String matiere){
        try {
            String req = "SELECT * FROM matiere_classe WHERE classe = ? AND annee = ? AND matiere = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, classe);
            preparedStatement.setString(2, annee);
            preparedStatement.setString(3, matiere);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new MatiereClasse(classeController.getClasse(resultSet.getString("classe"), resultSet.getString("annee")), matiereController.getMatiere(resultSet.getString("matiere")), resultSet.getInt("volume_horaire"), resultSet.getInt("coefficient"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MatiereClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<MatiereClasse> getListMatiereClasse(){
        ArrayList<MatiereClasse> listMatiereClasse = new ArrayList<>();
        try {
            String req = "SELECT * FROM matiere_classe";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                listMatiereClasse.add(new MatiereClasse(classeController.getClasse(resultSet.getString("classe"), resultSet.getString("annee")), matiereController.getMatiere(resultSet.getString("matiere")), resultSet.getInt("volume_horaire"), resultSet.getInt("coefficient")));
            }
            return listMatiereClasse;
        } catch (SQLException ex) {
            Logger.getLogger(MatiereClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void setMatiereClasse(String oldClasse, String oldAnnee, String oldMatiere, String classe, String annee, String matiere, int volume_horaire, int coefficient){
        try {
            String req = "UPDATE matiere_classe SET classe = ?, annee = ?, matiere = ?, volume_horaire = ?, coefficient = ? WHERE classe = ? AND annee = ? AND matiere = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, classe);
            preparedStatement.setString(2, annee);
            preparedStatement.setString(3, matiere);
            preparedStatement.setInt(4, volume_horaire);
            preparedStatement.setInt(5, coefficient);
            preparedStatement.setString(6, oldClasse);
            preparedStatement.setString(7, oldAnnee);
            preparedStatement.setString(8, oldMatiere);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MatiereClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setMatiereClasse(MatiereClasse o, MatiereClasse n){
        try {
            String req = "UPDATE matiere_classe SET classe = ?, annee = ?, matiere = ?, volume_horaire = ?, coefficent = ? WHERE classe = ? AND annee = ? AND matiere = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, n.getClasse().getClasse());
            preparedStatement.setString(2, n.getClasse().getAnnee());
            preparedStatement.setString(3, n.getMatiere().getMatiere());
            preparedStatement.setInt(4, n.getVolume_horaire());
            preparedStatement.setInt(5, n.getCoefficient());
            preparedStatement.setString(6, o.getClasse().getClasse());
            preparedStatement.setString(7, o.getClasse().getAnnee());
            preparedStatement.setString(8, o.getMatiere().getMatiere());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MatiereClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void removeMatiereClasse(String classe, String annee, String matiere){
        try {
            String req = "DELETE FROM matiere_classe WHERE classe = ? AND annee = ? AND matiere = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, classe);
            preparedStatement.setString(2, annee);
            preparedStatement.setString(3, matiere);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MatiereClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void removeMatiereClasse(MatiereClasse matiereClasse){
        try {
            String req = "DELETE FROM matiere_classe WHERE classe = ? AND annee = ? AND matiere = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, matiereClasse.getClasse().getClasse());
            preparedStatement.setString(2, matiereClasse.getClasse().getAnnee());
            preparedStatement.setString(3, matiereClasse.getMatiere().getMatiere());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MatiereClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
