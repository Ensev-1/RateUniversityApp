import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
public class FrameApplication extends JFrame implements ActionListener {
    private JTextField name;
    private JTextField password;
    private JTextField lb1, lb2;
    private ButtonGroup bg;
    private JRadioButton rbLogIn;
    private JRadioButton rbSignUp;
    private JRadioButton rbCourses;
    private JRadioButton rbMostRated;
    private JButton bt;
    private JButton close;

    public FrameApplication() {
        super("University Application");
        setLayout(new GridLayout(4, 1));

        name = new JTextField(20);
        password = new JTextField(20);
        rbLogIn = new JRadioButton("Log In", false);
        rbSignUp = new JRadioButton("Sign Up", false);
        rbCourses = new JRadioButton("Courses", false);
        rbMostRated = new JRadioButton("Most Rated", false);

        bt = new JButton("OK");
        bg = new ButtonGroup();
        bg.add(rbLogIn);
        bg.add(rbSignUp);
        bg.add(rbCourses);
        bg.add(rbMostRated);
        close = new JButton("Quit");

        lb1= new JTextField("Name: ");
        lb1.setEditable(false);
        lb2= new JTextField("Password: ");
        lb2.setEditable(false);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        panel1.add(lb1);
        panel1.add(name);
        panel2.add(lb2);
        panel2.add(password);
        panel3.add(rbLogIn);
        panel3.add(rbSignUp);
        panel3.add(rbCourses);
        panel3.add(rbMostRated);
        panel4.add(bt);
        panel4.add(close);
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);

        bt.addActionListener(this);
        close.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == bt) {
            if (!rbLogIn.isSelected() && !rbSignUp.isSelected() && !rbCourses.isSelected() && !rbMostRated.isSelected())
                JOptionPane.showMessageDialog(null, "Zgjidh nje veprim", "KUJDES", JOptionPane.ERROR_MESSAGE);
            else if ((name.getText().equals("") || password.getText().equals("")) && (rbLogIn.isSelected())) {
                JOptionPane.showMessageDialog(null, "Te dhenat nuk jane futur sakte", "KUJDES", JOptionPane.ERROR_MESSAGE);
            } else {
                String inputName = name.getText();
                String inputPassword = password.getText();

                if(rbCourses.isSelected()){
                    FrameNoAccount fr = null;
                    try {
                        fr = new FrameNoAccount();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    fr.setSize(500, 400);
                    fr.setVisible(true);
                    dispose();
                }
                else if(rbMostRated.isSelected()){
                    FrameMostRated fr = null;
                    try {
                        fr = new FrameMostRated();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    fr.setSize(500, 400);
                    fr.setVisible(true);
                    dispose();
                }
                else if (rbLogIn.isSelected()) {
                    Account a = new Account();
                    int id = a.loginInfoIsCorrect(inputName, inputPassword);
                    if (id != -1){

                        FrameAccount fr = null;

                        try {
                            fr = new FrameAccount(id);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        fr.setSize(500, 400);
                        fr.setVisible(true);
                        dispose();
                    }
                    else{
                        name.setText("");
                        password.setText("");
                    }
                }
                if (rbSignUp.isSelected()) {
                    FrameSignUp frame = new FrameSignUp();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(500, 400);
                    frame.setVisible(true);
                    dispose();
                }
            }
        } else {
            dispose();
                            }
            }
}