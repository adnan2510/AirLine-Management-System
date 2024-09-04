package airlinemanagmentsystem;

/**
 *
 * @author Adnan
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class BookFlight extends JFrame implements ActionListener {

    JTextField tfaadhar;
    JLabel tfname, tfaddress, tfnationlity, lalelgender, labelfname, labelfcode, labelfdate;
    JButton flight, fetchButton, bookflight;
    Choice source, destination;
    JDateChooser dcdate;

    public BookFlight() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

//        Heading
        JLabel heading = new JLabel("Book Flight");
        heading.setBounds(420, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);

//        Aadhar
        JLabel lblaadhar = new JLabel("Aadhar");
        lblaadhar.setBounds(60, 80, 150, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(220, 80, 150, 25);
        add(tfaadhar);

        fetchButton = new JButton("Fetch User");
        fetchButton.setBackground(Color.black);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 80, 120, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);

//        Name
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 130, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);

        tfname = new JLabel();
        tfname.setBounds(220, 130, 150, 25);
        add(tfname);

//        Nationlity
        JLabel lblnationlity = new JLabel("Nationlity");
        lblnationlity.setBounds(60, 180, 150, 25);
        lblnationlity.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationlity);

        tfnationlity = new JLabel();
        tfnationlity.setBounds(220, 180, 150, 25);
        add(tfnationlity);

//        Address
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60, 230, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbladdress);

        tfaddress = new JLabel();
        tfaddress.setBounds(220, 230, 150, 25);
        add(tfaddress);

//        Button
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 280, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);

        lalelgender = new JLabel("Gender");
        lalelgender.setBounds(220, 280, 150, 25);
        add(lalelgender);

//        Source
        JLabel lblsource = new JLabel("Source");
        lblsource.setBounds(60, 330, 150, 25);
        lblsource.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblsource);

        source = new Choice();
        source.setBounds(220, 330, 150, 25);
        add(source);

//        Destination
        JLabel lbldest = new JLabel("Destination");
        lbldest.setBounds(60, 380, 150, 25);
        lbldest.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldest);

        destination = new Choice();
        destination.setBounds(220, 380, 150, 25);
        add(destination);

        try {

            Conn c = new Conn();

            String query = "select * from flight";

            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()) {
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

//        Fetch Flight Button
        flight = new JButton("Fetch Flight");
        flight.setBounds(380, 380, 120, 23);
        flight.setBackground(Color.black);
        flight.setForeground(Color.WHITE);
        flight.addActionListener(this);
        add(flight);

//        Flight Name
        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60, 430, 150, 25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfname);

        labelfname = new JLabel();
        labelfname.setBounds(220, 430, 150, 25);
        add(labelfname);

//        Flight Code
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(60, 480, 150, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfcode);

        labelfcode = new JLabel();
        labelfcode.setBounds(220, 480, 150, 25);
        add(labelfcode);

//       Date of Travrl 
        JLabel lbldate = new JLabel("Date of Travel");
        lbldate.setBounds(60, 530, 150, 25);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldate);

        dcdate = new JDateChooser();
        dcdate.setBounds(220, 530, 150, 25);
        add(dcdate);

//        Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagmentsystem/icons/details.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(550, 80, 500, 410);
        add(lblimage);

//        Book Flight Button
        bookflight = new JButton("Book Flight");
        bookflight.setBounds(220, 580, 150, 25);
        bookflight.setBackground(Color.black);
        bookflight.setForeground(Color.WHITE);
        bookflight.addActionListener(this);
        add(bookflight);

//        Frame Size
        setSize(1100, 700);
        setLocation(200, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
//        Fetch Button
        if (ae.getSource() == fetchButton) {

            String aadhar = tfaadhar.getText();

            try {

                Conn conn = new Conn();

                String query = "select * from passenger where aadhar = '" + aadhar + "'";

                ResultSet rs = conn.s.executeQuery(query);

                if (rs.next()) {

                    tfname.setText(rs.getString("name"));
                    tfaddress.setText(rs.getString("address"));
                    tfnationlity.setText(rs.getString("nationality"));
                    lalelgender.setText(rs.getString("gender"));

                } else {

                    JOptionPane.showMessageDialog(null, "Please Enter A Correct Aadhar");

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } //        Flight 
        else if (ae.getSource() == flight) {

            String scr = source.getSelectedItem();
            String dest = destination.getSelectedItem();

            try {

                Conn conn = new Conn();

                String query = "select * from flight where source = '" + scr + "' and destination = '" + dest + "'";

                ResultSet rs = conn.s.executeQuery(query);

                if (rs.next()) {

                    labelfname.setText(rs.getString("f_name"));
                    labelfcode.setText(rs.getString("f_code"));
                } else {

                    JOptionPane.showMessageDialog(null, "No Flight Found");

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {

            Random random = new Random();
            String aadhar = tfaadhar.getText();
            String name = tfname.getText();
            String nationlity = tfnationlity.getText();
            String flightname = labelfname.getText();
            String flightcode = labelfcode.getText();
            String scr = source.getSelectedItem();
            String dest = destination.getSelectedItem();
            String ddate = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();

            try {

                Conn conn = new Conn();

                String query = "insert into reservation values('PNR" + random.nextInt(1000000) + "' , 'TIC" + random.nextInt(10000) + "','" + aadhar + "','" + name + "','" + nationlity + "','" + flightname + "','" + flightcode + "', '" + scr + "','" + dest + "','" + ddate + "')";

                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Ticket Booked Successfully");

                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new BookFlight();
    }

}
