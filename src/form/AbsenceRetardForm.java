/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import bean.AbsenceRetard;
import bean.Classe;
import controller.AbsenceRetardController;
import controller.AnneeScolaireController;
import controller.ClasseController;
import controller.CycleController;
import controller.EleveController;
import dialog.ContacterDialog;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ATH
 */
public class AbsenceRetardForm extends javax.swing.JFrame {

    /**
     * Creates new form RetardForm
     */
    public AbsenceRetardForm() {
        absenceRetardController = new AbsenceRetardController();
        cycleController = new CycleController();
        classeController = new ClasseController();
        anneeScolaireController = new AnneeScolaireController();
        eleveController = new EleveController();
        initComponents();
        initCbAnnee();
        initCbCycle();
        initCbClasse();
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

        popup_menu = new javax.swing.JPopupMenu();
        menu_item_detail = new javax.swing.JMenuItem();
        menu_item_contacter = new javax.swing.JMenuItem();
        menu_item_retirer = new javax.swing.JMenuItem();
        rSPanelImage1 = new rojerusan.RSPanelImage();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rSComboMetro_cycle = new rojerusan.RSComboMetro();
        jLabel2 = new javax.swing.JLabel();
        rSComboMetro_classe = new rojerusan.RSComboMetro();
        rSComboMetro_absence_retard = new rojerusan.RSComboMetro();
        rSComboMetro_annee = new rojerusan.RSComboMetro();
        jLabel3 = new javax.swing.JLabel();
        rSMTextFull_recherche = new rojeru_san.RSMTextFull();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_eleve = new javax.swing.JTable();
        btn_nouveau = new rojeru_san.RSButton();

        menu_item_detail.setText("Voir détail");
        menu_item_detail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_detailActionPerformed(evt);
            }
        });
        popup_menu.add(menu_item_detail);

        menu_item_contacter.setText("Contacter le parent ou tuteur");
        menu_item_contacter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_contacterActionPerformed(evt);
            }
        });
        popup_menu.add(menu_item_contacter);

        menu_item_retirer.setText("Retirer");
        menu_item_retirer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_retirerActionPerformed(evt);
            }
        });
        popup_menu.add(menu_item_retirer);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Absence - Retard");
        setMinimumSize(new java.awt.Dimension(1000, 558));
        setResizable(false);

        rSPanelImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/icon/getty_655998316_2000149920009280219_363765.jpg"))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Selection", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel1.setText("Cycle");

        rSComboMetro_cycle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSComboMetro_cycleActionPerformed(evt);
            }
        });

        jLabel2.setText("Classe");

        rSComboMetro_classe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSComboMetro_classeActionPerformed(evt);
            }
        });

        rSComboMetro_absence_retard.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Absence", "Retard" }));
        rSComboMetro_absence_retard.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rSComboMetro_absence_retard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSComboMetro_absence_retardActionPerformed(evt);
            }
        });

        rSComboMetro_annee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSComboMetro_anneeActionPerformed(evt);
            }
        });

        jLabel3.setText("Année");

        rSMTextFull_recherche.setPlaceholder("");
        rSMTextFull_recherche.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rSMTextFull_rechercheKeyReleased(evt);
            }
        });

        jLabel4.setText("Recherche");

        jLabel5.setText("Absence/Retard");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSComboMetro_annee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSComboMetro_cycle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSComboMetro_classe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSComboMetro_absence_retard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSMTextFull_recherche, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSComboMetro_annee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(rSComboMetro_absence_retard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rSComboMetro_cycle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rSComboMetro_classe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(rSMTextFull_recherche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jTable_eleve.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "N°", "MATRICULE", "NOM ET PRENOM", "DATE", "COMMENTAIRE", "ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_eleve.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable_eleveMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_eleve);
        if (jTable_eleve.getColumnModel().getColumnCount() > 0) {
            jTable_eleve.getColumnModel().getColumn(0).setMinWidth(50);
            jTable_eleve.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable_eleve.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable_eleve.getColumnModel().getColumn(1).setMinWidth(80);
            jTable_eleve.getColumnModel().getColumn(1).setPreferredWidth(80);
            jTable_eleve.getColumnModel().getColumn(1).setMaxWidth(80);
            jTable_eleve.getColumnModel().getColumn(3).setMinWidth(150);
            jTable_eleve.getColumnModel().getColumn(3).setPreferredWidth(150);
            jTable_eleve.getColumnModel().getColumn(3).setMaxWidth(150);
            jTable_eleve.getColumnModel().getColumn(4).setMinWidth(350);
            jTable_eleve.getColumnModel().getColumn(4).setPreferredWidth(350);
            jTable_eleve.getColumnModel().getColumn(4).setMaxWidth(350);
            jTable_eleve.getColumnModel().getColumn(5).setMinWidth(10);
            jTable_eleve.getColumnModel().getColumn(5).setPreferredWidth(10);
            jTable_eleve.getColumnModel().getColumn(5).setMaxWidth(10);
        }

        btn_nouveau.setBackground(new java.awt.Color(0, 204, 102));
        btn_nouveau.setText("NOUVEAU");
        btn_nouveau.setColorHover(new java.awt.Color(0, 153, 51));
        btn_nouveau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nouveauActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rSPanelImage1Layout = new javax.swing.GroupLayout(rSPanelImage1);
        rSPanelImage1.setLayout(rSPanelImage1Layout);
        rSPanelImage1Layout.setHorizontalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelImage1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1090, Short.MAX_VALUE)
                    .addGroup(rSPanelImage1Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_nouveau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        rSPanelImage1Layout.setVerticalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelImage1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_nouveau, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nouveauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nouveauActionPerformed
//        Enregistrer enregistrer = new Enregistrer(this, true);
//        enregistrer.setVisible(true);
    }//GEN-LAST:event_btn_nouveauActionPerformed

    private void rSComboMetro_cycleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSComboMetro_cycleActionPerformed
        initCbClasse();
        initTable();
    }//GEN-LAST:event_rSComboMetro_cycleActionPerformed

    private void rSComboMetro_classeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSComboMetro_classeActionPerformed
        initTable();
    }//GEN-LAST:event_rSComboMetro_classeActionPerformed

    private void rSComboMetro_absence_retardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSComboMetro_absence_retardActionPerformed
        initTable();
    }//GEN-LAST:event_rSComboMetro_absence_retardActionPerformed

    private void jTable_eleveMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_eleveMouseReleased
        int index = jTable_eleve.getSelectedRow();
        if(index < 0){
            return;
        }
        if(evt.isPopupTrigger() && evt.getComponent() instanceof JTable){
            popup_menu.show(evt.getComponent(), evt.getX(), evt.getY());
            popup_menu.setVisible(true);
        }
    }//GEN-LAST:event_jTable_eleveMouseReleased

    private void menu_item_retirerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_retirerActionPerformed
        int choice = JOptionPane.showConfirmDialog(this, "Etes vous sure de vouloir suprimer l'eleve " + jTable_eleve.getValueAt(jTable_eleve.getSelectedRow(), 1) + " ?", "Action irréversible", JOptionPane.YES_NO_OPTION);
        if(choice == 0){
            absenceRetardController.removeAbsenceRetard((int) jTable_eleve.getValueAt(jTable_eleve.getSelectedRow(), 5));
            initTable();
        }
    }//GEN-LAST:event_menu_item_retirerActionPerformed

    private void menu_item_detailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_detailActionPerformed
