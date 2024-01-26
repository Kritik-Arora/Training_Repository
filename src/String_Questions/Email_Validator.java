package String_Questions;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email_Validator {

    public static void main(String[] args) {
        String email = "test.email@example.com";

        if (isValidEmail(email)) {
            System.out.println(email + " is a valid email address.");
        } else {
            System.out.println(email + " is not a valid email address.");
        }
    }

    public static boolean isValidEmail(String email) {
        // Define a regular expression for a valid email address
        String emailRegex = "^[a-z A-Z 0-9 ]+(?:\\.[a-z A-Z 0-9]+)*@(?:[a-z A-Z 0-9]+\\.)+[a-z A-Z]{2,7}$";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(emailRegex);

        // Create a Matcher object
        Matcher matcher = pattern.matcher(email);

        // Return true if the email matches the regular expression, otherwise false
        return matcher.matches();
    }
}
