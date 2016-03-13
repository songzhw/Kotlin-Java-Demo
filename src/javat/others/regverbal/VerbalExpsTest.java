package javat.others.regverbal;

/**
 * Created by songzhw on 2016/1/13.
 */
public class VerbalExpsTest {
    public static void main(String[] args) {
        VerbalExpression testRegex = VerbalExpression.regex()
                .startOfLine().then("http").maybe("s")
                .then("://")
                .maybe("www.").anythingBut(" ")
                .endOfLine()
                .build();

        // Create an example URL
        String url = "https://www.google.com";

        // Use VerbalExpression's testExact() method to test if the entire string matches the regex
        testRegex.testExact(url); //True

        testRegex.toString(); // Outputs the regex used:
        // ^(?:http)(?:s)?(?:\:\/\/)(?:www\.)?(?:[^\ ]*)$






        String text = "aaabcd";
        VerbalExpression regex = VerbalExpression.regex()
                .find("a")
                .capture().find("b").anything().endCapture().then("cd").build();

        regex.getText(text);     // returns "abcd"
        regex.getText(text, 1);  // returns "b"

    }
}
