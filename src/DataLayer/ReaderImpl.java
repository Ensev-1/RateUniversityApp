import java.sql.*;

public class ReaderImpl implements Reader {
    private Connection conn = null;

    public String[][] readUsers(){
        String[][] users =new String[100][5];
        int i=0;
        try{
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/UniversityApplication", "root", "");
            Statement stmt = conn.createStatement();

            String query="SELECT * FROM users";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                users[i][0] = rs.getString("PersonID");
                users[i][1] = rs.getString("FirstName");
                users[i][2] = rs.getString("LastName");
                users[i][3] = rs.getString("Email");
                users[i][4] = rs.getString("Password");
                i++;
            }
            conn.close();
        }
        catch(Exception e) {
            System.out.println(e.toString());
        }
        return users;
    }

    public String[][] readCourses(){
        String[][] courses =new String[11][3];

        int i=0;
        try{
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/UniversityApplication", "root", "");
            Statement stmt = conn.createStatement();

            String query="SELECT * FROM courses";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                courses[i][0] = rs.getString("CourseID");
                courses[i][1] = rs.getString("CourseName");
                courses[i][2] = rs.getString("CourseDescription");
                i++;
            }
            conn.close();
        }
        catch(Exception e) {
            System.out.println(e.toString());
        }
        return courses;
    }

    public String[][] readFeedbacks(){
        String[][] feedbacks =new String[100][3];
        int i=0;
        try{
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/UniversityApplication", "root", "");
            Statement stmt = conn.createStatement();

            String query="SELECT * FROM feedbacks";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                feedbacks[i][0] = rs.getString("FeedbackID");
                feedbacks[i][1] = rs.getString("FeedbackDescription");
                feedbacks[i][2] = rs.getString("CourseID");
                i++;
            }
            conn.close();
        }
        catch(Exception e) {
            System.out.println(e.toString());
        }
        return feedbacks;
    }


}