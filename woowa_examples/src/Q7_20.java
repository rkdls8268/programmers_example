import java.util.Arrays;
import java.util.Stack;

public class Q7_20 {
    public static void main(String[] args) {
        int n = 4;
        boolean horizontal = true;
        System.out.println(Arrays.deepToString(solution(n, horizontal)));
    }

    static int[][] solution(int n, boolean horizontal) {
        int[][] answer = new int[n][n];
        boolean[][] flag = new boolean[n][n];
        for (boolean[] f : flag) {
            Arrays.fill(f, false);
        }
        // [0, 0] 은 항상 0: 시작점
        int x = 0, y = 0;
        int sum = 0;
        answer[y][x] = 0;
        flag[y][x] = true;

        // horizontal 이 true 면 x축으로 1칸, 아니면 y축으로 1칸
        if (horizontal) {
            x += 1;
            sum += 1;
            answer[y][x] = sum;
            flag[y][x] = true;
        }
        else {
            y += 1;
            sum += 1;
            answer[y][x] = sum;
            flag[y][x] = true;
        }

        System.out.println(Arrays.deepToString(answer));

        // 갈수 있는 경로 : 오른쪽, 아래 / 아래, 오른쪽
        // x, y 중에 n-1 을 만나면 무조건 대각선
        // x, y 중에 0 나오면 대각선 or 오른쪽 or 아래

        Stack<int[]> stack = new Stack<>();
        while(flag[n-1][n-1]) {
            if (x == 0 || y == 0) {
                stack.push(new int[]{});
            }
        }

        return answer;
    }
}
