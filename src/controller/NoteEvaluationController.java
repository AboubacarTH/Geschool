/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.NoteEvaluationClasse;
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
public class NoteEvaluationController {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private final EleveController eleveController;
    private final ClasseController classeController;
    private final SemestreController semestreController;
    public NoteEvaluationController(Connection connection) {
        this.connection = connection;
        eleveController = new EleveController();
        classeController = new ClasseController();
        semestreController = new SemestreController();
    }
    public NoteEvaluationController(){
        this.connection = MainForm.getConnection();
        eleveController = new EleveController();
        classeController = new ClasseController();
        semestreController = new SemestreController();
    }
    public void setConnection(Connection connection){
        this.connection = connection;
    }
    public ArrayList<NoteEvaluationClasse> getColonnesEvaluationClasse(String annee, String cycle, String classe, String matiere, String rechercher){
        ArrayList<NoteEvaluationClasse> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM evaluation_classe JOIN classe ON evaluation_classe.classe = evaluation_classe.classe AND evaluation_classe.annee = classe.annee JOIN eleve ON "
                    + "evaluation_classe.matricule = eleve.matricule "
                    + "WHERE eleve.etat = ? ";
            if(annee != null && !"Toutes".equals(annee)){
                req += "AND eleve.annee = '" + annee +"' ";
            }
            if(cycle != null && !"Tous".equals(cycle)){
                req += "AND classe.cycle = '" + cycle +"' ";
            }
            if(classe != null && !"Toutes".equals(classe)){
                req += "AND eleve.classe = '" + classe +"' ";
            }
            if(matiere != null && !"Toutes".equals(matiere)){
                req += "AND matiere_classe.matiere = '" + matiere +"' ";
            }
            if(rechercher != null){
                req += "AND (eleve.matricule LIKE  = '%" + rechercher +"%' OR eleve.nom_prenom LIKE = '%" + rechercher + "%')";
            }
            req += "ORDER BY evaluation_classe.moyenne DESC";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setBoolean(1, true);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                list.add(new NoteEvaluationClasse(eleveController.getEleve(resultSet.getString("matricule")), classeController.getClasse(resultSet.getString("classe"), resultSet.getString("annee")), semestreController.getSemestre(resultSet.getString("semestre"))));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
