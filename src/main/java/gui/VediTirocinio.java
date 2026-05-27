package gui;

import controller.Controller;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VediTirocinio extends JDialog {
    private JFrame frame;
    private JPanel panel;
    private JButton buttonEsci;
    private JTable table1;

    public VediTirocinio(JFrame frameHomeD, Controller controller) {
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
        model.addRow(new Object[]{
                controller.leggiNomeTirocinio(), controller.leggiEnteTirocinio(),
                controller.leggiDisponibilitaTirocinio(), controller.leggiInCorsoTirocinio()
                });


        buttonEsci.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                frameHomeD.setVisible(true);
            }
        });
    }
}
