package gui;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home {
    private static JFrame frame;
    //private static Controller controller;;
    private JPanel panel;
    private JLabel login;
    private JLabel password;
    private JTextField loginS;
    private JTextField passwordS;
    private JButton accedi;
    private JButton registrati;
    private JComboBox stuDoc;

    public Home() {
        accedi.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //JOptionPane.showMessageDialog(frame, "ciao");
                HomePageStudente homePageStudente  = new HomePageStudente(frame);
            }
        });
    }


    public static void main(String[] args) {
        frame= new JFrame("Home");
        frame.setSize(400,400);
        frame.setContentPane(new Home().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
