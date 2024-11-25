/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Connectors.dbconnect;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author User
 */
public class HistoryOfTenants extends javax.swing.JFrame {
        private Connection conn;
        private String query;
        
    /**
     * Creates new form HistoryOfTenants
     */
    public HistoryOfTenants() {
        initComponents();
        dbconnect dbc = new dbconnect();
        conn = dbc.getConnection();
        loadData();
    }
    public void loadData() {
    // Clear the existing rows in the table
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0);

    try {
        // SQL Query
        String query = "SELECT payments.PaymentID, customertenants.TenantID, rooms.RoomID, " +
                       "payments.CheckInDate, payments.CheckOutDate, payments.TotalAmount AS Payments " +
                       "FROM payments " +
                       "JOIN customertenants ON customertenants.TenantID = payments.TenantID " +
                       "JOIN rooms ON rooms.RoomID = payments.RoomID;";
        
        // Execute Query
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        // Populate Data in Table
        while (rs.next()) {
            int tenantID = rs.getInt("TenantID");
            int roomID = rs.getInt("RoomID");
            String checkInDate = rs.getString("CheckInDate");
            String checkOutDate = rs.getString("CheckOutDate");
            double payment = rs.getDouble("Payments");
            
            Object[] rowData = {tenantID, roomID, checkInDate, checkOutDate, payment};
            model.addRow(rowData);
        }
        
        // Close Resources
        rs.close();
        stmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    // Refresh Scroll Pane
    jScrollPane1.setViewportView(jTable1);
    jScrollPane1.revalidate();
    jScrollPane1.repaint();
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "TenantID", "RoomID", "CheckINdate", "CheckOUTdate", "Payment"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1027, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(HistoryOfTenants.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistoryOfTenants.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistoryOfTenants.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoryOfTenants.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistoryOfTenants().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
