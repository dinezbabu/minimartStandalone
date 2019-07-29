/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimartstore;

import Business.ProductList;
import TableModel.ProductTableModel;
import static Utility.Constant.PRODUCTTABLE;
import java.awt.Dimension;
import java.util.List;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import minimartstore.Entity.Product;

/**
 *
 * @author dbabu
 */
public class ProductGridFrame extends javax.swing.JFrame {
    /**
     * Creates new form ProductGridFrame
     */
    
         DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern( "E MMM dd HH:mm:ss z uuuu" )
                                       .withLocale( Locale.getDefault() );
    public ProductGridFrame() {
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
         BindData(txtBarCode.getText());
         this.setVisible(true);
    }

    private void BindData(String search)
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        tblOrder.setPreferredSize(screenSize);
        tblOrder.setModel(new ProductTableModel(new ProductList(),search));
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();
        lblBarCode = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        txtBarCode = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                formInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "HSN Code", "Particulars", "Qty", "Price", "TotalPrice"
            }
        ));
        tblOrder.setRowHeight(20);
        tblOrder.setShowGrid(true);
        tblOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrderMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblOrder);

        lblBarCode.setText("Bar Code");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        txtBarCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBarCodeKeyReleased(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblBarCode)
                        .addGap(18, 18, 18)
                        .addComponent(txtBarCode, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBarCode)
                    .addComponent(btnAdd)
                    .addComponent(txtBarCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        new ProductFrame();
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtBarCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBarCodeKeyReleased
        // TODO add your handling code here:
                BindData(txtBarCode.getText());
    }//GEN-LAST:event_txtBarCodeKeyReleased

    private void tblOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrderMouseClicked
             
             
    }//GEN-LAST:event_tblOrderMouseClicked

    private void formInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_formInputMethodTextChanged
             tblOrder.getValueAt(tblOrder.getSelectedRow(),tblOrder.getSelectedColumn()); 
             ProductList productList= new ProductList();
             productList.Update(new Product(tblOrder.getValueAt(tblOrder.getSelectedRow(), 1).toString(),
                     ZonedDateTime.parse(tblOrder.getValueAt(tblOrder.getSelectedRow(), 2).toString() , dateTimeFormatter ).toLocalDate(),
                     Integer.parseInt(tblOrder.getValueAt(tblOrder.getSelectedRow(), 3).toString()),
                     Integer.parseInt(tblOrder.getValueAt(tblOrder.getSelectedRow(), 4).toString()),
                     Integer.parseInt(tblOrder.getValueAt(tblOrder.getSelectedRow(), 5).toString()),
                     Float.parseFloat(tblOrder.getValueAt(tblOrder.getSelectedRow(), 6).toString()),
                     Float.parseFloat(tblOrder.getValueAt(tblOrder.getSelectedRow(), 7).toString()),
                     Float.parseFloat(tblOrder.getValueAt(tblOrder.getSelectedRow(), 8).toString()),
                     Float.parseFloat(tblOrder.getValueAt(tblOrder.getSelectedRow(), 9).toString()),
                     Float.parseFloat(tblOrder.getValueAt(tblOrder.getSelectedRow(), 10).toString()),
                    Float.parseFloat( tblOrder.getValueAt(tblOrder.getSelectedRow(), 11).toString()),
                     "Admin",
                     "Admin"));    }//GEN-LAST:event_formInputMethodTextChanged

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
             ProductList productList= new ProductList();
             productList.delete(new Product(tblOrder.getValueAt(tblOrder.getSelectedRow(), 0).toString()));
             BindData(txtBarCode.getText());
    }//GEN-LAST:event_btnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(ProductGridFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductGridFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductGridFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductGridFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductGridFrame().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBarCode;
    private javax.swing.JTable tblOrder;
    private javax.swing.JTextField txtBarCode;
    // End of variables declaration//GEN-END:variables
}
