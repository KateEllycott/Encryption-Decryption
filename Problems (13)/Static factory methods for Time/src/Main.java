import java.util.Scanner;

class Time {

    int hour;
    int minute;
    int second;

    public static Time noon() {
        Time time = new Time();

        time.hour = 12;
        time.minute = 0;
        time.second = 0;

        return time;
    }

    public static Time midnight() {
        Time time = new Time();

        time.hour = 0;
        time.minute = 0;
        time.second = 0;

        return time;
    }

    public static Time ofSeconds(long seconds) {
        Time time = new Time();

        int day = 60 * 60 * 24;

        time.hour = (int) (seconds % day) / 3600;
        time.minute = (int) ((seconds % day) % 3600) / 60;
        time.second = (int) (((seconds % day) % 3600) % 60);

        return time;
    }

    public static Time of(int hour, int minute, int second) {

        Time time = new Time();

        if ((hour < 0 || hour > 23) ||
                (minute < 0 || minute > 59) ||
                (second < 0 || second > 59)) {
            return null;
        } else {
            time.hour = hour;
            time.minute = minute;
            time.second = second;

        }
        return time;
    }
}

/* Do not change code below */
public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final String type = scanner.next();
        Time time = null;

        switch (type) {
            case "noon":
                time = Time.noon();
                break;
            case "midnight":
                time = Time.midnight();
                break;
            case "hms":
                int h = scanner.nextInt();
                int m = scanner.nextInt();
                int s = scanner.nextInt();
                time = Time.of(h, m, s);
                break;
            case "seconds":
                time = Time.ofSeconds(scanner.nextInt());
                break;
            default:
                time = null;
                break;
        }

        if (time == null) {
            System.out.println(time);
        } else {
            System.out.println(String.format("%s %s %s", time.hour, time.minute, time.second));
        }
    }
}