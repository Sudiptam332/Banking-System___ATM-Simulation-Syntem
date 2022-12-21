package banking_system.atm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
    
    JRadioButton SavingAC, CurrentAC, FixedAC, RecurringAC; 
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;
    long cardnumber, pinnumber;
    
    SignupThree(String formno) {
        
        this.formno = formno;
        
        setLayout(null);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/bg.jpg"));
        Image i5 = i4.getImage().getScaledInstance(850, 650, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel bg = new JLabel(i6);
        bg.setBounds(0, 0, 850, 650);
        add(bg);
        
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(290,15,400,40);
        bg.add(l1);
        
        JLabel actype = new JLabel("Account Type : ");
        actype.setFont(new Font("Raleway", Font.BOLD, 18));
        actype.setBounds(100,80,400,40);
        bg.add(actype);
        
        SavingAC = new JRadioButton("Saving Accont");
        SavingAC.setFont(new Font("Raleway", Font.BOLD, 14));
        SavingAC.setBackground(Color.WHITE);
        SavingAC.setBounds(280, 90, 160, 20);
        bg.add(SavingAC);
        
        CurrentAC = new JRadioButton("Current Accont");
        CurrentAC.setFont(new Font("Raleway", Font.BOLD, 14));
        CurrentAC.setBackground(Color.WHITE);
        CurrentAC.setBounds(280, 130, 160, 20);
        bg.add(CurrentAC);
        
        FixedAC = new JRadioButton("Fixed Deposite Accont");
        FixedAC.setFont(new Font("Raleway", Font.BOLD, 14));
        FixedAC.setBackground(Color.WHITE);
        FixedAC.setBounds(500, 90, 200, 20);
        bg.add(FixedAC);
        
        RecurringAC = new JRadioButton("Recurring Deposit Accont");
        RecurringAC.setFont(new Font("Raleway", Font.BOLD, 14));
        RecurringAC.setBackground(Color.WHITE);
        RecurringAC.setBounds(500, 130, 250, 20);
        bg.add(RecurringAC);
        
        ButtonGroup groupAC = new ButtonGroup();
        groupAC.add(SavingAC);
        groupAC.add(CurrentAC);
        groupAC.add(FixedAC);
        groupAC.add(RecurringAC);
        
        Random random = new Random();
        cardnumber = Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
        pinnumber = Math.abs((random.nextLong() % 9000L)) + 1000L;
        String s = "" + cardnumber;
        
        JLabel card = new JLabel("Card Number : ");
        card.setFont(new Font("Raleway", Font.BOLD, 18));
        card.setBounds(100,180,400,30);
        bg.add(card);
        JLabel cardText = new JLabel("Your 16 Digit Card Number");
        cardText.setFont(new Font("Raleway", Font.BOLD, 10));
        cardText.setBounds(100,196,400,30);
        bg.add(cardText);
        
        JLabel cardNumber = new JLabel(s.substring(0, 4) + "-" + s.substring(4, 8) + "-" + s.substring(8, 12) + "-" + s.substring(12, 16));
        cardNumber.setFont(new Font("Raleway", Font.BOLD, 18));
        cardNumber.setBounds(280,180,500,30);
        bg.add(cardNumber);
        
        JLabel cardPin = new JLabel("Pin Number : ");
        cardPin.setFont(new Font("Raleway", Font.BOLD, 18));
        cardPin.setBounds(100,230,400,30);
        bg.add(cardPin);
        JLabel cardPinText = new JLabel("Your 4 Digit Pin Number");
        cardPinText.setFont(new Font("Raleway", Font.BOLD, 10));
        cardPinText.setBounds(100,246,400,30);
        bg.add(cardPinText);
        
        JLabel pinNumber = new JLabel("" + pinnumber);
        pinNumber.setFont(new Font("Raleway", Font.BOLD, 18));
        pinNumber.setBounds(280,230,400,30);
        bg.add(pinNumber);
        
        JLabel services = new JLabel("Services Required : ");
        services.setFont(new Font("Raleway", Font.BOLD, 18));
        services.setBounds(100,290,300,30);
        bg.add(services);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setOpaque(false);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(280, 290, 200, 30);
        bg.add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setOpaque(false);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(280, 320, 200, 30);
        bg.add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setOpaque(false);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(280, 350, 200, 30);
        bg.add(c3);
        
        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setOpaque(false);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(500, 290, 200, 30);
        bg.add(c4);
        
        c5 = new JCheckBox("Check Book");
        c5.setOpaque(false);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(500, 320, 200, 30);
        bg.add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setOpaque(false);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(500, 350, 200, 30);
        bg.add(c6);
        
        c7 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge. And I");
        c7.setOpaque(false);
        c7.setFont(new Font("Raleway", Font.PLAIN, 14));
        c7.setBounds(100, 420, 700, 30);
        bg.add(c7);
        JLabel c7Text = new JLabel("have also noted down my Card number and Pin number for future requirment.");
        c7Text.setFont(new Font("Raleway", Font.PLAIN, 14));
        c7Text.setBounds(125,440,700,30);
        bg.add(c7Text);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(280, 500, 100, 30);
        submit.addActionListener(this);
        bg.add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(500, 500, 100, 30);
        cancel.addActionListener(this);
        bg.add(cancel);

        //frame
        setSize(850, 650);
        setUndecorated(true);
        setLocation(250, 30);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        
    }
    
    public void actionPerformed(ActionEvent ac){
        
        if (ac.getSource() == submit){
            String actype = null;
            if (SavingAC.isSelected()){
                actype = "Saving Accont";
            } else if (CurrentAC.isSelected()){
                actype = "Current Accont";
            } else if (FixedAC.isSelected()){
                actype = "Fixed Deposite Accont";
            } else if (RecurringAC.isSelected()){
                actype = "Recurring Deposit Accont";
            }
            
            String card_number = "" + cardnumber;
            String pin_number = "" + pinnumber;
            
            String facility = "";
            if (c1.isSelected()){
                facility = facility + " ATM Card";
            } else if (c2.isSelected()){
                facility = facility + " Internet Banking";
            } else if (c3.isSelected()){
                facility = facility + " Mobile Banking";
            } else if (c4.isSelected()){
                facility = facility + " Email & SMS Alerts";
            } else if (c5.isSelected()){
                facility = facility + " Check Book";
            } else if (c6.isSelected()){
                facility = facility + " E-Statement";
            }
            
            try {
                if (actype.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Select the Account Type");
                } else if (!c7.isSelected()){
                    JOptionPane.showMessageDialog(null, "Please Select the bellow Check box to Procced Further");
                } else{
                    Conn c = new Conn();
                    String query1 = "insert into signupthree values('"+formno+"', '"+actype+"', '"+card_number+"', '"+pin_number+"', '"+facility+"')";
                    String query2 = "insert into login values('"+formno+"', '"+card_number+"', '"+pin_number+"')";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    
                    setVisible(false);
                    new Deposit(pin_number).setVisible(true);
                }
            } catch(Exception e){
                System.out.println(e);
            }
            
        } else if(ac.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new SignupThree("");
    }
    
}
