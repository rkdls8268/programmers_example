package P230706;

import java.util.Map;

public class Ex2_230706 {
    public static void main(String[] args) {
        String s = "one4seveneight";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        // 문자열에 해당하는 원래 숫자 반환
        // ex) 1478
        // 배열에 넣고 인덱스로 바꾸줘도 됨..
        Map<Integer, String> numberAlphaMap = Map.of(
                0, "zero",
                1, "one",
                2, "two",
                3, "three",
                4, "four",
                5, "five",
                6, "six",
                7, "seven",
                8, "eight",
                9, "nine"
            );

        for (Map.Entry<Integer, String> entry : numberAlphaMap.entrySet()) {
            if (s.contains(entry.getValue())) {
                s = s.replaceAll(entry.getValue(), entry.getKey().toString());
            }
        }
        return Integer.parseInt(s);
    }
}
