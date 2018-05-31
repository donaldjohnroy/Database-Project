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
import java.util.Random;
import java.util.Vector;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import laundry_service.*;


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
    
    
    
    public void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        refresh_btn = new javax.swing.JButton();
        add_btn = new javax.swing.JButton();
        exit_btn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        transac_table = new javax.swing.JTable();
        claimbutton = new javax.swing.JButton();
        remove = new javax.swing.JButton();

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
        refresh_btn.setBounds(380, 10, 200, 27);

        add_btn.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        add_btn.setText("ADD");
        add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btnActionPerformed(evt);
            }
        });
        jPanel1.add(add_btn);
        add_btn.setBounds(20, 390, 140, 40);

        exit_btn.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        exit_btn.setText("EXIT");
        exit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btnActionPerformed(evt);
            }
        });
        jPanel1.add(exit_btn);
        exit_btn.setBounds(780, 390, 140, 40);

        transac_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Transaction ID", "Customer", "Date received", "Date claimed", "Total amount", "OR number", "Services", "Employee-on-duty"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        transac_table.setColumnSelectionAllowed(false);
        transac_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                transac_tableMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(transac_table);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(20, 50, 910, 330);

        claimbutton.setText("Claim");
        claimbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                claimbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(claimbutton);
        claimbutton.setBounds(190, 390, 130, 40);

        remove.setText("Remove Entry");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        jPanel1.add(remove);
        remove.setBounds(560, 390, 140, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        claimbutton = new javax.swing.JButton();
        remove = new javax.swing.JButton();

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
        refresh_btn.setBounds(380, 10, 200, 27);

        add_btn.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        add_btn.setText("ADD");
        add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btnActionPerformed(evt);
            }
        });
        jPanel1.add(add_btn);
        add_btn.setBounds(20, 390, 140, 40);

        exit_btn.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        exit_btn.setText("EXIT");
        exit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btnActionPerformed(evt);
            }
        });
        jPanel1.add(exit_btn);
        exit_btn.setBounds(780, 390, 140, 40);

        transac_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Transaction ID", "Customer", "Date received", "Date claimed", "Total amount", "OR number", "Services", "Employee-on-duty"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        transac_table.setColumnSelectionAllowed(false);
        transac_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                transac_tableMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(transac_table);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(20, 50, 910, 330);

        claimbutton.setText("Claim");
        claimbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                claimbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(claimbutton);
        claimbutton.setBounds(190, 390, 130, 40);

        remove.setText("Remove Entry");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        jPanel1.add(remove);
        remove.setBounds(560, 390, 140, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void transac_tableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transac_tableMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_transac_tableMousePressed

    private void claimbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_claimbuttonActionPerformed
        // TODO add your handling code here:
        int row = transac_table.getSelectedRow();
        String value = transac_table.getModel().getValueAt(row, 0).toString();
        int id = Integer.valueOf(value);
        updateClaim(id);
       
        
    }//GEN-LAST:event_claimbuttonActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        // TODO add your handling code here:
        int row = transac_table.getSelectedRow();
        String value = transac_table.getModel().getValueAt(row, 0).toString();
        int id = Integer.valueOf(value);
        
        removeTransaction(id);
    }//GEN-LAST:event_removeActionPerformed

/**/
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
    
    public static void removeTransaction(int tID){
        EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("laundry_servicePU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        Transaction transac = (Transaction)em.find(Transaction.class, tID);
        ServicesAvailed sa = (ServicesAvailed)em.find(ServicesAvailed.class, transac.getServicesId().getServiceId());
        LaundryInfo li = (LaundryInfo)em.find(LaundryInfo.class, transac.getServicesId().getLaundryId().getClothTypeId());
        
        if(transac != null){
            em.remove(transac);
            em.remove(sa);
            em.remove(li);
        }
        em.getTransaction().commit();
        em.close();
        
        retrievenewitems();
    }
    
    public static void updateClaim(int tID){
        EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("laundry_servicePU");
        Random rand = new Random();

        int  or = rand.nextInt(100000) + 1;
        int dsID = rand.nextInt(100000) + 1;
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        Transaction transac = (Transaction)em.find(Transaction.class, tID);
        float total = transac.getTotalAmount();
        DailySales ds = new DailySales();
        
        java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf(java.time.LocalDateTime.now());
        transac.setDateClaimed(timestamp);
        transac.setOrNumber(or);
        ds.setDailySalesId(dsID);
        ds.setTotal(total);
        ds.setDate(timestamp);
        ds.setTransactionId(transac);
        em.persist(transac);
        em.getTransaction().commit();
        em.close();
        
        retrievenewitems();
    }
    
    public static void markClaim(int row){
        System.out.println("Entered claim");
        EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("laundry_servicePU");
        EntityManager em = emf.createEntityManager();
        
        String value = transac_table.getModel().getValueAt(row, 0).toString();
        
        
        Transaction ts = em.find(Transaction.class, value);
        java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf(java.time.LocalDateTime.now());
        ts.setDateClaimed(timestamp);
        em.merge(ts);    
        
        
    }
    
    public static void editRow(){
        
    }
    
    public static void seedetails(){
        
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
            
             Query findCustomer = em.createNamedQuery("Customer.findByCustomerId");
            findCustomer.setParameter("customerId", tr.getServicesId().getLaundryId().getCustomerId().getCustomerId());
            List<Customer> cust2 = findCustomer.getResultList();
            String custName = cust2.get(0).getName();
            
            data.add(custName);
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
    public static javax.swing.JButton claimbutton;
    public static javax.swing.JButton remove;


    
    
/*
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_btn;
    private javax.swing.JButton claimbutton;
    public javax.swing.JButton exit_btn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JButton refresh_btn;
    private javax.swing.JButton remove;
    private javax.swing.JTable transac_table;
    // End of variables declaration//GEN-END:variables
*/
}
