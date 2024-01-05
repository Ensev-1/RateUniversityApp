import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class FrameCourseTest {

    @Test
    public void testFrameCourse() throws SQLException {

        ReaderImpl r = new ReaderImpl();
        int[] coursesForUser = r.readCourseIDS(1);
        String courseSelected = "Elementet e Informatikes";
        FrameCourse f = new FrameCourse(coursesForUser,courseSelected,1);

        boolean wasCreated;

        if(f!=null) wasCreated=true;
        else wasCreated=false;

        Assertions.assertTrue(wasCreated);
    }
}