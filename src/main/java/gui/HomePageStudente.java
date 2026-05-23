package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HomePageStudente{
    JFrame frame;
    private JPanel panelMain;



    public HomePageStudente(JFrame frameHome) {
        frame = new JFrame("HomePageStudente");
        frame.setContentPane(panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
