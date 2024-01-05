import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class FrameNoCourseTest {

    @Test
    public void testFrameNoCourse() throws SQLException {

        FrameNoCourse f = new FrameNoCourse("Elementet e Informatikes");

        boolean wasCreated;

        if(f!=null) wasCreated=true;
        else wasCreated=false;

        Assertions.assertTrue(wasCreated);
    }

}