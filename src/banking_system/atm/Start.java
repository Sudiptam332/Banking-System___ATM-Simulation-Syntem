package banking_system.atm;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Start extends JFrame implements ActionListener {
    
    JButton start;
    
    Start(){
        
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/background.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 480, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lable = new JLabel(i3);
        lable.setBounds(0, 0, 800, 480);
        add(lable);
        
        setTitle("Banking System");
        
        start = new JButton("START");
        start.setBounds(340, 350, 130, 30);
        start.setBackground(Color.BLACK);
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);
        
        setSize(800,480);
        setUndecorated(true);
        setVisible(true);
        setLocation(280, 160);
        getContentPane().setBackground(Color.white);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login().setVisible(true);
    }
    
    public static void main(String arg[]){
        new Start();
    }
}
