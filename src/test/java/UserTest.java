import org.junit.Test;
import validator.UserValidator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserTest {

    @Test
    public void testNullUsername() {
        String username = null;
        assertFalse(UserValidator.validate(username));
    }

    @Test
    public void testEmptyUsername() {
        String username = "";
        assertFalse(UserValidator.validate(username));
    }

    @Test
    public void test50CharUsername() {
        String username = "asdfghjklíyxcvbnmaqwertzuiopasdfghjklíyxvbnmfkgifd";
        assertTrue(UserValidator.validate(username));
    }

    @Test
    public void test50LtCharUsername() {
        String username = "asdf";
        assertTrue(UserValidator.validate(username));
    }

    @Test
    public void test50GtCharUsername() {
        String username = "asdfghjklíyxcvbnmaqwerthgdhdhdhdfhdfhfdhddhfdhdhzuiopasdfghjklíyxsdfvbnmfkgifd";
        assertFalse(UserValidator.validate(username));
    }

}
