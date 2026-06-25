package gui;

import controller.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La GUI PrenotaSeduta.
 * L'interfaccia usata dagli studenti per prenotare una seduta di laurea.
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
     * Costruttore della GUI PrenotaSeduta.
     *
     * @param frameHomeS il frame della GUI della home del studente
     * @param controller il controller che ci permette di passare informazioni da un frame ad un altro
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

        /**
         * Il bottone per prenotare la seduta di laurea.
         */
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

        /**
         * Il bottone per tornare al frame precedente.
         */
        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                frameHomeS.setVisible(true);
            }
        });
    }
}
