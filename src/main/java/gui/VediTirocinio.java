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
                        "Nome", "Ente", "Disponibile", "In Corso", "ID studente"
                }
        ));
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        ArrayList<Object> info = controller.recuperaInfo(idD);
        if(info != null)
                for (int i = 0; i < info.size(); i++)
                    model.addRow(new Object[]{info.get(i), info.get(++i), info.get(++i), info.get(++i), info.get(++i)});


        buttonEsci.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                frameHomeD.setVisible(true);
            }
        });
    }
}
