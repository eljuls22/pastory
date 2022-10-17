/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mx.itson.pastory.presentacion;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mx.itson.pastory.entidades.Cliente;
import mx.itson.pastory.persistencia.ClienteDAO;

/**
 *
 * @author julio
 */
public class ClienteListado extends javax.swing.JFrame {

    /**
     * Creates new form ClienteListado
     */
    public ClienteListado() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem3 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnAgregarCliente = new javax.swing.JMenuItem();
        btnEditarCliente = new javax.swing.JMenuItem();
        btnEliminarCliente = new javax.swing.JMenuItem();
        btnCargar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        btnVerCuentas = new javax.swing.JMenuItem();

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Direccion", "Telefono", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClientes.setColumnSelectionAllowed(true);
        tblClientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblClientes);

        jMenu1.setText("Opciones");

        btnAgregarCliente.setText("Agregar cliente");
        btnAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarClienteActionPerformed(evt);
            }
        });
        jMenu1.add(btnAgregarCliente);

        btnEditarCliente.setText("Editar cliente");
        btnEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarClienteActionPerformed(evt);
            }
        });
        jMenu1.add(btnEditarCliente);

        btnEliminarCliente.setText("Eliminar cliente");
        btnEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarClienteActionPerformed(evt);
            }
        });
        jMenu1.add(btnEliminarCliente);

        btnCargar.setText("Cargar ");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });
        jMenu1.add(btnCargar);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Cuenta");

        btnVerCuentas.setText("Ver cuentas");
        btnVerCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerCuentasActionPerformed(evt);
            }
        });
        jMenu2.add(btnVerCuentas);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClienteActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
        int id = Integer.parseInt(String.valueOf(modelo.getValueAt(tblClientes.getSelectedRow(), 0)));
        int confirmar = JOptionPane.showConfirmDialog(null, "¿Realmente desea eliminar este registro?", "Confirmar eliminacion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (confirmar == 0) {
            ClienteDAO.Eliminar(id);
            cargar();
        } else {
            cargar();
        }
    }//GEN-LAST:event_btnEliminarClienteActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:

        cargar();

    }//GEN-LAST:event_formWindowOpened

    private void btnAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClienteActionPerformed
        // TODO add your handling code here:
        ClienteForm agregar = new ClienteForm(this, true, 0);

        agregar.setVisible(true);

    }//GEN-LAST:event_btnAgregarClienteActionPerformed

    private void btnEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarClienteActionPerformed
        // TODO add your handling code here:
        int renglon = tblClientes.getSelectedRow();
        String id = tblClientes.getModel().getValueAt(renglon, 0).toString();
        ClienteForm f = new ClienteForm(this, true, Integer.parseInt(id));
        f.setVisible(true);

    }//GEN-LAST:event_btnEditarClienteActionPerformed

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        // TODO add your handling code here:
        cargar();
    }//GEN-LAST:event_btnCargarActionPerformed

    private void btnVerCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerCuentasActionPerformed
        // TODO add your handling code here:
        int renglon = tblClientes.getSelectedRow();
        String id = tblClientes.getModel().getValueAt(renglon, 0).toString();
        CuentaListado cu = new CuentaListado(this, true, Integer.parseInt(id));
        cu.setVisible(true);

    }//GEN-LAST:event_btnVerCuentasActionPerformed

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
            java.util.logging.Logger.getLogger(ClienteListado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteListado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteListado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteListado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteListado().setVisible(true);
            }
        });
    }

    public void cargar() {
        DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
        modelo.setRowCount(0);
        List<Cliente> clientes = ClienteDAO.obtenerTodos();
        for (Cliente c : clientes) {
            modelo.addRow(new Object[]{
                c.getId(),
                c.getNombre(),
                c.getDireccion(),
                c.getTelefono(),
                c.getEmail()
            });
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnAgregarCliente;
    private javax.swing.JMenuItem btnCargar;
    private javax.swing.JMenuItem btnEditarCliente;
    private javax.swing.JMenuItem btnEliminarCliente;
    private javax.swing.JMenuItem btnVerCuentas;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientes;
    // End of variables declaration//GEN-END:variables
}
