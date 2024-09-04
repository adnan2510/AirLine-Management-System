package airlinemanagmentsystem;

/**
 *
 * @author Adnan
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class JourneyDetails extends JFrame implements ActionListener {

    JTable table;
    JTextField pnr;
    JButton show;

    public JourneyDetails() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

//        Flight Name
        JLabel lblpnr = new JLabel("PNR Details");
        lblpnr.setBounds(50, 50, 100, 25);
        lblpnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpnr);

        pnr = new JTextField();
        pnr.setBounds(160, 50, 120, 25);
        add(pnr);

        show = new JButton("Show");
        show.setForeground(Color.WHITE);
        show.setBackground(Color.BLACK);
        show.setBounds(290, 50, 120, 25);
        show.addActionListener(this);
        add(show);

        table = new JTable();

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 800, 500);
        jsp.setBackground(Color.WHITE);
        add(jsp);

//        Frame Size
        setSize(800, 600);
        setLocation(400, 150);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        try {
            Conn conn = new Conn();

            ResultSet rs = conn.s.executeQuery("select * from reservation where PNR= '" + pnr.getText() + "'");

            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "No Information Found");

            }

            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new JourneyDetails();
    }

}
