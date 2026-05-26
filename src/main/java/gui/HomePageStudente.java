package gui;

import controller.Controller;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HomePageStudente{
    private JFrame frame;
    private JPanel panel;
    private JLabel nome;
    private JLabel cognome;
    private JLabel dataSeduta;
    private JButton creaTesiButton;
    private JButton prenotaSedutaButton;
    private JButton continuaTesiButton;
    private JButton creaRichiestaButton;
    private JButton esciButton;

    public HomePageStudente(JFrame frameHome, Controller controller) {
        frame = new JFrame("HomePageStudente");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        esciButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frameHome.setVisible(true);
                frame.dispose();
            }

        });
    }
}
