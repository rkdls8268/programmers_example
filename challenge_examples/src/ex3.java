import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ex3 {
    // 삼각 달팽이
    public static void main(String[] args) {
        int n = 4;
        System.out.println(Arrays.toString(solution(n)));
    }

    static int[] solution(int n) {
        int[] answer = new int[(n*(n+1))/2];
        int cnt = 0;
        // n만큼 2차원 배열을 만들고
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                arr[i][j] = -1;
            }
        }

        int num = 1;
        int i = 0, j = 0;
        // arr[0][0] 은 항상 1
        arr[i][j] = num;

        while (num < answer.length) {
            // 아래로
            while (i+1 < n && arr[i+1][j] < 0) {
                arr[++i][j] = ++num;
            }
            // 옆으로
            while (j + 1 < n && arr[i][j + 1] < 0) {
                arr[i][++j] = ++num;
            }
            // 위로
            while (i - 1 > 0 && arr[i - 1][j - 1] < 0) {
                arr[--i][--j] = ++num;
            }
        }

        num = 0;

        for (i = 0; i < n; i++) {
            for (j = 0; j <= i; j++) {
                answer[num++] = arr[i][j];
            }
        }

        return answer;
    }
}
