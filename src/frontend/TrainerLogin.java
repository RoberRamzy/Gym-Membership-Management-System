package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static constants.LoginCredentials.*;

public class TrainerLogin extends JFrame{
    private JPanel container7;
    private JButton loginButton;
    private JLabel Usernamelabel;
    private JLabel trainerPassLabel;
    private JTextField UsernameInput;
    private JPasswordField trainerPass;


    public TrainerLogin() {
        setTitle("Trainer Login");
        setVisible(true);
        setSize(new Dimension(500,450));
        setContentPane(container7);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username=UsernameInput.getText();
                String password=new String(trainerPass.getPassword());

                if(username.isEmpty()||password.isEmpty()){
                    JOptionPane.showMessageDialog(container7,"Some fields are empty","Message",JOptionPane.WARNING_MESSAGE);

                }else if(username.equals(TRAINER_USERNAME)&&password.equals(TRAINER_PASSWORD)){
                    JOptionPane.showMessageDialog(container7,"Welcome");
                    dispose();
                    TrainerRoleWindow trainerRoleWindow=new TrainerRoleWindow();

                }else {
                    JOptionPane.showMessageDialog(container7,"Wrong username or password");
                }
            }
        });
    }
}
