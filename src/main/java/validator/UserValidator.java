package validator;

public class UserValidator {

    public static boolean validate(String username) {
        return username != null && !username.isEmpty() && username.length() <= 50;
    }

}
