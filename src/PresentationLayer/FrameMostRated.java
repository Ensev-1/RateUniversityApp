import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class FrameMostRated extends JFrame implements ActionListener {
    String[] courseNames;
    private JTextField[] course = new JTextField[11];
    private JButton[] btCourse = new JButton[11];
    private JButton close;

    public FrameMostRated() throws SQLException {
        super("University Application");

        setLayout(new GridLayout(11, 1));
        JPanel[] panel = new JPanel[12];

        ReaderImpl r = new ReaderImpl();
        this.courseNames = r.readCourseNames();

        int[][] courseIDAndAverage = new int[courseNames.length][2];
        for(int j=0; j< courseNames.length; j++){
            courseIDAndAverage[j][0] = r.readCourseID(courseNames[j]);
            courseIDAndAverage[j][1] = r.averageRatingOfCourse(courseIDAndAverage[j][0]);
        }

        //insertion sort
        int[] key = new int[2];
        for (int j = 1; j < courseIDAndAverage.length; ++j) {
            key[0] = courseIDAndAverage[j][1];
            key[1] = courseIDAndAverage[j][0];
            int k = j-1;

            while (k >= 0 && courseIDAndAverage[k][1] < key[1]) {
                courseIDAndAverage[k + 1][1] = courseIDAndAverage[k][1];
                courseIDAndAverage[k + 1][0] = courseIDAndAverage[k][0];
                k = k - 1;
            }
            courseIDAndAverage[k + 1][1] = key[1];
            courseIDAndAverage[k + 1][0] = key[0];
        }

        int i=0;
        for(i=0; i< 8; i++){
            course[i] = new JTextField(""+r.courseNameById(courseIDAndAverage[i][0]));
            course[i].setEditable(false);
            btCourse[i] = new JButton("Details");
            panel[i]=new JPanel();
            panel[i].add(course[i]);
            panel[i].add(btCourse[i]);
            this.add(panel[i]);
        }

        close= new JButton("Close");
        panel[i]=new JPanel();
        panel[i].add(close);
        this.add(panel[i]);

        close.addActionListener(this);

        for(i=0; i<8; i++) {
            btCourse[i].addActionListener(this);
        }

    }


    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == close)
            dispose();
        else{
            for(int j=0; j<10; j++) {
                if (e.getSource() == btCourse[j]) {
                    FrameNoCourse frameCourse;
                    try {
                        frameCourse = new FrameNoCourse(courseNames[j]);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    frameCourse.setSize(600, 600);
                    frameCourse.setVisible(true);
                }
            }
        }
    }

}