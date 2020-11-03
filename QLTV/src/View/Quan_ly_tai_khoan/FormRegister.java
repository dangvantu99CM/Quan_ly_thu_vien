/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Quan_ly_tai_khoan;

import Model.Da.Da.UserDA;
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

public class FormRegister extends JFrame {

    private JTextField txtUsername, txtPasswordAgain, txtEmail,txtMsv,txtPhoneNumber;
    private JPasswordField txtPassword;
    private JButton btnResgister, btnCancel;
    private boolean isLoading = false;

    public FormRegister() {

        this.setTitle("Đăng ký");
        this.setSize(780, 442);
        JLabel background = new JLabel(new ImageIcon(ClassLoader.getSystemResource("asset/img/bg_1.jpg")));
        background.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setContentPane(background);
        this.setLayout(new BorderLayout());

        JPanel contend = new JPanel();
        contend.setLayout(new MigLayout("", "[][grow]", "[][]"));

        JLabel lblUsername = new JLabel("Tên truy nhập*");
        contend.add(lblUsername, "cell 0 0,alignx trailing");
        txtUsername = new JTextField();
        contend.add(txtUsername, "cell 1 0,growx");

        JLabel lblPassword = new JLabel("Mật khẩu*");
        contend.add(lblPassword, "cell 0 1,alignx trailing");
        txtPassword = new JPasswordField();
        contend.add(txtPassword, "cell 1 1,growx");

        JLabel lblPasswordAgain = new JLabel("Gõ lại MK*");
        contend.add(lblPasswordAgain, "cell 0 2,alignx trailing");
        txtPasswordAgain = new JPasswordField();
        contend.add(txtPasswordAgain, "cell 1 2,growx");
        
        JLabel lblMsv = new JLabel("Mã sinh viên*");
        contend.add(lblMsv, "cell 0 3,alignx trailing");
        txtEmail = new JTextField();
        contend.add(txtEmail, "cell 1 3,growx");
        
        JLabel txtPhoneNumber = new JLabel("Số điện thoại*");
        contend.add(txtPhoneNumber, "cell 0 3,alignx trailing");
        txtEmail = new JTextField();
        contend.add(txtEmail, "cell 1 3,growx");

        JLabel lblEmail = new JLabel("Email*");
        contend.add(lblEmail, "cell 0 3,alignx trailing");
        txtEmail = new JTextField();
        contend.add(txtEmail, "cell 1 3,growx");

        btnResgister = new JButton("Đăng Ký");
        btnCancel = new JButton("Thoát");
        contend.add(btnResgister, "cell 1 4,growx");
        contend.add(btnCancel, "cell 1 4,growx");
        contend.setBackground(new Color(0f, 0f, 0f, 0f));
        contend.setBorder(BorderFactory.createEmptyBorder(70, 400, 0, 0));

        this.add(contend, BorderLayout.WEST);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

        actionListener();

    }

    public void actionListener() {
        JFrame self = this;
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormLogin formLogin = new FormLogin();
                self.dispose();
            }
        });
        btnResgister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserDA userDa = new UserDA();
                JDialog f = new JDialog();
              //  try {
                   // boolean isAddSucess = itemDa.addUser(
                    //        new User(txtUsername.getText(), txtPassword.getText(), txtEmail.getText(), 0));
                   // if (isAddSucess) {
                   //     MenuComponent menuComponent = new MenuComponent(); 
                  //      self.dispose();
                  //  } else {
                  //      JOptionPane.showMessageDialog(f, "Đăng kí thất bại!");
                    }
             //   } catch (SQLException ex) {
              //      ex.printStackTrace();
              //      JOptionPane.showMessageDialog(f, "Error");
               // }
           // }
        });
    }

    public static void main(String[] args) {
        FormRegister f = new FormRegister();
        f.actionListener();
    }
}
