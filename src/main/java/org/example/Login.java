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
        

    }


    public Image getScaledImg(ImageIcon icon) {
        if (icon == null) {
            return null;
        }
        return icon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);

    }


    public JPanel getPanelLogin() {
        return panelLogin;
    }
}
