import java.sql.*;

public class Writer implements Reader{
    private Connection conn = null;

    public void leaveFeedback(String feedbackDescription, int rating, int courseID, int userID) throws SQLException {

        conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/UniversityApplication", "root", "");
        Statement stmt = conn.createStatement();
        String query="INSERT INTO feedbacks(FeedbackDescription, CourseID, FeedbackRating, UserID) VALUES('"+feedbackDescription+"','"+courseID+"','"+rating+"','"+userID+"')";
        stmt.executeUpdate(query);

        public void registerInCourse(int userID, int courseID) throws SQLException {
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/UniversityApplication", "root", "");
            Statement stmt = conn.createStatement();
            String query="INSERT INTO coursesforusers(UserID, CourseID) VALUES('"+userID+"','"+courseID+"')";
            stmt.executeUpdate(query);
        }

    }


}
