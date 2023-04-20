/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package interfaz;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Movimiento;
import modelo.TarjetaCredito;

/**
 *
 * @author josemaria
 */
public class JDGestionarTarjeta extends javax.swing.JDialog {
    /**
     * Creates new form JDGestionarTarjeta
     */
    public JDGestionarTarjeta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public JDGestionarTarjeta(java.awt.Frame parent, boolean modal, TarjetaCredito tarjetaSeleccionada) {
        this(parent, modal);
        this.tarjetaSeleccionada = tarjetaSeleccionada;
        inicializar();
    }

    private void inicializar() {
        jlNumeroTarjeta.setText(tarjetaSeleccionada.getNumeroTarjeta());
        jlTitular.setText(tarjetaSeleccionada.getTitular());
        jlFechaCaducidad.setText(tarjetaSeleccionada.getMesCaducidad()+"/"+tarjetaSeleccionada.getAñoCaducidad());
        jlGastosTotales.setText(String.valueOf(tarjetaSeleccionada.gastado()));
    }
    
    public boolean isActualizado () {
        return isActualizada;
    }
    
    public TarjetaCredito getTarjetaCredito() {
        return new TarjetaCredito(tarjetaSeleccionada);
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
        jlTituloNumeroTarjeta = new javax.swing.JLabel();
        jlTituloTitular = new javax.swing.JLabel();
        jlTituloFechaCaducidad = new javax.swing.JLabel();
        jlTituloGastosTotales = new javax.swing.JLabel();
        jlNumeroTarjeta = new javax.swing.JLabel();
        jlTitular = new javax.swing.JLabel();
        jlFechaCaducidad = new javax.swing.JLabel();
        jlGastosTotales = new javax.swing.JLabel();
        jbSalir = new javax.swing.JButton();
        jmbMenu = new javax.swing.JMenuBar();
        jmAcciones = new javax.swing.JMenu();
        jmiModificarPIN = new javax.swing.JMenuItem();
        jmiRealizarPago = new javax.swing.JMenuItem();
        jmiConsultarMovimientos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jlTitulo.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jlTitulo.setText("GESTIONAR TARJETA");

        jlTituloNumeroTarjeta.setText("Número Tarjeta: ");

        jlTituloTitular.setText("Titular: ");

        jlTituloFechaCaducidad.setText("Fecha Caducidad:");

        jlTituloGastosTotales.setText("Gastos Totales:");

        jlNumeroTarjeta.setText(" ");

        jlTitular.setText(" ");

        jlFechaCaducidad.setText(" ");

        jlGastosTotales.setText(" ");

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jmAcciones.setText("Acciones");

        jmiModificarPIN.setText("Modificar PIN");
        jmiModificarPIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiModificarPINActionPerformed(evt);
            }
        });
        jmAcciones.add(jmiModificarPIN);

        jmiRealizarPago.setText("Realizar Pago");
        jmiRealizarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRealizarPagoActionPerformed(evt);
            }
        });
        jmAcciones.add(jmiRealizarPago);

        jmiConsultarMovimientos.setText("Consultar Movimientos");
        jmiConsultarMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiConsultarMovimientosActionPerformed(evt);
            }
        });
        jmAcciones.add(jmiConsultarMovimientos);

        jmbMenu.add(jmAcciones);

        setJMenuBar(jmbMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlTitulo)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlTituloNumeroTarjeta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlNumeroTarjeta))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlTituloTitular)
                            .addComponent(jlTituloFechaCaducidad)
                            .addComponent(jlTituloGastosTotales))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlTitular)
                            .addComponent(jlFechaCaducidad)
                            .addComponent(jlGastosTotales))))
                .addContainerGap(111, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbSalir)
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTitulo)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTituloNumeroTarjeta)
                    .addComponent(jlNumeroTarjeta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTituloTitular)
                    .addComponent(jlTitular))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTituloFechaCaducidad)
                    .addComponent(jlFechaCaducidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTituloGastosTotales)
                    .addComponent(jlGastosTotales))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jbSalir)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jmiModificarPINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiModificarPINActionPerformed
        boolean validPin = false;
        boolean exit = false;
        String newPin;
        do {
            newPin = JOptionPane.showInputDialog(this,"Ingresa su nuevo PIN.","Nuevo PIN",1);
            if (newPin != null && newPin.matches("^\\d{4,}$")) {
                validPin = true;
            } else if (newPin != null) {
                JOptionPane.showMessageDialog(this, "El PIN insertado es erroneo");
                validPin = false;
            } else {
                exit = true;
            }
        } while (!validPin && !exit);
        
        if (validPin) {
            tarjetaSeleccionada.setPin(newPin);
            this.isActualizada = true;
            JOptionPane.showMessageDialog(rootPane, "Se ha actualizado el PIN correctamente.");
        }
    }//GEN-LAST:event_jmiModificarPINActionPerformed

    private void jmiRealizarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRealizarPagoActionPerformed
        JTextField jtfConcepto = new JTextField();
        JTextField jtfCantidad = new JTextField();
        Object[] message = {
            "Concepto:", jtfConcepto,
            "Cantidad:", jtfCantidad
        };
        boolean exit = false;
        boolean pagoRealizado = false;
        
        do {
            int option = JOptionPane.showConfirmDialog(this, message, "Realizar Pago", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                double saldoDisponible = tarjetaSeleccionada.getLimite() - tarjetaSeleccionada.gastado();
                boolean validInput = true;
                String concepto = jtfConcepto.getText();
                String cantidad = jtfCantidad.getText();

                if (concepto.isBlank()) {
                    JOptionPane.showMessageDialog(this, "El concepto no puede estar vacio.");
                    validInput = false;
                }
                if (validInput && !cantidad.matches("\\d+")) {
                    JOptionPane.showMessageDialog(this, "La cantidad debe de ser un valor numérico");
                    System.out.println(cantidad);
                    validInput = false;
                }

                if (validInput && (Integer.valueOf(cantidad) < 0 || Integer.valueOf(cantidad) > saldoDisponible)) {
                    JOptionPane.showMessageDialog(this, "La cantidad debe de ser un valor numérico");
                    validInput = false;
                }
                
                if (validInput && tarjetaSeleccionada.pagar(Double.valueOf(cantidad), concepto)) {
                    JOptionPane.showMessageDialog(rootPane, "Se ha realizado el pago");
                    this.jlGastosTotales.setText(String.valueOf(tarjetaSeleccionada.gastado()));
                    this.isActualizada = true;
                    pagoRealizado = true;
                } else {
                   JOptionPane.showMessageDialog(rootPane, "No se ha podido realizar el pago");
                }
            } else {
                exit = true;
            }
        } while (!exit && !pagoRealizado);
    }//GEN-LAST:event_jmiRealizarPagoActionPerformed

    private void jmiConsultarMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiConsultarMovimientosActionPerformed
        JDListaMovimientos jDListaMovimientos = new JDListaMovimientos(this, rootPaneCheckingEnabled);
        int numeroTotalMovimientos = tarjetaSeleccionada.numeroMovimientos();
        if (numeroTotalMovimientos == 0) {
            JOptionPane.showMessageDialog(this, "La tarjeta no posee Movimientos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            ArrayList<Movimiento> movimientos = tarjetaSeleccionada.movimientos(numeroTotalMovimientos);
            movimientos.forEach(movimiento -> jDListaMovimientos.añadirMovimiento(movimiento));
            jDListaMovimientos.setVisible(true);
        }
    }//GEN-LAST:event_jmiConsultarMovimientosActionPerformed

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
            java.util.logging.Logger.getLogger(JDGestionarTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDGestionarTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDGestionarTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDGestionarTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDGestionarTarjeta dialog = new JDGestionarTarjeta(new javax.swing.JFrame(), true);
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

    
    
    private boolean isActualizada;
    private TarjetaCredito tarjetaSeleccionada;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbSalir;
    private javax.swing.JLabel jlFechaCaducidad;
    private javax.swing.JLabel jlGastosTotales;
    private javax.swing.JLabel jlNumeroTarjeta;
    private javax.swing.JLabel jlTitular;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JLabel jlTituloFechaCaducidad;
    private javax.swing.JLabel jlTituloGastosTotales;
    private javax.swing.JLabel jlTituloNumeroTarjeta;
    private javax.swing.JLabel jlTituloTitular;
    private javax.swing.JMenu jmAcciones;
    private javax.swing.JMenuBar jmbMenu;
    private javax.swing.JMenuItem jmiConsultarMovimientos;
    private javax.swing.JMenuItem jmiModificarPIN;
    private javax.swing.JMenuItem jmiRealizarPago;
    // End of variables declaration//GEN-END:variables

    
}
