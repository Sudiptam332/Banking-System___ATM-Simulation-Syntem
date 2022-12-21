package banking_system.atm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.text.*;
import java.sql.*;

public class FastCash extends JFrame implements ActionListener{
    
    JButton b1, b2, b3, b4, b5, b6, exit;
    String pinnumber;
    
    FastCash(String pinnumber){
        
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lable = new JLabel(i3);
        lable.setBounds(0, 0, 1100, 650);
        add(lable);
        
        JLabel text = new JLabel("Select The Amount You Want To Withdrawl");
        text.setFont(new Font("Raleway", Font.BOLD, 26));
        text.setBounds(110, 130, 700, 30);
        text.setForeground(Color.WHITE);
        lable.add(text);
        
        b1 = new JButton("Rs 100");
        b1.setBounds(120, 250, 150, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        lable.add(b1);
        
        b2 = new JButton("Rs 500");
        b2.setBounds(120, 300, 150, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        lable.add(b2);
        
        b3 = new JButton("Rs 1000");
        b3.setBounds(120, 350, 150, 30);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        lable.add(b3);
        
        b4 = new JButton("Rs 2000");
        b4.setBounds(480, 350, 150, 30);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.addActionListener(this);
        lable.add(b4);
        
        b5 = new JButton("Rs 5000");
        b5.setBounds(480, 250, 150, 30);
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.addActionListener(this);
        lable.add(b5);
        
        b6 = new JButton("Rs 10000");
        b6.setBounds(480, 300, 150, 30);
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        b6.addActionListener(this);
        lable.add(b6);
        
        exit = new JButton("Back");
        exit.setBounds(300, 420, 150, 30);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        lable.add(exit);
        
        //frame
        setTitle("ATM");
        setUndecorated(true);
        setSize(1100,650);
        setVisible(true);
        setLocation(140, 40);
        getContentPane().setBackground(Color.white);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if(balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                
                java.util.Date dNow = new java.util.Date( );
                SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
                String date = ft.format(dNow);
                
                String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+amount+" Debited Successfully");
                
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
                
            }catch(Exception e){
                System.out.println(e);
            }
            
        }
    }
    
    public static void main(String arg[]){
        new FastCash("");
    }
    
}
