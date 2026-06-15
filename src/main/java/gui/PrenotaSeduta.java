package gui;

import controller.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Prenota seduta.
 */
public class PrenotaSeduta extends JDialog {
    private JFrame frame;
    private JPanel panel;
    private JButton buttonSalva;
    private JButton buttonCancel;
    private JTable table1;
    private JTextField dataSedutaTextField;
    private JTextField luogoSedutaTextField;

    /**
     * Instantiates a new Prenota seduta.
     *
     * @param frameHomeS the frame home s
     * @param controller the controller
     */
    public PrenotaSeduta(JFrame frameHomeS, Controller controller) {
        frame = new JFrame("PrenotaSeduta");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        table1.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Data", "Luogo"
                }
        ));
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.addRow(new Object[]{
                controller.getDataSeduta(), controller.getLuogoSeduta()
        });

        buttonSalva.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(dataSedutaTextField.getText().isEmpty() || luogoSedutaTextField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Non hai riempito tutti i vcampi");
                }else{
                    if(controller.verificaSeduta(dataSedutaTextField.getText(), luogoSedutaTextField.getText())){
                        JOptionPane.showMessageDialog(frame, "Seduta di Laurea prenotata");
                    }else{
                        JOptionPane.showMessageDialog(frame, "Si è verificato un errore");
                    }
                }
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                frameHomeS.setVisible(true);
            }
        });
    }
}
