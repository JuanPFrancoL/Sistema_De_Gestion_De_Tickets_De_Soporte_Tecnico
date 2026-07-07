package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client {
    private JPanel panelPrincipalClient;
    private JLabel lblClientTitle;
    private JButton btnCreateTicket;
    private JButton btnClose;
    private Queue queue;

    public Client(JPanel mainPanel, Queue queue) {
        this.queue = queue;
        btnCreateTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TicketDialog ticketDialog = new TicketDialog(queue);
                ticketDialog.setVisible(true);
            }
        });
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.remove(panelPrincipalClient);
            }
        });
    }

    public JPanel getPanelPrincipalClient() {
        return panelPrincipalClient;
    }
}
