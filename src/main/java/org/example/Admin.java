package org.example;

import javax.swing.*;
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
    private JButton btnStartAttention;
    private Queue queue;
    private Stack stack;
    private DoublyLinkedList doublyLinkedList;


    public Admin(JPanel mainPanel, Queue queue, DoublyLinkedList doublyLinkedList) {

        this.queue = queue;
        this.doublyLinkedList = doublyLinkedList;


        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.remove(panelPrincipalAdmin);
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

        btnStartAttention.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Node node = queue.dequeue();
                if (node == null) {
                    JOptionPane.showMessageDialog(null, "No hay tickets pendientes");
                    return;
                }
                Ticket ticket = node.ticket;
                ticket.actualState = ActualState.IN_PROCESS;
                ticket.history.push(String.valueOf(ActualState.IN_PROCESS));
            }
        });

        btnChangePriority.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String number = JOptionPane.showInputDialog("Ingrese el numero del ticket:");
                Ticket ticket = doublyLinkedList.find(number);
                if (ticket == null) {
                    JOptionPane.showMessageDialog(null, "Ticket no encontrado");
                    return;
                }
                Priority priority = (Priority) JOptionPane.showInputDialog(
                        null, "Seleccione la nueva prioridad",
                        "Cambiar prioridad", JOptionPane.QUESTION_MESSAGE,
                        null, Priority.values(), ticket.priority
                );
                if (priority != null) {
                    ticket.priority = priority;
                    JOptionPane.showMessageDialog(null, "Prioridad actualizada");
                }
            }
        });

        btnChangeStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public JPanel getPanelPrincipalAdmin() {
        return panelPrincipalAdmin;
    }
}
