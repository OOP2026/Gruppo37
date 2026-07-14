package gui;

import controller.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * La GUI ApprovaRichiesta.
 * E' l'interfaccia usata dal docente per approvare le richieste degli studenti.
 */
public class ApprovaRichiesta extends JDialog {
    private JFrame frame;
    private JPanel panel;
    private JButton salvaButton;
    private JButton buttonCancel;
    private JTable table1;
    private JComboBox statoRichiestaBox;
    private JTextField nomeStudenteTextField;
    private JTextField nomeTirocinioTextField;
    private JTextField cognomeStudenteTextField;

    /**
     * Costruttore della GUI ApprovaRichiesta.
     *
     * @param frameHomeD il frame della GUI della home del docente
     * @param controller il controller che ci permette di passare informazioni da un frame ad un altro
     */
    public ApprovaRichiesta(JFrame frameHomeD, Controller controller,int idD) {
        frame = new JFrame("ApprovaRichiesta");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        table1.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Nome Studente", "Cognome Studente", "Nome Tirocinio"
                }
        ));
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        ArrayList<String> info=controller.getStudenteETirocinio(idD);
        if(info != null)
            for (int i = 0; i < info.size()/3; i++)
                model.addRow(new Object[]{info.get(i), info.get(++i), info.get(++i)});

        /**
         * Il bottone per salvare le modifiche.
         */
        salvaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(nomeStudenteTextField.getText().isEmpty() || nomeTirocinioTextField.getText().isEmpty() ||
                        cognomeStudenteTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Non hai riempito tutti i campi");
                }else{
                    boolean stato;
                        if("Approva".equals(statoRichiestaBox.getSelectedItem())){
                            stato=true;
                        }else{
                            stato=false;
                        }
                    if(controller.verificaRichiesta(nomeStudenteTextField.getText(),cognomeStudenteTextField.getText(),
                            nomeTirocinioTextField.getText(), stato)){
                        frame.dispose();
                        frameHomeD.setVisible(true);
                        JOptionPane.showMessageDialog(frame, "Modificato stato della Richiesta");
                    }else{
                        JOptionPane.showMessageDialog(frame, "Richiesta inesistente");
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
