import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
public class FrameSignUp extends JFrame implements ActionListener {
    private JTextField firstName;
    private JTextField lastName;
    private JTextField password;
    private JTextField email;
    private JTextField lb1, lb2, lb3, lb4;
    private JButton bt;
    private JButton close;

    public FrameSignUp() {
        super("Sign Up");
        // Layout i frame eshte GridLayout me 5 rreshta
        setLayout(new GridLayout(5, 1));
        firstName = new JTextField(30);
        lastName = new JTextField(30);
        email = new JTextField(30);
        password = new JTextField(30);
        bt = new JButton("Sign Up");
        close = new JButton("Close");

        lb1 = new JTextField("First Name: ");
        lb1.setEditable(false);
        lb2 = new JTextField("Last Name: ");
        lb2.setEditable(false);
        lb3 = new JTextField("Email: ");
        lb3.setEditable(false);
        lb4 = new JTextField("Password: ");
        lb4.setEditable(false);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();

        panel1.add(lb1);
        panel1.add(firstName);
        panel2.add(lb2);
        panel2.add(lastName);
        panel3.add(lb3);
        panel3.add(email);
        panel4.add(lb4);
        panel4.add(password);
        panel5.add(bt);
        panel5.add(close);

        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
        add(panel5);

        bt.addActionListener(this);
        close.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt){
            String inputFirstName = firstName.getText();
            String inputLastName = lastName.getText();
            String inputEmail = email.getText();
            String inputPassword = password.getText();

            Account a = new Account();
            int id;
            try {
                if(!a.signUp(inputFirstName, inputLastName, inputEmail, inputPassword)){
                    firstName.setText("");
                    lastName.setText("");
                    email.setText("");
                    password.setText("");
                }
                else{
                    FrameApplication f = new FrameApplication();
                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    f.setSize(500, 400);
                    f.setVisible(true);
                    dispose();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        else {
            FrameApplication f = new FrameApplication();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setSize(500, 400);
            f.setVisible(true);
            dispose();
        }

    }
}
