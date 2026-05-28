package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.*;

public class ApprovaRichiesta extends JDialog {
    private JFrame frame;
    private JPanel panel;
    private JButton salvaButton;
    private JButton buttonCancel;

    public ApprovaRichiesta(JFrame frameHomeD, Controller controller) {
        frame = new JFrame("ApprovaRichiesta");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        salvaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

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