//        if("Retard".equals(cb_absence_retard.getSelectedItem().toString())){
//            Etudiant e = retardDAO.getRetard((int) jTable_eleve.getValueAt(jTable_eleve.getSelectedRow(), 4)).getEleve();
//            Detail detail = new Detail(this, true, el);
//            detail.setVisible(true);
//        }
//        if("Absence".equals(cb_absence_retard.getSelectedItem().toString())){
//            Eleve el = absenceDAO.getAbsence((int) jTable_eleve.getValueAt(jTable_eleve.getSelectedRow(), 4)).getEleve();
//            Detail detail = new Detail(this, true, el);
//            detail.setVisible(true);
//        }
    }//GEN-LAST:event_menu_item_detailActionPerformed

    private void menu_item_contacterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_contacterActionPerformed
        int row = jTable_eleve.getSelectedRow();
        ContacterDialog contacter = new ContacterDialog(this, true, eleveController.getEleve(jTable_eleve.getValueAt(row, 5).toString()));
        contacter.setVisible(true);
    }//GEN-LAST:event_menu_item_contacterActionPerformed

    private void rSComboMetro_anneeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSComboMetro_anneeActionPerformed
        initTable();
    }//GEN-LAST:event_rSComboMetro_anneeActionPerformed

    private void rSMTextFull_rechercheKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rSMTextFull_rechercheKeyReleased
        initTable();
    }//GEN-LAST:event_rSMTextFull_rechercheKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AbsenceRetardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AbsenceRetardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AbsenceRetardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AbsenceRetardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AbsenceRetardForm().setVisible(true);
        });
    }
    private final AbsenceRetardController absenceRetardController;
    private final CycleController cycleController;
    private final ClasseController classeController;
    private final AnneeScolaireController anneeScolaireController;
    private final EleveController eleveController;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButton btn_nouveau;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_eleve;
    private javax.swing.JMenuItem menu_item_contacter;
    private javax.swing.JMenuItem menu_item_detail;
    private javax.swing.JMenuItem menu_item_retirer;
    private javax.swing.JPopupMenu popup_menu;
    private rojerusan.RSComboMetro rSComboMetro_absence_retard;
    private rojerusan.RSComboMetro rSComboMetro_annee;
    private rojerusan.RSComboMetro rSComboMetro_classe;
    private rojerusan.RSComboMetro rSComboMetro_cycle;
    private rojeru_san.RSMTextFull rSMTextFull_recherche;
    private rojerusan.RSPanelImage rSPanelImage1;
    // End of variables declaration//GEN-END:variables



    private void initTable(){
        String entete[] = {"N°", "MATRICULE", "NOM ET PRENOM", "DATE", "COMMENTAIRE", "ID"};
        DefaultTableModel dt=new DefaultTableModel(null,entete);
        dt.setRowCount(0);
        String annee = null, cycle = null, classe = null, type = null, rechercher = null;
        if(rSComboMetro_annee.getSelectedIndex() > -1){
            annee = rSComboMetro_annee.getSelectedItem().toString();
        }
        if(rSComboMetro_cycle.getSelectedIndex() > -1){
            cycle = rSComboMetro_cycle.getSelectedItem().toString();
        }
        if(rSComboMetro_classe.getSelectedIndex() > -1){
            classe = rSComboMetro_classe.getSelectedItem().toString();
        }
        if(rSComboMetro_absence_retard.getSelectedIndex() > -1){
            type = rSComboMetro_absence_retard.getSelectedItem().toString();
        }
        if(rSMTextFull_recherche.getText().length() > 0){
            rechercher = rSMTextFull_recherche.getText();
        }
        ArrayList<AbsenceRetard> list = absenceRetardController.getListAbsenceRetard(annee, cycle, classe, type, rechercher);
        for(int i = 0; i< list.size(); i++){
            Object colonne[]=new Object[6];
            colonne[0] = i + 1;
            colonne[1] = list.get(i).getEleve().getMatricule();
            colonne[2] = list.get(i).getEleve().getNom_prenom();
            colonne[3] = list.get(i).getDate();
            colonne[4] = list.get(i).getCommentaire();
            colonne[5] = list.get(i).getId();
            dt.addRow(colonne);
        }
        this.jTable_eleve.setModel(dt);
        if (jTable_eleve.getColumnModel().getColumnCount() > 0) {
            jTable_eleve.getColumnModel().getColumn(0).setMinWidth(50);
            jTable_eleve.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable_eleve.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable_eleve.getColumnModel().getColumn(1).setMinWidth(80);
            jTable_eleve.getColumnModel().getColumn(1).setPreferredWidth(80);
            jTable_eleve.getColumnModel().getColumn(1).setMaxWidth(80);
            jTable_eleve.getColumnModel().getColumn(3).setMinWidth(150);
            jTable_eleve.getColumnModel().getColumn(3).setPreferredWidth(150);
            jTable_eleve.getColumnModel().getColumn(3).setMaxWidth(150);
            jTable_eleve.getColumnModel().getColumn(4).setMinWidth(350);
            jTable_eleve.getColumnModel().getColumn(4).setPreferredWidth(350);
            jTable_eleve.getColumnModel().getColumn(4).setMaxWidth(350);
            jTable_eleve.getColumnModel().getColumn(5).setMinWidth(10);
            jTable_eleve.getColumnModel().getColumn(5).setPreferredWidth(10);
            jTable_eleve.getColumnModel().getColumn(5).setMaxWidth(10);
            jTable_eleve.setRowHeight(30);
        }
    }

    private void initCbClasse() {
        rSComboMetro_classe.removeAllItems();
        String annee = null, cycle = null;
        if(rSComboMetro_annee.getSelectedIndex() > -1){
            annee = rSComboMetro_annee.getSelectedItem().toString();
        }else{
            return;
        }
        if(rSComboMetro_cycle.getSelectedIndex() > -1){
            cycle = rSComboMetro_cycle.getSelectedItem().toString();
        }
        ArrayList<Classe> listClasse = classeController.getListClasse(annee, cycle);
        
        int size = listClasse.size();
        if(size > 1){
            listClasse.forEach((c) -> {
                rSComboMetro_classe.addItem(c.getClasse());
            });
            rSComboMetro_classe.addItem("Toutes");
        }else if(size > 0){
            listClasse.forEach((c) -> {
                rSComboMetro_classe.addItem(c.getClasse());
                
            });
        }
    }
    
    private void initCbAnnee(){
        if(anneeScolaireController.getListAnneeScolaire() == null){
            return;
        }
        rSComboMetro_annee.removeAllItems();
        anneeScolaireController.getListAnneeScolaire().forEach((a) -> {
            rSComboMetro_annee.addItem(a.getAnnee());
        });
    }
    private void initCbCycle(){
        rSComboMetro_cycle.removeAllItems();
        if(cycleController.getListCycle() == null){
            return;
        }
        if(cycleController.getListCycle().size() > 1){
            rSComboMetro_cycle.addItem("Tous");
            cycleController.getListCycle().forEach((c) -> {
                rSComboMetro_cycle.addItem(c);
            });
        }else if(cycleController.getListCycle().size() > 0){
            cycleController.getListCycle().forEach((c) -> {
                rSComboMetro_cycle.addItem(c);
            });
        }
        
    }
}
