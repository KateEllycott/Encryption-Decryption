import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main {
    public static void main(String[] args) throws Exception {
        try (Reader reader = new BufferedReader(new InputStreamReader(System.in))) {
           List<Character> characterList = new ArrayList<>();
           int input = 0;
           while ((input = reader.read()) != -1) {
               characterList.add((char)input);
           }
            Collections.reverse(characterList);
            for(Character element: characterList) {
                System.out.print(element);
            }
        }
    }
}