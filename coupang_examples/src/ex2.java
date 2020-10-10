import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ex2 {
    public static void main(String[] args) {
        int n = 3;
        String[] customers = {
                "10/01 23:20:25 30", "10/01 23:25:50 26", "10/01 23:31:00 05",
                "10/01 23:33:17 24", "10/01 23:50:25 13", "10/01 23:55:45 20",
                "10/01 23:59:39 03", "10/02 00:10:00 10"
        };
        System.out.println(solution(n, customers));
    }

    public static int solution(int n, String[] customers) {
        int answer = 0;

        int[] kiosk = new int[n]; // n대의 kiosk

        // priority queue
        Queue<String > queue = new PriorityQueue<>();
        queue.addAll(Arrays.asList(customers));

        System.out.println(queue);

        System.out.println(calc(customers[0]));

        return answer;
    }

    public static String calc(String time1) {
        String result = "";

        int mon1 = Integer.parseInt(time1.substring(0, 2));
        int day1 = Integer.parseInt(time1.substring(3, 5));
        int hr1 = Integer.parseInt(time1.substring(6, 8));
        int min1 = Integer.parseInt(time1.substring(9, 11));
        int sec1 = Integer.parseInt(time1.substring(12, 14));
        int dur1 = Integer.parseInt(time1.substring(15, 17));

        if (min1 + dur1 >= 60) {
            if (hr1 >= 24) {
                if (mon1 == 1 || mon1 == 3 || mon1 == 5 || mon1 == 7 || mon1 == 8 || mon1 == 10 || mon1 == 12) {
                    if (day1 > 31) mon1++;
                } else if (mon1 == 2) {
                    if (day1 > 28) mon1++;
                } else {
                    if (day1 > 30) mon1++;
                }
                day1++;
            }
            hr1++;
            min1 += dur1;
        } else {
            min1 += dur1;
        }

        result = mon1 + "/" + day1 + " " + hr1 + ":" + min1 + ":" + sec1;

        return result;
    }
}
