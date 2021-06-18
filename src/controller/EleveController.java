/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Classe;
import bean.Cycle;
import bean.Eleve;
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
public class EleveController {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private final ClasseController classeController;
    public EleveController() {
        this.connection = MainForm.getConnection();
        classeController = new ClasseController();
    }
    public void setConnection(Connection connection){
        this.connection = connection;
    }
    
    //C
    public void addEleve(String matricule, String annee, String nom_prenom, Date date_de_naissance, String lieu_de_naissance, String nationalite, String contact, String sexe, String classe, String qr_code, String photo){
        try {
            String req = "INSERT INTO eleve (matricule,annee,nom_prenom,date_de_naissance,lieu_de_naissance,nationalite,contact,sexe,classe,qr_code,photo) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, matricule);
            preparedStatement.setString(2, annee);
            preparedStatement.setString(3, nom_prenom);
            preparedStatement.setDate(4, date_de_naissance);
            preparedStatement.setString(5, lieu_de_naissance);
            preparedStatement.setString(6, nationalite);
            preparedStatement.setString(7, contact);
            preparedStatement.setString(8, sexe);
            preparedStatement.setString(9, classe);
            preparedStatement.setString(10, qr_code);
            preparedStatement.setString(11, photo);
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            Logger.getLogger(EleveController.class.getName()).log(Level.SEVERE, null, ex);
            error_information();
        }
    }
    //R
    public Eleve getEleve(String matricule){
        try {
            String req = "SELECT * FROM eleve WHERE matricule = ? AND etat = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, matricule);
            preparedStatement.setBoolean(2, true);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new Eleve(resultSet.getString("matricule"), resultSet.getString("annee"), resultSet.getString("nom_prenom"), resultSet.getDate("date_de_naissance"), resultSet.getString("lieu_de_naissance"), resultSet.getString("nationalite"), resultSet.getString("contact"), resultSet.getString("sexe"), classeController.getClasse(resultSet.getString("classe"), resultSet.getString("annee")), resultSet.getString("qr_code"), resultSet.getString("photo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EleveController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Eleve getEleve(Eleve e){
        try {
            String req = "SELECT * FROM eleve WHERE matricule = ? AND etat = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, e.getMatricule());
            preparedStatement.setBoolean(2, true);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new Eleve(resultSet.getString("matricule"), resultSet.getString("annee"), resultSet.getString("nom_prenom"), resultSet.getDate("date_de_naissance"), resultSet.getString("lieu_de_naissance"), resultSet.getString("nationalite"), resultSet.getString("contact"), resultSet.getString("sexe"), classeController.getClasse(resultSet.getString("classe"), resultSet.getString("annee")), resultSet.getString("qr_code"), resultSet.getString("photo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EleveController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public int getEleveCount(){
        try {
            String req = "SELECT COUNT(matricule) AS effectif FROM eleve";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return resultSet.getInt("effectif");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EleveController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public int getEleveCount(boolean etat){
        try {
            String req = "SELECT COUNT(matricule) AS effectif FROM eleve WHERE etat = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setBoolean(1, etat);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return resultSet.getInt("effectif");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EleveController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public int getEleveCount(String annee){
        try {
            String req = "SELECT COUNT(matricule) AS effectif FROM eleve WHERE annee = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, annee);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return resultSet.getInt("effectif");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EleveController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public int getEleveCount(String annee, boolean etat){
        try {
            String req = "SELECT COUNT(matricule) AS effectif FROM eleve WHERE annee = ? AND etat = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, annee);
            preparedStatement.setBoolean(2, etat);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return resultSet.getInt("effectif");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EleveController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public int getEleveCount(Cycle cycle, String annee){
        try {
            String req = "SELECT COUNT(matricule) AS effectif FROM eleve JOIN classe ON "
                    + "eleve.classe = classe.classe AND eleve.annee = classe.annee WHERE classe.cycle = ? AND classe.annee = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, cycle.getCycle());
            preparedStatement.setString(2, annee);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return resultSet.getInt("effectif");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EleveController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public int getEleveCount(Cycle cycle, String annee, boolean etat){
        try {
            String req = "SELECT COUNT(matricule) AS effectif FROM eleve JOIN classe ON "
                    + "eleve.classe = classe.classe AND eleve.annee = classe.annee WHERE classe.cycle = ? AND classe.annee = ? AND etat = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, cycle.getCycle());
            preparedStatement.setString(2, annee);
            preparedStatement.setBoolean(3, etat);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return resultSet.getInt("effectif");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EleveController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public int getEleveCount(String classe, String annee){
        try {
            String req = "SELECT COUNT(matricule) AS effectif FROM eleve WHERE classe = ? AND annee = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, classe);
            preparedStatement.setString(2, annee);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return resultSet.getInt("effectif");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EleveController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public int getEleveCount(String classe, String annee, boolean etat){
        try {
            String req = "SELECT COUNT(matricule) AS effectif FROM eleve WHERE classe = ? AND annee = ? AND etat = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, classe);
            preparedStatement.setString(2, annee);
            preparedStatement.setBoolean(3, etat);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return resultSet.getInt("effectif");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EleveController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public int getEleveCount(Classe classe){
        try {
            String req = "SELECT COUNT(matricule) AS effectif FROM eleve WHERE classe = ? AND annee = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, classe.getClasse());
            preparedStatement.setString(2, classe.getAnnee());
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return resultSet.getInt("effectif");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EleveController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public int getEleveCount(Classe classe, boolean etat){
        try {
            String req = "SELECT COUNT(matricule) AS effectif FROM eleve WHERE classe = ? AND annee = ? AND etat = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, classe.getClasse());
            preparedStatement.setString(2, classe.getAnnee());
            preparedStatement.setBoolean(3, etat);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return resultSet.getInt("effectif");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EleveController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public ArrayList<Eleve> getListEleve(String annee,String cycle, String classe, String rechercher, String nationalite, String sexe){
        ArrayList<Eleve> listEleve = new ArrayList<>();
        try {
            String req = "SELECT * FROM eleve JOIN classe ON eleve.classe = classe.classe AND eleve.annee = classe.annee WHERE etat = ? ";
            if(annee != null){
                req += "AND eleve.annee = '" + annee +"' ";
            }
            if(cycle != null && !"Tous".equals(cycle)){
                req += "AND classe.cycle = '" + cycle +"' ";
            }
            if(classe != null && !"Toutes".equals(classe)){
                req += "AND eleve.classe = '" + classe +"' ";
            }
            if(rechercher != null){
                req += "AND (eleve.matricule LIKE '%" + rechercher +"%' OR eleve.nom_prenom LIKE '%" + rechercher + "%')";
            }
            if(nationalite != null && !"Toutes".equals(nationalite)){
                req += "AND eleve.nationalite = '" + nationalite +"' ";
            }
            if(sexe != null && !"Tous".equals(sexe)){
                req += "AND eleve.sexe = '" + sexe +"' ";
            }
            req += "ORDER BY nom_prenom ASC";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setBoolean(1, true);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                listEleve.add(new Eleve(resultSet.getString("matricule"), resultSet.getString("annee"), resultSet.getString("nom_prenom"), resultSet.getDate("date_de_naissance"), resultSet.getString("lieu_de_naissance"), resultSet.getString("nationalite"), resultSet.getString("contact"), resultSet.getString("sexe"), classeController.getClasse(resultSet.getString("classe"), resultSet.getString("annee")), resultSet.getString("qr_code"), resultSet.getString("photo")));
            }
            return listEleve;
        } catch (SQLException ex) {
            Logger.getLogger(EleveController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //U
    public void setEleve(Eleve o, Eleve n){
        try {
            String req = "UPDATE eleve SET matricule = ?, annee = ?, nom_prenom = ?, date_de_naissance = ?,lieu_de_naissance = ?, nationalite = ?, contact = ?, sexe = ?, classe = ?, qr_code = ?, photo = ? WHERE matricule = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, n.getMatricule());
            preparedStatement.setString(2, n.getAnneeScolaire());
            preparedStatement.setString(3, n.getNom_prenom());
            preparedStatement.setDate(4, n.getDate_de_naissance());
            preparedStatement.setString(5, n.getLieu_de_naissance());
            preparedStatement.setString(6, n.getNationalite());
            preparedStatement.setString(7, n.getContact());
            preparedStatement.setString(8, n.getSexe());
            preparedStatement.setString(9, n.getClasse().getClasse());
            preparedStatement.setString(10, n.getQr_code());
            preparedStatement.setString(11, n.getPhoto());
            preparedStatement.setString(12, o.getMatricule());
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(EleveController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setEleve(String old_matricule, String matricule, String annee, String nom_prenom, Date date, String lieu, String nationalite, String contact, String sexe, String classe, String qr_code, String photo){
        try {
            String req = "UPDATE eleve SET matricule = ?, annee = ?, nom_prenom = ?, date_de_naissance = ?,lieu_de_naissance = ?, nationalite = ?, contact = ?, sexe = ?, classe = ?, qr_code = ?, photo = ? WHERE matricule = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, matricule);
            preparedStatement.setString(2, annee);
            preparedStatement.setString(3, nom_prenom);
            preparedStatement.setDate(4, date);
            preparedStatement.setString(5, lieu);
            preparedStatement.setString(6, nationalite);
            preparedStatement.setString(7, contact);
            preparedStatement.setString(8, sexe);
            preparedStatement.setString(9, classe);
            preparedStatement.setString(10, qr_code);
            preparedStatement.setString(11, photo);
            preparedStatement.setString(12, old_matricule);
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(EleveController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //D
    public void removeEleve(String matricule){
        try {
            String req = "UPDATE eleve SET etat = ? WHERE matricule = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setBoolean(1, false);
            preparedStatement.setString(2, matricule);
            preparedStatement.executeUpdate();
            removeAll(matricule);
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(EleveController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void removeEleve(Eleve e){
        try {
            String req = "UPDATE eleve SET etat = ? WHERE matricule = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setBoolean(1, false);
            preparedStatement.setString(2, e.getMatricule());
            preparedStatement.executeUpdate();
            removeAll(e.getMatricule());
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(EleveController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void removeAll(String matricule) {
        try {
            String req = "DELETE FROM evaluation_matiere WHERE matricule = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, matricule);
            preparedStatement.executeUpdate();
            req = "DELETE FROM evaluation_classe WHERE matricule = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, matricule);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void success_information() {
        JOptionPane.showMessageDialog(null, "Opération effectuée avec succes ", "Réussie !", JOptionPane.INFORMATION_MESSAGE);
    }
    private void error_information(){
        JOptionPane.showMessageDialog(null, "Opération echouée ", "Echec !", JOptionPane.WARNING_MESSAGE);
    }
}
