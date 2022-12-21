package banking_system.atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login(){
        //logo
        setLayout(null);
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/bg.jpg"));
        Image i5 = i4.getImage().getScaledInstance(800, 460, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel bg = new JLabel(i6);
        bg.setBounds(0, 0, 800, 460);
        add(bg);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lable = new JLabel(i3);
        lable.setBounds(150, 10, 100, 100);
        bg.add(lable);
        
        setTitle("Automated Teller Machine");
        
        //welcome
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(290, 40, 400, 40);
        bg.add(text);
        
        //from
        JLabel cardno = new JLabel("Card No: ");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(200, 150, 150, 40);
        bg.add(cardno);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(340, 156, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);
        
        JLabel pin = new JLabel("PIN: ");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(200, 220, 150, 40);
        bg.add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(340, 226, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);
        
        login = new JButton("SIGN IN");
        login.setBounds(340, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        bg.add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(470, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        bg.add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(340, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        bg.add(signup);
        
        //Create Frame
        setSize(800,460);
        setUndecorated(true);
        setVisible(true);
        setLocation(280, 160);
        getContentPane().setBackground(Color.white);
                
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (ae.getSource() == login){
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login  where cardnumber = '"+cardnumber+"' and pinnumber = '"+pinnumber+"'";
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                } else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
                
            }catch(Exception e){
                System.out.println(e);
            }
            
        } else if (ae.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
            
    }
    
    public static void main(String arg[]){
        new Login();
    }
    
}
