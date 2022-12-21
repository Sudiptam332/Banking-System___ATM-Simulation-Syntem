package banking_system.atm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener {
    
    String pinnumber;
    JPasswordField pin, repin;
    JButton change, back;
    
    PinChange(String pinnumber){
        
        this.pinnumber = pinnumber;

        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lable = new JLabel(i3);
        lable.setBounds(0, 0, 1100, 650);
        add(lable);
        
        JLabel text = new JLabel("Change Your Pin Number");
        text.setFont(new Font("System", Font.BOLD, 26));
        text.setBounds(210, 140, 700, 30);
        text.setForeground(Color.WHITE);
        lable.add(text);
        
        JLabel pintext = new JLabel("New Pin : ");
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setBounds(150, 220, 150, 30);
        pintext.setForeground(Color.BLACK);
        lable.add(pintext);
        
        JLabel repintext = new JLabel("Re-Enter New Pin : ");
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setBounds(150, 290, 150, 30);
        repintext.setForeground(Color.BLACK);
        lable.add(repintext);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Arial", Font.BOLD, 14));
        pin.setBounds(330, 220, 200, 30);
        lable.add(pin);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Arial", Font.BOLD, 14));
        repin.setBounds(330, 290, 200, 30);
        lable.add(repin);
        
        change = new JButton("Change Pin");
        change.setBounds(200, 370, 150, 30);
        change.setBackground(Color.BLACK);
        change.setForeground(Color.WHITE);
        change.addActionListener(this);
        lable.add(change);
        
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
        if(ae.getSource() == change){
            try{
                String npin = pin.getText();
                String rpin = repin.getText();
                
                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "New Pin and Re-Enter Pin should be Same");
                    return;
                }
                
                if(npin.length() != 4){
                    JOptionPane.showMessageDialog(null, "Pin Number should be 4 digits");
                    return;
                }
                
                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+rpin+"' where pin='"+pinnumber+"'";
                String query2 = "update login set pinnumber = '"+rpin+"' where pinnumber='"+pinnumber+"'";
                String query3 = "update signupthree set pinnumber = '"+rpin+"' where pinnumber='"+pinnumber+"'";
                
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "Pin Changed Succesfully");
                
                setVisible(false);
                new Transaction(rpin).setVisible(true);
                
            }catch(Exception e){
                System.out.println(e);
            }
            
        } else if(ae.getSource() == back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String agrs[]){
        new PinChange("");
    }
}
