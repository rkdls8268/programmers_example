package kakao2018;

import java.util.ArrayList;
import java.util.List;

public class GameN {
    public static void main(String[] args) {
        int n = 16; // 진법
        int t = 16; // 미리 구할 숫자 개수
        int m = 2; // 총 인원
        int p = 1; // 순서

        System.out.println(solution(n, t, m, p));
    }

    public static String solution(int n, int t, int m, int p) {
        String answer = "";
        List<String> numberList = new ArrayList<>();

        int cnt = 0;
        while (numberList.size() <= t * m) {
            String str = Integer.toString(cnt, n);
            for (char s : str.toCharArray()) {
                numberList.add(String.valueOf(s));
            }
            cnt++;
        }


        for (int i = 0; i < t; i++) {
            answer = answer.concat(numberList.get(i * m + p - 1));
        }

        return answer.toUpperCase();
    }
}
