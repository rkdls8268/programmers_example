import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrainingSuits {
    // 체육복
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 3};
        int[] reserve = {1, 3, 5};
        System.out.println(solution(n, lost, reserve));
    }

    static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        for (int i = 0; i < reserve.length; i++) {
            for (int j = 0; j < lost.length; j++) {
                if (reserve[i] == lost[j]) {
                    reserve[i] = -1;
                    lost[j] = -1;
                    answer++;
                    break;
                }
            }
        }

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j] + 1 || lost[i] == reserve[j] - 1) {
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        return answer;
    }
}
