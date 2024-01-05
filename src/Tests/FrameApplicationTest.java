import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
class FrameApplicationTest {

    @Test
    public void testFrameApplication(){

        FrameApplication f = new FrameApplication();

        boolean wasCreated;

        if(f!=null) wasCreated=true;
        else wasCreated=false;

        Assertions.assertTrue(wasCreated);
    }

}