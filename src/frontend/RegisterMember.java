package frontend;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;

public class RegisterMember extends JFrame{
    private JButton RegisterButton;
    private JTextField TextMemberId;
    private JLabel MemberId;
    private JPanel Container9;
    private JLabel ClassId;
    private JTextField TextClassId;
    private JLabel RegistrationDate;
    private JDateChooser RegistrationDateChooser;

    private void createUIComponents() {
        RegistrationDateChooser = new JDateChooser(); // Instantiate your custom component
        // Set any properties for the date chooser here, if needed
    }
    public RegisterMember() {
    }
}
