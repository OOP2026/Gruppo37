package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.*;

/**
 * La GUI ApprovaTesi.
 * L'interfaccia usata dal docente per approvare le tesi degli studenti.
 */
public class ApprovaTesi extends JDialog {
    private JFrame frame;
    private JPanel panel;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox statoTesi;
    private JLabel titoloTesi;
    private JLabel testoTesi;

    /**
     * Costruttore della GUI ApprovaTesi.
     *
     * @param frameVediTesi il frame della GUI di VediTesi
     * @param controller il controller che ci permette di passare informazioni da un frame ad un altro
     */
    public ApprovaTesi(JFrame frameVediTesi, Controller controller, int idD, int idS) {
        frame = new JFrame("VediTirocinio");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        titoloTesi.setText(controller.getTestoT(idS));
        testoTesi.setText(controller.getTitoloT(idS));

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                frameVediTesi.setVisible(true);
            }
        });
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean stato="Approva".equals(statoTesi.getSelectedItem());
                controller.statoTesi(idS, stato);
                frame.dispose();
                frameVediTesi.setVisible(true);
                JOptionPane.showMessageDialog(frame, "Modificato stato della Tesi");
            }
        });
    }
}
