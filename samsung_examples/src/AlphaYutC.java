import java.util.Scanner;

public class AlphaYutC {
    public static void main(String[] args) {
        // 50 -> 275, 100 -> 150, 75 -> 80, 300 -> 350 방향으로만 갈 수 있음
        // 총 4개의 방향 나옴
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int start = 0, end = 0, currentScore = 0;
        int[] route1 = {0, 5, 10, 15, 20, 50, 30, 35, 40, 45, 100, 55, 60, 65, 70, 75, 80, 85, 90, 95, 500, 1000};
//        int[] route2 = {0, 5, 10, 15, 20, 50, 275, 250, 300, 350, 400, 500, 1000};
//        int[] route3 = {0, 5, 10, 15, 20, 50, 275, 250, 300, 150, 175, 75, 80, 85, 90, 95, 500, 1000};
//        int[] route4 = {0, 5, 10, 15, 20, 50, 30, 35, 40, 45, 100, 150, 125, 300, 350, 400, 500, 1000};
//        int score = 0;
        for (int i = 0; i < n; i++) {
            int k = in.nextInt();
            int score = getScore(k, start, currentScore, route1);
            System.out.print(score + " ");
            if (score >= 1000) break;
            start += k;
            currentScore = score;
//            System.out.println(currentScore);
        }
    }
    static int getScore(int k, int start, int currentScore, int[] arr) {
        // route1) 가장자리, route2) 50->275, 300->350) route3) 50->275, 75->80, route4) 100->150, 300->350
        int[] route1 = {0, 5, 10, 15, 20, 50, 30, 35, 40, 45, 100, 55, 60, 65, 70, 75, 80, 85, 90, 95, 500, 1000};
        int[] route2 = {0, 5, 10, 15, 20, 50, 275, 250, 300, 350, 400, 500, 1000};
        int[] route3 = {0, 5, 10, 15, 20, 50, 275, 250, 300, 150, 175, 75, 80, 85, 90, 95, 500, 1000};
        int[] route4 = {0, 5, 10, 15, 20, 50, 30, 35, 40, 45, 100, 150, 125, 300, 350, 400, 500, 1000};

        if (currentScore == 50) {
            // route2, route3
            // route3으로 가고 있다가 300 나오면 route2로 아니면 계속 3으로
            arr = route3;
        }
        if (currentScore == 300) {
            // route2
            arr = route2;
        } else {
            // route3
            arr = route3;
        }

        if (currentScore == 100) {
            // route4
            arr = route4;
        } else {
            // route1
            arr = route1;
        }
        start += k;
        if (start >= arr.length-1) start = arr.length-1;

        return arr[start];
    }
}
