package banking_system.atm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.text.*;

public class Deposit extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton deposit, back;
    String pinnumber;
    
    Deposit(String pinnumber){
        
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lable = new JLabel(i3);
        lable.setBounds(0, 0, 1100, 650);
        add(lable);
        
        JLabel text = new JLabel("Enter the amount You want to Deposit : ");
        text.setFont(new Font("System", Font.BOLD, 26));
        text.setBounds(130, 160, 700, 30);
        text.setForeground(Color.WHITE);
        lable.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Arial", Font.BOLD, 14));
        amount.setBounds(170, 240, 400, 40);
        add(amount);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(200, 370, 150, 30);
        deposit.setBackground(Color.BLACK);
        deposit.setForeground(Color.WHITE);
        deposit.addActionListener(this);
        lable.add(deposit);
        
        back = new JButton("Back");
        back.setBounds(400, 370, 150, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        lable.add(back);
        
        setTitle("ATM");
        setUndecorated(true);
        setSize(1100,650);
        setVisible(true);
        setLocation(140, 40);
        getContentPane().setBackground(Color.white);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == deposit){
            String number = amount.getText();
            Date dNow = new Date( );
            SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
            String date = ft.format(dNow);
            if (number.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter the amount you want to deposit");
            } else{
                try{
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Deposit', '"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+number+" Deposited Successfully");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                    
                } catch(Exception e){
                    System.out.println(e);
                }
                
            }
            
        } else if(ae.getSource() == back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String agrs[]){
        new Deposit("");
    }
}
