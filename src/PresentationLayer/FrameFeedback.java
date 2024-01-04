import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

import static java.lang.Integer.parseInt;

public class FrameFeedback extends JFrame implements ActionListener {
    private int courseID;
    private int userID;
    private JLabel feedbackLabel;
    private JTextArea feedback;
    private JLabel ratingLabel;
    private JTextField rating;
    private JButton send;
    private JButton close;

    public FrameFeedback(int courseID,int userID) throws SQLException {
        super("Feedback");
        this.courseID=courseID;
        this.userID=userID;

        setLayout(new GridLayout(4, 1));
        feedbackLabel = new JLabel("Leave your feedback: ");
        feedback= new JTextArea(40,40);
        feedback.setLineWrap(true);
        ratingLabel = new JLabel("Rating: (1-5)");
        rating = new JTextField(5);
        rating.setEditable(true);
        send= new JButton("Send Feedback");
        close= new JButton("Close");

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        panel1.add(feedbackLabel);
        panel2.add(feedback);
        panel3.add(ratingLabel);
        panel3.add(rating);
        panel4.add(send);
        panel4.add(close);

        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.add(panel4);

        send.addActionListener(this);
        close.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == close){
            dispose();
        }
        else{
            Writer w = new Writer();
            try {
                int tmp = parseInt(rating.getText());
                if(tmp <=5 && tmp>0){
                    w.leaveFeedback(feedback.getText(),tmp,courseID,userID);
                    dispose();
                }
                else {
                    rating.setText("");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

    }

}