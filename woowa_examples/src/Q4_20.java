import java.util.Arrays;
import java.util.HashMap;

public class Q4_20 {
    public static void main(String[] args) {
        int n = 3;
        int[][] board = {
                {3, 5, 6}, {9, 2, 7}, {4, 1, 8}
        };
        System.out.println(solution(n, board));
    }

    static int solution(int n, int[][] board) {
        int answer = 0;
        HashMap<Integer, int[]> point = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int[] p = {i, j};
//                p[0] = i;
//                p[1] = j;
                point.put(board[i][j], p);
//                System.out.println(board[i][j]);
            }
        }
//        System.out.println(Arrays.toString(point.get(1)));

        int[] now = {0, 0};
//        now[0] = 0;
//        now[1] = 0;

        for (int i = 0; i < n * n; i++) {
//            System.out.println(Arrays.toString(point.get(i+1)));
            int togoX = Integer.parseInt(Arrays.toString(point.get(i+1)).substring(1, 2));
            int togoY = Integer.parseInt(Arrays.toString(point.get(i+1)).substring(4, 5));
//            int togoY = point.get(i)[1];

            // X 거리 구하기
            answer += getDistanceX(now[0], togoX, n);
            // y도 똑같이 해주기
            answer += getDistanceY(now[1], togoY, n);
            // 엔터 키
            answer += 1;
            // now point 교체
            now[0] = togoX;
            now[1] = togoY;
        }
        return answer;
    }

    static int getDistanceX(int nowX, int togoX, int n) {
        int result = 0;
        int a = nowX - togoX;
        if (a < 0) a += n;
        int b = togoX - nowX;
        if (b < 0) b += n;
        result = Math.min(a, b);
        return result;
    }

    static int getDistanceY(int nowY, int togoY, int n) {
        int result = 0;
        int a = nowY - togoY;
        if (a < 0) a += n;
        int b = togoY - nowY;
        if (b < 0) b += n;
        result = Math.min(a, b);
        return result;
    }
}
