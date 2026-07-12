package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.*;

/**
 * La GUI CreaTirocinio.
 * L'interfaccia usata dai docenti per creare nuovi tirocini.
 */
public class CreaTirocinio extends JDialog {
    private JFrame frame;
    private JPanel panel;
    private JButton buttonCrea;
    private JButton buttonCancel;
    private JTextField nomeS;
    private JComboBox ente;

    /**
     * Costruttore della GUI CreaTirocinio.
     *
     * @param frameHomeD il frame della GUI della home del docente
     * @param controller il controller che ci permette di passare informazioni da un frame ad un altro
     */
    public CreaTirocinio(JFrame frameHomeD, Controller controller,String nomeD) {
        frame=new JFrame("CreaTirocinio");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        /**
         * Il bottone per creare un nuovo tirocinio.
         */
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

        /**
         * Il bottone per tornare al frame precedente.
         */
        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                frameHomeD.setVisible(true);
            }
        });
    }
}
