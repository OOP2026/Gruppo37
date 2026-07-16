package gui;

import controller.Controller;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * La GUI Home.
 * L'interfaccia usata dagli utenti del sistema per accedere alla loro pagina personale.
 */
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

    /**
     * Costruttore della GUI Home.
     */
    public Home() {

        /**
         * Il bottone per accedere alla pagina personale dell'utente.
         */
        accedi.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(loginS.getText().isEmpty()||passwordS.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Non hai riempito tutti i campi");
                }else {
                    if ("Studente".equals(stuDoc.getSelectedItem())) {
                        int id=controller.accediUtente(loginS.getText(), passwordS.getText(), true);
                        if (id!=0) {
                            HomePageStudente homePageStudente = new HomePageStudente(frame, controller,id);
                            frame.setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(frame, "Nessun login e password associabili a questo Studente");
                        }
                    } else {
                        int id=controller.accediUtente(loginS.getText(), passwordS.getText(), false);
                        if (id!=0) {
                            HomePageDocente homePageDocente = new HomePageDocente(frame, controller,id);
                            frame.setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(frame, "Nessun login e password associabili a questo Docente");
                        }
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


    /**
     * Il main.
     * Serve per creare il primo frame.
     *
     */
    public static void main(String[] args) {
        frame= new JFrame("Home");
        frame.setSize(400,400);
        frame.setContentPane(new Home().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        controller=new Controller();
    }

}
