package gui;

import controller.Controller;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * La GUI HomePageStudente.
 * L'interfaccia usata dal studente per poter accedere a tutte le attivita' che puo' compiere.
 */
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

    /**
     * Costruttore della GUI HomePageStudente.
     *
     * @param frameHome  il frame della GUI della home
     * @param controller il controller che ci permette di passare informazioni da un frame ad un altro
     */
    public HomePageStudente(JFrame frameHome, Controller controller,String nomeS) {
        frame = new JFrame("HomePageStudente");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        nome.setText(controller.getNome(true));
        cognome.setText(controller.getCognome(true));
        dataSeduta.setText(controller.getDataSeduta());

        /**
         * Il bottone per uscire dal frame.
         */
        esciButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frameHome.setVisible(true);
                frame.dispose();
            }
        });

        /**
         * Il bottone per accedere al frame per creare una nuova tesi.
         */
        creaTesiButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                ScritturaTesi scritturaTesi=new ScritturaTesi(frame,controller,true,nomeS);
            }
        });

        /**
         * Il bottone per accedere al frame per continuare una tesi gia' esistente.
         */
        continuaTesiButton.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               if(controller.notNullTesi()==true){
                   frame.setVisible(false);
                   ScritturaTesi scritturaTesi=new ScritturaTesi(frame,controller,false,nomeS);
               }else{
                   JOptionPane.showMessageDialog(frame, "Non hai mai creato una tesi");
               }
           }
        });

        /**
         * Il bottone per accedere al frame per creare una nuova richiesta.
         */
        creaRichiestaButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                CreaRichiesta creaRichiesta=new CreaRichiesta(frame, controller,nomeS);
            }
        });

        /**
         * Il bottone per accedere al frame per prenotare una seduta di laurea.
         */
        prenotaSedutaButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                PrenotaSeduta prenotaSeduta=new PrenotaSeduta(frame, controller, nomeS);
            }
        });
    }
}
