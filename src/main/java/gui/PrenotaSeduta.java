package gui;

import controller.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    public PrenotaSeduta(JFrame frameHomeS, Controller controller, int idS) {
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
        ArrayList<String> dataS = controller.getDataSeduta();
        ArrayList<String> luogoS=controller.getLuogoSeduta();
        if(dataS != null && luogoS != null)
            for (int i = 0; i < dataS.size(); i++)
                model.addRow(new Object[]{dataS.get(i), luogoS.get(i)});


        buttonSalva.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(dataSedutaTextField.getText().isEmpty() || luogoSedutaTextField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Non hai riempito tutti i vcampi");
                }else{
                    if(controller.verificaSeduta(dataSedutaTextField.getText(), luogoSedutaTextField.getText(), idS)){
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
