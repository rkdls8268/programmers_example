import java.util.Arrays;

public class NumberGame {
    // 숫자 게임
    public static void main(String[] args) {
        int[] A = {1, 2, 2, 3};
        int[] B = {1, 1, 1, 3};
        System.out.println(solution(A, B));
    }
    static int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        /* 아래 방법은 1223, 1113의 경우 0을 반환 */
//        for (int i = 0; i < A.length; i++) {
//            if (A[i] < B[i]) answer++;
//        }
        int idx_A = 0, idx_B = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[idx_A] > B[idx_B]) idx_B++;
            else if (A[idx_A] == B[idx_B]) {
                idx_B++;
            } else {
                idx_A++;
                idx_B++;
                answer++;
            }
        }

        return answer;
    }
}
