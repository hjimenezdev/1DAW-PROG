/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaz;

import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Media;
import modelo.ModeloListaMedia;
import modelo.Pelicula;
import modelo.Serie;
import modelo.Tematica;

/**
 *
 * @author josemaria
 */
public class IntefazJF extends javax.swing.JFrame {

    /**
     * Creates new form IntefazJF
     */
    public IntefazJF() {
        initComponents();
        inicializar();
    }
    
    public void inicializar() {
        this.listaMedia = new ArrayList<>();
        
        // Creamos el Modelos de la Lista
        modelo = new ModeloListaMedia();
                
        // Actualizamos JTable para que use el Modelo de Canción
        jtListaMedia.setModel(modelo);
        Pelicula p = new Pelicula("Prueba", 10, LocalDate.of(2022, 10, 1), true, "Paco", "Alvaro", 90, Tematica.CIENCIA_FICCION);
        Serie s = new Serie("Prueba", 10, LocalDate.of(2022, 10, 1), true, LocalDate.of(2022, 10, 1));
        s.añadirTemporada(LocalDate.of(2022, 10, 31));
        modelo.añadirMedia(p);
        modelo.añadirMedia(s);
        listaMedia.add(p);
        listaMedia.add(s);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpmEliminar = new javax.swing.JPopupMenu();
        jmiEliminar = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListaMedia = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmArchivo = new javax.swing.JMenu();
        jmiGuardar = new javax.swing.JMenuItem();
        jmiCargar = new javax.swing.JMenuItem();
        jmCrear = new javax.swing.JMenu();
        jmiCrearPelicula = new javax.swing.JMenuItem();
        jmiCrearSerie = new javax.swing.JMenuItem();

        jmiEliminar.setText("Eliminar");
        jmiEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEliminarActionPerformed(evt);
            }
        });
        jpmEliminar.add(jmiEliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtListaMedia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtListaMedia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListaMediaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtListaMedia);

        jmArchivo.setText("Archivo");

        jmiGuardar.setText("Guardar");
        jmArchivo.add(jmiGuardar);

        jmiCargar.setText("Cargar");
        jmArchivo.add(jmiCargar);

        jMenuBar1.add(jmArchivo);

        jmCrear.setText("Crear");

        jmiCrearPelicula.setText("Crear Pelicula");
        jmiCrearPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCrearPeliculaActionPerformed(evt);
            }
        });
        jmCrear.add(jmiCrearPelicula);

        jmiCrearSerie.setText("Crear Serie");
        jmiCrearSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCrearSerieActionPerformed(evt);
            }
        });
        jmCrear.add(jmiCrearSerie);

        jMenuBar1.add(jmCrear);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiCrearSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCrearSerieActionPerformed
        JDCrearSerie jDCrearSerie = new JDCrearSerie(this, rootPaneCheckingEnabled, listaMedia);
        jDCrearSerie.setVisible(true);
        
        if (jDCrearSerie.isCreada()) {
            Serie nuevaSerie = jDCrearSerie.getSerie();
            this.listaMedia.add(nuevaSerie);
            this.modelo.añadirMedia(nuevaSerie);
        }
    }//GEN-LAST:event_jmiCrearSerieActionPerformed

    private void jmiCrearPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCrearPeliculaActionPerformed
        JDCrearPelicula jDCrearPelicula = new JDCrearPelicula(this, rootPaneCheckingEnabled);
        jDCrearPelicula.setVisible(true);
        
        if (jDCrearPelicula.isCreada()) {
            Pelicula nuevaPelicula = jDCrearPelicula.getPelicula();
            boolean peliculaDuplicada = listaMedia.contains(nuevaPelicula);
            boolean noCreada = false;
            System.out.println(peliculaDuplicada +" "+ noCreada);
            while (peliculaDuplicada && !noCreada) {
                JOptionPane.showMessageDialog(rootPane, "Ya existe otra Película con el mismo Título y Calificación de Edad");
                jDCrearPelicula.setVisible(true);
                if (jDCrearPelicula.isCreada()) {
                    nuevaPelicula = jDCrearPelicula.getPelicula();
                    peliculaDuplicada = listaMedia.contains(nuevaPelicula);
                    
                } else {
                    noCreada = true;
                }
            }
            
            if (!peliculaDuplicada) {
                this.listaMedia.add(nuevaPelicula);
                this.modelo.añadirMedia(nuevaPelicula);
            }
        }
    }//GEN-LAST:event_jmiCrearPeliculaActionPerformed

    private void jtListaMediaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListaMediaMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) { // Si es Click Derecho
            // Mostramos  el Menú
            jpmEliminar.show(jtListaMedia, evt.getX(), evt.getY());
        } else if (evt.getClickCount() == 2) { // Si ha realizado Dos Clicks
            int index = jtListaMedia.getSelectedRow(); // Obtenemos el indice de la canción seleccionada (JTable)
            Media mediaSeleccionada = listaMedia.get(index); // Creamos el JDialog para modificar la Canción
            
            if (mediaSeleccionada instanceof Pelicula) {
                JDGestionarPelicula jDGestionarPelicula = new JDGestionarPelicula(this, true, (Pelicula) mediaSeleccionada,listaMedia);
                jDGestionarPelicula.setVisible(true);
                modelo.fireTableDataChanged();
            } else if (mediaSeleccionada instanceof Serie) {
                JDGestionarSerie jDGestionarSerie = new JDGestionarSerie(this, true, (Serie) mediaSeleccionada, listaMedia);
                jDGestionarSerie.setVisible(true);
                modelo.fireTableDataChanged();
            }
        }
    }//GEN-LAST:event_jtListaMediaMouseClicked

    private void jmiEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEliminarActionPerformed
        int index = jtListaMedia.getSelectedRow(); // Obteenos el indice        
        this.listaMedia.remove(index); // Lo eliminamos de la lista
        modelo.eliminarMedia(index); // Lo eliminamos de la Tabla
    }//GEN-LAST:event_jmiEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(IntefazJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IntefazJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IntefazJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IntefazJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IntefazJF().setVisible(true);
            }
        });
    }

    private ArrayList<Media> listaMedia;
    private ModeloListaMedia modelo;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu jmArchivo;
    private javax.swing.JMenu jmCrear;
    private javax.swing.JMenuItem jmiCargar;
    private javax.swing.JMenuItem jmiCrearPelicula;
    private javax.swing.JMenuItem jmiCrearSerie;
    private javax.swing.JMenuItem jmiEliminar;
    private javax.swing.JMenuItem jmiGuardar;
    private javax.swing.JPopupMenu jpmEliminar;
    private javax.swing.JTable jtListaMedia;
    // End of variables declaration//GEN-END:variables
}
