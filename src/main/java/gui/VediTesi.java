package gui;

import controller.Controller;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

/**
 * La GUI VediTesi.
 * L'interfaccia usata dal docente per poter visulizzare le tesi degli studenti.
 */
public class VediTesi extends JDialog {
    private JFrame frame;
    private JPanel panel;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTable table1;
    private JTextField nomeS;
    private JTextField cognomeS;

    /**
     * Costruttore della GUI VediTesi.
     *
     * @param frameHomeD il frame della GUI della home page del docente
     * @param controller il controller che ci permette di passare informazioni da un frame ad un altro
     */
    public VediTesi(JFrame frameHomeD, Controller controller,int idD) {
        frame = new JFrame("VediTirocinio");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        table1.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Nome Studente", "Cognome Studente"
                }
        ));
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        ArrayList<String> studente = controller.recuperaStudente(idD);
        if(studente != null)
            for (int i = 0; i < studente.size(); i++)
                model.addRow(new Object[]{studente.get(i), studente.get(++i)});

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                frameHomeD.setVisible(true);
            }
        });

        buttonOK.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if(nomeS.getText().isEmpty() || cognomeS.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Non hai riempito tutti i campi");
            } else{
                int idS=controller.verificaStudente(nomeS.getText(),cognomeS.getText());
                if(idS!=0){
                    ApprovaTesi approvaTesi= new ApprovaTesi(frame, controller,idD,idS);
                } else {
                    JOptionPane.showMessageDialog(frame, "Studente inesistente");
                }
            }
        }
        });
    }
}
