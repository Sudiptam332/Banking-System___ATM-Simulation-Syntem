package banking_system.atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    
    JTextField panNoTextField, aadharTextField;
    JButton next;
    JRadioButton seniorCitizen_yes, seniorCitizen_no, exisitingAccount_yes, exisitingAccount_no;
    JComboBox religionComboBox, categoryComboBox, incomeComboBox, educationComboBox, ocupationComboBox;
    String formno;
    
    SignupTwo(String formno){
        
        this.formno = formno;
        
        setLayout(null);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/bg.jpg"));
        Image i5 = i4.getImage().getScaledInstance(850, 650, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel bg = new JLabel(i6);
        bg.setBounds(0, 0, 850, 650);
        add(bg);
        
        setTitle("APPLICATION FORM - PAGE 2");
        
        //form
        JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 20));
        additionalDetails.setBounds(290, 50, 400, 30);
        bg.add(additionalDetails);  
        
        JLabel religion = new JLabel("Religion : ");
        religion.setFont(new Font("Raleway", Font.BOLD, 16));
        religion.setBounds(100, 120, 100, 20);
        bg.add(religion);
        
        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religionComboBox = new JComboBox(valReligion);
        religionComboBox.setBounds(300, 120, 400, 25);
        religionComboBox.setBackground(Color.WHITE);
        bg.add(religionComboBox);
        
        JLabel category = new JLabel("Category : ");
        category.setFont(new Font("Raleway", Font.BOLD, 16));
        category.setBounds(100, 170, 200, 20);
        bg.add(category);
        
        String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
        categoryComboBox = new JComboBox(valCategory);
        categoryComboBox.setBounds(300, 170, 400, 25);
        categoryComboBox.setBackground(Color.WHITE);
        bg.add(categoryComboBox);
        
        JLabel income = new JLabel("Income : ");
        income.setFont(new Font("Raleway", Font.BOLD, 16));
        income.setBounds(100, 220, 200, 20);
        bg.add(income);
        
        String incomeCategory[] = {"Null", "< 1,50,000", "< 3,00,000", "< 5,00,000", "Upto 10,00,000"};
        incomeComboBox = new JComboBox(incomeCategory);
        incomeComboBox.setBounds(300, 220, 400, 25);
        incomeComboBox.setBackground(Color.WHITE);
        bg.add(incomeComboBox);

        JLabel education = new JLabel("Education : ");
        education.setFont(new Font("Raleway", Font.BOLD, 16));
        education.setBounds(100, 270, 200, 20);
        bg.add(education);
        
        String educationCategory[] = {"10th Pass", "12th Pass", "Graduate", "Post-Graduate", "Doctrate", "Other"};
        educationComboBox = new JComboBox(educationCategory);
        educationComboBox.setBounds(300, 270, 400, 25);
        educationComboBox.setBackground(Color.WHITE);
        bg.add(educationComboBox);
               
        JLabel ocupation = new JLabel("Occupation : ");
        ocupation.setFont(new Font("Raleway", Font.BOLD, 16));
        ocupation.setBounds(100, 320, 200, 20);
        bg.add(ocupation);
        
        String ocupationCategory[] = {"Salaried", "Self_Employed", "Buissness", "Student", "Other"};
        ocupationComboBox = new JComboBox(ocupationCategory);
        ocupationComboBox.setBounds(300, 320, 400, 25);
        ocupationComboBox.setBackground(Color.WHITE);
        bg.add(ocupationComboBox);
               
        JLabel panNo = new JLabel("Pan No. : ");
        panNo.setFont(new Font("Raleway", Font.BOLD, 16));
        panNo.setBounds(100, 370, 200, 20);
        bg.add(panNo);
        
        panNoTextField = new JTextField();
        panNoTextField.setFont(new Font("Arial", Font.BOLD, 14));
        panNoTextField.setBounds(300, 370, 400, 25);
        bg.add(panNoTextField);
        
        JLabel aadhar = new JLabel("Aadhar No. : ");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 16));
        aadhar.setBounds(100, 420, 200, 20);
        bg.add(aadhar);
        
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Arial", Font.BOLD, 14));
        aadharTextField.setBounds(300, 420, 400, 25);
        bg.add(aadharTextField);
        
        JLabel seniorCitizen = new JLabel("Senior Citizen : ");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 16));
        seniorCitizen.setBounds(100, 470, 200, 20);
        bg.add(seniorCitizen);
        
        seniorCitizen_yes = new JRadioButton("Yes");
        seniorCitizen_yes.setBounds(300, 470, 100, 25);
        seniorCitizen_yes.setOpaque(false);
        bg.add(seniorCitizen_yes);
        
        seniorCitizen_no = new JRadioButton("No");
        seniorCitizen_no.setBounds(450, 470, 100, 25);
        seniorCitizen_no.setOpaque(false);
        bg.add(seniorCitizen_no);
        
        ButtonGroup seniorCitizengroup = new ButtonGroup();
        seniorCitizengroup.add(seniorCitizen_yes);
        seniorCitizengroup.add(seniorCitizen_no);
        
        JLabel exisitingAccount = new JLabel("Exisiting Account : ");
        exisitingAccount.setFont(new Font("Raleway", Font.BOLD, 16));
        exisitingAccount.setBounds(100, 510, 200, 20);
        bg.add(exisitingAccount);
        
        exisitingAccount_yes = new JRadioButton("Yes");
        exisitingAccount_yes.setBounds(300, 510, 100, 25);
        exisitingAccount_yes.setOpaque(false);
        bg.add(exisitingAccount_yes);
        
        exisitingAccount_no = new JRadioButton("No");
        exisitingAccount_no.setBounds(450, 510, 100, 25);
        exisitingAccount_no.setOpaque(false);
        bg.add(exisitingAccount_no);
        
        ButtonGroup exisitingAccountgroup = new ButtonGroup();
        exisitingAccountgroup.add(exisitingAccount_yes);
        exisitingAccountgroup.add(exisitingAccount_no);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 540, 80, 30);
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
        String religion = (String) religionComboBox.getSelectedItem();
        String category = (String) categoryComboBox.getSelectedItem();
        String income = (String) incomeComboBox.getSelectedItem();
        String education = (String) educationComboBox.getSelectedItem();
        String ocupation = (String) ocupationComboBox.getSelectedItem();
        String pan = panNoTextField.getText();
        String aadhar = aadharTextField.getText();
        
        String seniorCitizen = null;
        if (seniorCitizen_yes.isSelected()){
            seniorCitizen = "Yes";
        } else if (seniorCitizen_no.isSelected()){
            seniorCitizen = "No";
        }
        
        String exisitingAccount = null;
        if (exisitingAccount_yes.isSelected()){
            exisitingAccount = "Yes";
        } else if (exisitingAccount_no.isSelected()){
            exisitingAccount = "No";
        }
        
        try {
            if (pan.equals("")){
                JOptionPane.showMessageDialog(null, "Pan Number is Required");
            } else if (aadhar.equals("")){
                JOptionPane.showMessageDialog(null, "Aadhar Number is Required");
            } else if (seniorCitizen.equals("")){
                JOptionPane.showMessageDialog(null, "Please Mention, are you Senior Citizen or not");
            } else if (exisitingAccount.equals("")){
                JOptionPane.showMessageDialog(null, "Please Mention, You have an Exisiting Account or not");
            } else{
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"', '"+religion+"', '"+category+"', '"+income+"', '"+education+"', '"+ocupation+"', '"+pan+"', '"+aadhar+"', '"+seniorCitizen+"', '"+exisitingAccount+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        } catch (Exception e){
            System.out.println(e);
        }
        
    }
    
    public static void main(String arg[]){
        new SignupTwo("");
    }
}


