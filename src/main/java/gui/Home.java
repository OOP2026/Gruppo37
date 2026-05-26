package gui;

import controller.Controller;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home {
    private static JFrame frame;
    private static Controller controller;
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
                if(loginS.getText().equals("")||passwordS.getText().equals("")){
                    JOptionPane.showMessageDialog(frame, "Non hai riempito tutti i campi");
                }
                else {
                    frame.setVisible(false);
                    if ("Studente".equals(stuDoc.getSelectedItem())) {
                        HomePageStudente homePageStudente = new HomePageStudente(frame, controller);
                    } else {
                        HomePageDocente homePageDocente = new HomePageDocente(frame, controller);
                    }
                }
            }
        });
        registrati.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                Registrazione registrazione = new Registrazione(frame, controller);
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
