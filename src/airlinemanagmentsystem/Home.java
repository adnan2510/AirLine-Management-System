package airlinemanagmentsystem;

/**
 *
 * @author Adnan
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Home extends JFrame implements ActionListener {

    public Home() {
        setLayout(null);

        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("airlinemanagmentsystem/icons/front.jpg"));
        JLabel image = new JLabel(il);
        image.setBounds(0, 0, 1550, 800);
        add(image);

//        Heading
        JLabel heading = new JLabel("Air India Welcomes You");
        heading.setBounds(500, 40, 1000, 40);
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 36));
        image.add(heading);

//       Menu bar 
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);

//        Details menu
        JMenu details = new JMenu("Details");
        menubar.add(details);

        JMenuItem flightDetails = new JMenuItem("Flight Details");
        flightDetails.addActionListener(this);
        details.add(flightDetails);

        JMenuItem customerDetails = new JMenuItem("Add Customer Details");
        customerDetails.addActionListener(this);
        details.add(customerDetails);

        JMenuItem bookFlight = new JMenuItem("Book Flight Details");
        bookFlight.addActionListener(this);
        details.add(bookFlight);

        JMenuItem journeyDetails = new JMenuItem("Journey Details");
        journeyDetails.addActionListener(this);
        details.add(journeyDetails);

        JMenuItem ticketCancellation = new JMenuItem("Cancel Ticket");
        ticketCancellation.addActionListener(this);
        details.add(ticketCancellation);

//        Tickets menu
        JMenu ticket = new JMenu("Ticket");
        menubar.add(ticket);

        JMenuItem boardingPass = new JMenuItem("Boarding Pass");
        ticket.add(boardingPass);

//        Frame Size
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocation(600, 250);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        String text = ae.getActionCommand();

        if (text.equals("Add Customer Details")) {
            new AddCustomer();
        } else if (text.equals("Flight Details")) {
            new FlightInfo();
        } else if (text.equals("Book Flight Details")) {
            new BookFlight();
        } else if (text.equals("Book Flight Details")) {
            new JourneyDetails();
        } else if (text.equals("Cancel Ticket")) {
            new Cancel();
        }  else if (text.equals("Boarding Pass")) {
            new BoardingPass();
        } 

    }

    public static void main(String[] args) {
        new Home();
    }
}
