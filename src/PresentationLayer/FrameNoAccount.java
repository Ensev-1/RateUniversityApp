import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class FrameNoAccount extends JFrame implements ActionListener {

    String[] courseNames;
    private JTextField[] course = new JTextField[11];
    private JButton[] btCourse = new JButton[11];
    private JButton close;

    public FrameNoAccount() throws SQLException {
        super("University Application");

        setLayout(new GridLayout(11, 1));
        JPanel[] panel = new JPanel[12];

        ReaderImpl r = new ReaderImpl();
        this.courseNames = r.readCourseNames();

        int i = 0;
        for (i = 0; i < 10; i++) {
            course[i] = new JTextField(courseNames[i]);
            course[i].setEditable(false);
            btCourse[i] = new JButton("Details");
            panel[i] = new JPanel();
            panel[i].add(course[i]);
            panel[i].add(btCourse[i]);
            this.add(panel[i]);
        }

        close = new JButton("Close");
        panel[i] = new JPanel();
        panel[i].add(close);
        this.add(panel[i]);

        close.addActionListener(this);

        for (i = 0; i < courseNames.length; i++) {
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
