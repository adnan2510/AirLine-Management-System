package airlinemanagmentsystem;

/**
 *
 * @author Adnan
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener {

    JTextField tfname, tfnationlity, tfaadhar, tfaddress, tfphone;
    JRadioButton rbmale, rbfemale;
    JButton save;

    public AddCustomer() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

//        Heading
        JLabel heading = new JLabel("Add Customer Details");
        heading.setBounds(220, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);

//        Name
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 80, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(220, 80, 150, 25);
        add(tfname);

//        Nationlity
        JLabel lblnationlity = new JLabel("Nationlity");
        lblnationlity.setBounds(60, 130, 150, 25);
        lblnationlity.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationlity);

        tfnationlity = new JTextField();
        tfnationlity.setBounds(220, 130, 150, 25);
        add(tfnationlity);

//        Aadhar
        JLabel lblaadhar = new JLabel("Aadhar");
        lblaadhar.setBounds(60, 180, 150, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(220, 180, 150, 25);
        add(tfaadhar);

//        Address
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60, 230, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(220, 230, 150, 25);
        add(tfaddress);

//        Button
        ButtonGroup gendergroup = new ButtonGroup();

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 280, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);

        rbmale = new JRadioButton("Male");
        rbmale.setBounds(220, 280, 70, 25);
        rbmale.setBackground(Color.WHITE);
        add(rbmale);

        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(300, 280, 70, 25);
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);

        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);

//        Phone
        JLabel lblphone = new JLabel("Mobile Number");
        lblphone.setBounds(60, 330, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(220, 330, 150, 25);
        add(tfphone);

//        Save Button
        save = new JButton("Save");
        save.setBounds(220, 380, 150, 30);
        save.setBackground(Color.black);
        save.setForeground(Color.WHITE);
        save.addActionListener(this);
        add(save);

//        Image
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airlinemanagmentsystem/icons/emp.png"));
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(450, 80, 280, 400);
        add(lblimage);

//        Frame Size
        setSize(900, 600);
        setLocation(300, 150);
        setVisible(true);
    } 

    public void actionPerformed(ActionEvent ae) {

        String name = tfname.getText();
        String nationality = tfnationlity.getText();
        String phone = tfphone.getText();
        String address = tfaddress.getText();
        String aadhar = tfaadhar.getText();
        String gender = null;
        if (rbmale.isSelected()) {
            gender = "Male";
        } else {
            gender = "Female";
        }
        try {

            Conn conn = new Conn();
            
            String query = "insert into passenger values('" + name + "','" + nationality + "','" + phone + "','" + address + "','" + aadhar + "','" + gender + "' )";
            
            conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
            setVisible(false);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new AddCustomer();
    }

}
