/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import java.awt.CardLayout;
import java.util.ArrayList;
import model.Profile;
import model.ProfileDirectory;
import ui.ProfileManager.ProfileMngWorkAreaJPanel;
/**
 *
 * @author tirthnaik
 */
public class MainProfileJFrame extends javax.swing.JFrame {
    
    private ProfileDirectory profileDirectory;
    /**
     * Creates new form MainJFrame
     */
    public MainProfileJFrame() {
        initComponents();
        
        this.profileDirectory = new ProfileDirectory();
        generateDemoDate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        splitPane = new javax.swing.JSplitPane();
        topJPanel = new javax.swing.JPanel();
        btnProfileMng = new javax.swing.JButton();
        userProcessContainer = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        splitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        btnProfileMng.setBackground(new java.awt.Color(153, 204, 255));
        btnProfileMng.setText("Open Profile Manager Work Area");
        btnProfileMng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileMngActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topJPanelLayout = new javax.swing.GroupLayout(topJPanel);
        topJPanel.setLayout(topJPanelLayout);
        topJPanelLayout.setHorizontalGroup(
            topJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topJPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btnProfileMng, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(687, Short.MAX_VALUE))
        );
        topJPanelLayout.setVerticalGroup(
            topJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topJPanelLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(btnProfileMng, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        splitPane.setTopComponent(topJPanel);

        userProcessContainer.setLayout(new java.awt.CardLayout());
        splitPane.setRightComponent(userProcessContainer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(splitPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1023, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(splitPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProfileMngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileMngActionPerformed
        // TODO add your handling code here:
        ProfileMngWorkAreaJPanel panel = new ProfileMngWorkAreaJPanel(userProcessContainer,profileDirectory);
        userProcessContainer.add("ProfileMngWorkAreaJPanel", panel);
        
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnProfileMngActionPerformed

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
            java.util.logging.Logger.getLogger(MainProfileJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainProfileJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainProfileJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainProfileJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainProfileJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProfileMng;
    private javax.swing.JSplitPane splitPane;
    private javax.swing.JPanel topJPanel;
    private javax.swing.JPanel userProcessContainer;
    // End of variables declaration//GEN-END:variables

    private void generateDemoDate() {
    // First profile
    Profile newProfile = profileDirectory.addProfile();
    newProfile.setFirstName("Tirth");
    newProfile.setLastName("Naik");
    newProfile.setSsn("123-23-3449");
    newProfile.setHomeCity("Boston");
    newProfile.setHomeZip("02121");
    newProfile.setWorkCity("Cambridge");
    newProfile.setWorkZip("02344");
    
    // Second profile
    Profile anotherNewOneProfile = profileDirectory.addProfile();
    anotherNewOneProfile.setFirstName("Ram");
    anotherNewOneProfile.setLastName("Patel");
    anotherNewOneProfile.setSsn("321-23-3456");
    anotherNewOneProfile.setHomeCity("Lovel");
    anotherNewOneProfile.setHomeZip("02545");
    anotherNewOneProfile.setWorkCity("Chelsea");
    anotherNewOneProfile.setWorkZip("02567");
    
    // Third profile
    Profile anotherNewTwoProfile = profileDirectory.addProfile();
    anotherNewTwoProfile.setFirstName("Siddharth");
    anotherNewTwoProfile.setLastName("Naik");
    anotherNewTwoProfile.setSsn("541-23-7856");
    anotherNewTwoProfile.setHomeCity("Mumbai");
    anotherNewTwoProfile.setHomeZip("30335");
    anotherNewTwoProfile.setWorkCity("London");
    anotherNewTwoProfile.setWorkZip("05467");
    
    // Fourth profile
    Profile anotherNewThreeProfile = profileDirectory.addProfile();
    anotherNewThreeProfile.setFirstName("Hari");
    anotherNewThreeProfile.setLastName("Yadav");
    anotherNewThreeProfile.setSsn("987-65-0010");
    anotherNewThreeProfile.setHomeCity("Delhi");
    anotherNewThreeProfile.setHomeZip("98675");
    anotherNewThreeProfile.setWorkCity("New York");
    anotherNewThreeProfile.setWorkZip("06733");
    
    // Fifth profile
    Profile anotherNewFourProfile = profileDirectory.addProfile();
    anotherNewFourProfile.setFirstName("Shyam");
    anotherNewFourProfile.setLastName("Sharma");
    anotherNewFourProfile.setSsn("987-65-3210");
    anotherNewFourProfile.setHomeCity("Punjab");
    anotherNewFourProfile.setHomeZip("67880");
    anotherNewFourProfile.setWorkCity("Houston");
    anotherNewFourProfile.setWorkZip("98700");
}

}
