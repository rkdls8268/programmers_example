package P230706;

import java.util.Arrays;

public class Ex1_230706 {
    public static void main(String[] args) {
        String[] strings = {"abce", "abcd", "cdx"};
        int n = 2;
        System.out.println(Arrays.toString(solution(strings, n)));
    }

    public static String[] solution(String[] strings, int n) {
        // n 번째 인덱스 기준으로 문자열 재정렬
        Arrays.sort(strings);
        Arrays.sort(strings, (o1, o2) -> {
            char c1 = o1.charAt(n);
            char c2 = o2.charAt(n);
            return Character.compare(c1, c2);
        });
        return strings;
    }


}
