/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import static SigningIn.ConnectMSSQL.connected;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tashreef
 */
public class DisplayInfo extends javax.swing.JFrame {

    /**
     * Creates new form DisplayInfo
     */
    public DisplayInfo() {
        initComponents();
        if(((String)jComboBox1.getSelectedItem()).equals("--")){
           jPanel1.setVisible(false); 
        }
        else{
            jPanel1.setVisible(true);
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

        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "Persons", "Admin", "Security", "Payments", "GuestInfo", "Visitor", "ParkingSlot", "ParkingRecord" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        if(((String)jComboBox1.getSelectedItem()).equals("--")){
           jPanel1.setVisible(false); 
        }
        else{
            jPanel1.setVisible(true);
            String val = (String) jComboBox1.getSelectedItem();
            if(val.equals("Persons")){
                ShowPersons();
            }
            else if(val.equals("Admin")){
                ShowAdmin();
            }
            else if(val.equals("Security")){
                ShowSecurity();
            }
            else if(val.equals("Payments")){
                ShowPayments();
            }
            else if(val.equals("ParkingSlot")){
                ShowParkingSlot();
            }
            else if(val.equals("ParkingRecord")){
                ShowParkingRecord();
            }
            else if(val.equals("GuestInfo")){
                ShowGuestinfo();
            }
            else if(val.equals("Visitor")){
                ShowVisitor();
            }
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        AdminInfo.main(null);
    }//GEN-LAST:event_jButton2ActionPerformed
    void ShowPersons(){
        try {
            PreparedStatement statement = connected.prepareStatement("SELECT * from Persons");
            statement.execute();
            ResultSet resultSet = statement.executeQuery();
            DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
            tb.setRowCount(0);
            tb.setColumnIdentifiers(new Object[]{"Name", "FlatNo", "ContactNo"});
            Object[] row = new Object[3];
            while (resultSet.next()) {
                row[0] = resultSet.getString("Name");
                row[1] = resultSet.getString("FlatNo");
                row[2] = resultSet.getString("ContactNo");
                tb.addRow(row);
            }
            jTable1.setModel(tb);
        } catch (SQLException e) {
            System.out.println("Error found at DisplayInfo Class in Persons");
            System.out.println("Error: " + e);
        }
    }
    void ShowAdmin(){
        try {
            PreparedStatement statement = connected.prepareStatement("SELECT * from Admin");
            statement.execute();
            ResultSet resultSet = statement.executeQuery();
            DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
            tb.setRowCount(0);
            tb.setColumnIdentifiers(new Object[]{"AdminId", "AdminName", "Status"});
            Object[] row = new Object[3];
            while (resultSet.next()) {
                row[0] = resultSet.getString("AdminId");
                row[1] = resultSet.getString("AdminName");
                row[2] = resultSet.getString("Status");
                tb.addRow(row);
            }
            jTable1.setModel(tb);
        } catch (SQLException e) {
            System.out.println("Error found at DisplayInfo Class at Admin");
            System.out.println("Error: " + e);
        }
    }
    
    void ShowSecurity(){
        try {
            PreparedStatement statement = connected.prepareStatement("SELECT * from Security");
            statement.execute();
            ResultSet resultSet = statement.executeQuery();
            DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
            tb.setRowCount(0);
            tb.setColumnIdentifiers(new Object[]{"SecurityId", "SecurityName"});
            Object[] row = new Object[2];
            while (resultSet.next()) {
                row[0] = resultSet.getString("SecurityId");
                row[1] = resultSet.getString("SecurityName");
                tb.addRow(row);
            }
            jTable1.setModel(tb);
        } catch (SQLException e) {
            System.out.println("Error found at DisplayInfo Class at Security");
            System.out.println("Error: " + e);
        }
    }
    
    void ShowPayments(){
        try {
            PreparedStatement statement = connected.prepareStatement("SELECT * from Payments");
            statement.execute();
            ResultSet resultSet = statement.executeQuery();
            DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
            tb.setRowCount(0);
            tb.setColumnIdentifiers(new Object[]{"Id", "FlatNo","DateofPayment","PaidFor"});
            Object[] row = new Object[4];
            while (resultSet.next()) {
                row[0] = resultSet.getString("Id");
                row[1] = resultSet.getString("FlatNo");
                row[2] = resultSet.getString("DateofPayment");
                row[3] = resultSet.getString("PaidFor");
                tb.addRow(row);
            }
            jTable1.setModel(tb);
        } catch (SQLException e) {
            System.out.println("Error found at DisplayInfo Class at Payment");
            System.out.println("Error: " + e);
        }
    }
    
    void ShowParkingSlot(){
        try {
            PreparedStatement statement = connected.prepareStatement("SELECT * from ParkingSlot");
            statement.execute();
            ResultSet resultSet = statement.executeQuery();
            DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
            tb.setRowCount(0);
            tb.setColumnIdentifiers(new Object[]{"SlotNo", "Status","SlotOwnerId","SlotUserId"});
            Object[] row = new Object[4];
            while (resultSet.next()) {
                row[0] = resultSet.getString("SlotNo");
                row[1] = resultSet.getString("Status");
                row[2] = resultSet.getString("SlotOwnerId");
                row[3] = resultSet.getString("SlotUserId");
                tb.addRow(row);
            }
            jTable1.setModel(tb);
        } catch (SQLException e) {
            System.out.println("Error found at DisplayInfo Class at ParkingSlot");
            System.out.println("Error: " + e);
        }
    }
   
    void ShowParkingRecord(){
        try {
            PreparedStatement statement = connected.prepareStatement("SELECT * from ParkingRecord");
            statement.execute();
            ResultSet resultSet = statement.executeQuery();
            DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
            tb.setRowCount(0);
            tb.setColumnIdentifiers(new Object[]{"RecordNo", "VehicleNo","ParkingSlotNo","EntryTime","ExitTime"});
            Object[] row = new Object[5];
            while (resultSet.next()) {
                row[0] = resultSet.getString("RecordNo");
                row[1] = resultSet.getString("VehicleNo");
                row[2] = resultSet.getString("ParkingSlotNo");
                row[3] = resultSet.getString("EntryTime");
                row[4] = resultSet.getString("ExitTime");
                tb.addRow(row);
            }
            jTable1.setModel(tb);
        } catch (SQLException e) {
            System.out.println("Error found at DisplayInfo Class at ParkingRecord");
            System.out.println("Error: " + e);
        }
    }
    
    void ShowGuestinfo(){
        try {
            PreparedStatement statement = connected.prepareStatement("SELECT * from GuestInfo");
            statement.execute();
            ResultSet resultSet = statement.executeQuery();
            statement = connected.prepareStatement("Select COUNT(GuestId) FROM Visitor Group BY GuestId");
            statement.execute();
            ResultSet counter = statement.executeQuery();
            DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
            tb.setRowCount(0);
            tb.setColumnIdentifiers(new Object[]{"GuestId", "GuestName","ContactNo","VisitedTime"});
            Object[] row = new Object[4];
            while (resultSet.next()&&counter.next()) {
                row[0] = resultSet.getString("GuestId");
                row[1] = resultSet.getString("GuestName");
                row[2] = resultSet.getString("ContactNo");
                row[3] = counter.getString(1);
                tb.addRow(row);
            }
            jTable1.setModel(tb);
        } catch (SQLException e) {
            System.out.println("Error found at DisplayInfo Class at GuestInfo");
            System.out.println("Error: " + e);
        }
    }
    
    void ShowVisitor(){
        try {
            PreparedStatement statement = connected.prepareStatement("SELECT * from Visitor");
            statement.execute();
            ResultSet resultSet = statement.executeQuery();
            DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
            tb.setRowCount(0);
            tb.setColumnIdentifiers(new Object[]{"EntryId", "Guestid","SecurityId","EntryTime"});
            Object[] row = new Object[4];
            while (resultSet.next()) {
                row[0] = resultSet.getString("EntryId");
                row[1] = resultSet.getString("Guestid");
                row[2] = resultSet.getString("SecurityId");
                row[3] = resultSet.getString("EntryTime");
                tb.addRow(row);
            }
            jTable1.setModel(tb);
        } catch (SQLException e) {
            System.out.println("Error found at DisplayInfo Class at Visitor");
            System.out.println("Error: " + e);
        }
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
            java.util.logging.Logger.getLogger(DisplayInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DisplayInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DisplayInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DisplayInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DisplayInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
