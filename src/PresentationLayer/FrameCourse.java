import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
public class FrameCourse extends JFrame implements ActionListener {

    private int[] coursesForUser;
    private int courseID;
    private int userID;
    private int kushti;
    private String courseSelected;
    private JButton close;
    private JButton register;
    private JButton unregister;
    private JButton leaveFeedback;
    private JTextField courseName;
    private JTextArea courseDescription;
    private JLabel courseFeedbacksLabel;
    private JLabel courseDescriptionLabel;
    private JTextArea[] courseFeedbacks = new JTextArea[5];
    private JLabel registerStatus;
    private JTextField average;


    public FrameCourse(int[] coursesForUser, String courseSelected, int userID) throws SQLException {
        super("Courses");
        this.coursesForUser=coursesForUser;
        this.courseSelected=courseSelected;
        this.userID=userID;

        setLayout(new GridLayout(11, 1));
        JPanel[] panel = new JPanel[11];

        ReaderImpl r = new ReaderImpl();

        courseName = new JTextField(courseSelected);
        courseName.setEditable(false);
        courseDescriptionLabel= new JLabel("Course Description: ");
        courseDescription = new JTextArea(r.readCourseDescription(courseSelected),20,50);
        courseDescription.setLineWrap(true);
        courseDescription.setEditable(false);

        panel[0] = new JPanel();
        panel[0].add(courseName);
        panel[1] = new JPanel();
        panel[1].add(courseDescriptionLabel);
        panel[2] = new JPanel();
        panel[2].add(courseDescription);

        this.add(panel[0]);
        this.add(panel[1]);
        this.add(panel[2]);

        this.courseID = r.readCourseID(courseSelected);
        String[][] feedbacks = r.readFeedbacksForCourse(courseID);

        courseFeedbacksLabel = new JLabel("Feedbacks for "+ courseSelected);
        panel[3] = new JPanel();
        panel[3].add(courseFeedbacksLabel);
        this.add(panel[3]);

        int i;
        for(i=0; i<feedbacks.length; i++){
            if(feedbacks[i][1]!=null)
                courseFeedbacks[i] = new JTextArea(feedbacks[i][0] +"Rating: "+feedbacks[i][1],40,40);
            else
                courseFeedbacks[i] = new JTextArea(40,40);
            courseFeedbacks[i].setEditable(false);
            courseFeedbacks[i].setLineWrap(true);
            panel[i+4] = new JPanel();
            panel[i+4].add(courseFeedbacks[i]);
            this.add(panel[i+4]);
        }

        this.kushti=0;
        for(int j=0; j<coursesForUser.length;j++){
            if(courseID == coursesForUser[j])
                this.kushti=1;
        }

        if(this.kushti==1)
            registerStatus = new JLabel("Registered.");
        else
            registerStatus = new JLabel("Not Registered.");

        if(r.averageRatingOfCourse(courseID) != -1 )
            average = new JTextField(""+r.averageRatingOfCourse(courseID));
        else
            average = new JTextField("No Ratings");
        average.setEditable(false);

        panel[i] = new JPanel();
        panel[i].add(registerStatus);
        panel[i].add(average);
        this.add(panel[i]);
        i++;

        register= new JButton("Register");
        unregister= new JButton("Unregister");
        leaveFeedback = new JButton("Leave Feedback");
        close= new JButton("Close");
        panel[i] = new JPanel();
        panel[i].add(register);
        panel[i].add(unregister);
        panel[i].add(leaveFeedback);
        panel[i].add(close);
        this.add(panel[i]);

        register.addActionListener(this);
        unregister.addActionListener(this);
        leaveFeedback.addActionListener(this);
        close.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == close){
            dispose();
        }
        else if(e.getSource() == register){
            if(kushti==1){

            }
            else{
                Writer w = new Writer();
                try {
                    w.registerInCourse(userID, courseID);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            this.kushti=1;
        }
        else if(e.getSource() == unregister){
            if(kushti==0){

            }
            else{
                Writer w = new Writer();
                try {
                    w.unregisterInCourse(userID, courseID);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            this.kushti=0;
        }
        else if(e.getSource() == leaveFeedback){
            if(kushti==1){
                ReaderImpl r = new ReaderImpl();
                try {
                    if(!r.hasLeftFeedbackForCourse(userID, courseID)) {
                        FrameFeedback f = null;
                        try {
                            f = new FrameFeedback(courseID, userID);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        f.setSize(450, 400);
                        f.setVisible(true);
                    }
                    else{

                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            else{

            }

        }
    }

}
