package frontend;

import backend.TrainerRole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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

    private TrainerRole trainer;

    public TrainerRoleWindow (){

        setTitle("Trainer widow");
        setVisible(true);
        setSize(new Dimension(500,450));
        setContentPane(Container12);
        trainer=new TrainerRole();
        AddMember.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                AddMember addMember= new AddMember(trainer);
            }
        });
        AddClass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddClass addClass=new AddClass(trainer);
            }
        });
        RegisterMemberForClass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterMember registerMember=new RegisterMember(trainer);
            }
        });
        CancelRegistration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*delete registeration is messing*/
            }
        });
        Logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trainer.logout();
            }
        });
    }
}
