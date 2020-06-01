import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = null;
        int consonantsInRow = 0;
        int vowelsInRow = 0;
        int vowelsDividerCount = 0;
        int consonantsDividerCount = 0;

        if(scanner.hasNextLine()) {
            word = scanner.nextLine();
        }
        else {
            throw new IllegalArgumentException();
        }

        char[] wordChars = word.toCharArray();

        for(int i = 0; i < wordChars.length; i++) {
            if(wordChars[i] == 'a' || wordChars[i] == 'e'
            || wordChars[i] == 'i' || wordChars[i] == 'o'
            || wordChars[i] == 'u' || wordChars[i] == 'y' ) {
                if(consonantsInRow >= 3) {
                    consonantsDividerCount += (consonantsInRow % 2 == 0 ?
                            consonantsInRow / 2 - 1 : consonantsInRow / 2);
                }
                consonantsInRow = 0;
                ++vowelsInRow;
            }

            else {
                if (vowelsInRow >= 3) {
                    vowelsDividerCount += (vowelsInRow % 2 == 0 ?
                            vowelsInRow / 2 - 1 : vowelsInRow / 2);
                }
                vowelsInRow = 0;
                ++consonantsInRow;
            }
        }

        if(consonantsInRow >= 3) {
            consonantsDividerCount += (consonantsInRow % 2 == 0 ? consonantsInRow / 2 - 1 : consonantsInRow / 2);
        }

        if(vowelsInRow >= 3) {
            vowelsDividerCount += (vowelsInRow % 2 == 0 ?  vowelsInRow / 2 - 1 : vowelsInRow / 2);
        }

        System.out.println((vowelsDividerCount + consonantsDividerCount));
    }
}