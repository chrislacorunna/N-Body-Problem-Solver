/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.GUI;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JOptionPane.showMessageDialog;
import main.FileIO.ICoordinatesWriter;
import main.FileIO.IPlanetsReader;
import main.FileIO.IScript;
import main.bodyLogic.Controller;
import main.bodyLogic.Singleton;

/**
 *
 * @author Michal
 */
public class LoadDataFromFile extends javax.swing.JFrame {

    
     private boolean fileChoosed = false;


    private double timeStep = 24 * 60 * 60;
    private double simulationTime = 30 * 24 * 60 * 60;

    private boolean computed = false;
    
    
    /**
     * Creates new form loadDataFromFile
     */
    public LoadDataFromFile() {
        initComponents();
        ButtonGroup simulationGroup = new ButtonGroup();
        simulationGroup.add(thirtyDaysSimulationRadioButton);
        simulationGroup.add(yearSimulationRadioButton);
        simulationGroup.add(customSimulationRadioButton);
        
        thirtyDaysSimulationRadioButton.setSelected(true);
        
         ButtonGroup stepGroup = new ButtonGroup();
        stepGroup.add(oneDayStepRadioButton);
        stepGroup.add(fiveDayStepRadioButton);
        stepGroup.add(customDayStepRadioButton);

        oneDayStepRadioButton.setSelected(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pathLabel = new javax.swing.JLabel();
        oneDayStepRadioButton = new javax.swing.JRadioButton();
        fiveDayStepRadioButton = new javax.swing.JRadioButton();
        customDayStepRadioButton = new javax.swing.JRadioButton();
        thirtyDaysSimulationRadioButton = new javax.swing.JRadioButton();
        yearSimulationRadioButton = new javax.swing.JRadioButton();
        customSimulationRadioButton = new javax.swing.JRadioButton();
        customDaySimulationField = new javax.swing.JTextField();
        customDayStepField = new javax.swing.JTextField();
        visualiseButton = new javax.swing.JButton();
        saveToFileButton = new javax.swing.JButton();
        outputLabel = new javax.swing.JLabel();
        fileChooserButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        oneDayStepRadioButton.setText("1 dzień");
        oneDayStepRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oneDayStepRadioButtonActionPerformed(evt);
            }
        });

        fiveDayStepRadioButton.setText("5 dni");
        fiveDayStepRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveDayStepRadioButtonActionPerformed(evt);
            }
        });

        customDayStepRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customDayStepRadioButtonActionPerformed(evt);
            }
        });

        thirtyDaysSimulationRadioButton.setText("30 dni");
        thirtyDaysSimulationRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thirtyDaysSimulationRadioButtonActionPerformed(evt);
            }
        });

        yearSimulationRadioButton.setText("rok(365 dni)");
        yearSimulationRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearSimulationRadioButtonActionPerformed(evt);
            }
        });

        customSimulationRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customSimulationRadioButtonActionPerformed(evt);
            }
        });

        customDaySimulationField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                customDaySimulationFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                customDaySimulationFieldFocusLost(evt);
            }
        });
        customDaySimulationField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                customDaySimulationFieldKeyTyped(evt);
            }
        });

        customDayStepField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                customDayStepFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                customDayStepFieldFocusLost(evt);
            }
        });
        customDayStepField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                customDayStepFieldKeyTyped(evt);
            }
        });

        visualiseButton.setText("Wizualizuj...");
        visualiseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualiseButtonActionPerformed(evt);
            }
        });

        saveToFileButton.setText("Zapisz dane do pliku...");
        saveToFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveToFileButtonActionPerformed(evt);
            }
        });

        outputLabel.setBackground(new java.awt.Color(255, 255, 255));

        fileChooserButton.setText("Wybierz plik...");
        fileChooserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileChooserButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Krok czasowy");

        jLabel2.setText("Czas symulacji");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fiveDayStepRadioButton)
                            .addComponent(oneDayStepRadioButton)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(customDayStepRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(customDayStepField, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 204, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(customSimulationRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(customDaySimulationField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(yearSimulationRadioButton)
                            .addComponent(jLabel2)
                            .addComponent(thirtyDaysSimulationRadioButton))
                        .addGap(59, 59, 59))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(191, 191, 191)
                                .addComponent(visualiseButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(167, 167, 167)
                                .addComponent(saveToFileButton)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(outputLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(fileChooserButton))
                            .addComponent(pathLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pathLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fileChooserButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(oneDayStepRadioButton)
                            .addComponent(thirtyDaysSimulationRadioButton))
                        .addGap(2, 2, 2)
                        .addComponent(fiveDayStepRadioButton)
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(customDayStepField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customDayStepRadioButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(yearSimulationRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(customSimulationRadioButton)
                            .addComponent(customDaySimulationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15)
                .addComponent(visualiseButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveToFileButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(outputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void oneDayStepRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oneDayStepRadioButtonActionPerformed
        timeStep = 24 * 60 * 60;
    }//GEN-LAST:event_oneDayStepRadioButtonActionPerformed

    private void fiveDayStepRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveDayStepRadioButtonActionPerformed
        timeStep = 5 * 24 * 60 * 60;
    }//GEN-LAST:event_fiveDayStepRadioButtonActionPerformed

    private void customDayStepRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customDayStepRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customDayStepRadioButtonActionPerformed

    private void thirtyDaysSimulationRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thirtyDaysSimulationRadioButtonActionPerformed
        simulationTime = 30 * 24 * 60 * 60;
    }//GEN-LAST:event_thirtyDaysSimulationRadioButtonActionPerformed

    private void yearSimulationRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearSimulationRadioButtonActionPerformed
        simulationTime = 365 * 24 * 60 * 60;
    }//GEN-LAST:event_yearSimulationRadioButtonActionPerformed

    private void customSimulationRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customSimulationRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customSimulationRadioButtonActionPerformed

    private void customDaySimulationFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_customDaySimulationFieldFocusGained
        customSimulationRadioButton.setSelected(true);        // TODO add your handling code here:
    }//GEN-LAST:event_customDaySimulationFieldFocusGained

    private void customDaySimulationFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_customDaySimulationFieldFocusLost
        if (customDaySimulationField.getText().equals("")) {
            showMessageDialog(null, "Czas symulacji nie może być pusty!");
            return;
        }
        if ("0".equals(customDaySimulationField.getText())) {
            showMessageDialog(null, "Czas symulacji nie może być równy 0!");
            return;
        }

        simulationTime = Double.parseDouble(customDaySimulationField.getText()) * 24 * 60 * 60;        // TODO add your handling code here:
    }//GEN-LAST:event_customDaySimulationFieldFocusLost

    private void customDaySimulationFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customDaySimulationFieldKeyTyped
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar) || (vChar == KeyEvent.VK_BACK_SPACE) || (vChar == KeyEvent.VK_DELETE))) {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_customDaySimulationFieldKeyTyped

    private void customDayStepFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_customDayStepFieldFocusGained
        customDayStepRadioButton.setSelected(true);
    }//GEN-LAST:event_customDayStepFieldFocusGained

    private void customDayStepFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_customDayStepFieldFocusLost
        if (customDayStepField.getText().equals("")) {
            showMessageDialog(null, "Krok czasowy nie może być pusty!");
            return;
        }

        if ("0".equals(customDayStepField.getText())) {
            showMessageDialog(null, "Krok czasowy nie może być równy 0!");
            return;
        }

        timeStep = Double.parseDouble(customDayStepField.getText()) * 24 * 60 * 60;        // TODO add your handling code here:
    }//GEN-LAST:event_customDayStepFieldFocusLost

    private void customDayStepFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customDayStepFieldKeyTyped
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar) || (vChar == KeyEvent.VK_BACK_SPACE) || (vChar == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
    }//GEN-LAST:event_customDayStepFieldKeyTyped

    private void saveToFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveToFileButtonActionPerformed
        if (!fileChoosed) {
            showMessageDialog(null, "Musisz najpierw wybrać plik z danymi do wizualizacji");
            return;
        }
        if (!computed)
            Controller.compute(simulationTime, timeStep);

        JFileChooser chooser = new JFileChooser();
        chooser.setApproveButtonText("Zapisz");
        chooser.setCurrentDirectory(new File("."));
        chooser.setDialogTitle("Wybierz gdzie chcesz zapisać plik z danymi");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            boolean saved = false;
            ICoordinatesWriter coordinatesWriter = Singleton.getCoordinatesWriter();
            try {
                saved = coordinatesWriter.Write(Singleton.getBodyStorage(), chooser.getSelectedFile().getAbsolutePath());
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }

            IScript script = Singleton.getScript();

            script.Generate(chooser.getSelectedFile().getAbsolutePath());

            try {
                script.Save(chooser.getSelectedFile().getAbsolutePath());
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }

            if (saved) {
                showMessageDialog(null, "Zapisano plik: '" + chooser.getSelectedFile().getAbsolutePath() + "'");
                outputLabel.setText("<html>Zapisano plik: " + chooser.getSelectedFile().getAbsolutePath() + "'<br> z przeliczonymi danymi wyjściowymi</html>");
            }

        }

    }//GEN-LAST:event_saveToFileButtonActionPerformed

    private void fileChooserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileChooserButtonActionPerformed
        chooseFile();
    }//GEN-LAST:event_fileChooserButtonActionPerformed

    private void visualiseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualiseButtonActionPerformed
        if (!fileChoosed) {
                    showMessageDialog(null, "Musisz najpierw wybrać plik z danymi do wizualizacji");
                    return;
                }


                if (!computed)
                    Controller.compute(simulationTime, timeStep);

                Visualisation v = new Visualisation();
                v.setLocationRelativeTo(null);
                v.setSize(1000, 800);
                v.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                v.pack();
                v.setVisible(true);
    }//GEN-LAST:event_visualiseButtonActionPerformed

    
     private void chooseFile() {
        JFileChooser chooser = new JFileChooser();
        chooser.setApproveButtonText("Otwórz");
        chooser.setCurrentDirectory(new File("."));
        chooser.setDialogTitle("Wybierz plik z danymi planet");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        //chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            IPlanetsReader planetsReader = Singleton.getPlanetsReader();
            boolean correctFile = false;
            String errorsList = "";
            try {
                correctFile = planetsReader.readFromFile(chooser.getSelectedFile().getAbsolutePath());
            } catch (FileNotFoundException e) {
                showMessageDialog(null, "Wybrany plik nie istnieje");
                errorsList += "-Wybrany plik nie istnieje<br>";
            } catch (Exception e) {
                showMessageDialog(null, e.getMessage());
                errorsList += "-" + e.getMessage() + "<br>";
            }
            if (correctFile) {
                fileChoosed = true;
                pathLabel.setText(chooser.getSelectedFile().getAbsolutePath());
                outputLabel.setText("<html>Poprawnie wczytano plik! Możesz nacisnąć przycisk 'Wizualizuj...', aby zwizualizować symulację dla wprowadzonych danych," +
                        "<br>lub przycisk 'Zapisz dane do pliku...', aby zapisać przeliczone dane do pliku.</html>");
            } else
                outputLabel.setText("<html>Plik nie został wczytany poprawnie z powodu(-ów):<br>" + errorsList + "</html>");
        }
    }
    
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField customDaySimulationField;
    private javax.swing.JTextField customDayStepField;
    private javax.swing.JRadioButton customDayStepRadioButton;
    private javax.swing.JRadioButton customSimulationRadioButton;
    private javax.swing.JButton fileChooserButton;
    private javax.swing.JRadioButton fiveDayStepRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton oneDayStepRadioButton;
    private javax.swing.JLabel outputLabel;
    private javax.swing.JLabel pathLabel;
    private javax.swing.JButton saveToFileButton;
    private javax.swing.JRadioButton thirtyDaysSimulationRadioButton;
    private javax.swing.JButton visualiseButton;
    private javax.swing.JRadioButton yearSimulationRadioButton;
    // End of variables declaration//GEN-END:variables
}
