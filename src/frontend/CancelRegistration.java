package frontend;

import backend.TrainerRole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelRegistration extends JFrame {
    private JLabel MemberId;
    private JTextField TextMemberId;
    private JButton CancelButton;
    private JPanel Container10;
    private JLabel ClassId;
    private JTextField TextClassId;

    public CancelRegistration(TrainerRole trainer) {
        setTitle("Delete registration");
        setVisible(true);
        setSize(new Dimension(500,450));
        setContentPane(Container10);
        CancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String MemberID= TextMemberId.getText();
                String ClassID=TextClassId.getText();
                if(MemberID.isEmpty()||ClassID.isEmpty()){
                    JOptionPane.showMessageDialog(Container10,"Some fields are missing","Message",JOptionPane.WARNING_MESSAGE);
                } else if (trainer.cancelRegistration(MemberID,ClassID)) {
                    JOptionPane.showMessageDialog(Container10,"Registration cancelled","Message",JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(Container10,"Failed to cancel","Message",JOptionPane.WARNING_MESSAGE);
                }

            }
        });
    }
}
