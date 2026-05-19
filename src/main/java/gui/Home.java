package gui;

import javax.swing.*;

public class Home {
    private static JFrame frame;
    //private static Controller controller;;
    private JPanel panel;
    private JLabel loginA;
    private JLabel passwordA;
    private JLabel passwordR;
    private JPanel loginR;
    private JLabel Registrati;
    private JLabel Accedi;
    private JTextField TestoLoginA;

    public Home() {}


    public static void main(String[] args) {
        frame= new JFrame("Home");
        frame.setContentPane(new Home().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
