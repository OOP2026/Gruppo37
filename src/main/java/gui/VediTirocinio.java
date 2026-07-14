package gui;

import controller.Controller;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * La GUI VediTirocinio.
 * L'interfaccia usata dai docenti per visualizzare i vari tirocini creati.
 */
public class VediTirocinio extends JDialog {
    private JFrame frame;
    private JPanel panel;
    private JButton buttonEsci;
    private JTable table1;

    /**
     * Costruttore della GUI VediTirocinio.
     *
     * @param frameHomeD il frame della GUI della home del docente
     * @param controller il controller che ci permette di passare informazioni da un frame ad un altro
     */
    public VediTirocinio(JFrame frameHomeD, Controller controller,int idD) {
        frame = new JFrame("VediTirocinio");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        ArrayList<String> nomeT = controller.leggiNomeTirocinio(idD);
        ArrayList<String> ente=controller.leggiEnteTirocinio(idD);
        ArrayList<Boolean> disponibile=controller.leggiDisponibilitaTirocinio(idD);
        ArrayList<Boolean> inCorso=controller.leggiInCorsoTirocinio(idD);
        if(nomeT != null && ente != null && disponibile != null && inCorso != null)
            for (int i = 0; i < nomeT.size(); i++)
                model.addRow(new Object[]{nomeT.get(i), ente.get(i), disponibile.get(i), inCorso.get(i)});

        /**
         * Il bottone per tornare al frame precedente.
         */
        buttonEsci.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                frameHomeD.setVisible(true);
            }
        });
    }
}
