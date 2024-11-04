package frontend;

import backend.AdminRole;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AdminRoleWindow {
    private JButton AddTrainer;
    private JButton RemoveTrainer;
    private JButton ViewTrainers;
    private JButton Logout;
    private JPanel Container3;
    private AdminRole Admin;
    public AdminRoleWindow() {
        Admin=new AdminRole();
        /*Log out*/
        Logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Admin.logout();
                    JOptionPane.showMessageDialog(Container3,"Log out successfully","Success",JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
