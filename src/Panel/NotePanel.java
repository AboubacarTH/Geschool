/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panel;

import controller.AnneeScolaireController;
import controller.ClasseController;
import controller.CycleController;
import controller.EvaluationController;
import controller.MatiereController;
import controller.SemestreController;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import rojerusan.RSPanelImage;

/**
 *
 * @author ATH
 */
public class NotePanel extends RSPanelImage {

    /**
     * Creates new form ElevePan
     */
    public NotePanel() {
        
        cycleController = new CycleController();
        classeController = new ClasseController();
        matiereController = new MatiereController();
        semestreController = new SemestreController();
        anneeScolaireController = new AnneeScolaireController();
        evController = new EvaluationController();
        initComponents();
        initCbAnnee();
        try {
            rSComboMetro_annee.setSelectedItem(anneeScolaireController.getAnneeScolaireEnCours());
        } catch (Exception e) {
        }
        
        initCbCycle();
        initCbClasse();
        initCbMatiere();
        initCbSemestre();
        initTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_note = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        rSComboMetro_matiere = new rojerusan.RSComboMetro();
        rSComboMetro_semestre = new rojerusan.RSComboMetro();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        rSMTextFull_recherche = new rojeru_san.RSMTextFull();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        rSComboMetro_annee = new rojerusan.RSComboMetro();
        rSComboMetro_cycle = new rojerusan.RSComboMetro();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        rSComboMetro_classe = new rojerusan.RSComboMetro();
        jPanel3 = new javax.swing.JPanel();
        rSButtonRiple_bulletin_classe = new rojeru_san.RSButtonRiple();
        rSButtonRiple_eleve = new rojeru_san.RSButtonRiple();

        setImagen(new javax.swing.ImageIcon(getClass().getResource("/icon/getty_655998316_2000149920009280219_363765.jpg"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(1100, 579));

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Table des notes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jTable_note.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N??", "CLASSE", "MATRICULE", "NOM ET PRENOM", "MATIERE", "DEVOIR N??1", "DEVOIR N??2", "INTERRO. N??1", "INTERRO. N??2", "COMPOSITION"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_note.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_noteMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable_note);
        if (jTable_note.getColumnModel().getColumnCount() > 0) {
            jTable_note.getColumnModel().getColumn(0).setMinWidth(50);
            jTable_note.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable_note.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable_note.getColumnModel().getColumn(1).setMinWidth(80);
            jTable_note.getColumnModel().getColumn(1).setPreferredWidth(80);
            jTable_note.getColumnModel().getColumn(1).setMaxWidth(80);
            jTable_note.getColumnModel().getColumn(2).setMinWidth(80);
            jTable_note.getColumnModel().getColumn(2).setPreferredWidth(80);
            jTable_note.getColumnModel().getColumn(2).setMaxWidth(80);
            jTable_note.getColumnModel().getColumn(4).setMinWidth(200);
            jTable_note.getColumnModel().getColumn(4).setPreferredWidth(200);
            jTable_note.getColumnModel().getColumn(4).setMaxWidth(200);
            jTable_note.getColumnModel().getColumn(5).setMinWidth(100);
            jTable_note.getColumnModel().getColumn(5).setPreferredWidth(100);
            jTable_note.getColumnModel().getColumn(5).setMaxWidth(100);
            jTable_note.getColumnModel().getColumn(6).setMinWidth(100);
            jTable_note.getColumnModel().getColumn(6).setPreferredWidth(100);
            jTable_note.getColumnModel().getColumn(6).setMaxWidth(100);
            jTable_note.getColumnModel().getColumn(7).setMinWidth(100);
            jTable_note.getColumnModel().getColumn(7).setPreferredWidth(100);
            jTable_note.getColumnModel().getColumn(7).setMaxWidth(100);
            jTable_note.getColumnModel().getColumn(8).setMinWidth(100);
            jTable_note.getColumnModel().getColumn(8).setPreferredWidth(100);
            jTable_note.getColumnModel().getColumn(8).setMaxWidth(100);
            jTable_note.getColumnModel().getColumn(9).setMinWidth(100);
            jTable_note.getColumnModel().getColumn(9).setPreferredWidth(100);
            jTable_note.getColumnModel().getColumn(9).setMaxWidth(100);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        rSComboMetro_matiere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSComboMetro_matiereActionPerformed(evt);
            }
        });

        rSComboMetro_semestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSComboMetro_semestreActionPerformed(evt);
            }
        });

        jLabel7.setText("Mati??re");

        jLabel8.setText("Semestre");

        rSMTextFull_recherche.setPlaceholder("Rechercher");
        rSMTextFull_recherche.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rSMTextFull_rechercheKeyReleased(evt);
            }
        });

        jLabel2.setText("Rechercher");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSMTextFull_recherche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rSComboMetro_matiere, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rSComboMetro_semestre, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSComboMetro_matiere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSComboMetro_semestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSMTextFull_recherche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ann??e");

        rSComboMetro_annee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSComboMetro_anneeActionPerformed(evt);
            }
        });

        rSComboMetro_cycle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSComboMetro_cycleActionPerformed(evt);
            }
        });

        jLabel4.setText("Cycle");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Classe");

        rSComboMetro_classe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSComboMetro_classeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSComboMetro_annee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rSComboMetro_classe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rSComboMetro_cycle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSComboMetro_annee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSComboMetro_cycle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSComboMetro_classe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Impression bulletin"));

        rSButtonRiple_bulletin_classe.setText("BULLETIN CLASSE");
        rSButtonRiple_bulletin_classe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonRiple_bulletin_classeActionPerformed(evt);
            }
        });

        rSButtonRiple_eleve.setBackground(java.awt.Color.gray);
        rSButtonRiple_eleve.setText("BULLETIN ELEVE");
        rSButtonRiple_eleve.setEnabled(false);
        rSButtonRiple_eleve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonRiple_eleveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSButtonRiple_bulletin_classe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSButtonRiple_eleve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSButtonRiple_bulletin_classe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rSButtonRiple_eleve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1088, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rSComboMetro_classeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSComboMetro_classeActionPerformed
        initTable();
    }//GEN-LAST:event_rSComboMetro_classeActionPerformed

    private void rSComboMetro_matiereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSComboMetro_matiereActionPerformed
        initTable();
    }//GEN-LAST:event_rSComboMetro_matiereActionPerformed

    private void rSComboMetro_semestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSComboMetro_semestreActionPerformed
        initTable();
    }//GEN-LAST:event_rSComboMetro_semestreActionPerformed

    private void rSComboMetro_cycleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSComboMetro_cycleActionPerformed
        initCbClasse();
        initTable();
    }//GEN-LAST:event_rSComboMetro_cycleActionPerformed

    private void rSMTextFull_rechercheKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rSMTextFull_rechercheKeyReleased
        initTable();
    }//GEN-LAST:event_rSMTextFull_rechercheKeyReleased

    private void rSComboMetro_anneeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSComboMetro_anneeActionPerformed
        initTable();
    }//GEN-LAST:event_rSComboMetro_anneeActionPerformed

    private void jTable_noteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_noteMouseClicked
        action_bulletin_eleve();
    }//GEN-LAST:event_jTable_noteMouseClicked

    private void rSButtonRiple_eleveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonRiple_eleveActionPerformed
        int row = jTable_note.getSelectedRow();
        evController.getBulletin(jTable_note.getValueAt(row, 2).toString(), rSComboMetro_annee.getSelectedItem().toString(), jTable_note.getValueAt(row, 1).toString(), rSComboMetro_semestre.getSelectedItem().toString());
    }//GEN-LAST:event_rSButtonRiple_eleveActionPerformed

    private void rSButtonRiple_bulletin_classeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonRiple_bulletin_classeActionPerformed
        evController.getBulletin(rSComboMetro_classe.getSelectedItem().toString(), rSComboMetro_annee.getSelectedItem().toString(), rSComboMetro_semestre.getSelectedItem().toString());
    }//GEN-LAST:event_rSButtonRiple_bulletin_classeActionPerformed

    
    private final SemestreController semestreController;
    private final AnneeScolaireController anneeScolaireController;
    private final CycleController cycleController;
    private final ClasseController classeController;
    private final MatiereController matiereController;
    private final EvaluationController evController;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable_note;
    private rojeru_san.RSButtonRiple rSButtonRiple_bulletin_classe;
    private rojeru_san.RSButtonRiple rSButtonRiple_eleve;
    private rojerusan.RSComboMetro rSComboMetro_annee;
    private rojerusan.RSComboMetro rSComboMetro_classe;
    private rojerusan.RSComboMetro rSComboMetro_cycle;
    private rojerusan.RSComboMetro rSComboMetro_matiere;
    private rojerusan.RSComboMetro rSComboMetro_semestre;
    private rojeru_san.RSMTextFull rSMTextFull_recherche;
    // End of variables declaration//GEN-END:variables
    
