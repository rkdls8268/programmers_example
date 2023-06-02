import java.util.Arrays;

public class Carpet2 {
    // 프로그래머스 완전탐색 - 카펫
    // 근의공식으로 풀수도 있음.
    public static void main(String[] args) {
        int brown = 24;
        int yellow = 24;
        System.out.println(Arrays.toString(solution(brown, yellow)));
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for (int i = 1; i <= Math.sqrt(yellow); i++) {
            if (yellow % i == 0 ) {
                if (brown == (i + (yellow / i)) * 2 + 4) {
                    answer[0] = Math.max(i, yellow / i) + 2;
                    answer[1] = Math.min(i, yellow / i) + 2;
                    return answer;
                }
            }
        }
        return answer;
    }
}
