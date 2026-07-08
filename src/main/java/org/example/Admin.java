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
    private JButton btnSearchPendingTickets;
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
                    JOptionPane.showMessageDialog(null, doublyLinkedList.displayForward());
                } else if (option == 1) {
                    JOptionPane.showMessageDialog(null, doublyLinkedList.displayBackward());
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
                doublyLinkedList.addLast(ticket);
                JOptionPane.showMessageDialog(null, "El ticket esta en atencion");
            }
        });

        btnChangePriority.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String number = JOptionPane.showInputDialog("Ingrese el numero del ticket:");
                Priority priority = (Priority) JOptionPane.showInputDialog(
                        null, "Seleccione la nueva prioridad",
                        "Cambiar prioridad", JOptionPane.QUESTION_MESSAGE,
                        null, Priority.values(), Priority.MEDIUM
                );
                if (priority != null) {
                    if (doublyLinkedList.changePriority(number, priority)) {
                        JOptionPane.showMessageDialog(null, "Prioridad actualizada");
                    } else {
                        JOptionPane.showMessageDialog(null, "Ticket no encontrado");
                    }

                }
            }
        });

        btnChangeStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String number = JOptionPane.showInputDialog("Ingrese el numero del ticket:");
                ActualState state = (ActualState) JOptionPane.showInputDialog(
                        null, "Seleccione el nuevo estado",
                        "Cambiar estado", JOptionPane.QUESTION_MESSAGE,
                        null, ActualState.values(), ActualState.NEW
                );
                if (state != null) {
                    if (doublyLinkedList.changeState(number, state)) {
                        JOptionPane.showMessageDialog(null, "Estado actualizado");
                    } else {
                        JOptionPane.showMessageDialog(null, "Ticket no encontrado");
                    }
                }
            }
        });

        btnCloseTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String number = JOptionPane.showInputDialog("Numero del ticket");

                Ticket ticket = doublyLinkedList.close(number);

                if (ticket == null) {
                    JOptionPane.showMessageDialog(null, "El ticket no existe");
                } else {
                    JOptionPane.showMessageDialog(null, "Ticket cerrado");
                }
            }
        });

        btnSearchTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String number = JOptionPane.showInputDialog("Numero del ticket");

                Ticket ticket = doublyLinkedList.find(number);

                if (ticket == null) {
                    JOptionPane.showMessageDialog(null, "Ticket no encontrado");
                    return;
                } else {
                    JOptionPane.showMessageDialog(null, ticket);
                }
            }
        });

        btnSearchPendingTickets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                        null, queue.printQueueFirstToLast()
                );
            }
        });

        btnShowTicketStatusHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String number = JOptionPane.showInputDialog("Numero del ticket:");
                Ticket ticket = doublyLinkedList.find(number);

                if (ticket == null) {
                    JOptionPane.showMessageDialog(null, "Ticket no encontrado");
                    return;
                }
                JOptionPane.showMessageDialog(null, ticket.history.printStack());
            }
        });

        btnUndoLastStateChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String number = JOptionPane.showInputDialog("Numero del ticket:");
                Ticket ticket = doublyLinkedList.find(number);
                if (ticket == null) {
                    JOptionPane.showMessageDialog(null, "Ticket no encontrado");
                    return;
                }
                if (ticket.history.getSize() <= 1) {
                    JOptionPane.showMessageDialog(null,
                            "No es posible deshacer el estado inicial");
                }
                ticket.history.pop();
                ticket.actualState = ActualState.valueOf(ticket.history.peek());
                JOptionPane.showMessageDialog(null, "Estado restaurado");
            }
        });
    }

    public JPanel getPanelPrincipalAdmin() {
        return panelPrincipalAdmin;
    }
}
