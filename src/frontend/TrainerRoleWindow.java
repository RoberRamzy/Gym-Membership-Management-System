package frontend;

import backend.TrainerRole;

import javax.swing.*;
import java.awt.*;


public class TrainerRoleWindow extends JFrame{
    private JPanel Container12;
    private JButton AddMember;
    private JButton ViewMembers;
    private JButton AddClass;
    private JButton Logout;
    private JButton ViewClasses;
    private JButton RegisterMemberForClass;
    private JButton CancelRegistration;
    private JButton ViewRegistration;
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
