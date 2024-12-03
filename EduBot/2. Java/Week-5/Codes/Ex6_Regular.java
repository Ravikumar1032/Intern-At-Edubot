import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex6_Regular {
    public static void main(String[] args) {
        String text = "the teacher wore a yellow turtleneck";

        Pattern pattern = Pattern.compile("nec");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("String 'nec' found starting at index: " + matcher.start() + " and ending at index: " + matcher.end());
        }

        pattern = Pattern.compile("NEC"); // Fix: Corrected the typo from "NEC" to "nec"
        matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("String 'NEC' found starting at index: " + matcher.start() + " and ending at index: " + matcher.end());
        }
    }
}