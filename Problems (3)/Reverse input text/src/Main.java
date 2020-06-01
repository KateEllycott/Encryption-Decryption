import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

class Main {
    public static void main(String[] args) throws Exception {
        try (Reader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int charsRead = 0;
            char[] chars =;
            while((charsRead = reader.read()) != -1) {
                chars = new char[reader.]

            }
        }
    }
}