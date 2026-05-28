package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.*;

public class CreaTirocinio extends JDialog {
    private JFrame frame;
    private JPanel panel;
    private JButton buttonCrea;
    private JButton buttonCancel;
    private JTextField nomeS;
    private JComboBox ente;

    public CreaTirocinio(JFrame frameHomeD, Controller controller) {
        frame=new JFrame("CreaTirocinio");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        buttonCrea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (nomeS.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Non hai riempito il campo");
                } else {
                    if (controller.creaTirocinio(nomeS.getText(), (String) ente.getSelectedItem())) {
                        frame.dispose();
                        frameHomeD.setVisible(true);
                        JOptionPane.showMessageDialog(frame, "Tirocinio creato con successo");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Si è verificato un errore");
                    }
                }
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                frameHomeD.setVisible(true);
            }
        });
    }
}
