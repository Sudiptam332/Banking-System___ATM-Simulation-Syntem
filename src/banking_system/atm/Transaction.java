package banking_system.atm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Transaction extends JFrame implements ActionListener{
    
    JButton deposit, withdrawl, fastcash, ministatement, pinchange, balanceenquiry, exit;
    String pinnumber;
    
    Transaction(String pinnumber){
        
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lable = new JLabel(i3);
        lable.setBounds(0, 0, 1100, 650);
        add(lable);
        
        JLabel text = new JLabel("Please Select Your Transaction");
        text.setFont(new Font("Raleway", Font.BOLD, 32));
        text.setBounds(140, 120, 700, 30);
        text.setForeground(Color.WHITE);
        lable.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(120, 250, 150, 30);
        deposit.setBackground(Color.BLACK);
        deposit.setForeground(Color.WHITE);
        deposit.addActionListener(this);
        lable.add(deposit);
        
        withdrawl = new JButton("Withdrawl");
        withdrawl.setBounds(120, 300, 150, 30);
        withdrawl.setBackground(Color.BLACK);
        withdrawl.setForeground(Color.WHITE);
        withdrawl.addActionListener(this);
        lable.add(withdrawl);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(120, 350, 150, 30);
        fastcash.setBackground(Color.BLACK);
        fastcash.setForeground(Color.WHITE);
        fastcash.addActionListener(this);
        lable.add(fastcash);
        
        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(480, 350, 150, 30);
        ministatement.setBackground(Color.BLACK);
        ministatement.setForeground(Color.WHITE);
        ministatement.addActionListener(this);
        lable.add(ministatement);
        
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(480, 250, 150, 30);
        pinchange.setBackground(Color.BLACK);
        pinchange.setForeground(Color.WHITE);
        pinchange.addActionListener(this);
        lable.add(pinchange);
        
        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(480, 300, 150, 30);
        balanceenquiry.setBackground(Color.BLACK);
        balanceenquiry.setForeground(Color.WHITE);
        balanceenquiry.addActionListener(this);
        lable.add(balanceenquiry);
        
        exit = new JButton("Exit");
        exit.setBounds(300, 420, 150, 30);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        lable.add(exit);
        
        //frame
        setTitle("ATM");
        setSize(1100,650);
        setUndecorated(true);
        setVisible(true);
        setLocation(140, 40);
        getContentPane().setBackground(Color.white);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        } else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if(ae.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        } else if(ae.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if(ae.getSource() == pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if(ae.getSource() == balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        } else if(ae.getSource() == ministatement){
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String arg[]){
        new Transaction("");
    }
    
}
