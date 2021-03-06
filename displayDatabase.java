/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author softliampisan
 */
public class displayDatabase extends javax.swing.JFrame {

    /**
     * Creates new form displayDatabase
     */
    Connection con;
    Statement stmt;
    ResultSet rs;
    
    public displayDatabase() {
        initComponents();
        DoConnect();
        setDefaultCloseOperation(displayDatabase.DISPOSE_ON_CLOSE);
        
        
    }
    
    
    public void DoConnect() {
        try {
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            
            //connection to the HS Classses database 
            String host = "jdbc:derby://localhost:1527/HS Classes";
            String uName = "Flexblock";
            String uPass = "Project123";
            con = DriverManager.getConnection(host, uName, uPass);
            
            stmt = con.createStatement();
            String SQL = "SELECT * FROM CourseScheduling";
            rs = stmt.executeQuery(SQL);
            
            //convert int to string
            int CourseNumber_col;
            String CourseNumber;
            String course_name;
            String teacher_name;
            int studentid_col;
            String student_id;
            String student_name;
            
            
            //Displaying all contents from the database on the table
            while(rs.next()){
                //rs.next();
                CourseNumber_col = rs.getInt("CourseNumber");
                CourseNumber = Integer.toString(CourseNumber_col);
                course_name = rs.getString("Course_Name");
                teacher_name = rs.getString("Teacher_Name");
                studentid_col = rs.getInt("student_ID");
                student_id = Integer.toString(studentid_col);
                student_name = rs.getString("Student_Name");
                
                model.addRow(new Object[]{CourseNumber, course_name, teacher_name, student_id, student_name});

//                model.setValueAt(CourseNumber,i,0);
//                model.setValueAt(course_name,i,1);
//                model.setValueAt(teacher_name,i,2);
//                model.setValueAt(student_id,i,3);
//                model.setValueAt(student_name,i,4);
            }
            
            
            
                
            
            
        }
        catch (SQLException err) {
            JOptionPane.showMessageDialog(this, err.getMessage());
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Course Number", "Course Name", "Teacher ", "Student ID", "Student Name"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jScrollPane1.setViewportView(jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(displayDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(displayDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(displayDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(displayDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new displayDatabase().setVisible(true);
            }
        });
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
