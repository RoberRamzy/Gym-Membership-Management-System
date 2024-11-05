package frontend;

import backend.Main;
import backend.TrainerRole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;

public class MainWindow extends JFrame{
    private JButton AdminRole;
    private JPanel container1;
    private JButton TrainerRole;


    public MainWindow() {
        setTitle("Main Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(new Dimension(500,450));
        setContentPane(container1);
        AdminRole.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AdminLogin adminLogin=new AdminLogin();
                
            }
        });

        TrainerRole.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                TrainerLogin trainerLogin=new TrainerLogin();
            }
        });
    }

}




