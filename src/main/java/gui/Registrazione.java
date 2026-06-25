package gui;

import controller.Controller;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La GUI Registrazione.
 * L'interfaccia usata dagli utenti per fare parte del sistema.
 */
public class Registrazione extends JDialog {
    private JFrame frame;
    private JPanel panel;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel nome;
    private JLabel cognome;
    private JLabel password;
    private JLabel login;
    private JTextField nomeS;
    private JTextField cognomeS;
    private JTextField loginS;
    private JPasswordField passwordS;
    private JComboBox stuDoc;
    private JLabel email;
    private JTextField emailS;

    /**
     * Costruttore della GUI Registrazione.
     *
     * @param frameHome  il frame della GUI della home
     * @param controller il controller che ci permette di passare informazioni da un frame ad un altro
     */
    public Registrazione(JFrame frameHome, Controller controller) {
        frame=new JFrame("Registrazione");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        /**
         * Il bottone per tornare al frame precedente
         */
        buttonCancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frameHome.setVisible(true);
                frame.dispose();
            }
    });

        /**
         * Il bottone per creare un nuovo utente.
         */
        buttonOK.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(loginS.getText().equals("")||passwordS.getText().equals("")||nomeS.getText().equals("")
                        ||cognomeS.getText().equals("")||emailS.getText().equals("")){
                    JOptionPane.showMessageDialog(frame, "Non hai riempito tutti i campi");
                }
                else{
                    if("Studente".equals(stuDoc.getSelectedItem())){
                        if(controller.aggiungiUtente(loginS.getText(),passwordS.getText(),nomeS.getText(),
                                cognomeS.getText(),emailS.getText(),true)){
                            frameHome.setVisible(true);
                            frame.dispose();
                        }
                        else{
                            JOptionPane.showMessageDialog(frame, "Qualscosa e' andato storto");
                        }

                    }
                    else{
                        if(controller.aggiungiUtente(loginS.getText(),passwordS.getText(),nomeS.getText(),
                                cognomeS.getText(),emailS.getText(),false)){
                            frameHome.setVisible(true);
                            frame.dispose();
                        }
                        else{
                            JOptionPane.showMessageDialog(frame,"Qualcosa e' andato storto");
                        }
                    }
                }
            }
        });



    }
}
