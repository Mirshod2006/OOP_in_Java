import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//At the below code we are inheriting ContactForm from JFrame and intstantiating below two Interfaces
public class JavaWeek7_U2310088 extends JFrame implements ActionListener, ItemListener {
    // Below required fields are being created with corresponding JFrame Elements
    private JTextField nameField, emailField; 
    private JRadioButton maleButton, femaleButton;
    private JComboBox<String> countryComboBox;
    private JCheckBox newsletterCheckBox;
    private JButton submitButton;
    
    public JavaWeek7_U2310088() {
        setTitle("Contact Form");
        setLayout(new FlowLayout(6, 2, 5));
        
        add(new JLabel("Name:"));
        nameField = new JTextField(15);
        add(nameField);
        
        add(new JLabel("Email:"));
        emailField = new JTextField(15);
        add(emailField);
        
        add(new JLabel("Gender:"));
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        
        JPanel genderPanel = new JPanel();
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        add(genderPanel);
        
        add(new JLabel("Country:"));
        String[] countries = {"USA", "Canada", "UK", "Australia"};
        countryComboBox = new JComboBox<>(countries);
        add(countryComboBox);
        
        add(new JLabel("Subscribe to Newsletter:"));
        newsletterCheckBox = new JCheckBox();
        add(newsletterCheckBox);
        
        submitButton = new JButton("Submit");
        add(submitButton);
        
        submitButton.addActionListener(this);
        countryComboBox.addActionListener(this);
        newsletterCheckBox.addItemListener(this);
        maleButton.addItemListener(this);
        femaleButton.addItemListener(this);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String name = nameField.getText();
            String email = emailField.getText();
            String gender = maleButton.isSelected() ? "Male" : "Female"; // This Trenary operator checks for gender type
            String country = (String) countryComboBox.getSelectedItem();
            String subscribed = newsletterCheckBox.isSelected() ? "Yes" : "No";
            
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
            System.out.println("Gender: " + gender);
            System.out.println("Country: " + country);
            System.out.println("Subscribed to Newsletter: " + subscribed);
        } else if (e.getSource() == countryComboBox) {
            System.out.println("Country selected: " + countryComboBox.getSelectedItem());
        }
    }
    
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == newsletterCheckBox) {
            System.out.println("Subscribed to Newsletter: " + (newsletterCheckBox.isSelected() ? "Yes" : "No"));
        } else if (e.getSource() == maleButton || e.getSource() == femaleButton) {
            System.out.println("Gender selected: " + (maleButton.isSelected() ? "Male" : "Female"));
        }
    }
    
    public static void main(String[] args) {
        new JavaWeek7_U2310088();
    }
}
