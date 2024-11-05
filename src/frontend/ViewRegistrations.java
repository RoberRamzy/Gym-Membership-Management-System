package frontend;

import backend.MemberClassRegistration;
import backend.TrainerRole;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ViewRegistrations extends JFrame{
    private JTable table1;
    private JScrollPane scrollpanel;
    private JPanel Container15;

    public ViewRegistrations(TrainerRole trainer) {
        setTitle("View Trainers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Member Id");
        model.addColumn("Class Id");
        model.addColumn("Registration Date");

        table1 = new JTable(model);
        scrollpanel = new JScrollPane(table1);
        add(scrollpanel);

        ArrayList<MemberClassRegistration> registrations = trainer.getListOfRegistrations();
        for (MemberClassRegistration register : registrations){
            String [] args = register.lineRepresentation().split(",");
            model.addRow(new Object[] {args[0],args[1],args[2]} );
        }
        setVisible(true);
    }

}
