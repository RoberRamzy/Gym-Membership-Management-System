package frontend;

import backend.TrainerRole;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class RegisterMember extends JFrame{
    private JButton RegisterButton;
    private JTextField TextMemberId;
    private JLabel MemberId;
    private JPanel Container9;
    private JLabel ClassId;
    private JTextField TextClassId;
    private JLabel RegistrationDate;
    private JDateChooser RegistrationDateChooser;

    private void createUIComponents() {
        RegistrationDateChooser = new JDateChooser();
    }
    public RegisterMember(TrainerRole trainer) {
        setTitle("Trainer widow");
        setVisible(true);
        setSize(new Dimension(500,450));
        setContentPane(Container9);
        RegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String memID= TextMemberId.getText();
                String classID=TextClassId.getText();
                Date Date=RegistrationDateChooser.getDate();
                LocalDate localDate = Date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                if(memID.isEmpty()||classID.isEmpty()||Date==null){
                    JOptionPane.showMessageDialog(Container9,"Some fields are missing","Message",JOptionPane.WARNING_MESSAGE);
                }else if(trainer.registerMemberForClass(memID,classID, localDate)) {
                    JOptionPane.showMessageDialog(Container9,"Class registered successfully","Message",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(Container9,"Register failed","Message",JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
}
