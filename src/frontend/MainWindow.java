package frontend;

import backend.Main;

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
        setVisible(true);
        setSize(new Dimension(500,450));
        setContentPane(container1);
        AdminRole.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AdminLogin adminLogin=new AdminLogin();
                
            }
        });
    }

}




