package banking_system.atm;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*; 

public class MiniStatement extends JFrame implements ActionListener{
    
    String pinnumber;
    JButton exit;
    
    MiniStatement(String pinnumber){
        
        this.pinnumber = pinnumber;
        
        setTitle("Mini Statement");
        
        setLayout(null);
        
        JLabel bank = new JLabel("Sudipta Bank");
        bank.setBounds(150, 30, 150, 20);
        bank.setFont(new Font("System", Font.BOLD, 16));
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        // account type
        JLabel actext = new JLabel();
        actext.setBounds(20, 130, 700, 30);
        actext.setForeground(Color.BLACK);
        add(actext);
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from signupthree where pinnumber = '"+pinnumber+"'");

            while(rs.next()){
                actext.setText("Account Type : "  + rs.getString("actype"));
            }
            
        } catch(Exception e){
            System.out.println(e);
        }
        
        // Current Balance
        try{
            int balance = 0;
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            
            JLabel balancetext = new JLabel("Current Balance : " + balance);
            balancetext.setBounds(20, 100, 700, 30);
            balancetext.setForeground(Color.BLACK);
            add(balancetext);
            
        } catch(Exception e){
            System.out.println(e);
        }
        
        //Card Number
        try{            
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pinnumber = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number : XXXX-XXXX-XXXX-" + rs.getString("cardnumber").substring(12));
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        JLabel mini = new JLabel();
        mini.setBounds(20, 180, 400, 200);
        add(mini);
        
        
        try{            
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        exit = new JButton("Close");
        exit.setBounds(160, 440, 80, 20);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        add(exit);
        
        setSize(400, 500);
        setUndecorated(true);
        setLocation(20, 20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
            setVisible(false);
    }
    
    public static void main(String args[]){
        new MiniStatement("");
    }
}
