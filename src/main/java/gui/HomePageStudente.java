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
    public HomePageStudente(JFrame frameHome, Controller controller,int idS) {
        frame = new JFrame("HomePageStudente");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        nome.setText(controller.getNome(true));
        cognome.setText(controller.getCognome(true));
        dataSeduta.setText(controller.getDataSedutaScritta());


        esciButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frameHome.setVisible(true);
                frame.dispose();
            }
        });


        creaTesiButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                ScritturaTesi scritturaTesi=new ScritturaTesi(frame,controller,true,idS);
            }
        });


        continuaTesiButton.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               if(controller.notNullTesi(idS)){
                   frame.setVisible(false);
                   ScritturaTesi scritturaTesi=new ScritturaTesi(frame,controller,false,idS);
               }else{
                   JOptionPane.showMessageDialog(frame, "Non hai mai creato una tesi");
               }
           }
        });


        creaRichiestaButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                CreaRichiesta creaRichiesta=new CreaRichiesta(frame, controller,idS);
            }
        });


        prenotaSedutaButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                PrenotaSeduta prenotaSeduta=new PrenotaSeduta(frame, controller, idS);
            }
        });
    }
}
