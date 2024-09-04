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

public class Cancel extends JFrame implements ActionListener {

    JTextField tfpnr;
    JLabel tfname, lblfcode, cancellationno, lbldateoftravel, labelfname, labelfcode, labelfdate;
    JButton flight, fetchButton;
    Choice source, destination;
    JDateChooser dcdate;

    public Cancel() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        Random random = new Random();

//        Heading
        JLabel heading = new JLabel("CNACALLATION");
        heading.setBounds(180, 20, 250, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        add(heading);

//        Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagmentsystem/icons/cancel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lblimage = new JLabel(i3);
        lblimage.setBounds(470, 120, 250, 250);
        add(lblimage);

//        Pnr Number
        JLabel lblaadhar = new JLabel("PNR Number");
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblaadhar.setBounds(60, 80, 150, 25);
        add(lblaadhar);

        tfpnr = new JTextField();
        tfpnr.setBounds(220, 80, 150, 25);
        add(tfpnr);

        fetchButton = new JButton("Show Details");
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

//        Cancellation
        JLabel lblnationlity = new JLabel("Cancellation No");
        lblnationlity.setBounds(60, 180, 150, 25);
        lblnationlity.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationlity);

        cancellationno = new JLabel("" + random.nextInt(1000000));
        cancellationno.setBounds(220, 180, 150, 25);
        add(cancellationno);

//        Flight Code
        JLabel lbladdress = new JLabel("Flight Code");
        lbladdress.setBounds(60, 230, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbladdress);

        lblfcode = new JLabel();
        lblfcode.setBounds(220, 230, 150, 25);
        add(lblfcode);

//        Date Of Travel
        JLabel lblgender = new JLabel("Date");
        lblgender.setBounds(60, 280, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);

        lbldateoftravel = new JLabel("Gender");
        lbldateoftravel.setBounds(220, 280, 150, 25);
        add(lbldateoftravel);

//        Cancel Button
        flight = new JButton("Cnacel");
        flight.setBounds(220, 330, 120, 25);
        flight.setBackground(Color.black);
        flight.setForeground(Color.WHITE);
        flight.addActionListener(this);
        add(flight);

//        Frame Size
        setSize(800, 450);
        setLocation(350, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
//        Fetch Button
        if (ae.getSource() == fetchButton) {

            String pnr = tfpnr.getText();

            try {

                Conn conn = new Conn();

                String query = "select * from reservation where PNR = '" + pnr + "'";

                ResultSet rs = conn.s.executeQuery(query);

                if (rs.next()) {

                    tfname.setText(rs.getString("name"));
                    lblfcode.setText(rs.getString("flightcode"));
                    lbldateoftravel.setText(rs.getString("ddate"));

                } else {

                    JOptionPane.showMessageDialog(null, "Please Enter A Correct Aadhar");

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } //        Flight 
        else if (ae.getSource() == flight) {

            String name = tfname.getText();
            String pnr = tfpnr.getText();
            String cancelno = cancellationno.getText();
            String fcode = lblfcode.getText();
            String date = lbldateoftravel.getText();

            try {

                Conn conn = new Conn();

                String query = "insert into cancel values( '" + pnr + "' , '" + name + "', '" + cancelno + "', '" + fcode + "', '" + date + "')";

                conn.s.executeUpdate(query);
                conn.s.executeUpdate("delete from  reservation where PNR = '" + pnr + "'");

                JOptionPane.showMessageDialog(null, "Ticket Cancelled");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Cancel();
    }

}
