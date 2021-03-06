/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dialog;

import bean.Matiere;
import controller.MatiereController;
import javax.swing.JOptionPane;

/**
 *
 * @author ATH
 */
public class MatiereDialog extends javax.swing.JDialog {

    /**
     * Creates new form MatiereDialog
     * @param parent
     * @param modal
     */
    public MatiereDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        matiereController = new MatiereController();
        initComponents();
    }
    public MatiereDialog(java.awt.Frame parent, boolean modal, Matiere matiere) {
        super(parent, modal);
        matiereController = new MatiereController();
        this.matiere = matiere;
        initComponents();
        try {
            rSMTextFull_matiere.setText(this.matiere.getMatiere());
            rSComboMetro_type.setSelectedItem(this.matiere.getType());
            jSpinner_priorite.setValue(this.matiere.getPriorite());
        } catch (Exception e) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSMTextFull_matiere = new rojeru_san.RSMTextFull();
        jLabel1 = new javax.swing.JLabel();
        rSComboMetro_type = new rojerusan.RSComboMetro();
        jLabel2 = new javax.swing.JLabel();
        jSpinner_priorite = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        rSButtonRiple_enregistrer = new rojeru_san.RSButtonRiple();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestion Matière");
        setResizable(false);

        rSMTextFull_matiere.setPlaceholder("");

        jLabel1.setText("Matière");

        rSComboMetro_type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Scientifique", "Littéraire", "Autre" }));

        jLabel2.setText("Type");

        jSpinner_priorite.setModel(new javax.swing.SpinnerNumberModel(10, 1, null, 1));

        jLabel3.setText("Priorité");

        rSButtonRiple_enregistrer.setText("Valider");
        rSButtonRiple_enregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonRiple_enregistrerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSComboMetro_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rSMTextFull_matiere, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner_priorite, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(rSButtonRiple_enregistrer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSMTextFull_matiere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSComboMetro_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner_priorite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(rSButtonRiple_enregistrer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rSButtonRiple_enregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonRiple_enregistrerActionPerformed
        if(rSMTextFull_matiere.getText().length() == 0){
            JOptionPane.showMessageDialog(this, "Champ matricule vide ou auccun enseignant trouvé pour le numéro matricule saisie.", "Erreur de matricule !", JOptionPane.WARNING_MESSAGE);
            return;
        }else{
            if(matiere == null){
                matiereController.addMatiere(rSMTextFull_matiere.getText(), rSComboMetro_type.getSelectedItem().toString(), (int) jSpinner_priorite.getValue());
            }else{
                matiereController.setMatiere(matiere, new Matiere(rSMTextFull_matiere.getText(), rSComboMetro_type.getSelectedItem().toString(), (int) jSpinner_priorite.getValue()));
            }
        }
        this.dispose();
    }//GEN-LAST:event_rSButtonRiple_enregistrerActionPerformed

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
            java.util.logging.Logger.getLogger(MatiereDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MatiereDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MatiereDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MatiereDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MatiereDialog dialog = new MatiereDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    private final MatiereController matiereController;
    private Matiere matiere;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSpinner jSpinner_priorite;
    private rojeru_san.RSButtonRiple rSButtonRiple_enregistrer;
    private rojerusan.RSComboMetro rSComboMetro_type;
    private rojeru_san.RSMTextFull rSMTextFull_matiere;
    // End of variables declaration//GEN-END:variables
}
