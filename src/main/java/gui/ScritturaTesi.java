package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.*;

/**
 * The type Scrittura tesi.
 */
public class ScritturaTesi extends JDialog {
    private JFrame frame;
    private JPanel panel;
    private JButton buttonSalva;
    private JButton buttonCancel;
    private JTextField testo;
    private JTextField titolo;
    private JButton caricaButton;

    /**
     * Instantiates a new Scrittura tesi.
     *
     * @param frameHomeS the frame home s
     * @param controller the controller
     * @param primaVolta the prima volta
     */
    public ScritturaTesi(JFrame frameHomeS, Controller controller, boolean primaVolta) {
        frame = new JFrame("ScritturaTesi");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        if(primaVolta){
            titolo.setText("TITOLO");
            testo.setText("TESTO");
        }
        else{
            titolo.setText(controller.getTitolo());
            testo.setText(controller.getTesto());
        }

        buttonSalva.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(controller.salvaTesi(titolo.getText(), testo.getText())) {
                    frame.dispose();
                    frameHomeS.setVisible(true);
                    JOptionPane.showMessageDialog(frameHomeS, "Tesi salvata");
                }
                else{
                    JOptionPane.showMessageDialog(frame, "Riscontrato problema durante il salvataggio");}
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frameHomeS.setVisible(true);
                frame.dispose();
            }
        });

        caricaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(controller.salvaTesi(titolo.getText(), testo.getText()) && controller.caricaTesi()) {
                    frame.dispose();
                    frameHomeS.setVisible(true);
                    JOptionPane.showMessageDialog(frameHomeS, "Tesi caricata");
                }
                else{
                    JOptionPane.showMessageDialog(frame, "Riscontrato problema durante il caricamento");}
            }
        });
}}
