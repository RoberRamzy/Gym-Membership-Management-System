package frontend;

import backend.TrainerRole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMember extends JFrame{
    private JButton AddButton;
    private JTextField TextId;
    private JLabel Id;
    private JTextField TextName;
    private JTextField TextEmail;
    private JTextField TextPhoneNumber;
    private JLabel Name;
    private JLabel Email;
    private JLabel Speciality;
    private JLabel PhoneNumber;
    private JTextField TextMembershipType;
    private JPanel container5;
    private JLabel Status;
    private JTextField TextStatus;

    public AddMember (TrainerRole trainer) {
        setTitle("Add Member");
        setVisible(true);
        setSize(new Dimension(500,550));
        setContentPane(container5);
        AddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID= TextId.getText();
                String Name= TextName.getText();
                String Email=TextEmail.getText();
                String phone=TextPhoneNumber.getText();
                String membership=TextMembershipType.getText();
                String status=TextStatus.getText();
                boolean flag=false;
                if(Name.isEmpty()||Email.isEmpty()||membership.isEmpty()||phone.isEmpty()||ID.isEmpty()||status.isEmpty()){
                    JOptionPane.showMessageDialog(container5,"Some fields are empty","Message",JOptionPane.WARNING_MESSAGE);
                    flag=true;
                }else {
                    for (int i = 0; i < trainer.getListOfMembers().size(); i++) {
                        if (trainer.getListOfMembers().get(i).getSearchKey().equalsIgnoreCase(ID)) {
                            JOptionPane.showMessageDialog(container5, "The Member with ID = " + ID + " already exists!", "Message", JOptionPane.WARNING_MESSAGE);
                            flag = true;
                        }
                    }
                }
                if(!flag) {
                    trainer.addMember(ID, Name, membership, Email, phone, status);
                    JOptionPane.showMessageDialog(container5, "The Member with ID = " + ID + "has successfully added", "Message", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }
                }
        });
    }
}
