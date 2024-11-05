package frontend;

import backend.Class;
import backend.Member;
import backend.TrainerRole;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ViewClasses extends JFrame{
    private JTable table1;
    private JScrollPane scrollpanel;
    private JPanel Container14;

    public ViewClasses() {
        setTitle("View Trainers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Class Id");
        model.addColumn("Class Name");
        model.addColumn("Trainer Id");
        model.addColumn("Duration");
        model.addColumn("Max Participants");

        table1 = new JTable(model);
        scrollpanel = new JScrollPane(table1);
        add(scrollpanel);

        TrainerRole trainerRole = new TrainerRole();
        ArrayList<Class> classes = trainerRole.getListOfClasses();
        for (Class class_ : classes){
            String [] args = class_.lineRepresentation().split(",");
            model.addRow(new Object[] {args[0],args[1],args[2],args[3],args[4]} );
        }
        setVisible(true);
    }


}
