package frontend;

import backend.TrainerRole ;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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




            setVisible(true);
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(ViewTrainers::new);
        }


}
