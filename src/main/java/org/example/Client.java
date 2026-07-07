package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client {
    private JPanel panel1;
    private JLabel lblClientTitle;
    private JButton btnCreateTicket;

    public Client() {
        btnCreateTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }
}