//    private void success_information() {
//        JOptionPane.showMessageDialog(this, "Op??ration effectu??e avec succes ", "R??ussie !", JOptionPane.INFORMATION_MESSAGE);
//    }
      
    private void initTable(){
        String entete[] = {"N??", "CLASSE", "MATRICULE", "NOM ET PRENOM", "MATIERE", "DEVOIR N??1", "DEVOIR N??2", "INTERRO. N??1", "INTERRO. N??2", "COMPOSITION"};
        DefaultTableModel dt=new DefaultTableModel(null,entete);
        dt.setRowCount(0);
        if(rSComboMetro_semestre.getSelectedIndex() < 0 || rSComboMetro_annee.getSelectedIndex() < 0 || rSComboMetro_classe.getSelectedIndex() < 0 || rSComboMetro_matiere.getSelectedIndex() < 0 || rSComboMetro_semestre.getSelectedIndex() < 0){
            return;
        }
        action_bulletin_classe();
        action_bulletin_eleve();
        String annee = null, cycle = null, classe = null, rechercher = null, matiere = null;
        if(rSComboMetro_annee.getSelectedIndex() > -1){
            annee = rSComboMetro_annee.getSelectedItem().toString();
        }
        if(rSComboMetro_cycle.getSelectedIndex() > -1){
            cycle = rSComboMetro_cycle.getSelectedItem().toString();
        }
        if(rSComboMetro_classe.getSelectedIndex() > -1){
            classe = rSComboMetro_classe.getSelectedItem().toString();
        }
        if(rSComboMetro_matiere.getSelectedIndex() > -1){
            matiere = rSComboMetro_matiere.getSelectedItem().toString();
        }
        if(rSMTextFull_recherche.getText().length() > 0){
            rechercher = rSMTextFull_recherche.getText();
        }
        ArrayList<bean.Note> list = evController.getColonnes(annee, cycle, classe, matiere, rechercher);
        
        double note;
        for(int i = 0; i< list.size(); i++){
            Object colonne[]= new Object[10];
            colonne[0] = i + 1;
            colonne[1] = list.get(i).getMatiereClasse().getClasse().getClasse();
            colonne[2] = list.get(i).getEleve().getMatricule();
            colonne[3] = list.get(i).getEleve().getNom_prenom();
            colonne[4] = list.get(i).getMatiereClasse().getMatiere().getMatiere();
            note = evController.getMatiereNote(rSComboMetro_semestre.getSelectedItem().toString(), list.get(i), "DEVOIR N??1");
            colonne[5] = note == 0.00? "" : note;
            note = evController.getMatiereNote(rSComboMetro_semestre.getSelectedItem().toString(), list.get(i), "DEVOIR N??2");
            colonne[6] = note == 0.00? "" : note;
            note = evController.getMatiereNote(rSComboMetro_semestre.getSelectedItem().toString(), list.get(i), "INTERRO. N??1");
            colonne[7] = note == 0.00? "" : note;
            note = evController.getMatiereNote(rSComboMetro_semestre.getSelectedItem().toString(), list.get(i), "INTERRO. N??2");
            colonne[8] = note == 0.00? "" : note;
            note = evController.getMatiereNote(rSComboMetro_semestre.getSelectedItem().toString(), list.get(i), "COMPOSITION");
            colonne[9] = note == 0.00? "" : note;
            dt.addRow(colonne);
        }
        this.jTable_note.setModel(dt);
        if (jTable_note.getColumnModel().getColumnCount() > 0) {
            jTable_note.getColumnModel().getColumn(0).setMinWidth(50);
            jTable_note.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable_note.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable_note.getColumnModel().getColumn(1).setMinWidth(80);
            jTable_note.getColumnModel().getColumn(1).setPreferredWidth(80);
            jTable_note.getColumnModel().getColumn(1).setMaxWidth(80);
            jTable_note.getColumnModel().getColumn(2).setMinWidth(80);
            jTable_note.getColumnModel().getColumn(2).setPreferredWidth(80);
            jTable_note.getColumnModel().getColumn(2).setMaxWidth(80);
            jTable_note.getColumnModel().getColumn(4).setMinWidth(200);
            jTable_note.getColumnModel().getColumn(4).setPreferredWidth(200);
            jTable_note.getColumnModel().getColumn(4).setMaxWidth(200);
            jTable_note.getColumnModel().getColumn(5).setMinWidth(100);
            jTable_note.getColumnModel().getColumn(5).setPreferredWidth(100);
            jTable_note.getColumnModel().getColumn(5).setMaxWidth(100);
            jTable_note.getColumnModel().getColumn(6).setMinWidth(100);
            jTable_note.getColumnModel().getColumn(6).setPreferredWidth(100);
            jTable_note.getColumnModel().getColumn(6).setMaxWidth(100);
            jTable_note.getColumnModel().getColumn(7).setMinWidth(100);
            jTable_note.getColumnModel().getColumn(7).setPreferredWidth(100);
            jTable_note.getColumnModel().getColumn(7).setMaxWidth(100);
            jTable_note.getColumnModel().getColumn(8).setMinWidth(100);
            jTable_note.getColumnModel().getColumn(8).setPreferredWidth(100);
            jTable_note.getColumnModel().getColumn(8).setMaxWidth(100);
            jTable_note.getColumnModel().getColumn(9).setMinWidth(100);
            jTable_note.getColumnModel().getColumn(9).setPreferredWidth(100);
            jTable_note.getColumnModel().getColumn(9).setMaxWidth(100);
            jTable_note.setRowHeight(30);
            this.jTable_note.getModel().addTableModelListener((TableModelEvent e) -> {
                mise_a_jour_note();
            });
        }
    }
    private void initCbAnnee(){
        rSComboMetro_annee.removeAllItems();
        anneeScolaireController.getListAnneeScolaire().forEach((a) -> {
            rSComboMetro_annee.addItem(a.getAnnee());
        });
    }
    private void initCbCycle(){
        rSComboMetro_cycle.removeAllItems();
        cycleController.getListCycle().forEach((c) -> {
            rSComboMetro_cycle.addItem(c);
        });
        
    }
    private void initCbClasse() {
        rSComboMetro_classe.removeAllItems();
        String cycle = null;
        if(rSComboMetro_annee.getSelectedIndex() < 0){
            return;
        }
        if(rSComboMetro_cycle.getSelectedIndex() > -1){
            cycle = rSComboMetro_cycle.getSelectedItem().toString();
        }
        classeController.getListClasse(rSComboMetro_annee.getSelectedItem().toString(), cycle).forEach((c) -> {
        rSComboMetro_classe.addItem(c.getClasse());
        });        
        if(rSComboMetro_classe.getItemCount() > 1){
            rSComboMetro_classe.addItem("Toutes");
        }
    }
    private void initCbMatiere(){
        rSComboMetro_matiere.removeAllItems();
        rSComboMetro_matiere.addItem("Toutes");
        matiereController.getListMatiere().forEach((c) -> {
            rSComboMetro_matiere.addItem(c.getMatiere());
        });
    }
    private void initCbSemestre(){
        rSComboMetro_semestre.removeAllItems();
        semestreController.getListSemestre().forEach((s) -> {
            rSComboMetro_semestre.addItem(s.getSemestre());
        });
    }

    private void mise_a_jour_note() {
        int row = jTable_note.getSelectedRow();
        int col = jTable_note.getSelectedColumn();        
        if(col < 5){
            initTable();
            return;
        }
        double valeur;
        try {
            valeur = Double.parseDouble(jTable_note.getValueAt(row, col).toString());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valeur incorrect !\nSaisissez uniquement des chiffres !\nMettre un point a la place de virgule.", "Valeur incorrecte ", JOptionPane.INFORMATION_MESSAGE);
            initTable();
            return;
        }
        if(valeur < 0.00 || valeur > 20.00){
            JOptionPane.showMessageDialog(this, "Valeur incorrect !\nLa note ?? saisir doit ??tre incluse entre 0 et 20!", "Valeur incorrecte ", JOptionPane.INFORMATION_MESSAGE);
            initTable();
            return;
        }
        evController.addMatiereNote(rSComboMetro_annee.getSelectedItem().toString(), jTable_note.getValueAt(row, 1).toString(), jTable_note.getValueAt(row, 4).toString(), rSComboMetro_semestre.getSelectedItem().toString(), jTable_note.getValueAt(row, 2).toString(), jTable_note.getModel().getColumnName(col), valeur);
    }

    private void action_bulletin_classe() {
        if(rSComboMetro_classe.getSelectedIndex() < 0){
            rSButtonRiple_bulletin_classe.setEnabled(false);
            rSButtonRiple_bulletin_classe.setBackground(Color.gray);
            return;
        }
        if(!"Toutes".equals(rSComboMetro_classe.getSelectedItem().toString())){
            rSButtonRiple_bulletin_classe.setEnabled(true);
            rSButtonRiple_bulletin_classe.setBackground(Color.blue);
        }else{
            rSButtonRiple_bulletin_classe.setEnabled(false);
            rSButtonRiple_bulletin_classe.setBackground(Color.gray);
        }
    }
    private void action_bulletin_eleve() {
        if(jTable_note.getSelectedRow() < 0){
            rSButtonRiple_eleve.setEnabled(false);
            rSButtonRiple_eleve.setBackground(Color.gray);
        }else{
            rSButtonRiple_eleve.setEnabled(true);
            rSButtonRiple_eleve.setBackground(Color.blue);
        }
    }
}
