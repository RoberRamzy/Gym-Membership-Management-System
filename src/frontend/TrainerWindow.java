package frontend;

import backend.AdminRole;
import backend.Trainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrainerWindow extends JFrame {
    private JButton AddButton;
    private JTextField TextId;
    private JLabel Id;
    private JPanel Container4;
    private JLabel Name;
    private JLabel Email;
    private JLabel Speciality;
    private JLabel PhoneNumber;
    private JTextField TextName;
    private JTextField TextEmail;
    private JTextField TextSpeciality;
    private JTextField TextPhoneNumber;

    public TrainerWindow(AdminRole Admin) {
        setTitle("Main Window");
        setVisible(true);
        setSize(new Dimension(500,450));
        setContentPane(Container4);

        AddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String Name=TextName.getText();
                String Email=TextEmail.getText();
                String Speciality=TextSpeciality.getText();
                String PhoneNumber=TextPhoneNumber.getText();
                String ID=TextId.getText();
                boolean flag=false;
                /*if(Name.isEmpty()||Email.isEmpty()||Speciality.isEmpty()||PhoneNumber.isEmpty()||ID.isEmpty()){
                    JOptionPane.showMessageDialog(Container4,"Some fields are empty","Message",JOptionPane.WARNING_MESSAGE);
                }*/
                for (int i = 0; i < Admin.getListOfTrainers().size(); i++) {
                    if(Admin.getListOfTrainers().get(i).getSearchKey().equalsIgnoreCase(ID)){
                        JOptionPane.showMessageDialog(Container4,"The Trainer with ID = "+ID+" already exists!","Message",JOptionPane.WARNING_MESSAGE);
                        flag=true;
                    }
                }
                if(!flag){
                    Admin.addTrainer(ID,Name,Email,Speciality,PhoneNumber);
                    JOptionPane.showMessageDialog(Container4,"The TRainer with ID = "+ID+"has successfully added","Message",JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });
    }
}
