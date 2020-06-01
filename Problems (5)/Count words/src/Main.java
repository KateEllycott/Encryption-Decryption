import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = reader.readLine();
            Pattern pattern = Pattern.compile("\\b+[A-Za-z]+\\b+");
            Matcher matcher = pattern.matcher(input);
            int wordCounter = 0;
            while (matcher.find()) {
                wordCounter++;
            }
            System.out.println(wordCounter);
        }
    }
}