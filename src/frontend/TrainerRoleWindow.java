package frontend;

import backend.TrainerRole;

import javax.swing.*;
import java.awt.*;


public class TrainerRoleWindow
 extends JFrame{
    private JButton AddTrainer;
    private JButton RemoveTrainer;
    private JButton ViewTrainers;
    private JButton Logout;
    private JPanel Container8;
    private TrainerRole trainer;

    public TrainerRoleWindow (){

        setTitle("Admin Login");
        setVisible(true);
        setSize(new Dimension(500,450));
        setContentPane(Container8);
        trainer=new TrainerRole();


    }
}
