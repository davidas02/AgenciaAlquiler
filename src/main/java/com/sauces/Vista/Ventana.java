/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.Vista;

import com.sauces.Controlador.Controlador;
import com.sauces.Modelo.Vehiculo;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author daw1
 */
public class Ventana extends javax.swing.JFrame {

    private DialogoVehiculo dialogoVehiculo = new DialogoVehiculo(this, true);
    private Controlador controlador;
    private VehiculoTableModel vehiculoTM;

    /**
     * Creates new form Ventana
     */
    public Ventana() {
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

        selectorFicheros = new javax.swing.JFileChooser();
        bgOrdenListado = new javax.swing.ButtonGroup();
        pDatosVehiculo = new javax.swing.JPanel();
        lMatricula = new javax.swing.JLabel();
        tMatricula = new javax.swing.JTextField();
        lGrupo = new javax.swing.JLabel();
        cbGrupo = new javax.swing.JComboBox<>();
        lTipo = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox<>();
        lPlazas = new javax.swing.JLabel();
        spPlazas = new javax.swing.JSpinner();
        lCapacidad = new javax.swing.JLabel();
        tCapacidad = new javax.swing.JFormattedTextField();
        bBorrar = new javax.swing.JButton();
        bModificar = new javax.swing.JButton();
        pOtrasOperaciones = new javax.swing.JPanel();
        bMasBarato = new javax.swing.JButton();
        bMasCaro = new javax.swing.JButton();
        lPrecioDia = new javax.swing.JLabel();
        tPrecioDia = new javax.swing.JFormattedTextField();
        pListado = new javax.swing.JPanel();
        bListarVehiculos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVehiculos = new javax.swing.JTable();
        lOrdenListado = new javax.swing.JLabel();
        lFiltrarGrupo = new javax.swing.JLabel();
        lFiltrarTipo = new javax.swing.JLabel();
        bMatricula = new javax.swing.JRadioButton();
        bPrecioAlquiler = new javax.swing.JRadioButton();
        cbFiltrarGrupo = new javax.swing.JComboBox<>();
        cbFiltrarTipo = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        miArchivo = new javax.swing.JMenu();
        miAbrir = new javax.swing.JMenuItem();
        miGuardar = new javax.swing.JMenuItem();
        miVehiculo = new javax.swing.JMenu();
        miNuevo = new javax.swing.JMenuItem();
        miBuscar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pDatosVehiculo.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Vehículo"));

        lMatricula.setText("MATRÍCULA");

        tMatricula.setEditable(false);

        lGrupo.setText("GRUPO");

        cbGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C" }));

        lTipo.setText("TIPO");

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TURISMO", "FURGONETA" }));

        lPlazas.setText("PLAZAS");

        lCapacidad.setText("CAPACIDAD");

        tCapacidad.setEditable(false);

        bBorrar.setText("BORRAR");

        bModificar.setText("MODIFICAR");

        pOtrasOperaciones.setBorder(javax.swing.BorderFactory.createTitledBorder("Otras Operaciones"));

        bMasBarato.setText("MOSTRAR VEHÍCULO MÁS BARATO");
        bMasBarato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMasBaratoActionPerformed(evt);
            }
        });

        bMasCaro.setText("MOSTRAR VEHÍCULO MÁS CARO");
        bMasCaro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMasCaroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pOtrasOperacionesLayout = new javax.swing.GroupLayout(pOtrasOperaciones);
        pOtrasOperaciones.setLayout(pOtrasOperacionesLayout);
        pOtrasOperacionesLayout.setHorizontalGroup(
            pOtrasOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pOtrasOperacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pOtrasOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bMasBarato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pOtrasOperacionesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bMasCaro, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pOtrasOperacionesLayout.setVerticalGroup(
            pOtrasOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pOtrasOperacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bMasBarato)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bMasCaro)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        lPrecioDia.setText("PRECIO POR DÍA");

        tPrecioDia.setEditable(false);

        javax.swing.GroupLayout pDatosVehiculoLayout = new javax.swing.GroupLayout(pDatosVehiculo);
        pDatosVehiculo.setLayout(pDatosVehiculoLayout);
        pDatosVehiculoLayout.setHorizontalGroup(
            pDatosVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDatosVehiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pDatosVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pOtrasOperaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pDatosVehiculoLayout.createSequentialGroup()
                        .addComponent(lMatricula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tMatricula))
                    .addGroup(pDatosVehiculoLayout.createSequentialGroup()
                        .addGroup(pDatosVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pDatosVehiculoLayout.createSequentialGroup()
                                .addComponent(lGrupo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lTipo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pDatosVehiculoLayout.createSequentialGroup()
                                .addComponent(bBorrar)
                                .addGap(45, 45, 45)
                                .addComponent(bModificar))
                            .addGroup(pDatosVehiculoLayout.createSequentialGroup()
                                .addComponent(lPlazas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spPlazas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pDatosVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pDatosVehiculoLayout.createSequentialGroup()
                                    .addComponent(lPrecioDia)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tPrecioDia))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pDatosVehiculoLayout.createSequentialGroup()
                                    .addComponent(lCapacidad)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pDatosVehiculoLayout.setVerticalGroup(
            pDatosVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDatosVehiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pDatosVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lMatricula)
                    .addComponent(tMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pDatosVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lGrupo)
                    .addComponent(cbGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lTipo)
                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pDatosVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lPlazas)
                    .addComponent(spPlazas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pDatosVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lCapacidad)
                    .addComponent(tCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pDatosVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lPrecioDia)
                    .addComponent(tPrecioDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(pDatosVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bBorrar)
                    .addComponent(bModificar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pOtrasOperaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pListado.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de vehículos"));

        bListarVehiculos.setText("LISTAR VEHÍCULOS");

        vehiculoTM=new VehiculoTableModel();
        tablaVehiculos.setModel(vehiculoTM);
        jScrollPane1.setViewportView(tablaVehiculos);

        lOrdenListado.setText("ORDEN DEL LISTADO");

        lFiltrarGrupo.setText("FILTRAR POR GRUPO");

        lFiltrarTipo.setText("FILTRAR POR TIPO");

        bgOrdenListado.add(bMatricula);
        bMatricula.setText("MATRÍCULA");

        bgOrdenListado.add(bPrecioAlquiler);
        bPrecioAlquiler.setText("PRECIO ALQUILER");

        cbFiltrarGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "A", "B", "C" }));

        cbFiltrarTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "TURISMO", "FURGONETA" }));

        javax.swing.GroupLayout pListadoLayout = new javax.swing.GroupLayout(pListado);
        pListado.setLayout(pListadoLayout);
        pListadoLayout.setHorizontalGroup(
            pListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pListadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lOrdenListado)
                .addGap(70, 70, 70)
                .addComponent(lFiltrarGrupo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lFiltrarTipo)
                .addGap(57, 57, 57))
            .addGroup(pListadoLayout.createSequentialGroup()
                .addGroup(pListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pListadoLayout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(bListarVehiculos))
                    .addGroup(pListadoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pListadoLayout.createSequentialGroup()
                        .addComponent(bMatricula)
                        .addGap(99, 99, 99)
                        .addComponent(cbFiltrarGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(cbFiltrarTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bPrecioAlquiler))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pListadoLayout.setVerticalGroup(
            pListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pListadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bListarVehiculos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addGroup(pListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lOrdenListado)
                    .addComponent(lFiltrarGrupo)
                    .addComponent(lFiltrarTipo))
                .addGap(28, 28, 28)
                .addGroup(pListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bMatricula)
                    .addComponent(cbFiltrarGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbFiltrarTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bPrecioAlquiler)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        miArchivo.setText("Archivo");

        miAbrir.setText("Abrir");
        miAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAbrirActionPerformed(evt);
            }
        });
        miArchivo.add(miAbrir);

        miGuardar.setText("Guardar");
        miGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miGuardarActionPerformed(evt);
            }
        });
        miArchivo.add(miGuardar);

        jMenuBar1.add(miArchivo);

        miVehiculo.setText("Vehiculo");

        miNuevo.setText("Nuevo");
        miNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNuevoActionPerformed(evt);
            }
        });
        miVehiculo.add(miNuevo);

        miBuscar.setText("Buscar");
        miBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miBuscarActionPerformed(evt);
            }
        });
        miVehiculo.add(miBuscar);

        jMenuBar1.add(miVehiculo);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pDatosVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pListado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pListado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pDatosVehiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAbrirActionPerformed
        // TODO add your handling code here:
        if (selectorFicheros.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            controlador.cargarVehiculos();
        }
    }//GEN-LAST:event_miAbrirActionPerformed

    private void miNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNuevoActionPerformed
        // TODO add your handling code here:
        if (dialogoVehiculo.mostrar() == DialogoVehiculo.ACEPTAR) {
            mostrarMatricula(dialogoVehiculo.getMatricula());
            mostrarGrupo(dialogoVehiculo.getGrupo());
            mostrarTipo(dialogoVehiculo.getTipo());
            if(cbTipo.getSelectedItem().equals("TURISMO")){
                mostrarPlazas(dialogoVehiculo.getPlazas());
            }else{
                mostrarCapacidad(dialogoVehiculo.getCapacidad());}
            controlador.crearVehiculo();
            tablaVehiculos.revalidate();
        }
    }//GEN-LAST:event_miNuevoActionPerformed

    private void miGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miGuardarActionPerformed
        // TODO add your handling code here:
        if (selectorFicheros.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            controlador.guardarVehiculos();
        }
    }//GEN-LAST:event_miGuardarActionPerformed

    private void miBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miBuscarActionPerformed
        // TODO add your handling code here:
        controlador.buscarVehiculo();
    }//GEN-LAST:event_miBuscarActionPerformed

    private void bMasBaratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMasBaratoActionPerformed
        // TODO add your handling code here:
        controlador.buscarVehiculoMasBarato();
    }//GEN-LAST:event_bMasBaratoActionPerformed

    private void bMasCaroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMasCaroActionPerformed
        // TODO add your handling code here:
        controlador.buscarVehiculoMasCaro();
    }//GEN-LAST:event_bMasCaroActionPerformed
    public String getMatricula() {
        return this.tMatricula.getText();
        //
    }

    public String getGrupo() {
        return this.cbGrupo.toString();
    }

    public String getTipo() {
        return this.cbTipo.toString();
    }

    public int getPlazas() {
        return (int) spPlazas.getValue();
    }

    public float getCapacidad() {
        return ((Number) this.tCapacidad.getValue()).floatValue();
    }

    public String getArchivo() {
        return selectorFicheros.getSelectedFile().getAbsolutePath();
    }

    public String getOrden() {
        return bgOrdenListado.getSelection().getActionCommand();
    }

    /*public String getFiltroGrupo(){
    }
    public String getFiltroTipo(){
    }*/
    public void mostrarMatricula(String matricula) {
        this.tMatricula.setText(matricula);
    }

    public void mostrarTipo(String tipo) {
        this.cbTipo.setSelectedItem(tipo);
    }

    public void mostrarGrupo(String grupo) {
        this.cbGrupo.setSelectedItem(grupo);
    }

    public void mostrarPlazas(int plazas) {
        this.spPlazas.setValue(plazas);
    }

    public void mostrarCapacidad(float capacidad) {
        this.tCapacidad.setText(Float.toString(capacidad));
    }

    public void mostrarPrecioAlquiler(float precio) {
        this.tPrecioDia.setText(Float.toString(precio));
    }

    public void listarVehiculos(List<Vehiculo> listado) {
        vehiculoTM.setListadoVehiculos(listado);
        tablaVehiculos.revalidate();
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public boolean solicitarConfirmacion() {
        if (JOptionPane.showConfirmDialog(this, "¿Estás seguro de Borrar? Será permanente") == JOptionPane.OK_OPTION) {
            return true;
        }
        return false;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public void limpiarCampos() {
        this.tMatricula.setText("");
        this.tPrecioDia.setText("");
    }

    public void mostrar() {
        setVisible(true);
    }

    public void actalizarTabla() {
        this.tablaVehiculos.revalidate();
    }

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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBorrar;
    private javax.swing.JButton bListarVehiculos;
    private javax.swing.JButton bMasBarato;
    private javax.swing.JButton bMasCaro;
    private javax.swing.JRadioButton bMatricula;
    private javax.swing.JButton bModificar;
    private javax.swing.JRadioButton bPrecioAlquiler;
    private javax.swing.ButtonGroup bgOrdenListado;
    private javax.swing.JComboBox<String> cbFiltrarGrupo;
    private javax.swing.JComboBox<String> cbFiltrarTipo;
    private javax.swing.JComboBox<String> cbGrupo;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lCapacidad;
    private javax.swing.JLabel lFiltrarGrupo;
    private javax.swing.JLabel lFiltrarTipo;
    private javax.swing.JLabel lGrupo;
    private javax.swing.JLabel lMatricula;
    private javax.swing.JLabel lOrdenListado;
    private javax.swing.JLabel lPlazas;
    private javax.swing.JLabel lPrecioDia;
    private javax.swing.JLabel lTipo;
    private javax.swing.JMenuItem miAbrir;
    private javax.swing.JMenu miArchivo;
    private javax.swing.JMenuItem miBuscar;
    private javax.swing.JMenuItem miGuardar;
    private javax.swing.JMenuItem miNuevo;
    private javax.swing.JMenu miVehiculo;
    private javax.swing.JPanel pDatosVehiculo;
    private javax.swing.JPanel pListado;
    private javax.swing.JPanel pOtrasOperaciones;
    private javax.swing.JFileChooser selectorFicheros;
    private javax.swing.JSpinner spPlazas;
    private javax.swing.JFormattedTextField tCapacidad;
    private javax.swing.JTextField tMatricula;
    private javax.swing.JFormattedTextField tPrecioDia;
    private javax.swing.JTable tablaVehiculos;
    // End of variables declaration//GEN-END:variables
}
