package String_Questions;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSearchEngine {

    public static String StringSearchEngine(String input, String substring) {
        if (input == null || substring == null || substring.isEmpty()) {
            return input;
        }

        String regex = Pattern.quote(substring);
        String highlighted = input.replaceAll(regex, "<b>" + substring + "</b>");
        return highlighted;
    }

    public static void main(String[] args) {
        String originalString = "This is a sample string with sample substring occurrences.";
        String substringToHighlight = "sample";

        String highlightedString = StringSearchEngine(originalString, substringToHighlight);
        System.out.println("Original String: " + originalString);
        System.out.println("Highlighted String: " + highlightedString);
    }
}