package ZahlRaten;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
public class zahl {

    static int myNumber = ThreadLocalRandom.current().nextInt(0, 100 + 1);
    static JLabel textVersuche =new JLabel("Deine Versuche 0 von 10");
    static JLabel text =  new JLabel("Gebe eine Zahl zwischen 0 und 100 ein !");
    static JTextField textField = new JTextField();
    static JTextField versucheField = new JTextField();
    static Integer tries = 0;

    public static void main(String[] args){
      openUI();
       // nextround();
    }
    public static void openUI(){
        JFrame frame = new JFrame("Rate die Zahl!");
        frame.setSize(400,300);
        frame.setLocation(100,150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultLookAndFeelDecorated(true);

        textVersuche.setBounds(50,30,300,30);
        text.setBounds(50,50,300,30);
        textField.setBounds(50,100,200,30);

        JButton button = new JButton("Raten!");
        button.setBounds(50,150,200,30);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textfromtextfield = textField.getText();
                Integer number = Integer.parseInt(textfromtextfield);
                rightnumber(number);
                String textfromtextfield1 = versucheField.getText();
                Integer number1 = Integer.parseInt(textfromtextfield1);
                rightnumber(number);

            }
        });
        frame.add(textVersuche);
        frame.add(text);
        frame.add(textField);
        frame.add(versucheField);
        frame.add(button);
        frame.setLayout(null);
        frame.setVisible(true);

    }
    public static void nextround(){
        System.out.println("rate mal die Richtige Zahl !\nAchtung !! du hast nur 10 Versuche :D");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        rightnumber(number);

    }
    public static void rightnumber(int number){
        tries++;
        if (number==myNumber){
            System.out.println("richtig geraten!!!");
            text.setText("Richtig geraten mit "+ tries+" Versuchen :D ");
            textVersuche.setText("Deine Versuche "+tries+" von 10");
        }else {
            if (number< myNumber){
                text.setText("Falsch geraten!!! Deine Zahl ist zu klein");
                textVersuche.setText("Deine Versuche "+tries+" von 10");
            }else {
                text.setText("Falsch geraten !!! Deine Zahl ist zu groß");
                textVersuche.setText("Deine Versuche "+tries+" von 10");
            }

        }
        textField.setText("");
        textVersuche.setText("");
    }
}
