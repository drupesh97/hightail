/*
 * ConfigJDialog.java
 *
 * Created on 2011-02-18, 17:49:44
 */

package org.hightail.ui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import org.hightail.Config;

public class ConfigJDialog extends javax.swing.JDialog {
    protected final JFileChooser workingDirectoryChooser;
    
    /** Creates new form ConfigJDialog */
    public ConfigJDialog(JFrame parent) {
        super(parent, true); // makes it modal
        initComponents();
        
        makeShortcuts();
        
        setLocationRelativeTo(parent);
        
        String workingDirectory = Config.get("workingDirectory");
        
        workingDirectoryTextField.setText(workingDirectory);
        
        workingDirectoryChooser = new JFileChooser(new File(workingDirectory));
        workingDirectoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        pathFromWorkingDirToExec.setText(Config.get("pathFromWorkingDirToExec"));
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pathsAndDirectoriesPanel = new javax.swing.JPanel();
        workingDirectoryLabel = new javax.swing.JLabel();
        workingDirectoryTextField = new javax.swing.JTextField();
        workingDirectoryBrowseButton = new javax.swing.JButton();
        pathFromWorkingDirToExecLabel = new javax.swing.JLabel();
        pathFromWorkingDirToExecLabel2 = new javax.swing.JLabel();
        pathFromWorkingDirToExec = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Settings");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pathsAndDirectoriesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Paths and directories"));

        workingDirectoryLabel.setLabelFor(workingDirectoryTextField);
        workingDirectoryLabel.setText("Working directory:");

        workingDirectoryBrowseButton.setText("Browse...");
        workingDirectoryBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                workingDirectoryBrowseButtonActionPerformed(evt);
            }
        });

        pathFromWorkingDirToExecLabel.setText("Path from working directory to executable:");

        pathFromWorkingDirToExecLabel2.setText("Substitute %P for problem name, %L for lowercase problem name. Examples: \"%P.exe\", \"%L/%L\"");

        javax.swing.GroupLayout pathsAndDirectoriesPanelLayout = new javax.swing.GroupLayout(pathsAndDirectoriesPanel);
        pathsAndDirectoriesPanel.setLayout(pathsAndDirectoriesPanelLayout);
        pathsAndDirectoriesPanelLayout.setHorizontalGroup(
            pathsAndDirectoriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pathsAndDirectoriesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pathsAndDirectoriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pathsAndDirectoriesPanelLayout.createSequentialGroup()
                        .addComponent(workingDirectoryLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(workingDirectoryTextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(workingDirectoryBrowseButton))
                    .addGroup(pathsAndDirectoriesPanelLayout.createSequentialGroup()
                        .addComponent(pathFromWorkingDirToExecLabel2)
                        .addGap(0, 113, Short.MAX_VALUE))
                    .addGroup(pathsAndDirectoriesPanelLayout.createSequentialGroup()
                        .addComponent(pathFromWorkingDirToExecLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pathFromWorkingDirToExec)))
                .addContainerGap())
        );
        pathsAndDirectoriesPanelLayout.setVerticalGroup(
            pathsAndDirectoriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pathsAndDirectoriesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pathsAndDirectoriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(workingDirectoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(workingDirectoryBrowseButton)
                    .addComponent(workingDirectoryLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pathsAndDirectoriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pathFromWorkingDirToExecLabel)
                    .addComponent(pathFromWorkingDirToExec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pathFromWorkingDirToExecLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        saveButton.setText("Save settings");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pathsAndDirectoriesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cancelButton)
                        .addGap(18, 18, 18)
                        .addComponent(saveButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pathsAndDirectoriesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void makeShortcuts() {
        // escape key will close the dialog
        getRootPane().getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "close");
        getRootPane().getActionMap().put("close", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmAndClose();
            }
        });
        // enter key will perform the same action as save button
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        getRootPane().getActionMap().put("enter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });
        
    }
    private void workingDirectoryBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_workingDirectoryBrowseButtonActionPerformed
        int returnVal = workingDirectoryChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            workingDirectoryTextField.setText(workingDirectoryChooser.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_workingDirectoryBrowseButtonActionPerformed
    
    private boolean unsavedChanges() {
        if (!Config.get("workingDirectory").equals(workingDirectoryTextField.getText())) {
            return true;
        }
        if (!Config.get("pathFromWorkingDirToExec").equals(pathFromWorkingDirToExec.getText())) {
            return true;
        }
        return false;
    }
    
    private void confirmAndClose () {
        // ask for confirmation only if there is something unsaved
        if (unsavedChanges()) {
            // Display confirm dialog
            int confirmed = JOptionPane.showConfirmDialog(this,
                    "Are you sure? There's unsaved changes.",
                    "Confirm close",
                    JOptionPane.YES_NO_OPTION);
            
            // Close iff user confirmed
            if (confirmed == JOptionPane.YES_OPTION) {
                this.dispose();
            }
        }
        else {
            this.dispose();
        }
    }
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        confirmAndClose();
    }//GEN-LAST:event_formWindowClosing
    
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        confirmAndClose();
    }//GEN-LAST:event_cancelButtonActionPerformed
    
    private void save() {
        Config.set("workingDirectory", workingDirectoryTextField.getText());
        Config.set("pathFromWorkingDirToExec", pathFromWorkingDirToExec.getText());
        try {
            Config.save();
            JOptionPane.showMessageDialog(this, "The configuration file has been saved.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    "Error while saving configuration file:\n\n" + ex +
                    "\n\nThe new settings will be used until the end of the session, but haven't been saved.",
                    "Error!", JOptionPane.ERROR_MESSAGE);
        }
        
        this.dispose();
    }
    
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        save();
    }//GEN-LAST:event_saveButtonActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField pathFromWorkingDirToExec;
    private javax.swing.JLabel pathFromWorkingDirToExecLabel;
    private javax.swing.JLabel pathFromWorkingDirToExecLabel2;
    private javax.swing.JPanel pathsAndDirectoriesPanel;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton workingDirectoryBrowseButton;
    private javax.swing.JLabel workingDirectoryLabel;
    private javax.swing.JTextField workingDirectoryTextField;
    // End of variables declaration//GEN-END:variables
    
}
