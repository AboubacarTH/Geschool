/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.EvaluationClasse;
import bean.EvaluationMatiere;
import bean.Note;
import form.MainForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ATH
 */
public class EvaluationController {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private final MatiereClasseController matiereClasseController;
    private final EleveController eleveController;
    private final SemestreController semestreController;
    private final ClasseController classeController;
    public EvaluationController(){
        this.connection = MainForm.getConnection();
        this.eleveController = new EleveController();
        this.matiereClasseController = new MatiereClasseController();
        this.semestreController = new SemestreController();
        this.classeController = new ClasseController();
    }
    public void setConnection(Connection connection){
        this.connection = connection;
    }
    //C
    public void addMatiereNote(String annee, String classe, String matiere, String semestre, String matricule, String type_evaluation, double note){
        if(getEvaluationMatiere(annee, classe, matiere, semestre, matricule) == null){
            creatEvaluationMatiere(annee, classe, matiere, semestre, matricule);
        }
        if(getEvaluationClasse(annee, classe, semestre, matricule) == null){
            creatEvaluationClasse(annee, classe, semestre, matricule);
        }
        String type = "";
        switch(type_evaluation){
            case "DEVOIR N°1" :
                type = "devoir_1";
                break;
            case "DEVOIR N°2" :
                type = "devoir_2";
                break;
            case "INTERRO. N°1" :
                type = "interro_1";
                break;
            case "INTERRO. N°2" :
                type = "interro_2";
                break;
            case "COMPOSITION" :
                type = "composition";
                break;
        }
        try {
            String req = "UPDATE evaluation_matiere SET "+ type +" = ? WHERE annee = ? AND classe = ? AND matiere = ? AND semestre = ? AND matricule = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setDouble(1, note);
            preparedStatement.setString(2, annee);
            preparedStatement.setString(3, classe);
            preparedStatement.setString(4, matiere);
            preparedStatement.setString(5, semestre);
            preparedStatement.setString(6, matricule);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //
        updateMatiereMoyenneAppreciation(annee, classe, matiere, semestre, matricule);
        updateMatiereRang(annee, classe, matiere, semestre);
        updateEvaluationClasseMoyenneMoyenneLettre(matricule, classe, annee, semestre);
        updateClasseRang(annee, classe, semestre);
    }
    public double getMatiereNote(String annee, String classe, String matiere, String semestre, String matricule, String type_evaluation){
        if(getEvaluationMatiere(annee, classe, matiere, semestre, matricule) == null){
            creatEvaluationMatiere(annee, classe, matiere, semestre, matricule);
        }
        String type = "";
        switch(type_evaluation){
            case "DEVOIR N°1" :
                type = "devoir_1";
                break;
            case "DEVOIR N°2" :
                type = "devoir_2";
                break;
            case "INTERRO. N°1" :
                type = "interro_1";
                break;
            case "INTERRO. N°2" :
                type = "interro_2";
                break;
            case "COMPOSITION" :
                type = "composition";
                break;
        }
        try {
            String req = "SELECT "+ type +" FROM evaluation_matiere WHERE annee = ? AND classe = ? AND matiere = ? AND semestre = ? AND matricule = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, annee);
            preparedStatement.setString(2, classe);
            preparedStatement.setString(3, matiere);
            preparedStatement.setString(4, semestre);
            preparedStatement.setString(5, matricule);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return resultSet.getDouble(type);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1.0;
    }
    public double getMatiereNote(String semestre, Note note, String type_evaluation){
        if(getEvaluationMatiere(note.getMatiereClasse().getClasse().getAnnee(), note.getMatiereClasse().getClasse().getClasse(), note.getMatiereClasse().getMatiere().getMatiere(), semestre, note.getEleve().getMatricule()) == null){
            creatEvaluationMatiere(note.getMatiereClasse().getClasse().getAnnee(), note.getMatiereClasse().getClasse().getClasse(), note.getMatiereClasse().getMatiere().getMatiere(), semestre, note.getEleve().getMatricule());
        }
        String type = "";
        switch(type_evaluation){
            case "DEVOIR N°1" :
                type = "devoir_1";
                break;
            case "DEVOIR N°2" :
                type = "devoir_2";
                break;
            case "INTERRO. N°1" :
                type = "interro_1";
                break;
            case "INTERRO. N°2" :
                type = "interro_2";
                break;
            case "COMPOSITION" :
                type = "composition";
                break;
        }
        try {
            String req = "SELECT " + type +" FROM evaluation_matiere WHERE annee = ? AND classe = ? AND matiere = ? AND semestre = ? AND matricule = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, note.getMatiereClasse().getClasse().getAnnee());
            preparedStatement.setString(2, note.getMatiereClasse().getClasse().getClasse());
            preparedStatement.setString(3, note.getMatiereClasse().getMatiere().getMatiere());
            preparedStatement.setString(4, semestre);
            preparedStatement.setString(5, note.getEleve().getMatricule());
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return resultSet.getDouble(type);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1.00;
    }
    
    //R
    public EvaluationMatiere getEvaluationMatiere(String annee, String classe, String matiere, String semestre, String matricule){
        try {
            String req = "SELECT classe, annee, matiere, matricule, semestre FROM evaluation_matiere WHERE annee = ? AND classe = ? AND matiere = ? AND semestre = ? AND matricule = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, annee);
            preparedStatement.setString(2, classe);
            preparedStatement.setString(3, matiere);
            preparedStatement.setString(4, semestre);
            preparedStatement.setString(5, matricule);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new EvaluationMatiere(matiereClasseController.getMatiereClasse(classe, annee, matiere), eleveController.getEleve(matricule), semestreController.getSemestre(semestre));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void creatEvaluationMatiere(String annee, String classe, String matiere, String semestre, String matricule){
        try {
            String req = "INSERT INTO evaluation_matiere (annee, classe, matiere, semestre, matricule) VALUES (?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, annee);
            preparedStatement.setString(2, classe);
            preparedStatement.setString(3, matiere);
            preparedStatement.setString(4, semestre);
            preparedStatement.setString(5, matricule);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public EvaluationClasse getEvaluationClasse(String annee, String classe, String semestre, String matricule){
        try {
            String req = "SELECT matricule, classe, annee, semestre FROM evaluation_classe WHERE matricule = ? AND classe = ? AND annee = ? AND semestre = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, matricule);
            preparedStatement.setString(2, classe);
            preparedStatement.setString(3, annee);
            preparedStatement.setString(4, semestre);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new EvaluationClasse(classeController.getClasse(resultSet.getString("classe"), resultSet.getString("annee")), eleveController.getEleve(resultSet.getString("matricule")), semestreController.getSemestre(resultSet.getString("semestre")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void creatEvaluationClasse(String annee, String classe, String semestre, String matricule){
        try {
            String req = "INSERT INTO evaluation_classe (matricule, classe, annee, semestre) VALUES (?,?,?,?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, matricule);
            preparedStatement.setString(2, classe);
            preparedStatement.setString(3, annee);
            preparedStatement.setString(4, semestre);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Note> getColonnes(String annee, String cycle, String classe, String matiere, String rechercher){
        ArrayList<Note> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM eleve JOIN matiere_classe ON "
                    + "eleve.classe = matiere_classe.classe AND eleve.annee = matiere_classe.annee JOIN classe ON eleve.classe = classe.classe AND eleve.annee = classe.annee WHERE eleve.etat = ? ";
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
            req += "ORDER BY eleve.nom_prenom ASC";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setBoolean(1, true);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                list.add(new Note(eleveController.getEleve(resultSet.getString("matricule")), matiereClasseController.getMatiereClasse(resultSet.getString("classe"), resultSet.getString("annee"), resultSet.getString("matiere"))));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private void success_information() {
        JOptionPane.showMessageDialog(null, "Opération effectuée avec succes ", "Réussie !", JOptionPane.INFORMATION_MESSAGE);
    }
    private void error_information(){
        JOptionPane.showMessageDialog(null, "Opération echouée ", "Echec !", JOptionPane.WARNING_MESSAGE);
    }

    private void updateMatiereMoyenneAppreciation(String annee, String classe, String matiere, String semestre, String matricule) {
        try {
            String req = "SELECT devoir_1, devoir_2, interro_1, interro_2, composition, matiere_classe.coefficient FROM evaluation_matiere JOIN matiere_classe ON "
                    + "evaluation_matiere.matiere = matiere_classe.matiere AND evaluation_matiere.classe = matiere_classe.classe AND evaluation_matiere.annee = matiere_classe.annee "
                    + "WHERE evaluation_matiere.annee = ? AND evaluation_matiere.classe = ? AND evaluation_matiere.matiere = ? AND semestre = ? AND matricule = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, annee);
            preparedStatement.setString(2, classe);
            preparedStatement.setString(3, matiere);
            preparedStatement.setString(4, semestre);
            preparedStatement.setString(5, matricule);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                double devoir_1 = resultSet.getDouble("devoir_1");
                double devoir_2 = resultSet.getDouble("devoir_2");
                double interro_1 = resultSet.getDouble("interro_1");
                double interro_2 = resultSet.getDouble("interro_1");
                double composition = resultSet.getDouble("composition");
                int coefficient = resultSet.getInt("coefficient");
                double moyenne_classe;
                double moyenne;
                double note_devoir;
                double note_interro;
                if(devoir_1 == 0.00 || devoir_2 == 0.00){
                    note_devoir = devoir_1 + devoir_2;
                }else{
                    note_devoir = (devoir_1 + devoir_2)/2;
                }
                if(interro_1 == 0.00 || interro_2 == 0.00){
                    note_interro = interro_1 + devoir_2;
                }else{
                    note_interro = (interro_1 + interro_2)/2;
                }
                if(note_interro != 0.00){
                    moyenne_classe = (2*note_devoir + note_interro)/3;
                }else{
                    moyenne_classe = note_devoir;
                }
                if(composition != 0){
                    moyenne = (moyenne_classe + composition)/2;
                }else{
                    moyenne = moyenne_classe;
                }
                String appreciation = "Médiocre";
                if(moyenne > 17.99){
                    appreciation = "Excellent";
                }else if(moyenne > 15.99){
                    appreciation = "Très bien";
                }
                else if(moyenne > 13.99){
                    appreciation = "Bien";
                }
                else if(moyenne > 11.99){
                    appreciation = "Assez bien";
                }
                else if(moyenne > 9.99){
                    appreciation = "Passable";
                }
                req = "UPDATE evaluation_matiere SET coefficient = ?, moyenne_classe = ?, moyenne = ?, appreciation = ?, note_coefficient = ? WHERE annee = ? AND classe = ? AND matiere = ? AND semestre = ? AND matricule = ?";
                preparedStatement = connection.prepareStatement(req);
                preparedStatement.setInt(1, coefficient);
                preparedStatement.setDouble(2, moyenne_classe);
                preparedStatement.setDouble(3, moyenne);
                preparedStatement.setString(4, appreciation);
                preparedStatement.setDouble(5, moyenne * coefficient);
                preparedStatement.setString(6, annee);
                preparedStatement.setString(7, classe);
                preparedStatement.setString(8, matiere);
                preparedStatement.setString(9, semestre);
                preparedStatement.setString(10, matricule);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void updateMatiereRang(String annee, String classe, String matiere, String semestre) {
        try {
            String req = "SELECT moyenne FROM evaluation_matiere WHERE annee = ? AND classe =? AND matiere = ? AND semestre = ? GROUP BY moyenne ORDER BY moyenne DESC";
            preparedStatement =  connection.prepareStatement(req);
            preparedStatement.setString(1, annee);
            preparedStatement.setString(2, classe);
            preparedStatement.setString(3, matiere);
            preparedStatement.setString(4, semestre);
            preparedStatement.execute();
            int rang = 1;
            int compteur = 0;
            String rangString = "";
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                rang += compteur;
                compteur = 0;
                req = "SELECT COUNT(matricule) FROM evaluation_matiere WHERE annee = ? AND classe = ? AND matiere = ? AND semestre = ? AND moyenne = ? ";
                preparedStatement =  connection.prepareStatement(req);
                preparedStatement.setString(1, annee);
                preparedStatement.setString(2, classe);
                preparedStatement.setString(3, matiere);
                preparedStatement.setString(4, semestre);
                preparedStatement.setDouble(5, resultSet.getDouble("moyenne"));
                preparedStatement.execute();
                ResultSet rs = preparedStatement.getResultSet();
                if(rs.next()){
                    if(rs.getInt(1) == 1){
                        rangString = rang + "e";
                    }else{
                        rangString = rang + "ex";
                    }
                    compteur = rs.getInt(1);
                }
                req = "UPDATE evaluation_matiere SET rang = ? WHERE annee = ? AND classe = ? AND matiere = ? AND semestre = ? AND moyenne = ?";
                preparedStatement =  connection.prepareStatement(req);
                preparedStatement.setString(1, rangString);
                preparedStatement.setString(2, annee);
                preparedStatement.setString(3, classe);
                preparedStatement.setString(4, matiere);
                preparedStatement.setString(5, semestre);
                preparedStatement.setDouble(6, resultSet.getDouble("moyenne"));
                preparedStatement.executeUpdate();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void updateClasseRang(String annee, String classe, String semestre) {
        try {
            String req = "SELECT moyenne FROM evaluation_classe WHERE annee = ? AND classe =? AND semestre = ? GROUP BY moyenne ORDER BY moyenne DESC";
            preparedStatement =  connection.prepareStatement(req);
            preparedStatement.setString(1, annee);
            preparedStatement.setString(2, classe);
            preparedStatement.setString(3, semestre);
            preparedStatement.execute();
            int rang = 1;
            int compteur = 0;
            String rangString = "";
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                rang += compteur;
                compteur = 0;
                req = "SELECT COUNT(matricule) FROM evaluation_classe WHERE annee = ? AND classe = ? AND semestre = ? AND moyenne = ? ";
                preparedStatement =  connection.prepareStatement(req);
                preparedStatement.setString(1, annee);
                preparedStatement.setString(2, classe);
                preparedStatement.setString(3, semestre);
                preparedStatement.setDouble(4, resultSet.getDouble("moyenne"));
                preparedStatement.execute();
                ResultSet rs = preparedStatement.getResultSet();
                if(rs.next()){
                    if(rs.getInt(1) == 1){
                        rangString = rang + "e";
                    }else{
                        rangString = rang + "ex";
                    }
                    compteur = rs.getInt(1);
                }
                req = "UPDATE evaluation_classe SET rang = ? WHERE annee = ? AND classe = ? AND semestre = ? AND moyenne = ?";
                preparedStatement =  connection.prepareStatement(req);
                preparedStatement.setString(1, rangString);
                preparedStatement.setString(2, annee);
                preparedStatement.setString(3, classe);
                preparedStatement.setString(4, semestre);
                preparedStatement.setDouble(5, resultSet.getDouble("moyenne"));
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void getBulletin(String matricule, String annee, String classe, String semestre){
        try{
            HashMap<String, Object> m = new HashMap<>();
            String reports;
            if(classe.contains("TA") || classe.contains("TleA") || classe.contains("2ndeC") || classe.contains("1ereD") || classe.contains("1èreD")){
                reports = "bulletin_ta.jrxml";
            }else if(classe.contains("6ème") || classe.contains("6eme") || classe.contains("1ereA") || classe.contains("1èreA")){
                reports = "bulletin_6.jrxml";
            }else{
                reports = "bulletin_td.jrxml";
            }
            
            System.out.println(reports);
            
            m.put("annee", annee);
            m.put("semestre", semestre);
            m.put("classe", classe);
            m.put("matricule", matricule);
            JasperDesign jd = JRXmlLoader.load(getClass().getResourceAsStream("/report/" + reports));
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, m, connection);
            JasperViewer.viewReport(jp, false);

        }catch(JRException ex){
            JOptionPane.showMessageDialog(null," Echec d'impression du Rélévé de note\n" +ex.getMessage());
        }   
    }
    public void getBulletin(String classe, String annee, String semestre) {
        String req = "SELECT matricule FROM evaluation_classe WHERE classe = ? AND annee = ? AND semestre = ? GROUP BY matricule ORDER BY moyenne DESC";
        ArrayList<String> listMatricule = new ArrayList <>();
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, classe);
            preparedStatement.setString(2, annee);
            preparedStatement.setString(3, semestre);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                listMatricule.add(resultSet.getString("matricule"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            HashMap<String, Object> m = new HashMap<>();
            String reports;
            if(classe.contains("TA") || classe.contains("TleA") || classe.contains("2ndeC") || classe.contains("1ereD") || classe.contains("1èreD")){
                reports = "bulletin_ta.jrxml";
            }else if(classe.contains("6ème") || classe.contains("6eme") || classe.contains("1ereA") || classe.contains("1èreA")){
                reports = "bulletin_6.jrxml";
            }else{
                reports = "bulletin_td.jrxml";
            }
            m.put("annee", annee);
            m.put("semestre", semestre);
            m.put("classe", classe);
            m.put("id_eleve", 0);
            JasperDesign jd = JRXmlLoader.load(getClass().getResourceAsStream("/report/" + reports));
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, m, connection);
            listMatricule.forEach((id) -> {
                HashMap<String, Object> mp = new HashMap<>();
                mp.put("annee", annee);
                mp.put("semestre", semestre);
                mp.put("classe", classe);
                mp.put("matricule", id);
                try {
                    JasperPrint jp2 = JasperFillManager.fillReport(jr, mp, connection);
                    jp.addPage(jp2.getPages().get(0));
                } catch (JRException ex) {
                    Logger.getLogger(EvaluationController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            });
            JasperViewer.viewReport(jp, false);

        }catch(JRException ex){
            JOptionPane.showMessageDialog(null," Echec d'impression du Rélévé de note\n" +ex.getMessage());
        }   
    }
    private void updateEvaluationClasseMoyenneMoyenneLettre(String matricule, String classe, String annee, String semestre){
        try {
            String req = "SELECT SUM(note_coefficient) AS sommeMoyenne, SUM(coefficient) AS sommeCoefficient FROM evaluation_matiere "
                    + "WHERE evaluation_matiere.matricule = ? AND evaluation_matiere.classe = ? AND evaluation_matiere.annee = ? AND evaluation_matiere.semestre = ? AND coefficient IS NOT NULL";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, matricule);
            preparedStatement.setString(2, classe);
            preparedStatement.setString(3, annee);
            preparedStatement.setString(4, semestre);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            double moyenne = 0.00;
            if(resultSet.next()){
                moyenne  = resultSet.getDouble("sommeMoyenne") / resultSet.getDouble("sommeCoefficient");
            }
            
            String moyenneLettre = "";
            req = "UPDATE evaluation_classe SET moyenne = ? WHERE matricule = ? AND classe = ? AND annee = ? AND semestre = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setDouble(1, moyenne);
            preparedStatement.setString(2, matricule);
            preparedStatement.setString(3, classe);
            preparedStatement.setString(4, annee);
            preparedStatement.setString(5, semestre);
            preparedStatement.executeUpdate();
            req = "SELECT moyenne FROM evaluation_classe WHERE matricule = ? AND classe = ? AND annee = ? AND semestre = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, matricule);
            preparedStatement.setString(2, classe);
            preparedStatement.setString(3, annee);
            preparedStatement.setString(4, semestre);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                moyenne = resultSet.getDouble("moyenne");
                moyenneLettre = getMoyenneLettre(moyenne);
            }
            req = "UPDATE evaluation_classe SET moyenne_lettre = ? WHERE matricule = ? AND classe = ? AND annee = ? AND semestre = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, moyenneLettre);
            preparedStatement.setString(2, matricule);
            preparedStatement.setString(3, classe);
            preparedStatement.setString(4, annee);
            preparedStatement.setString(5, semestre);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String getMoyenneLettre(double moy) {
        String convert = "";
        String[] group_unit = {"", "un", "deux", "trois", "quatre", "cinq", "six", "sept", "huit", "neuf", "dix", "onze", "douze", "treize", "quatorze", "quinze", "seize", "dix sept", "dix huit", "dix neuf"};
        String[] group_diz = {"", "dix", "vingt", "trente", "quarante", "cinquante", "soixante", "soixante", "quatre vingt", "quatre vingt"};
        String moyenne = moy + "";
        //12.80
        System.out.println(moyenne + " "+ moy);
        try {
            switch(moyenne.length()){
                case 1 :
                    convert = group_unit[Integer.valueOf(moyenne)];
                    convert = convert.substring(0, 1).toUpperCase() + convert.substring(1);
                    break;
                case 2 :
                    convert = group_unit[Integer.valueOf(moyenne)];
                    convert = convert.substring(0, 1).toUpperCase() + convert.substring(1);
                    break;
                case 3 :
                    convert = group_unit[Integer.valueOf(moyenne.substring(0, 2))];
                    convert = convert.substring(0, 1).toUpperCase() + convert.substring(1);
                    break;
                case 4:
                    int indexVirgule = moyenne.indexOf(".");
                    convert = group_unit[Integer.valueOf(moyenne.substring(0, indexVirgule))] + " ";
                    convert += "virgule ";
                    convert += group_diz[Integer.valueOf(moyenne.substring(indexVirgule + 1, indexVirgule + 2))] + " ";
                    if("7".equals(moyenne.substring(indexVirgule + 1, indexVirgule + 2)) || "9".equals(moyenne.substring(indexVirgule + 1, indexVirgule + 2))){
                        convert += group_unit[Integer.valueOf(moyenne.substring(indexVirgule + 2)) + 10];
                    }else{
                        convert += group_unit[Integer.valueOf(moyenne.substring(indexVirgule + 2))];
                    }
                    convert = convert.substring(0, 1).toUpperCase() + convert.substring(1);
                    break;
                case 5:
                    convert = group_unit[Integer.valueOf(moyenne.substring(0, 2))] + " ";
                    convert += "virgule ";
                    convert += group_diz[Integer.valueOf(moyenne.substring(3, 4))] + " ";
                    if("7".equals(moyenne.substring(3, 4)) || "9".equals(moyenne.substring(3, 4))){
                        convert += group_unit[Integer.valueOf(moyenne.substring(4)) + 10];
                    }else{
                        convert += group_unit[Integer.valueOf(moyenne.substring(4))];
                    }
                    
                    convert = convert.substring(0, 1).toUpperCase() + convert.substring(1);
                    break;
            }
        } catch (Exception e) {
        }
        return convert;
    }
}
