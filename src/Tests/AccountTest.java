import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
class AccountTest {

    @Test
    public void testLoginInfoIsCorrect(){

        Account a = new Account();

        int isRegistered = a.loginInfoIsCorrect("Ensev Miraka", "test1");
        int isNotRegistered = a.loginInfoIsCorrect("ensi", "test1");

        Assertions.assertEquals(isRegistered, 1);
        Assertions.assertEquals(isNotRegistered, -1);
    }

    @Test
    public void testSignUp() throws SQLException {

        Account a = new Account();

        boolean cannotSignUp1 = a.signUp("12345678910111213141516","test","test","test");
        boolean cannotSignUp2 = a.signUp("test","12345678910111213141516","test","test");
        boolean cannotSignUp3 = a.signUp("test","test","123456789101112131415161718192021222324252627282930","test");
        boolean cannotSignUp4 = a.signUp("test","test","test","123456789101112131415161718192021222324252627282930");

        Assertions.assertFalse(cannotSignUp1);
        Assertions.assertFalse(cannotSignUp2);
        Assertions.assertFalse(cannotSignUp3);
        Assertions.assertFalse(cannotSignUp4);
    }

}