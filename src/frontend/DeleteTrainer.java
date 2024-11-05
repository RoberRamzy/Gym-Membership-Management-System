package frontend;

import backend.AdminRole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteTrainer extends JFrame{
    private JButton RemoveButton;
    private JTextField TextTrainerId;
    private JLabel TrainerId;
    private JPanel Container10;

    public DeleteTrainer(AdminRole Admin) {
        setTitle("Remove Trainer");
        setVisible(true);
        setSize(new Dimension(500,450));
        setContentPane(Container10);

        RemoveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Key=TextTrainerId.getText();
                boolean flag=false;
                for (int i = 0; i < Admin.getListOfTrainers().size(); i++) {

                    if(Admin.getListOfTrainers().get(i).getSearchKey().equals(Key)){
                        flag=true;
                        Admin.removeTrainer(Key);
                        JOptionPane.showMessageDialog(Container10,"The Trainer with ID = "+Key+" has been deleted","Message",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                if(!flag){
                    JOptionPane.showMessageDialog(Container10,"The Trainer with ID = "+Key+" doesn't exist","Message",JOptionPane.WARNING_MESSAGE);
                }

            }
        });
    }
}
