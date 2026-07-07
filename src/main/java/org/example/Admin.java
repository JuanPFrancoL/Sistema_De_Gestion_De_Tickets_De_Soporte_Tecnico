package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin {
    private JPanel panelPrincipalAdmin;
    private JLabel lblTitleAdmin;
    private JButton btnChangePriority;
    private JButton btnSearchTicket;
    private JButton btnCloseTicket;
    private JButton btnSeachPendingTickets;
    private JButton btnShowTicketsInAtention;
    private JButton btnChangeStatus;
    private JButton btnUndoLastStateChange;
    private JButton btnShowTicketStatusHistory;
    private JButton btnClose;
    private JLabel lblPanelStatus;
    private Queue queue;
    private Stack stack;


    public Admin(JPanel mainPanel, Queue queue) {

        this.queue = queue;


        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "login");
            }
        });
        btnShowTicketsInAtention.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] options = {"Desde el primero hasta el ultimo", "Desde el ultimo hasta el primero"};
                int option = JOptionPane.showOptionDialog(null, "Seleccione una opcion", "Consultar tickets", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if (option == JOptionPane.CLOSED_OPTION) {
                    return;
                }
                if (option == 0) {
                    JOptionPane.showMessageDialog(null, queue.printQueueFirstToLast());
                } else if (option == 1) {
                    JOptionPane.showMessageDialog(null, queue.printQueueLastToFirst());
                }
            }
        });
    }

    public JPanel getPanelPrincipalAdmin() {
        return panelPrincipalAdmin;
    }
}
