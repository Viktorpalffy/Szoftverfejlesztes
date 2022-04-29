import org.junit.Test;
import validator.GuessValidator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GuessTest {

    @Test
    public void testNullUGuess() {
        String guess = null;
        assertFalse(GuessValidator.validate(guess));
    }

    @Test
    public void testEmptyGuess() {
        String guess = "";
        assertFalse(GuessValidator.validate(guess));
    }

    @Test
    public void testNANGuess() {
        String guess = "10asd";
        assertFalse(GuessValidator.validate(guess));
    }

    @Test
    public void test100Guess() {
        String guess = "100";
        assertTrue(GuessValidator.validate(guess));
    }

    @Test
    public void test100LtGuess() {
        String guess = "30";
        assertTrue(GuessValidator.validate(guess));
    }

    @Test
    public void test100GtGuess() {
        String guess = "107";
        assertFalse(GuessValidator.validate(guess));
    }

}
