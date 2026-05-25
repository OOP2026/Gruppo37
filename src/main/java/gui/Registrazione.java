package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registrazione extends JDialog {
    private JFrame frame;
    private JPanel panel;
    private JButton buttonOK;
    private JButton buttonCancel;

    public Registrazione(JFrame frameHome, int controller) {
        frame=new JFrame("Registrazione");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        buttonCancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frameHome.setVisible(true);
                frame.dispose();
            }
    });}
}
