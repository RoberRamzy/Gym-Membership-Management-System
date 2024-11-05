package frontend;

import backend.TrainerRole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddClass extends JFrame {
    private JButton AddButton;
    private JTextField TextClassId;
    private JLabel ClassId;
    private JTextField TextClassName;
    private JTextField TextTrainerId;
    private JLabel ClassName;
    private JLabel TrainerId;
    private JLabel Duration;
    private JLabel PhoneNumber;
    private JTextField TextDuration;
    private JLabel MaxParticipants;
    private JTextField TextMaxParticipants;
    private JPanel Container6;

    public AddClass (TrainerRole trainer) {
        setTitle("Add Class");
        setVisible(true);
        setSize(new Dimension(500,450));
        setContentPane(Container6);
        AddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = TextClassId.getText();
                String ClassName = TextClassName.getText();
                String TrainerID = TextTrainerId.getText();
                String Duration = TextDuration.getText();
                String maxPart = TextMaxParticipants.getText();
                boolean flag = false;
                if (ID.isEmpty() || ClassName.isEmpty() || TrainerID.isEmpty() || Duration.isEmpty() || maxPart.isEmpty()) {
                    JOptionPane.showMessageDialog(Container6, "Some fields are empty", "Message", JOptionPane.WARNING_MESSAGE);
                    flag=true;
                } else {
                    for (int i = 0; i < trainer.getListOfClasses().size(); i++) {
                        if (trainer.getListOfClasses().get(i).getSearchKey().equalsIgnoreCase(ID)) {
                            JOptionPane.showMessageDialog(Container6, "The Class with ID = " + ID + " already exists!", "Message", JOptionPane.WARNING_MESSAGE);
                            flag = true;
                        }
                    }
                }
                if(!flag){
                    trainer.addClass(ID,ClassName,TrainerID,Integer.parseInt(Duration),Integer.parseInt(maxPart));
                    JOptionPane.showMessageDialog(Container6, "The Class with ID = " + ID + " added", "Message", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }
            }

        });
    }
}
