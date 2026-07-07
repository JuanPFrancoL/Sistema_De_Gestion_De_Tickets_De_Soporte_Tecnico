package org.example;

import javax.swing.*;
import java.awt.*;

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

        userName = txtUsername.getText();
        password = new String(txtPassword.getPassword());
        user = new User(userName, password);

    }


    public Image getScaledImg(ImageIcon icon) {
        if (icon == null) {
            return null;
        }
        return icon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);

    }

    public boolean validateUser(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter username or password");
            return false;
        } else {
            SimpleNode pointer = simpleList.head;
            while (pointer != null) {
                if (pointer.user.getName().equals(username) && pointer.user.getPassword().equals(password)) {
                    return true;
                }
                pointer = pointer.next;
            }
        }
    }


    public JPanel getPanelLogin() {
        return panelLogin;
    }
}
