package airlinemanagmentsystem;

/**
 *
 * @author Adnan
 */

//Username : - admin
//password : - admin
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JTextField tfusername;
    JPasswordField tfpassword;
    JButton submit, reset, close;

    public Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

//        Username
        JLabel lblusername = new JLabel("UserName");
        lblusername.setBounds(20, 20, 100, 20);
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(130, 20, 200, 20);
        add(tfusername);

//        Password
        JLabel lblpassword = new JLabel("Passwoed");
        lblpassword.setBounds(20, 60, 100, 20);
        add(lblpassword);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(130, 60, 200, 20);
        add(tfpassword);

//      Reset
        reset = new JButton("Reset");
        reset.setBounds(40, 120, 120, 20);
        reset.addActionListener(this);
        add(reset);
        
//        Submit
        submit = new JButton("submit");
        submit.setBounds(190, 120, 120, 20);
        submit.addActionListener(this);
        add(submit);
        
//        Close
        close = new JButton("Close");
        close.setBounds(120, 160, 120, 20);
        close.addActionListener(this);
        add(close);

//        Frame Size
        setSize(400, 250);
        setLocation(600, 250);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == submit) {
            String username = tfusername.getText();
            String password = tfpassword.getText();

        try {
                Conn c = new Conn();

                String query = "select * from login where username = '" + username + "' AND password = '" + password + "' ";
                
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    
                    new Home();
                    setVisible(false);

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username And Password");
                        setVisible(false);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == close) {
            setVisible(false);
        } else if (ae.getSource() == reset) {
            tfusername.setText("");
            tfpassword.setText("");
        }

    }

    public static void main(String[] args) {
        new Login();
    }
}


