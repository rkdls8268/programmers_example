import java.util.Scanner;

public class AlphaYutB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            int k = in.nextInt();
            int score = getScore(k, start);
            System.out.print(score + " ");
            if (score >= 1000) break;
            start += k;
        }
    }

    static int getScore(int k, int start) {
        int[] scores = {0, 5, 10, 15, 20, 50, 30, 35, 40, 45, 100, 55, 60, 65, 70, 75, 80, 85, 90, 95, 500, 1000};
        start += k;
        if (start >= scores.length-1) start = scores.length-1;
        return scores[start];
    }
}
