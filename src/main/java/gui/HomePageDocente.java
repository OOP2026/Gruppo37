package gui;

import controller.Controller;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePageDocente extends JDialog {
    private JFrame frame;
    private JPanel panel;
    private JButton esciButton;
    private JLabel nome;
    private JLabel cognome;
    private JButton visualizzaTirociniButton;
    private JButton creaTirocinioButton;
    private JButton approvaRichiesteButton;

    public HomePageDocente(JFrame frameHome, Controller controller) {
        frame=new JFrame("HomePageDocente");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        nome.setText(controller.getNome(false));
        cognome.setText(controller.getCognome(false));

        esciButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frameHome.setVisible(true);
                frame.dispose();
            }

        });

        creaTirocinioButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                CreaTirocinio creaTirocinio= new CreaTirocinio(frame,controller);
            }
        });

        visualizzaTirociniButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                VediTirocinio vediTirocinio= new VediTirocinio(frame,controller);
            }
        });

        approvaRichiesteButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                ApprovaRichiesta approvaRichiesta=new ApprovaRichiesta(frame, controller);
            }
        });
    }
}
