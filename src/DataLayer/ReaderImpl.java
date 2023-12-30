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


    public String[] readCourseNames() throws SQLException {

        String[] courseNames= new String[10];

        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/UniversityApplication", "root", "");
        Statement stmt = conn.createStatement();
        String query="SELECT CourseName FROM courses";
        ResultSet rs= stmt.executeQuery(query);

        int i=0;
        while(rs.next()) {
            courseNames[i++]= rs.getString("CourseName");
        }

        return courseNames;
    }

    public String readCourseDescription(String courseName) throws SQLException {

        String courseDescription = null;

        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/UniversityApplication", "root", "");
        Statement stmt = conn.createStatement();
        String query="SELECT CourseDescription FROM courses WHERE (CourseName='"+courseName+"')";
        ResultSet rs= stmt.executeQuery(query);

        while(rs.next()) {
            courseDescription = rs.getString("CourseDescription");
        }

        return courseDescription;
    }

    public int readCourseID(String courseName) throws SQLException {

        int courseID = -1;

        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/UniversityApplication", "root", "");
        Statement stmt = conn.createStatement();
        String query="SELECT CourseID FROM courses WHERE (CourseName='"+courseName+"')";
        ResultSet rs= stmt.executeQuery(query);

        while(rs.next()) {
            courseID = rs.getInt("CourseID");
        }

        return courseID;
    }

    public int[] readCourseIDS(int id) throws SQLException {
        int[] coursesID;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/UniversityApplication", "root", "");
            Statement stmt = conn.createStatement();

            String query = "SELECT CourseID FROM coursesforusers WHERE (UserID='" + id + "')";
            ResultSet rs = stmt.executeQuery(query);

            int i = 0;
            while (rs.next()) {
                i++;
            }

            coursesID = new int[i];
            rs = stmt.executeQuery(query);

            i = 0;
            while (rs.next()) {
                coursesID[i] = rs.getInt("CourseID");
                i++;
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return coursesID;
    }

}