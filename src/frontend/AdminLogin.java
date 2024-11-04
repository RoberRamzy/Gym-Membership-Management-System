package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static constants.LoginCredentials.ADMIN_PASSWORD;
import static constants.LoginCredentials.ADMIN_USERNAME;

public class AdminLogin extends JFrame{
    private JPanel container2;
    private JButton loginButton;
    private JLabel Usernamelabel;
    private JLabel adminPassLabel;
    private JTextField UsernameInput;
    private JPasswordField adminPass;


    public AdminLogin() {
        setTitle("Admin Login");
        setVisible(true);
        setSize(new Dimension(500,450));
        setContentPane(container2);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username=UsernameInput.getText();
                String password=new String(adminPass.getPassword());

                if(username.isEmpty()||password.isEmpty()){
                    JOptionPane.showMessageDialog(container2,"Some fields are empty","Message",JOptionPane.WARNING_MESSAGE);
                }else if(username.equals(ADMIN_USERNAME)&&password.equals(ADMIN_PASSWORD)){
                    JOptionPane.showMessageDialog(container2,"Welcome");
                    dispose();
                    AdminRoleWindow nextwindow=new AdminRoleWindow();
                }else {
                    JOptionPane.showMessageDialog(container2,"Wrong username or password!","Message",JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }


}
