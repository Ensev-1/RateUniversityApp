import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class FrameFeedbackTest {

    @Test
    public void testFrameFeedback() throws SQLException {

        FrameFeedback f = new FrameFeedback(6,2);

        boolean wasCreated;

        if(f!=null) wasCreated=true;
        else wasCreated=false;

        Assertions.assertTrue(wasCreated);
    }
}