package frontend;

import backend.TrainerRole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


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

        setTitle("Trainer window");
        setVisible(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
                CancelRegistration cancelRegistration=new CancelRegistration(trainer);
            }
        });
        Logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trainer.logout();
                JOptionPane.showMessageDialog(Container12,"Logout successfully","Success",JOptionPane.INFORMATION_MESSAGE);
                dispose();
                MainWindow MainWindow=new MainWindow();

            }
        });
        ViewMembers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewMembers viewMembers=new ViewMembers(trainer);
            }
        });
        ViewClasses.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewClasses viewClasses=new ViewClasses(trainer);
            }
        });
        ViewRegistration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewRegistrations viewRegistration=new ViewRegistrations(trainer);
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                trainer.logout();
                MainWindow mainWindow = new MainWindow();
            }
        });
    }



}
