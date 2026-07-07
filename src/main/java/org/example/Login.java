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

    public Login(SimpleList simpleList, JPanel mainPanel) {

        this.simpleList = simpleList;
        this.panelLogin = mainPanel;

        ImageIcon icon = new ImageIcon(getClass().getResource("/images/user.png"));

        Image scaledImg = getScaledImg(icon);

        lblUserImage.setIcon(new ImageIcon(scaledImg));

        ImageIcon icon2 = new ImageIcon(getClass().getResource("/images/password.png"));

        Image scaledImg2 = getScaledImg(icon2);

        lblPasswordImage.setIcon(new ImageIcon(scaledImg2));


        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userName = txtUsername.getText().trim();
                password = new String(txtPassword.getPassword());
                if (hasEmptyFields(userName, password)) {
                    return;
                }
                user = findUser(userName, password);
                if (isAdmin(user)) {
                    CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                    cardLayout.show(mainPanel, "principalAdmin");
                } else {
                    CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                    cardLayout.show(mainPanel, "client");
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

    public boolean hasEmptyFields(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter username or password");
            return true;
        }
        return false;
    }

    public boolean isAdmin(User user) {
        try {
            if (user.getRol() == Role.ADMIN) {
                return true;
            }
        } catch (NullPointerException e) {
            return false;
        }
        return false;
    }

    public User findUser(String userName, String password) {
        SimpleNode pointer = simpleList.head;
        while (pointer != null) {
            if (pointer.user.getName().equals(userName) && pointer.user.getPassword().equals(password)) {
                return pointer.user;
            }
            pointer = pointer.next;
        }
        JOptionPane.showMessageDialog(null, "User Not Found");
        return null;
    }


    public JPanel getPanelLogin() {
        return panelLogin;
    }
}
