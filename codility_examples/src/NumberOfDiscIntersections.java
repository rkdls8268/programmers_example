import java.util.ArrayList;
import java.util.Arrays;

// 43%
public class NumberOfDiscIntersections {
    public static void main(String[] args) {
        int[] A = {1, 5, 2, 1, 4, 0};
        System.out.println(solution(A));
    }

    static int solution(int[] A) {
        int len = A.length;
        int cnt = 0;
        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            int[] n = new int[2];

            if (list.isEmpty()) {
                n[0] = i - A[i];
                n[1] = i + A[i];
                list.add(n);
            }
            else {
                n[0] = i - A[i];
                n[1] = i + A[i];
                list.add(n); // 왜 같은 값이 들어가져있지? 왜 변경되지????? -> int[] n을 for 문에서 초기화해주니 해결됨
//                for (int[] l : list) {
//                    System.out.println(Arrays.toString(l));
//                }
                for (int j = 0; j < list.size() - 1; j++) {
                    if (n[0] <= list.get(j)[0] && n[1] >= list.get(j)[1]
                    || n[0] >= list.get(j)[0] && n[0] <= list.get(j)[1]) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
