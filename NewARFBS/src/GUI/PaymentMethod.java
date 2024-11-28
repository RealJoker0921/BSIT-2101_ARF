/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Connectors.dbconnect;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

/**
 *
 * @author User
 */
public class PaymentMethod extends javax.swing.JFrame {
        private Connection conn;
        private String query;
        private String updateCustomerQuery;
    /**
     * Creates new form PaymentMethod
     */
    public PaymentMethod() {
        initComponents();
        dbconnect dbc = new dbconnect();
        conn = dbc.getConnection();
        loadData(1);
    }
    
    public void loadData(int tenantID) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clear any previous rows

        try {
            // SQL Query to fetch data for the specified TenantID
            String query = "SELECT customertenants.TenantID, customertenants.TenantName, customertenants.LastName, " +
                           "rooms.RoomID, rooms.RoomSize , customertenants.CheckInDate, customertenants.CheckOutDate, " +
                           "rooms.BedType, rooms.RoomPricePerHead " +
                           "FROM customertenants " +
                           "JOIN rooms ON customertenants.RoomID = rooms.RoomID " +  // Assuming there's a RoomID in customertenants table
                           "WHERE customertenants.TenantID = ?";  // Using ? placeholder for prepared statement

            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, tenantID); // Set the tenantID passed as argument in the query

            ResultSet rs = pstmt.executeQuery(); // Execute the query

            // Populate Data in Table
            while (rs.next()) {
                String tenantName = rs.getString("TenantName");
                String lastName = rs.getString("LastName");
                int roomID = rs.getInt("RoomID");
                String roomType = rs.getString("BedType");
                String bed = rs.getString("RoomSize");
                String checkInDate = rs.getString("CheckInDate");
                String checkOutDate = rs.getString("CheckOutDate");
                double roomPrice = rs.getDouble("RoomPricePerHead");

                // Calculate the number of days stayed
                Date checkIn = rs.getDate("CheckInDate");
                Date checkOut = rs.getDate("CheckOutDate");
                long diffInMillies = Math.abs(checkOut.getTime() - checkIn.getTime());
                long daysStayed = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

                // Calculate water and electricity bills
                double waterBillPerDay = 15.0;  // Example: 15 PHP per day for water
                double electricityBillPerDay = 40.0;  // Example: 40 PHP per day for electricity
                double totalRoomPrice = roomPrice * daysStayed;
                double totalWaterBill = waterBillPerDay * daysStayed;
                double totalElectricityBill = electricityBillPerDay * daysStayed;
                double totalAmount = totalRoomPrice + totalWaterBill + totalElectricityBill;

                // Add a new row with the necessary data
                Object[] rowData = {tenantName, lastName, roomID, roomType, bed, checkInDate, checkOutDate, 
                                    totalWaterBill, totalElectricityBill, totalAmount};
                model.addRow(rowData);  // Add row data to the table
            }

            rs.close();  // Close the ResultSet
            pstmt.close();  // Close the PreparedStatement
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while loading data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        Payment = new javax.swing.JButton();
        txtPaymentAmount = new javax.swing.JTextField();
        bttnClear = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bttnexit = new javax.swing.JButton();
        txtTenantID = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/payment-method.png"))); // NOI18N
        jLabel1.setText("Payment Method");

        jButton1.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "First Name", "Last Name", "Room ID", "Bed Type", "Room Size", "Check In Date", "Check Out Date", "Electric Bill", "Water Bill", "Total  Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jLabel4.setText("Amount:");

