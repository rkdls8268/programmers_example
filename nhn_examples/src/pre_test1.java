import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class pre_test1 {
    public static void main(String[] args) {
        int n = 5;
        int[][] matrix = {
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {0, 0, 0, 1, 0},
            {0, 0, 1, 1, 0},
            {1, 1, 0, 0, 1}
        };
        System.out.println(solution(n, matrix));
    }

    static int solution(int n, int[][] matrix) {
        int answer = 0;
        List<Integer> areas = new ArrayList<>();
        int cnt = 0;
        int sizeOfAreas = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
                if (matrix[i][j] == 1) {
                    cnt++;
                    if ((i > 0 && matrix[i - 1][j] == 1) && (j > 0 && matrix[i][j-1] == 1) && matrix[i-1][j-1] == 0) {
                        sizeOfAreas--;
                        areas.remove(areas.size()-1);
//                        cnt++;
                        continue;
                    }
                    if ((i > 0 && matrix[i - 1][j] == 1) ||(j > 0 && matrix[i][j-1] == 1)) {
//                        cnt++;
                        continue;
                    }
                    sizeOfAreas++;
                    areas.add(cnt);
                    cnt = 0;
                }
            }
            System.out.println();
        }
        answer = sizeOfAreas;

        System.out.println("-------");
        for (int a : areas) {
            System.out.print(a+ " ");
        }
        System.out.println();
        return answer;
    }
}
