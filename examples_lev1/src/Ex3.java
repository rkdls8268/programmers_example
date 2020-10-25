import java.util.*;

public class Ex3 {
    // 문자열 내 마음대로 정렬하기
    public static void main(String[] args) {
        String[] strings = {
                "sun", "bed", "car"
        };
        int n = 1;
        System.out.println(Arrays.toString(solution(strings, n)));
    }

    static String[] solution(String[] strings, int n) {
        String[] answer = {};
        answer = new String[strings.length];
        Queue<String> queue = new LinkedList<>();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            list.add(strings[i].charAt(n));
        }

        return answer;
    }
}
