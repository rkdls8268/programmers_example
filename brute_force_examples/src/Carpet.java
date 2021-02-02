import java.util.Arrays;

public class Carpet {
    public static void main(String[] args) {
        int brown = 24;
        int yellow = 24;
        System.out.println(Arrays.toString(solution(brown, yellow)));
    }

    static int[] solution(int brown, int yellow) {
        int[] answer = {};
        int plus = (brown + 4) / 2;
        int multiple = brown + yellow;

        for (int i = 3; i < multiple/2; i++) {
            if (multiple % i == 0) {
                int k = multiple / i;
                if (i + k == plus) {
                    answer = new int[2];
                    answer[0] = k;
                    answer[1] = i;
                    break;
                }
            }
        }
        return answer;
    }
}
