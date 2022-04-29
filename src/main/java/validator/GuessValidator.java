package validator;

public class GuessValidator {

    public static boolean validate(String guess) {
        return guess != null && !guess.isEmpty() && isNumeric(guess) && Integer.parseInt(guess) <= 100 && Integer.parseInt(guess) >= 1;
    }

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}