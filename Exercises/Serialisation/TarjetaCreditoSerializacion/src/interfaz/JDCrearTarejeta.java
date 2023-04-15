package interfaz;


import modelo.TarjetaCredito;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */

/**
 *
 * @author josemaria
 */
public class JDCrearTarejeta extends javax.swing.JDialog {
    private TarjetaCredito nuevaTarjetaCredito;
    private boolean isCreada = false;

    /**
     * Creates new form JDCrearTarejeta
     */
    public JDCrearTarejeta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlTitulo = new javax.swing.JLabel();
        jlTitular = new javax.swing.JLabel();
        jlNIF = new javax.swing.JLabel();
        jlPIN = new javax.swing.JLabel();
        jlLimite = new javax.swing.JLabel();
        jlNumeroTarjeta = new javax.swing.JLabel();
        jtfTitular = new javax.swing.JTextField();
        jtfNIF = new javax.swing.JTextField();
        jtfPIN = new javax.swing.JTextField();
        jtfNumeroTarjeta = new javax.swing.JTextField();
        jbAñadir = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jsLimite = new javax.swing.JSlider();
        jlCantidadLimite = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jlTitulo.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jlTitulo.setText("CREAR TARJETA");

        jlTitular.setText("Titular:");

        jlNIF.setText("NIF:");

        jlPIN.setText("PIN:");

        jlLimite.setText("Limite:");

        jlNumeroTarjeta.setText("Numero Tarjeta:");

        jtfNIF.setToolTipText("");

        jbAñadir.setText("Añadir");
        jbAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAñadirActionPerformed(evt);
            }
        });

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jsLimite.setMaximum(5000);
        jsLimite.setMinimum(500);
        jsLimite.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jsLimiteStateChanged(evt);
            }
        });

        jlCantidadLimite.setText("500");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlNIF)
                    .addComponent(jlTitular)
                    .addComponent(jlPIN)
                    .addComponent(jlLimite)
                    .addComponent(jlNumeroTarjeta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlCantidadLimite)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jsLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jtfPIN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addComponent(jtfNIF, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jtfTitular, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jtfNumeroTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jlTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jbAñadir)
                        .addGap(59, 59, 59)
                        .addComponent(jbCancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jlTitulo)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTitular)
                    .addComponent(jtfTitular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNIF)
                    .addComponent(jtfNIF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPIN)
                    .addComponent(jtfPIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlLimite)
                    .addComponent(jsLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlCantidadLimite))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNumeroTarjeta)
                    .addComponent(jtfNumeroTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAñadir)
                    .addComponent(jbCancelar))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public boolean isCreada() {
        return isCreada;
    }
    public TarjetaCredito getTarjetaCredito() {
        return nuevaTarjetaCredito;
    }
    
    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jsLimiteStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jsLimiteStateChanged
        jlCantidadLimite.setText(String.valueOf(jsLimite.getValue()));
    }//GEN-LAST:event_jsLimiteStateChanged

    private void jbAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAñadirActionPerformed
        boolean validInput = true;
        String errorMessage = "";
        String titular = jtfTitular.getText();
        String nif = jtfNIF.getText().toUpperCase();
        String pin = jtfPIN.getText();
        int limite = jsLimite.getValue();
        String numeroTarjeta = jtfNumeroTarjeta.getText();
        
        if (!TarjetaCredito.validarTitular(titular)) {
            errorMessage = "El títular debe de poseer mas de 15 caracteres y menos de 80.";
            validInput = false;
        }
        if (validInput && !TarjetaCredito.validarNIF_NIE_CIF(nif)) {
            errorMessage = "El NIF es invalido";
            validInput = false;
        }
        if (validInput && !TarjetaCredito.validarPin(pin)) {
            errorMessage = "El PIN es inválido debe de poseer 4 dígitos o mas";
            validInput = false;
        }
        if (validInput && !TarjetaCredito.validarDigitosTarjeta(numeroTarjeta)) {
            errorMessage = "El número de la Tarjeta no es válido";
            validInput = false;
        }
        
        if (!validInput) {
            JOptionPane.showMessageDialog(this, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            nuevaTarjetaCredito = new TarjetaCredito(titular,nif,pin,limite,numeroTarjeta);
            isCreada = true;
            this.setVisible(false);
        }
          
        
        
    }//GEN-LAST:event_jbAñadirActionPerformed

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
            java.util.logging.Logger.getLogger(JDCrearTarejeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDCrearTarejeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDCrearTarejeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDCrearTarejeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDCrearTarejeta dialog = new JDCrearTarejeta(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbAñadir;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JLabel jlCantidadLimite;
    private javax.swing.JLabel jlLimite;
    private javax.swing.JLabel jlNIF;
    private javax.swing.JLabel jlNumeroTarjeta;
    private javax.swing.JLabel jlPIN;
    private javax.swing.JLabel jlTitular;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JSlider jsLimite;
    private javax.swing.JTextField jtfNIF;
    private javax.swing.JTextField jtfNumeroTarjeta;
    private javax.swing.JTextField jtfPIN;
    private javax.swing.JTextField jtfTitular;
    // End of variables declaration//GEN-END:variables
}
