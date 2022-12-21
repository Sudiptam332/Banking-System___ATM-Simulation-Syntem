package banking_system.atm;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    
    JButton back;
    String pinnumber;
    
    BalanceEnquiry(String pinnumber){
        
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lable = new JLabel(i3);
        lable.setBounds(0, 0, 1100, 650);
        add(lable);
        
        JLabel text = new JLabel("Your Account Balance");
        text.setFont(new Font("System", Font.BOLD, 26));
        text.setBounds(240, 160, 700, 30);
        text.setForeground(Color.WHITE);
        lable.add(text);
        
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
            
            JLabel balancetext = new JLabel("" + balance);
            balancetext.setFont(new Font("Arial", Font.BOLD, 26));
            balancetext.setBounds(350, 260, 700, 30);
            balancetext.setForeground(Color.BLACK);
            lable.add(balancetext);
            
        } catch(Exception e){
            System.out.println(e);
        }
        
        back = new JButton("Back");
        back.setBounds(300, 370, 150, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        lable.add(back);
        
        setTitle("ATM");
        setSize(1100,650);
        setUndecorated(true);
        setVisible(true);
        setLocation(140, 40);
        getContentPane().setBackground(Color.white);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }
    
    public static void main(String agrs[]){
        new BalanceEnquiry("");
    }
}
