/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;
import static frames.Expenses.jTable1;
import static frames.Expenses.totalText;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import laundry_service.Employee;
import laundry_service.Transaction;


/**
 *
 * @author Franklin
 */
public class Transactions extends javax.swing.JFrame {

    /**
     * Creates new form transaction
     */
    public Transactions() {
        initComponents();
        
        retrievenewitems();
    }
    
    public JPopupMenu popupMenu;
    public JMenuItem claim;
    public JMenuItem edit;
    public JMenuItem details;
    
    public void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        refresh_btn = new javax.swing.JButton();
        add_btn = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        update_btn = new javax.swing.JButton();
        exit_btn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        transac_table = new javax.swing.JTable();
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem claim = new JMenuItem("Mark as claimed");
        JMenuItem edit = new JMenuItem("Edit this transaction");
        JMenuItem details = new JMenuItem("See transaction details");
        
        popupMenu.add(claim);
        popupMenu.add(edit);
        popupMenu.add(details);
        
        transac_table.setComponentPopupMenu(popupMenu);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(null);

        refresh_btn.setBackground(new java.awt.Color(102, 102, 102));
        refresh_btn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        refresh_btn.setText("REFRESH TABLE");
        refresh_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_btnActionPerformed(evt);
            }
        });
        jPanel1.add(refresh_btn);
        refresh_btn.setBounds(300, 10, 200, 27);

        add_btn.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        add_btn.setText("ADD");
        add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btnActionPerformed(evt);
            }
        });
        jPanel1.add(add_btn);
        add_btn.setBounds(90, 390, 140, 40);

        
        jPanel1.add(delete_btn);
        delete_btn.setBounds(520, 390, 140, 40);

        
        jPanel1.add(update_btn);
        update_btn.setBounds(90, 500, 140, 40);

        exit_btn.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        exit_btn.setText("EXIT");
        exit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btnActionPerformed(evt);
            }
        });
        jPanel1.add(exit_btn);
        exit_btn.setBounds(520, 500, 140, 40);

        transac_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Transaction ID", "Date received", "Date claimed", "Total amount", "OR number", "Services", "Employee-on-duty"
            }
        ));
        jScrollPane3.setViewportView(transac_table);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(20, 50, 770, 330);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    /*
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        refresh_btn = new javax.swing.JButton();
        add_btn = new javax.swing.JButton();
        exit_btn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        transac_table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(null);

        refresh_btn.setBackground(new java.awt.Color(102, 102, 102));
        refresh_btn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        refresh_btn.setText("REFRESH TABLE");
        refresh_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_btnActionPerformed(evt);
            }
        });
        jPanel1.add(refresh_btn);
        refresh_btn.setBounds(300, 10, 200, 27);

        add_btn.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        add_btn.setText("ADD");
        add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btnActionPerformed(evt);
            }
        });
        jPanel1.add(add_btn);
        add_btn.setBounds(90, 390, 140, 40);

        exit_btn.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        exit_btn.setText("EXIT");
        exit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btnActionPerformed(evt);
            }
        });
        jPanel1.add(exit_btn);
        exit_btn.setBounds(550, 390, 140, 40);

        transac_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Transaction ID", "Date received", "Date claimed", "Total amount", "OR number", "Services", "Employee-on-duty"
            }
        ));
        transac_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                transac_tableMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(transac_table);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(20, 50, 770, 330);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    */
    private void refresh_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_btnActionPerformed
        // TODO add your handling code here:
        retrievenewitems();
        
    }//GEN-LAST:event_refresh_btnActionPerformed

    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Login l = new Login();
        //l.setVisible(true);
        if(!l.isVisible())
            new CustInfo().setVisible(true);
    }//GEN-LAST:event_add_btnActionPerformed

    private void exit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new EmployeeLaundry().setVisible(true);
    }//GEN-LAST:event_exit_btnActionPerformed
/*
    private void transac_tableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transac_tableMousePressed
        // TODO add your handling code here:
        Point point  = evt.getPoint();
        int currentRow =  transac_table.rowAtPoint(point);
        transac_table.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_transac_tableMousePressed
*/
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
            java.util.logging.Logger.getLogger(Transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transactions().setVisible(true);
            }
        });
    }
    
    public static void markClaim(){
        
    }
    
    public static void editRow(){
        
    }
    
    public static void seedetails(){
        
    }
    
    public void actionPerformed(ActionEvent event) {
        JMenuItem menu = (JMenuItem) event.getSource();
        if (menu == claim) {
            markClaim();
        } else if (menu == edit) {
            editRow();
        } else if (menu == details){
            seedetails();
        }
    }
    
     
    
    
    public static void retrievenewitems(){
        //Initialize
        DefaultTableModel dtm = new DefaultTableModel(10,10);
        List<String> l = new Vector<String>();
        System.out.println(transac_table.getColumnCount());
        for(int i = 0; i < transac_table.getColumnCount(); i++ ){ //Assign jTable1 number of columns to model
            l.add(transac_table.getColumnName(i));
        }
                
        //Set table model
        dtm.setColumnIdentifiers((Vector) l);
        dtm.setRowCount(0);
        transac_table.setModel(dtm);
        
        
        EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("laundry_servicePU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        List<Transaction> items = (List<Transaction>)em.createQuery("SELECT de from Transaction de").getResultList();
        Iterator i = items.iterator();
        
        Transaction tr;
        
        while(i.hasNext()){
            List<String> data = new Vector<String>();
            tr = (Transaction) i.next();
            data.add(Integer.toString(tr.getTransactionId()));
            data.add(tr.getDateReceived().toString());
            if(tr.getDateClaimed() == null)
                data.add("null");
            else
                data.add(tr.getDateClaimed().toString());
            data.add(Float.toString(tr.getTotalAmount()));
            if(tr.getOrNumber()== null)
                data.add("null");
            else
                data.add(Integer.toString(tr.getOrNumber()));
            data.add(tr.getServicesId().toString());
            Query findEmployee = em.createNamedQuery("Employee.findByEmployeeId");
            findEmployee.setParameter("employeeId", tr.getTransactionId().intValue());
            List<Employee> emp2 = findEmployee.getResultList();
            String employeeName = emp2.get(0).getName();
            System.out.println(emp2.get(0).getName());
            data.add(employeeName);
            dtm.addRow((Vector) data);
        }
        em.close();
                
    }
    
    public static javax.swing.JButton add_btn;
    public static javax.swing.JButton delete_btn;
    public static javax.swing.JButton exit_btn;
    public static javax.swing.JButton refresh_btn;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JButton update_btn;
    public static javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable trans_table;
    public static javax.swing.JTable transac_table;
    public static javax.swing.JScrollPane jScrollPane3;


    
    
/*
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_btn;
    public javax.swing.JButton exit_btn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JButton refresh_btn;
    private javax.swing.JTable transac_table;
    // End of variables declaration//GEN-END:variables
*/
}