        Payment.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        Payment.setText("Payment");
        Payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymentActionPerformed(evt);
            }
        });

        txtPaymentAmount.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N

        bttnClear.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        bttnClear.setText("Clear");
        bttnClear.setToolTipText("");
        bttnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnClearActionPerformed(evt);
            }
        });

        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPaymentAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Payment)
                        .addGap(461, 461, 461)
                        .addComponent(bttnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 943, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 36, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Payment)
                    .addComponent(jLabel4)
                    .addComponent(txtPaymentAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttnClear))
                .addGap(48, 48, 48))
        );

        bttnexit.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        bttnexit.setText("Back");
        bttnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnexitActionPerformed(evt);
            }
        });

        txtTenantID.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jLabel12.setText("Tenant ID:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bttnexit)
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenantID, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(90, 90, 90))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bttnexit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(txtTenantID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bttnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnexitActionPerformed
        setVisible(false);
    }//GEN-LAST:event_bttnexitActionPerformed

    private void PaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymentActionPerformed
        String sTid = txtTenantID.getText();  
        String sPaymentAmount = txtPaymentAmount.getText(); 

        // Show a confirmation dialog and store the user's response
        int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to proceed with this payment?", "Confirm Payment", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            System.out.println("User clicked YES. Proceeding with payment.");

            try {
                double paymentAmount = Double.parseDouble(sPaymentAmount);

                try (Connection connect = dbconnect.getConnection()) {
                    // Query to fetch tenant and room details
                    String query = "SELECT TenantID, TenantName, LastName, Gender, Bed, ContactNumber, RoomID, CheckInDate, CheckOutDate, RoomType FROM customertenants WHERE TenantID = ?";
                    PreparedStatement stmt = connect.prepareStatement(query);
                    stmt.setInt(1, Integer.parseInt(sTid));
                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                        int tenantID = rs.getInt("TenantID");
                        String tenantName = rs.getString("TenantName");
                        String lastName = rs.getString("LastName");
                        String gender = rs.getString("Gender");
                        String bed = rs.getString("Bed");
                        String contactNumber = rs.getString("ContactNumber");
                        int roomID = rs.getInt("RoomID");
                        Date checkInDate = rs.getDate("CheckInDate");
                        Date checkOutDate = rs.getDate("CheckOutDate");
                        String roomType = rs.getString("RoomType");

                        // Calculate the number of days stayed
                        long diffInMillies = Math.abs(checkOutDate.getTime() - checkInDate.getTime());
                        long daysStayed = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

                        // Fetch the room price
                        String roomQuery = "SELECT RoomPricePerHead FROM rooms WHERE RoomID = ?";
                        PreparedStatement roomStmt = connect.prepareStatement(roomQuery);
                        roomStmt.setInt(1, roomID);
                        ResultSet roomRs = roomStmt.executeQuery();

                        double roomPrice = 0.0;
                        if (roomRs.next()) {
                            roomPrice = roomRs.getDouble("RoomPricePerHead");
                        }

                        // Adjust room price based on bed type
                        if ("Single".equalsIgnoreCase(bed)) {
                            roomPrice *= 1;  // Price for Single bed (no change)
                        } else if ("Double".equalsIgnoreCase(bed)) {
                            roomPrice *= 2;  // Price for Double bed (multiply by 2)
                        } else if ("Group".equalsIgnoreCase(bed)) {
                            roomPrice *= 4;  // Price for Group bed (multiply by 4, or any appropriate multiplier)
                        }

                        // Calculate total room price based on days stayed
                        double totalRoomPrice = roomPrice * daysStayed;

                        // Calculate water and electricity bills
                        double waterBillPerDay = 15.0;  // Example: 15 PHP per day for water
                        double electricityBillPerDay = 40.0;  // Example: 40 PHP per day for electricity
                        double totalWaterBill = waterBillPerDay * daysStayed;
                        double totalElectricityBill = electricityBillPerDay * daysStayed;
                        double newTotalAmount = totalRoomPrice + totalWaterBill + totalElectricityBill;

                        // Check if the tenant has already made a payment
                        String paymentCheckQuery = "SELECT TotalAmount, PaymentAmount FROM payments WHERE TenantID = ?";
                        PreparedStatement paymentCheckStmt = connect.prepareStatement(paymentCheckQuery);
                        paymentCheckStmt.setInt(1, tenantID);
                        ResultSet paymentRs = paymentCheckStmt.executeQuery();

                        double previousTotalAmount = 0.0;
                        double previousPayment = 0.0;

                        if (paymentRs.next()) {
                            previousTotalAmount = paymentRs.getDouble("TotalAmount");
                            previousPayment = paymentRs.getDouble("PaymentAmount");
                        }

                        // Calculate the additional amount required based on new and previous totals
                        double additionalAmount = newTotalAmount - previousTotalAmount;

                        if (paymentAmount < additionalAmount) {
                            JOptionPane.showMessageDialog(null, "No additional payment is required.", "Payment Info", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }

                        // Check if the payment is sufficient for the additional amount
                        //if (paymentAmount < additionalAmount) {
                        //    JOptionPane.showMessageDialog(null, "Insufficient payment! The additional amount required is: " + additionalAmount + " PHP", "Payment Error", JOptionPane.ERROR_MESSAGE);
                         //   return;
                        //}

                        // Calculate the change
                        double change = paymentAmount - additionalAmount;

                        // Insert the new payment difference into the database
                        String receiptQuery = "INSERT INTO payments (TenantID, RoomID, CheckInDate, CheckOutDate, RoomPrice, WaterBill, ElectricityBill, TotalAmount, PaymentAmount, ChangeAmount, PaymentDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement receiptStmt = connect.prepareStatement(receiptQuery);
                        receiptStmt.setInt(1, tenantID);
                        receiptStmt.setInt(2, roomID);
                        receiptStmt.setDate(3, new java.sql.Date(checkInDate.getTime()));
                        receiptStmt.setDate(4, new java.sql.Date(checkOutDate.getTime()));
                        receiptStmt.setDouble(5, totalRoomPrice);
                        receiptStmt.setDouble(6, totalWaterBill);
                        receiptStmt.setDouble(7, totalElectricityBill);
                        receiptStmt.setDouble(8, newTotalAmount);
                        receiptStmt.setDouble(9, paymentAmount);
                        receiptStmt.setDouble(10, change);
                        receiptStmt.setDate(11, new java.sql.Date(System.currentTimeMillis()));
                        receiptStmt.executeUpdate();

                        // Show the receipt with tenant details
                        String receiptMessage = "Additional Payment Received!\n\n" +
                                "================= Tenant Details =================\n" +
                                "Tenant ID: " + tenantID + "\n" +
                                "Tenant Name: " + tenantName + " " + lastName + "\n" +
                                "Gender: " + gender + "\n" +
                                "Bed Type: " + bed + "\n" +
                                "Contact Number: " + contactNumber + "\n" +
                                "Room ID: " + roomID + "\n" +
                                "Check-in Date: " + checkInDate + "\n" +
                                "Check-out Date: " + checkOutDate + "\n" +
                                "Room Type: " + roomType + "\n\n" +
                                "================ Previous Payment =================\n" +
                                "Previous Total Amount: " + previousTotalAmount + " PHP\n" +
                                "Previous Payment: " + previousPayment + " PHP\n\n" +
                                "================= New Payment =====================\n" +
                                "Updated Room Price: " + totalRoomPrice + " PHP\n" +
                                "Updated Water Bill: " + totalWaterBill + " PHP\n" +
                                "Updated Electricity Bill: " + totalElectricityBill + " PHP\n" +
                                "New Total Amount: " + newTotalAmount + " PHP\n" +
                                "Additional Amount Required: " + additionalAmount + " PHP\n" +
                                "Payment Received: " + paymentAmount + " PHP\n" +
                                "Change: " + change + " PHP\n" +
                                "===================================================";

                        JOptionPane.showMessageDialog(null, receiptMessage, "Receipt", JOptionPane.INFORMATION_MESSAGE);
                        txtPaymentAmount.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Tenant not found!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error processing payment!", "Payment Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Payment must be a valid number!", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            System.out.println("User clicked NO. Operation aborted.");
        }

    }//GEN-LAST:event_PaymentActionPerformed

    private void bttnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnClearActionPerformed
        setVisible(false);
        new CustomerCheckin().setVisible(true);
    }//GEN-LAST:event_bttnClearActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Get tenant ID from text field (txtTenantID is the text field for tenant ID)
        String tenantIDText = txtTenantID.getText();

        // Validate tenant ID input
        if (tenantIDText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a Tenant ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return; // Exit if no tenant ID is entered
        }

        try {
            int tenantID = Integer.parseInt(tenantIDText);  // Parse the tenant ID

            // Call loadData to populate the table with data for the specific tenant ID
            loadData(tenantID);

        } catch (NumberFormatException e) {
            // Handle invalid tenant ID format (not an integer)
            JOptionPane.showMessageDialog(null, "Invalid Tenant ID format.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(PaymentMethod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaymentMethod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaymentMethod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaymentMethod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaymentMethod().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Payment;
    private javax.swing.JButton bttnClear;
    private javax.swing.JButton bttnexit;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtPaymentAmount;
    private javax.swing.JTextField txtTenantID;
    // End of variables declaration//GEN-END:variables

    
    
}
