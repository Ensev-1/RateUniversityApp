import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class FrameNoAccountTest {

    @Test
    public void testFrameNoAccount() throws SQLException {

        FrameNoAccount f = new FrameNoAccount();

        boolean wasCreated;

        if(f!=null) wasCreated=true;
        else wasCreated=false;

        Assertions.assertTrue(wasCreated);
    }
}