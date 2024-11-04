package frontend;

import backend.AdminRole ;
import backend.Trainer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ViewTrainers extends JFrame{
    private JPanel Container11;
    private JTable table1;
    private JScrollPane scrollpanel;

    public ViewTrainers() {
            setTitle("Data Table Example");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(600, 400);

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Id");
            model.addColumn("Name");
            model.addColumn("Email");
            model.addColumn("Speciality");
            model.addColumn("Phone Number");

            table1 = new JTable(model);
            scrollpanel = new JScrollPane(table1);
            add(scrollpanel);

            AdminRole adminRole = new AdminRole();
            ArrayList<Trainer> trainers = adminRole.getListOfTrainers();
            for (Trainer trainer : trainers){
                String [] args = trainer.lineRepresentation().split(",");
                model.addRow(new Object[] {args[0],args[1],args[2],args[3],args[4]} );
            }
            setVisible(true);
        }


}
