/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaz;

import Aplication.Gimnasio;
import Negocio.enums.Nivel;

/**
 *
 * @author Santi
 */
public class CrearSede extends javax.swing.JFrame {

    private Gimnasio controller;
    
    /**
     * Creates new form CrearSede
     */
    public CrearSede(Gimnasio controller) {
        initComponents();
        this.controller = controller;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombre = new javax.swing.JTextField();
        labelNombre = new javax.swing.JLabel();
        labelNivel = new javax.swing.JLabel();
        javax.swing.JComboBox<Nivel> selectNivelMinimo = new javax.swing.JComboBox<>();
        txtBarrio = new javax.swing.JTextField();
        labelBarrio = new javax.swing.JLabel();
        txtAlquiler = new javax.swing.JTextField();
        labelAlquiler = new javax.swing.JLabel();
        btnCrearSede = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CrearSede");

        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        labelNombre.setText("Nombre:");

        labelNivel.setText("Nivel Minimo:");

        for (Nivel nivel : Nivel.values()){
            selectNivelMinimo.addItem(nivel);
        }
        selectNivelMinimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectNivelMinimoActionPerformed(evt);
            }
        });

        txtBarrio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBarrioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBarrioFocusLost(evt);
            }
        });
        txtBarrio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBarrioActionPerformed(evt);
            }
        });

        labelBarrio.setText("Barrio:");

        txtAlquiler.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtAlquilerFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAlquilerFocusLost(evt);
            }
        });
        txtAlquiler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlquilerActionPerformed(evt);
            }
        });

        labelAlquiler.setText("Alquiler:");

        btnCrearSede.setText("Crear Sede");
        btnCrearSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearSedeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCrearSede, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAlquiler, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                    .addComponent(labelAlquiler)
                    .addComponent(txtBarrio, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                    .addComponent(labelBarrio)
                    .addComponent(selectNivelMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNivel)
                    .addComponent(labelNombre)
                    .addComponent(txtNombre))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(labelNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelNivel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectNivelMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelBarrio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBarrio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelAlquiler)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAlquiler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCrearSede, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
        
    }//GEN-LAST:event_txtNombreFocusGained

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        
    }//GEN-LAST:event_txtNombreFocusLost

    private void txtBarrioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBarrioFocusGained
       
    }//GEN-LAST:event_txtBarrioFocusGained

    private void txtBarrioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBarrioFocusLost
        
    }//GEN-LAST:event_txtBarrioFocusLost

    private void txtBarrioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBarrioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBarrioActionPerformed

    private void txtAlquilerFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAlquilerFocusGained
        
    }//GEN-LAST:event_txtAlquilerFocusGained

    private void txtAlquilerFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAlquilerFocusLost
        
    }//GEN-LAST:event_txtAlquilerFocusLost

    private void txtAlquilerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlquilerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlquilerActionPerformed

    private void btnCrearSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearSedeActionPerformed
            
    }//GEN-LAST:event_btnCrearSedeActionPerformed

    private void selectNivelMinimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectNivelMinimoActionPerformed
        // TODO hacer esto
    }//GEN-LAST:event_selectNivelMinimoActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearSede;
    private javax.swing.JLabel labelAlquiler;
    private javax.swing.JLabel labelBarrio;
    private javax.swing.JLabel labelNivel;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JTextField txtAlquiler;
    private javax.swing.JTextField txtBarrio;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
