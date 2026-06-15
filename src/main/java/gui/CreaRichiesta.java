package gui;

import controller.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

/**
 * The type Crea richiesta.
 */
public class CreaRichiesta extends JDialog {
    private JFrame frame;
    private JPanel panel;
    private JButton cancelButton;
    private JButton creaRichiestaButton;
    private JTable table1;
    private JTextField nomeTirocinio;


    /**
     * Instantiates a new Crea richiesta.
     *
     * @param frameHomePageS the frame home page s
     * @param controller     the controller
     */
    public CreaRichiesta(JFrame frameHomePageS, Controller controller) {
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
        model.addRow(new Object[]{
                controller.leggiNomeTirocinio(), controller.leggiEnteTirocinio(),
                controller.leggiDisponibilitaTirocinio(), controller.leggiInCorsoTirocinio()
        });

        creaRichiestaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(nomeTirocinio.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame,"Non hai riempito il campo");
                }else{
                    if(controller.verificaNomeTirocinio(nomeTirocinio.getText())){
                        JOptionPane.showMessageDialog(frame,"Tirocino creato con sucesso");
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
