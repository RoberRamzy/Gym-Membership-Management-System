package frontend;

import backend.AdminRole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AdminRoleWindow extends JFrame{
    private JButton AddTrainer;
    private JButton RemoveTrainer;
    private JButton ViewTrainers;
    private JButton Logout;
    private JPanel Container3;
    private AdminRole Admin;

    public AdminRoleWindow() {

        setTitle("Admin window");
        setVisible(true);
        setSize(new Dimension(500,450));
        setContentPane(Container3);
        Admin=new AdminRole();
        /*Logout*/
        Logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Admin.logout();
                    JOptionPane.showMessageDialog(Container3,"Logout successfully","Success",JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    MainWindow MainWindow=new MainWindow();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        AddTrainer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TrainerWindow trainer=new TrainerWindow(Admin);
            }
        });
        RemoveTrainer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteTrainer trainer=new DeleteTrainer(Admin);
            }
        });

        ViewTrainers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewTrainers viewTrainers = new ViewTrainers();
            }
        });
    }
}
