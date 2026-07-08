package org.example.controller;

import org.example.model.Node;
import org.example.model.Priority;
import org.example.model.Queue;
import org.example.model.Ticket;

import javax.swing.*;
import java.awt.event.*;

public class TicketDialog extends JDialog {
    private JPanel principalPaneTicket;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtTicketNumber;
    private JTextField txtClientName;
    private JTextField txtDescription;
    private JComboBox cmboxPriority;
    private JLabel lblTicketNumber;
    private JLabel lblClientName;
    private JLabel lblDescription;
    private JLabel lblPriority;
    private String number;
    private String clientName;
    private String description;
    private String priority;
    private Queue queue;


    public TicketDialog(Queue queue) {
        this.queue = queue;
        setContentPane(principalPaneTicket);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Ticket creation");
        setSize(800, 600);
        setLocationRelativeTo(null);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        principalPaneTicket.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        if (hasEmptyFields()) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos");
            return;
        }

        number = txtTicketNumber.getText().trim();
        clientName = txtClientName.getText().trim();
        description = txtDescription.getText().trim();
        priority = cmboxPriority.getSelectedItem().toString();

        Ticket ticket = new Ticket(number, clientName, description, Priority.valueOf(priority));
        queue.enqueue(new Node(ticket));
        JOptionPane.showMessageDialog(this, "Ticket registrado");

        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public boolean hasEmptyFields() {
        if (txtTicketNumber.getText().isEmpty() || txtClientName.getText().isEmpty() || txtDescription.getText().isEmpty() || cmboxPriority.getSelectedItem().toString().isEmpty()) {
            return true;
        }
        return false;
    }

    public Queue getQueue() {
        return queue;
    }
}
