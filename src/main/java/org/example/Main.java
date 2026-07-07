package org.example;

import javax.swing.*;
import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public Main() {
        FileManager fileManager = new FileManager();
        fileManager.readFile();
        Queue queue = new Queue();
        JFrame frame = new JFrame("Sistema de tickets");
        JPanel mainPanel = new JPanel(new CardLayout());

        Login loginPanel = new Login(fileManager.simpleList, mainPanel);
        Admin adminPanel = new Admin(mainPanel, queue);
        Client clientPanel = new Client(mainPanel, queue);

        mainPanel.add(loginPanel.getPanelLogin(), "login");
        mainPanel.add(adminPanel.getPanelPrincipalAdmin(), "principalAdmin");
        mainPanel.add(clientPanel.getPanelPrincipalClient(), "client");


        frame.setContentPane(mainPanel);

        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        cardLayout.show(mainPanel, "login");


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}