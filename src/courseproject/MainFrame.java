/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Josh Notter
 */
public class MainFrame extends javax.swing.JFrame {
final String Shop_DB_URL = "jdbc:derby://localhost:1527/dbCoffeeStoreData";
    static Connection conn;
    static Statement statement;
    static ResultSet resultsOfQuery = null;
    static String sql;
    static ResultSetMetaData meta;
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        
        try{
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch(ClassNotFoundException e){

        }
         try{
            this.conn = DriverManager.getConnection(Shop_DB_URL,"Username","Password"); 
            this.statement = conn.createStatement();
            
            // TODO add your handling code here:
            statement.execute("Create Table Customer(customerNumber Varchar(10) NOT NULL PRIMARY KEY,"
                + " firstName Varchar(30) NOT NULL, lastName Varchar(30) NOT NULL, street Varchar(30) NOT NULL,"
                + " city Varchar(30) NOT NULL, state Varchar (2) NOT NULL, zip Varchar(30) NOT NULL, "
                + "phoneNumber Varchar(30) NOT NULL,"
                + "email Varchar (30) NOT NULL, creditLimit Double NOT NULL)");
            statement.execute("Create Table Coffee(coffeeID Varchar(10) NOT NULL, name Varchar(30) NOT NULL,"
                    + "description Varchar(100) NOT NULL, price Double NOT NULL, stock Int NOT NULL)");
            statement.execute("Create Table Orders(orderID Varchar(10) NOT NULL, custID Varchar(10) NOT NULL,"
                    + "coffeeID Varchar(10) NOT NULL, numOrdered Double NOT NULL, total Double NOT NULL)");
        
            
            
            sql = "select * from Customer";
            resultsOfQuery = statement.executeQuery(sql); //Remember to tell them its Execute Query like Fig 24.23

            ResultSetMetaData meta = resultsOfQuery.getMetaData(); 
        
            statement.execute("DROP TABLE Customer");
            statement.execute("DROP TABLE Coffee");
            statement.execute("DROP TABLE Orders");
            
            
        } 
            catch (SQLException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("This program is a prototype developed to track, add, and display data about customers, coffee, and orders for a coffee shop.\n\nThere are two menu options: Menus and Prototype Controls.\n\nMenus can be used to navigate to the various parts of this program.\n\nPrototype controls can be used to create/delete data and insert test data for demonstration purposes.");
        jScrollPane1.setViewportView(jTextArea1);

        jMenu1.setText("Menus");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("Customer");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setText("Coffee");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem3.setText("Orders");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem4.setText("New Customer");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem5.setText("New Order");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("ProtoType Controls");

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem6.setText("Create Database");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem7.setText("Reset Database");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem8.setText("Insert Test Records");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CoffeeFrame().setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerFrame().setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrdersFrame().setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewCustFrame().setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewOrdersFrame().setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
    try {
        // TODO add your handling code here:
        statement.execute("Create Table Customer(customerNumber Varchar(10) NOT NULL PRIMARY KEY,"
                + " firstName Varchar(30) NOT NULL, lastName Varchar(30) NOT NULL, street Varchar(30) NOT NULL,"
                + " city Varchar(30) NOT NULL, state Varchar (10) NOT NULL, zip Varchar(30) NOT NULL, "
                + "phoneNumber Varchar(30) NOT NULL,"
                + "email Varchar (30) NOT NULL, creditLimit Double NOT NULL)");
    } catch (SQLException ex) {
        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        statement.execute("Create Table Coffee(coffeeID Varchar(10) NOT NULL, name Varchar(30) NOT NULL,"
                + "description Varchar(100) NOT NULL, price Double NOT NULL, stock Int NOT NULL)");
    } catch (SQLException ex) {
        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        statement.execute("Create Table Orders(orderID Varchar(10) NOT NULL, custID Varchar(10) NOT NULL,"
                + "coffeeID Varchar(10) NOT NULL, numOrdered Double NOT NULL, total Double NOT NULL)");
    } catch (SQLException ex) {
        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
    try {
        // TODO add your handling code here:
        statement.execute("DROP TABLE Customer");
        statement.execute("DROP TABLE Coffee");
        statement.execute("DROP TABLE Orders");
        
        statement.execute("Create Table Customer(customerNumber Varchar(10) NOT NULL PRIMARY KEY,"
                + " firstName Varchar(30) NOT NULL, lastName Varchar(30) NOT NULL, street Varchar(30) NOT NULL,"
                + " city Varchar(30) NOT NULL, state Varchar (10) NOT NULL, zip Varchar(30) NOT NULL, "
                + "phoneNumber Varchar(30) NOT NULL,"
                + "email Varchar (30) NOT NULL, creditLimit Double NOT NULL)");
        statement.execute("Create Table Coffee(coffeeID Varchar(10) NOT NULL, name Varchar(30) NOT NULL,"
                + "description Varchar(100) NOT NULL, price Double NOT NULL, stock Int NOT NULL)");
        statement.execute("Create Table Orders(orderID Varchar(10) NOT NULL, custID Varchar(10) NOT NULL,"
                + "coffeeID Varchar(10) NOT NULL, numOrdered Double NOT NULL, total Double NOT NULL)");
            
    } catch (SQLException ex) {
        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    try {
        // TODO add your handling code here:
        statement.execute("DROP TABLE Customer");
        statement.execute("DROP TABLE Coffee");
        statement.execute("DROP TABLE Orders");
    } catch (SQLException ex) {
        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        try {
            /* sql = "Insert into Customer values(\'001\', \'Amy\', \'Alpha\', \'111 Pleasant Dr\',\'Pleasantville\',\'NC\',"
                    + "\'27011\', \'111-111-1111\',\'amyalpha@fake.com\', 300)";
            statement.executeUpdate(sql); */
            
            //Insert Customer Data
            sql = "Insert into Customer values(\'001\', \'Andrew\', \'Alpha\', \'111 Pleasant Dr\',\'Pleasantville\',\'NC\',"
                    + "\'27011\', \'111-111-1111\',\'amyalpha@fake.com\', 100)";
            statement.executeUpdate(sql);
            sql = "Insert into Customer values(\'002\', \'Blake\', \'Bravo\', \'222 Nowhere St\',\'Nowhereville\',\'GA\',"
                    + "\'18624\', \'222-222-2222\',\'blakebravo@fake.com\', 200)";
            statement.executeUpdate(sql);
            sql = "Insert into Customer values(\'003\', \'Carmen\', \'Charlie\', \'333 Red Creek Rd\',\'Redville\',\'NC\',"
                    + "\'27055\', \'333-333-3333\',\'carmencharlie@fake.com\', 300)";
            statement.executeUpdate(sql);
            sql = "Insert into Customer values(\'004\', \'Daniel\', \'Delta\', \'444 Hamish Cr\',\'Hamish City\',\'GA\',"
                    + "\'28621\', \'444-444-4444\',\'danieldelta@fake.com\', 400)";
            statement.executeUpdate(sql);
            sql = "Insert into Customer values(\'005\', \'Emily\', \'Echo\', \'555 Roundtable Dr\',\'Mount Juliet\',\'TN\',"
                    + "\'26140\', \'555-555-5555\',\'emilyecho@fake.com\', 500)";
            statement.executeUpdate(sql);
            //Insert Coffee Data
            sql = "Insert into Coffee values(\'111\',\'Dark Roast\', \'Deep rich flavor\', 1.99, 7)";
            statement.executeUpdate(sql);
            sql = "Insert into Coffee values(\'222\',\'Light Roast\', \'Smooth columbian blends\', 2.99, 7)";
            statement.executeUpdate(sql);
            sql = "Insert into Coffee values(\'333\',\'Donut Blend\', \'Sweet kicks behind smooth flavor\', 3.99, 7)";
            statement.executeUpdate(sql);
            sql = "Insert into Coffee values(\'444\',\'Fireball\', \'Cinnamon textures overlapping deep flavor\', 4.99, 7)";
            statement.executeUpdate(sql);
            sql = "Insert into Coffee values(\'555\',\'Citrus Blend\', \'Orange peel enriched coffee\', 5.99, 7)";
            statement.executeUpdate(sql);
            //Insert Orders Data
            sql = "Insert into Orders values(\'101\', \'001\', \'111\', 10, 19.90)";
            statement.executeUpdate(sql);
            sql = "Insert into Orders values(\'102\', \'002\', \'222\', 10.0, 29.90)";
            statement.executeUpdate(sql);
            sql = "Insert into Orders values(\'103\', \'003\', \'333\', 10, 39.90)";
            statement.executeUpdate(sql);
            sql = "Insert into Orders values(\'104\', \'004\', \'444\', 10, 49.90)";
            statement.executeUpdate(sql);
            sql = "Insert into Orders values(\'105\', \'005\', \'555\', 10, 59.90)";
            statement.executeUpdate(sql);
            sql = "Insert into Orders values(\'106\', \'001\', \'111\', 10, 19.90)";
            statement.executeUpdate(sql);
            sql = "Insert into Orders values(\'107\', \'001\', \'111\', 10, 19.90)";
            statement.executeUpdate(sql);
            sql = "Insert into Orders values(\'108\', \'001\', \'111\', 10, 19.90)";
            statement.executeUpdate(sql);
            sql = "Insert into Orders values(\'109\', \'001\', \'111\', 10, 19.90)";
            statement.executeUpdate(sql);
            sql = "Insert into Orders values(\'110\', \'001\', \'111\', 10, 19.90)";
            statement.executeUpdate(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
