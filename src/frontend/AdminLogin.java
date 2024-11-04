package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static constants.LoginCredentials.ADMIN_PASSWORD;
import static constants.LoginCredentials.ADMIN_USERNAME;

public class AdminLogin extends JFrame{
    private JPanel panel1;
    private JButton loginButton;
    private JLabel Usernamelabel;
    private JLabel adminPassLabel;
    private JTextField UsernameInput;
    private JPasswordField adminPass;


    public AdminLogin() {
        setVisible(true);
        setSize(new Dimension(500,450));
        setContentPane(panel1);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username=UsernameInput.getText();
                String password=new String(adminPass.getPassword());
                System.out.println("entered");
                if(username.isEmpty()){
                    JOptionPane.showMessageDialog(panel1,"Enter a text");
                }
                if(password.isEmpty()) {
                    JOptionPane.showMessageDialog(panel1,"Enter a password");
                }
                if(username.equals(ADMIN_USERNAME)&&password.equals(ADMIN_PASSWORD)){
                    JOptionPane.showMessageDialog(panel1,"Welcome");
                }else {
                    JOptionPane.showMessageDialog(panel1,"Wrong username or password");
                }
            }
        });
    }

    public static void main(String[] args) {
        AdminLogin page=new AdminLogin();

    }
}
