package banking_system.atm;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.*;
import java.text.*;

public class Withdrawl extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton withdrawl, back;
    String pinnumber;
    
    Withdrawl(String pinnumber){
        
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lable = new JLabel(i3);
        lable.setBounds(0, 0, 1100, 650);
        add(lable);
        
        JLabel text = new JLabel("Enter the amount You want to Withdrawl : ");
        text.setFont(new Font("System", Font.BOLD, 26));
        text.setBounds(130, 160, 700, 30);
        text.setForeground(Color.WHITE);
        lable.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Arial", Font.BOLD, 14));
        amount.setBounds(170, 240, 400, 40);
        add(amount);
        
        withdrawl = new JButton("Withdraw");
        withdrawl.setBounds(200, 370, 150, 30);
        withdrawl.setBackground(Color.BLACK);
        withdrawl.setForeground(Color.WHITE);
        withdrawl.addActionListener(this);
        lable.add(withdrawl);
        
        back = new JButton("Back");
        back.setBounds(400, 370, 150, 30);
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
        if(ae.getSource() == withdrawl){
            String number = amount.getText();
            Date dNow = new Date( );
            SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
            String date = ft.format(dNow);
            if (number.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter the amount you want to withdrawl");
            } else{
                try{
                    Conn conn = new Conn();
                    ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                    int balance = 0;
                    while(rs.next()){
                        if(rs.getString("type").equals("Deposit")){
                            balance += Integer.parseInt(rs.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                
                    if(balance < Integer.parseInt(number)){
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                    
                    String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+number+" Withdraw Successfully");
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
        new Withdrawl("");
    }
}
