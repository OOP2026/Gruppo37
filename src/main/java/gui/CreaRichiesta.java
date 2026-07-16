package gui;

import controller.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * La GUI CreaRichiesta.
 * E' l'interfaccia usata dagli studenti per creare richieste da inviare ai docenti..
 */
public class CreaRichiesta extends JDialog {
    private JFrame frame;
    private JPanel panel;
    private JButton cancelButton;
    private JButton creaRichiestaButton;
    private JTable table1;
    private JTextField nomeTirocinio;


    /**
     * Costruttore della GUI CreaRichiesta.
     *
     * @param frameHomePageS il frame della GUI della home del studente
     * @param controller     il controller che ci permette di passare informazioni da un frame ad un altro
     */
    public CreaRichiesta(JFrame frameHomePageS, Controller controller, int idS) {
        frame = new JFrame("CreaRichiesta");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        table1.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Nome", "Ente", "Disponibile", "In Corso"
                }
        ));
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        ArrayList<String> nomeT = controller.leggiNomeTirocinio(0);
        ArrayList<String> ente=controller.leggiEnteTirocinio(0);
        ArrayList<Boolean> disponibile=controller.leggiDisponibilitaTirocinio(0);
        ArrayList<Boolean> inCorso=controller.leggiInCorsoTirocinio(0);
        if(nomeT != null && ente != null && disponibile != null && inCorso != null)
            for (int i = 0; i < nomeT.size(); i++)
        model.addRow(new Object[]{nomeT.get(i), ente.get(i), disponibile.get(i), inCorso.get(i)});


        creaRichiestaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(nomeTirocinio.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame,"Non hai riempito il campo");
                }else{
                    if(controller.verificaNomeTirocinio(nomeTirocinio.getText(), idS)){
                        JOptionPane.showMessageDialog(frame,"Richiesta creato con successo");
                    }else{
                        JOptionPane.showMessageDialog(frame,"Tirocinio inesistente o al completo");
                    }
                }
            }
        });


        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                frameHomePageS.setVisible(true);
            }
        });
    }
}
