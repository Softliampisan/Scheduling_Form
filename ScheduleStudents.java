/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
/**
 *
 * @author softliampisan
 */
public class ScheduleStudents extends javax.swing.JFrame {

    /**
     * Creates new form ScheduleStudents
     */
    Connection con;
    ResultSet rs;
    Statement stmt;
    int curRow = 0;
    
    Connection con2;
    ResultSet rs2;
    Statement stmt2;

    
    public ScheduleStudents() {
    
        initComponents();
        System.out.println("hi");
        DoConnect();
        DoConnect2();
        this.setDefaultCloseOperation(ScheduleStudents.DISPOSE_ON_CLOSE);
    }
    
    public void DoConnect(){
        try {

            String host = "jdbc:derby://localhost:1527/StudentsScheduled";
            String uName = "hsstudents";
            String uPass = "1234";
            con = DriverManager.getConnection(host, uName, uPass);
            //connection to database
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM Flexstudents";
            rs = stmt.executeQuery(SQL);
            rs.next();
                
            String studentName = rs.getString("Student");
            String teacherName = rs.getString("Teacher");
            String weekdayText = rs.getString("Weekday");
            
            textStudent.setText(studentName);
            textTeacher.setText(teacherName);
            textWeekday.setText(weekdayText);
            
           
            
            //String my_course = "AP Calculus BC";
            //only get values in the database that are from the course AP Calculus BC
            //String SQL = "SELECT * FROM CourseScheduling WHERE COURSE_NAME = '" + my_course + "'"; 
            //rs = stmt.executeQuery(SQL);
            //rs.first();
  
            
          
           //display all the student names from the class into each text area
         /*  while (rs.next()){
            String student_name = rs.getString("Student_Name");
            textMon.append(student_name);
            textMon.append("\n");
            textTues.append(student_name);
            textTues.append("\n");
            textWeds.append(student_name);
            textWeds.append("\n");
            textThurs.append(student_name);
            textThurs.append("\n");
            textFri.append(student_name);
            textFri.append("\n");
      
            
          
           }*/
            
           
        }
        catch (SQLException err) {
            JOptionPane.showMessageDialog(this, err.getMessage());
            
        }
 
        
        

}
    public void DoConnect2(){
         try {
            //connection to HS Classes database
            String host = "jdbc:derby://localhost:1527/HS Classes";
            String uName = "Flexblock";
            String uPass = "Project123";
            con2 = DriverManager.getConnection(host, uName, uPass);
            
            stmt2 = con2.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM CourseScheduling";
            rs2 = stmt2.executeQuery(SQL);
            
            rs2.next();
            //connect each column to the course scheduling form
            int CourseNumber_col = rs2.getInt("CourseNumber");
            String CourseNumber = Integer.toString(CourseNumber_col);
            String course_name = rs2.getString("Course_Name");
            String teacher_name = rs2.getString("Teacher_Name");
            int studentid_col = rs2.getInt("student_ID");
            String student_id = Integer.toString(studentid_col);
            String student_name = rs2.getString("Student_Name");
            //display each column
           /* textCourseNum.setText(CourseNumber);
            textCourseName.setText(course_name);
            textTeacher1.setText(teacher_name);
            textStudentID.setText(student_id);
            textStudentName.setText(student_name);*/
            
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

        jPanel1 = new javax.swing.JPanel();
        weekdayDropdown = new javax.swing.JComboBox<>();
        textWeekday = new javax.swing.JTextField();
        title = new javax.swing.JLabel();
        textStudent = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textTeacher = new javax.swing.JTextField();
        btnFirst = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnCombobox = new javax.swing.JButton();
        btnDisplay = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));

        jPanel1.setBackground(new java.awt.Color(206, 234, 216));
        jPanel1.setLayout(null);

        weekdayDropdown.setFont(new java.awt.Font("Palatino", 2, 20)); // NOI18N
        weekdayDropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" }));
        jPanel1.add(weekdayDropdown);
        weekdayDropdown.setBounds(130, 130, 140, 50);
        jPanel1.add(textWeekday);
        textWeekday.setBounds(310, 140, 110, 30);

        title.setFont(new java.awt.Font("Palatino", 1, 36)); // NOI18N
        title.setText("Schedule Flex Block");
        jPanel1.add(title);
        title.setBounds(220, 10, 360, 90);
        jPanel1.add(textStudent);
        textStudent.setBounds(400, 200, 110, 30);

        jLabel1.setFont(new java.awt.Font("Palatino", 0, 18)); // NOI18N
        jLabel1.setText("Student Name");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(260, 200, 130, 40);

        jLabel2.setFont(new java.awt.Font("Palatino", 0, 18)); // NOI18N
        jLabel2.setText("Teacher");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(300, 280, 70, 40);
        jPanel1.add(textTeacher);
        textTeacher.setBounds(400, 280, 110, 30);

