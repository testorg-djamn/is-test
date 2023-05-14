/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package net.is.lms.project.dialogs;

import net.is.lms.project.instances.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author dadi
 */
public class UserDialog extends javax.swing.JDialog {
    private final String addUserString = "Add User";
    private final String editUserString = "Edit User";
    private JSONArray jsonArray = new JSONArray();

    /**
     * Creates new form UserDialog
     */
    public UserDialog(java.awt.Frame parent, boolean modal, boolean inputValue) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        addNimbusLook();

        jLabel7.setText(inputValue ? addUserString : editUserString);
        setTitle(inputValue ? addUserString : editUserString);
    }

    public UserDialog(java.awt.Frame parent, boolean modal, boolean inputValue, User user) {
        super(parent, modal);
        initComponents();
        addToTextField(user);
        setLocationRelativeTo(null);
        addNimbusLook();

        jLabel7.setText(inputValue ? addUserString : editUserString);
        setTitle(inputValue ? addUserString : editUserString);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1Save = new javax.swing.JButton();
        jButton2Cancel = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(203, 230, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Add User");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("First Name");

        jTextField1.setPreferredSize(new java.awt.Dimension(284, 22));

        jTextField2.setPreferredSize(new java.awt.Dimension(284, 22));

        jTextField3.setPreferredSize(new java.awt.Dimension(284, 22));

        jTextField4.setPreferredSize(new java.awt.Dimension(284, 22));

        jTextField5.setPreferredSize(new java.awt.Dimension(284, 22));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Last Name");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Email");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Phone Number (opt.)");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Username (not changeable)");

        jButton1Save.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1Save.setText("Save");
        jButton1Save.setPreferredSize(new java.awt.Dimension(96, 31));
        jButton1Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1SaveActionPerformed(evt);
            }
        });

        jButton2Cancel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2Cancel.setText("Cancel");
        jButton2Cancel.setPreferredSize(new java.awt.Dimension(96, 31));
        jButton2Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2CancelActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Password");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(84, 84, 84))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addComponent(jButton1Save, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                                                .addComponent(jButton2Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jPasswordField1)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(59, 59, 59))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel7)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(19, 19, 19)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(19, 19, 19)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(19, 19, 19)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(19, 19, 19)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(19, 19, 19)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton2Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1Save, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1SaveActionPerformed
        if (!jTextField1.getText().equals("") && !jTextField2.getText().equals("") && !jTextField3.getText().equals("") && !jTextField5.getText().equals("") && !jPasswordField1.getText().equals("")) {
            if (!(jTextField4.getText().matches("^\\+?\\d*"))) { // Satzbeginn kann ein Plus stehen ansonsten nur Zahlen
                JOptionPane.showMessageDialog(this, "Please enter a valid phone number! [+ (opt.) & numbers]", "Error!", JOptionPane.ERROR_MESSAGE);
            } else if (!(jTextField3.getText().matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]+"))) {
                JOptionPane.showMessageDialog(this, "Please enter a valid mail address!", "Error!", JOptionPane.ERROR_MESSAGE);
            } else {
                readFile();

                if (jLabel7.getText().equals("Add User")) {
                    boolean usernameAlreadyExists = false;
                    for (int i = 0; i < jsonArray.size(); i++) {
                        JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                        Object user = jsonObject.get("User");
                        JSONObject userObj = (JSONObject) user;
                        if (userObj.get("UserName").toString().equals(jTextField5.getText())) {
                            JOptionPane.showMessageDialog(this, "This username already exists!", "Error!", JOptionPane.ERROR_MESSAGE);
                            usernameAlreadyExists = true;
                            break;
                        }
                    }
                    if (!usernameAlreadyExists) {
                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put("FirstName", jTextField1.getText());
                        jsonObject.put("LastName", jTextField2.getText());
                        jsonObject.put("Email", jTextField3.getText());
                        jsonObject.put("PhoneNumber", jTextField4.getText());
                        jsonObject.put("UserName", jTextField5.getText());
                        jsonObject.put("Password", jPasswordField1.getText()); // Todo nur für IS (sonst andere Strategie)
                        JSONObject userObj = new JSONObject();
                        userObj.put("User", jsonObject);
                        jsonArray.add(userObj);
                        writeFile();
                    }
                }
                if (jLabel7.getText().equals("Edit User")) {
                    for (int i = 0; i < jsonArray.size(); i++) {
                        JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                        Object user = jsonObject.get("User");
                        JSONObject userObj = (JSONObject) user;
                        if (userObj.get("UserName").toString().equals(jTextField5.getText())) {
                            userObj.put("FirstName", jTextField1.getText());
                            userObj.put("LastName", jTextField2.getText());
                            userObj.put("Email", jTextField3.getText());
                            userObj.put("PhoneNumber", jTextField4.getText());
                            userObj.put("Password", jPasswordField1.getText());
                            jsonObject.put("User", userObj);
                        }
                    }
                    writeFile();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please fill out all text fields!", "Error!", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton1SaveActionPerformed

    private void jButton2CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2CancelActionPerformed
//        System.out.println("Pressed Cancel");
        this.dispose();
    }//GEN-LAST:event_jButton2CancelActionPerformed

    private void readFile() {
        File file = new File("src/main/resources/users.txt");
        if (file.length() != 0) {
            JSONParser jsonParser = new JSONParser();
            try (FileReader fileReader = new FileReader("src/main/resources/users.txt")) {
                Object obj = jsonParser.parse(fileReader);
                jsonArray = (JSONArray) obj;
            } catch (ParseException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void writeFile() {
        try (FileWriter fileWriter = new FileWriter("src/main/resources/users.txt")) {
            fileWriter.write(jsonArray.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.dispose();
        ;
    }

    private void addToTextField(User user) {
        jTextField1.setText(user.getFirstName());
        jTextField2.setText(user.getLastName());
        jTextField3.setText(user.getEmail());
        jTextField4.setText(user.getPhoneNumber());
        jTextField5.setText(user.getUsername());
        jTextField5.setEnabled(false);  // Username nicht bearbeitbar
        jPasswordField1.setText(user.getPassword());

        if (user.getPhoneNumber().equals("-/-")) jTextField4.setText("");
    }

    private void addNimbusLook() {
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1Save;
    private javax.swing.JButton jButton2Cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
