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

    public HomePageDocente(JFrame frameHome, Controller controller) {
        frame=new JFrame("HomePageDocente");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
