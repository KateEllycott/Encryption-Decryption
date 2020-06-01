import java.util.Scanner;

class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       String gcContent = null;
       if(scanner.hasNext()) {
           gcContent = scanner.nextLine();
       }
       else {
           throw new IllegalArgumentException("Error: Input can't be empty.");
       }
       char[] gcSymbols = gcContent.toCharArray();
       int g = 0;
       int c = 0;
       for (int i = 0; i < gcSymbols.length; i++) {
           if(Character.toLowerCase(gcSymbols[i]) == 'g') {
               g++;
           }
           else if (Character.toLowerCase(gcSymbols[i]) == 'c') {
               c++;
           }
       }
       double result = ((double) (g + c) / gcSymbols.length) * 100;
       System.out.println(result);
    }
}