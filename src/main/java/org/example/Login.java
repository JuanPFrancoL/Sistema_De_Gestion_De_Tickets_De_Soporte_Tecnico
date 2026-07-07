package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    private JLabel lblLogin;
    private JLabel lblUsername;
    private JTextField txtUsername;
    private JLabel lblPassword;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JPanel panelLogin;
    private JLabel lblUserImage;
    private JLabel lblPasswordImage;
    private String userName;
    private String password;
    Role rol;
    User user;
    SimpleList simpleList;

    public Login(SimpleList simpleList) {

        this.simpleList = simpleList;

        ImageIcon icon = new ImageIcon(getClass().getResource("/images/user.png"));

        Image scaledImg = getScaledImg(icon);

        lblUserImage.setIcon(new ImageIcon(scaledImg));

        ImageIcon icon2 = new ImageIcon(getClass().getResource("/images/password.png"));

        Image scaledImg2 = getScaledImg(icon2);

        lblPasswordImage.setIcon(new ImageIcon(scaledImg2));


        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userName = txtUsername.getText();
                password = new String(txtPassword.getPassword());
                user = new User(userName, password);

                if (!validateUserAndPassword(userName, password)) {
                    JOptionPane.showMessageDialog(null, "Incorrect username or password");
                }

            }
        });
    }


    public Image getScaledImg(ImageIcon icon) {
        if (icon == null) {
            return null;
        }
        return icon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);

    }

    public boolean validateUserAndPassword(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter username or password");
        } else {
            SimpleNode pointer = simpleList.head;
            while (pointer != null) {
                if (pointer.user.getName().equals(username) && pointer.user.getPassword().equals(password)) {
                    return true;
                }
                pointer = pointer.next;
            }
        }
        return false;
    }

    public boolean isAdmin(User user) {
        if (user.getRol() == Role.ADMIN) {
            return true;
        }
        return false;
    }


    public JPanel getPanelLogin() {
        return panelLogin;
    }
}
