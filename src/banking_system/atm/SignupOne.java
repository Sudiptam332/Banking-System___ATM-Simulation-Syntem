package banking_system.atm;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
    
    long random;
    JTextField nameTextField, fnameTextField, emailTextField, pinTextField, cityTextField, addressTextField, stateTextField;
    JButton next;
    JDateChooser dateChooser;
    JRadioButton male, female, gender_other, married, unmarried, merital_other;
    
    SignupOne(){
        
        setLayout(null);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/bg.jpg"));
        Image i5 = i4.getImage().getScaledInstance(850, 650, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel bg = new JLabel(i6);
        bg.setBounds(0, 0, 850, 650);
        add(bg);
        
        setTitle("APPLICATION FORM - PAGE 1");
        
        //form
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        
        JLabel formno = new JLabel("Applicatin Form No. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 30));
        formno.setBounds(235, 20, 600, 40);
        bg.add(formno);
        
        JLabel personDetails = new JLabel("Page 1 : Personal Details");
        personDetails.setFont(new Font("Raleway", Font.BOLD, 20));
        personDetails.setBounds(300, 80, 400, 30);
        bg.add(personDetails);  
        
        JLabel name = new JLabel("Name : ");
        name.setFont(new Font("Raleway", Font.BOLD, 16));
        name.setBounds(100, 140, 100, 20);
        bg.add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Arial", Font.BOLD, 16));
        nameTextField.setBounds(300, 140, 400, 25);
        bg.add(nameTextField);
        
        JLabel fname = new JLabel("Fathers Name : ");
        fname.setFont(new Font("Raleway", Font.BOLD, 16));
        fname.setBounds(100, 180, 200, 20);
        bg.add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Arial", Font.BOLD, 14));
        fnameTextField.setBounds(300, 180, 400, 25);
        bg.add(fnameTextField);
        
        JLabel dob = new JLabel("Date of Birth : ");
        dob.setFont(new Font("Raleway", Font.BOLD, 16));
        dob.setBounds(100, 220, 200, 20);
        bg.add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 220, 400, 25);
        dateChooser.setForeground(new Color(105, 105, 105));
        bg.add(dateChooser);

        JLabel gender = new JLabel("Gender : ");
        gender.setFont(new Font("Raleway", Font.BOLD, 16));
        gender.setBounds(100, 260, 200, 20);
        bg.add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300, 260, 60, 25);
        male.setOpaque(false);
        bg.add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(450, 260, 100, 25);
        female.setOpaque(false);
        bg.add(female);
        
        gender_other = new JRadioButton("Other");
        gender_other.setBounds(600, 260, 100, 25);
        gender_other.setOpaque(false);
        bg.add(gender_other);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(gender_other);
        
        JLabel email = new JLabel("Email Address : ");
        email.setFont(new Font("Raleway", Font.BOLD, 16));
        email.setBounds(100, 300, 200, 20);
        bg.add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Arial", Font.BOLD, 16));
        emailTextField.setBounds(300, 300, 400, 25);
        bg.add(emailTextField);
        
        JLabel merital = new JLabel("Merital Status : ");
        merital.setFont(new Font("Raleway", Font.BOLD, 16));
        merital.setBounds(100, 340, 200, 20);
        bg.add(merital);
        
        married = new JRadioButton("Married");
        married.setBounds(300, 340, 100, 25);
        married.setOpaque(false);
        bg.add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 340, 100, 25);
        unmarried.setOpaque(false);
        bg.add(unmarried);
        
        merital_other = new JRadioButton("Other");
        merital_other.setBounds(600, 340, 100, 25);
        merital_other.setOpaque(false);
        bg.add(merital_other);
        
        ButtonGroup meritalgroup = new ButtonGroup();
        meritalgroup.add(married);
        meritalgroup.add(unmarried);
        meritalgroup.add(merital_other);
        
        JLabel address = new JLabel("Address : ");
        address.setFont(new Font("Raleway", Font.BOLD, 16));
        address.setBounds(100, 380, 200, 20);
        bg.add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Arial", Font.BOLD, 14));
        addressTextField.setBounds(300, 380, 400, 25);
        bg.add(addressTextField);
        
        JLabel city = new JLabel("City : ");
        city.setFont(new Font("Raleway", Font.BOLD, 16));
        city.setBounds(100, 420, 200, 20);
        bg.add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Arial", Font.BOLD, 14));
        cityTextField.setBounds(300, 420, 400, 25);
        bg.add(cityTextField);
        
        JLabel state = new JLabel("State : ");
        state.setFont(new Font("Raleway", Font.BOLD, 16));
        state.setBounds(100, 460, 200, 20);
        bg.add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Arial", Font.BOLD, 14));
        stateTextField.setBounds(300, 460, 400, 25);
        bg.add(stateTextField);
        
        JLabel pincode = new JLabel("Pincode : ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 16));
        pincode.setBounds(100, 500, 200, 20);
        bg.add(pincode);
        
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        pinTextField.setBounds(300, 500, 400, 25);
        bg.add(pinTextField);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 550, 80, 30);
        next.addActionListener(this);
        bg.add(next);

        
        //frame
        setSize(850, 650);
        setUndecorated(true);
        setLocation(250, 30);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
}
    
    public void actionPerformed(ActionEvent ae){
        String formno = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        
        String gender = null;
        if (male.isSelected()){
            gender = "Male";
        } else if (female.isSelected()){
            gender = "Female";
        } else if (gender_other.isSelected()){
            gender = "Other";
        }
        
        String email = emailTextField.getText();
        
        String marital = null;
        if (married.isSelected()){
            marital = "Married";
        } else if (unmarried.isSelected()){
            marital = "Unmarried";
        } else if (merital_other.isSelected()){
            marital = "Other";
        }
        
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();
        
        try {
            if (name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");
            } else if (fname.equals("")){
                JOptionPane.showMessageDialog(null, "Father Name is Required");
            }else if (dob.equals("")){
                JOptionPane.showMessageDialog(null, "Date of Birth is Required");
            }else if (gender.equals("")){
                JOptionPane.showMessageDialog(null, "Gender is Required");
            }else if (email.equals("")){
                JOptionPane.showMessageDialog(null, "Email is Required");
            }else if (marital.equals("")){
                JOptionPane.showMessageDialog(null, "Marital Status is Required");
            }else if (address.equals("")){
                JOptionPane.showMessageDialog(null, "Address is Required");
            }else if (city.equals("")){
                JOptionPane.showMessageDialog(null, "City is Required");
            }else if (state.equals("")){
                JOptionPane.showMessageDialog(null, "State is Required");
            }else if (pin.equals("")){
                JOptionPane.showMessageDialog(null, "Pincode is Required");
            }else{
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+pin+"', '"+state+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String arg[]){
        new SignupOne();
    }
}
