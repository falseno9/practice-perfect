package codewars;

/**
 * Created by Kunal on 11/25/2016.
 */
public class HumanReadableTime {
    public static String makeReadable(int seconds) {

        if (seconds == 0) {
            return "00:00:00";
        }

        int hours = seconds / 3600;
        seconds = (seconds - (hours * 3600));

        int minutes = seconds / 60;
        seconds = seconds - minutes * 60;

        return (hours < 10 ? "0" + hours : String.valueOf(hours)) + ":" + (minutes < 10 ? "0" + minutes : String.valueOf(minutes)) + ":" + (seconds < 10 ? "0" + seconds : String.valueOf(seconds));
    }

    public static void main(String[] args) {
        System.out.println(makeReadable(0));
        System.out.println(makeReadable(5));
        System.out.println(makeReadable(60));
        System.out.println(makeReadable(86399));
        System.out.println(makeReadable(359999));
    }
}