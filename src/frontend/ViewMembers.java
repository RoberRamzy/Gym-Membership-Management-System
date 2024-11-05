package frontend;

import backend.Member;
import backend.TrainerRole;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ViewMembers extends JFrame{
    private JTable table1;
    private JScrollPane scrollpanel;

    public ViewMembers(TrainerRole trainer) {
        setTitle("View Trainers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Name");
        model.addColumn("Email");
        model.addColumn("Membership type");
        model.addColumn("Phone Number");
        model.addColumn("Status");

        table1 = new JTable(model);
        scrollpanel = new JScrollPane(table1);
        add(scrollpanel);
        ArrayList<Member> members = trainer.getListOfMembers();
        for (Member member : members){
            String [] args = member.lineRepresentation().split(",");
            model.addRow(new Object[] {args[0],args[1],args[2],args[3],args[4],args[5]} );
        }
        setVisible(true);
    }


}
