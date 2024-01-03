import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class FrameNoCourse extends JFrame implements ActionListener {

    private String courseSelected;
    private JButton close;
    private JTextField courseName;
    private JTextArea courseDescription;
    private JLabel courseFeedbacksLabel;
    private JLabel courseDescriptionLabel;
    private JTextArea[] courseFeedbacks = new JTextArea[5];
    private JTextField average;

    public FrameNoCourse(String courseSelected) throws SQLException {

        super("Courses");
        this.courseSelected=courseSelected;

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

        int courseID = r.readCourseID(courseSelected);
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

        panel[i] = new JPanel();
        if(r.averageRatingOfCourse(courseID) != -1 )
            average = new JTextField(""+r.averageRatingOfCourse(courseID));
        else
            average = new JTextField("No Ratings");
        average.setEditable(false);
        panel[i].add(average);
        this.add(panel[i]);
        i++;

        close= new JButton("Close");

        panel[i] = new JPanel();
        panel[i].add(close);
        this.add(panel[i]);

        close.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == close){
            dispose();
        }
    }
}

