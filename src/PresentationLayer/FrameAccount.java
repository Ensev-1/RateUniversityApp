import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class FrameAccount extends JFrame implements ActionListener {

    int id;
    String[] courseNames;
    private JTextField[] course = new JTextField[11];
    private JButton[] btCourse = new JButton[11];

    private JButton btLogOut;
    private JButton close;

    public FrameAccount(int id) throws SQLException {
        super("University Application");
        this.id=id;
        setLayout(new GridLayout(11, 1));
        JPanel[] panel = new JPanel[12];

        ReaderImpl r = new ReaderImpl();
        this.courseNames = r.readCourseNames();

        int i=0;
        for(i=0; i< 10; i++){
            course[i] = new JTextField(courseNames[i]);
            course[i].setEditable(false);
            btCourse[i] = new JButton("Details");
            panel[i]=new JPanel();
            panel[i].add(course[i]);
            panel[i].add(btCourse[i]);
            this.add(panel[i]);
        }

        btLogOut= new JButton("Log Out");
        close= new JButton("Close");
        panel[i]=new JPanel();
        panel[i].add(btLogOut);
        panel[i].add(close);
        this.add(panel[i]);

        btLogOut.addActionListener(this);
        close.addActionListener(this);

        for(i=0; i<courseNames.length; i++) {
            btCourse[i].addActionListener(this);
        }

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btLogOut){
            FrameApplication f = new FrameApplication();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setSize(450, 400);
            f.setVisible(true);
            dispose();
        }
        else if (e.getSource() == close){
            dispose();
        }
        else {
            for(int j=0; j<10; j++){
                if(e.getSource() == btCourse[j]){
                    ReaderImpl r = new ReaderImpl();
                    int[] coursesID = new int[0];
                    try {
                        coursesID = r.readCourseIDS(id);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    FrameCourse frameCourse = null;
                    try {
                        frameCourse = new FrameCourse(coursesID, courseNames[j], id);
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