        btnFirst.setText("First");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });
        jPanel1.add(btnFirst);
        btnFirst.setBounds(160, 360, 75, 29);

        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });
        jPanel1.add(btnPrevious);
        btnPrevious.setBounds(290, 360, 97, 29);

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        jPanel1.add(btnNext);
        btnNext.setBounds(440, 360, 75, 29);

        btnLast.setText("Last");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });
        jPanel1.add(btnLast);
        btnLast.setBounds(550, 360, 75, 29);

        btnUpdate.setText("Update Record");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate);
        btnUpdate.setBounds(190, 410, 130, 29);

        btnNew.setText("New Record");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jPanel1.add(btnNew);
        btnNew.setBounds(340, 410, 118, 29);

        btnDelete.setText("Delete Record");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete);
        btnDelete.setBounds(480, 410, 131, 29);

        btnCancel.setText("Cancel New Record");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancel);
        btnCancel.setBounds(410, 460, 164, 29);

        btnSave.setText("Save New Record");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave);
        btnSave.setBounds(230, 460, 150, 29);

        btnCombobox.setText("Get Dropdown item");
        btnCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComboboxActionPerformed(evt);
            }
        });
        jPanel1.add(btnCombobox);
        btnCombobox.setBounds(460, 140, 160, 29);

        btnDisplay.setFont(new java.awt.Font("Phosphate", 0, 15)); // NOI18N
        btnDisplay.setForeground(new java.awt.Color(255, 102, 102));
        btnDisplay.setText("Display Database");
        btnDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisplayActionPerformed(evt);
            }
        });
        jPanel1.add(btnDisplay);
        btnDisplay.setBounds(300, 90, 170, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        try {
            if (rs.previous()) {
                //get new information to match student's scheduled
                String studentName = rs.getString("Student");
                String teacherName = rs.getString("Teacher");
                String weekdayText = rs.getString("Weekday");
            
                textStudent.setText(studentName);
                textTeacher.setText(teacherName);
                textWeekday.setText(weekdayText); 
            }
            else {
                rs.next();
                JOptionPane.showMessageDialog(ScheduleStudents.this, "End of File");
            }  
        } 
        catch (SQLException err) {
            JOptionPane.showMessageDialog(ScheduleStudents.this, err.getMessage());
        }
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
         try {
            if (rs.next()) {
                //get new information to match student's scheduled
                String studentName = rs.getString("Student");
                String teacherName = rs.getString("Teacher");
                String weekdayText = rs.getString("Weekday");
                
                textStudent.setText(studentName);
                textTeacher.setText(teacherName);
                textWeekday.setText(weekdayText);
            }
            else {
                rs.previous();
                JOptionPane.showMessageDialog(ScheduleStudents.this, "End of File");
            }
        } 
        catch (SQLException err) {
            JOptionPane.showMessageDialog(ScheduleStudents.this, err.getMessage());
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        try {
            //get new information to match the first student's courses

            rs.first();
            String studentName = rs.getString("Student");
            String teacherName = rs.getString("Teacher");
            String weekdayText = rs.getString("Weekday");
                
            textStudent.setText(studentName);
            textTeacher.setText(teacherName);
            textWeekday.setText(weekdayText);
           
        } 
        catch (SQLException err) {
            JOptionPane.showMessageDialog(ScheduleStudents.this, err.getMessage());
        }
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        try {
            //get new information to match the first student's courses

            rs.last();
            String studentName = rs.getString("Student");
            String teacherName = rs.getString("Teacher");
            String weekdayText = rs.getString("Weekday");
                
            textStudent.setText(studentName);
            textTeacher.setText(teacherName);
            textWeekday.setText(weekdayText);
           
        } 
        catch (SQLException err) {
            JOptionPane.showMessageDialog(ScheduleStudents.this, err.getMessage());
        }
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String studentName = textStudent.getText();
        String teacherName = textTeacher.getText();
        String weekdayText = textWeekday.getText();
            
            
            //replace the old text values with new text values
            try {
                
                rs.updateString( "Student", studentName );
                rs.updateString( "Teacher", teacherName );
                rs.updateString( "Weekday", weekdayText );
                rs.updateRow( );
                JOptionPane.showMessageDialog(ScheduleStudents.this, "Updated");
            }
            catch (SQLException err) {
                System.out.println(err.getMessage() );
            }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        try {
            curRow = rs.getRow( );
            //create a new blank row, set values to blank values
            
            textWeekday.setText("");
            textStudent.setText("");
            textTeacher.setText("");

            btnFirst.setEnabled( false );
            btnPrevious.setEnabled( false ) ;
            btnNext.setEnabled( false );
            btnLast.setEnabled( false );
            btnUpdate.setEnabled( false );
            btnDelete.setEnabled( false );
            btnNew.setEnabled( false );
            //enable the buttons below
            btnSave.setEnabled( true );
            btnCancel.setEnabled( true );
        }
        catch (SQLException err) {
            JOptionPane.showMessageDialog(this, err.getMessage());

        }
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
         try {
            //retrieve values
            rs.absolute(curRow);
            //reload the erased values
            btnFirst.setEnabled( true );
            btnPrevious.setEnabled( true ) ;
            btnNext.setEnabled( true );
            btnLast.setEnabled( true );
            btnUpdate.setEnabled( true );
            btnDelete.setEnabled( true );
            btnNew.setEnabled( true );

            btnSave.setEnabled( false );
            btnCancel.setEnabled( false );
        }
        catch (SQLException err) {
            JOptionPane.showMessageDialog(this, err.getMessage());

        }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            //delete the specific record
            rs.deleteRow();
            
            stmt.close();
            rs.close();
            //connection to HS classes database
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            String SQL = "SELECT * FROM Flexstudents";
            rs = stmt.executeQuery(SQL);
            
            rs.next();
            
            String studentName = textStudent.getText();
            String teacherName = textTeacher.getText();
            String weekdayText = textWeekday.getText();
            //set new values for record after the deleted record 
            textStudent.setText(studentName);
            textTeacher.setText(teacherName);
            textWeekday.setText(weekdayText);
            
            
            JOptionPane.showMessageDialog(this, "Record Deleted");
            
        }
        catch (SQLException err) {
            JOptionPane.showMessageDialog(this, err.getMessage());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String studentName = textStudent.getText();
        String teacherName = textTeacher.getText();
        String weekdayText = textWeekday.getText();
        

        try{
            stmt2 = con2.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //check for student and teacher name in database, both has to be in the same row for count to return true
            String SQL = "SELECT COUNT(*) AS rowcount FROM CourseScheduling WHERE Student_name = '" + studentName + "'"+" AND Teacher_name = '" + teacherName +"'";
            rs2 = stmt2.executeQuery(SQL);
            rs2.next();
            int count = rs2.getInt("rowcount");
            if (count == 0){
                 JOptionPane.showMessageDialog(this, "Student or Teacher not found");
                return;
                
            }
      
        }
        catch(SQLException err){
            JOptionPane.showMessageDialog(this, err.getMessage());
        }
        
        try {
            ResultSet rs3;
            Statement stmt3;
            stmt3 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL = "SELECT COUNT(*) AS rowcount FROM Flexstudents WHERE Student = '" + studentName + "'"+" AND Weekday = '" + weekdayText +"'";
            //check for student and weekday in the same row

            rs3 = stmt3.executeQuery(SQL);
            rs3.next();
            int count = rs3.getInt("rowcount");
            //if student is already booked on the weekday the if returns true, and the entry will not save
            if (count >= 1){
                 JOptionPane.showMessageDialog(this, "Student is already booked");
                return;
                
            }
            
        }catch (SQLException err){
            JOptionPane.showMessageDialog(this, err.getMessage());
        }
                
        try {
            rs.moveToInsertRow();
            //update the new values
            rs.updateString( "Student", studentName );
            rs.updateString( "Teacher", teacherName );
            rs.updateString( "Weekday", weekdayText );
            
            rs.insertRow();
            
            stmt.close();
            rs.close();
            
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            String SQL = "SELECT * FROM Flexstudents";
            rs =stmt.executeQuery(SQL);
            
            rs.next();
            
            String studentName2 = rs.getString("Student");
            String teacherName2 = rs.getString("Teacher");
            String weekdayText2 = rs.getString("Weekday");
           
            //new placeholders
            
            textStudent.setText(studentName2);
            textTeacher.setText(teacherName2);
            textWeekday.setText(weekdayText2);
             
            
            btnFirst.setEnabled( false );
            btnPrevious.setEnabled( false ) ;
            btnNext.setEnabled( false );
            btnLast.setEnabled( false );
            btnUpdate.setEnabled( false );
            btnDelete.setEnabled( false );
            btnNew.setEnabled( false );

            btnSave.setEnabled( true );
            btnCancel.setEnabled( true );
            
            JOptionPane.showMessageDialog(this, "Record Saved");
            
            
        }
        catch (SQLException err) {
            JOptionPane.showMessageDialog(this, err.getMessage());
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComboboxActionPerformed
        String itemText = (String)weekdayDropdown.getSelectedItem( );
        textWeekday.setText( itemText );
    }//GEN-LAST:event_btnComboboxActionPerformed

    private void btnDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisplayActionPerformed
        new flexSubmissions().setVisible(true); 
    }//GEN-LAST:event_btnDisplayActionPerformed

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
            java.util.logging.Logger.getLogger(ScheduleStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScheduleStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScheduleStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScheduleStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScheduleStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCombobox;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDisplay;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField textStudent;
    private javax.swing.JTextField textTeacher;
    private javax.swing.JTextField textWeekday;
    private javax.swing.JLabel title;
    private javax.swing.JComboBox<String> weekdayDropdown;
    // End of variables declaration//GEN-END:variables
}