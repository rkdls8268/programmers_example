import java.util.Arrays;
import java.util.Comparator;

public class Ex4 {
    // 문자열 내림차순으로 배치하기
    public static void main(String[] args) {
        String s = "Zbcdefg";
        System.out.println(solution(s));
    }

    static String solution(String s) {
        String answer = "";
        Character[] str = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            str[i] = s.charAt(i);
        }
        Arrays.sort(str, Comparator.reverseOrder());
        for (int i = 0; i < str.length; i++) {
            answer += str[i];
        }


        return answer;
    }
}
