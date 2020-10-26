import java.util.*;

public class Ex3 {
    // 문자열 내 마음대로 정렬하기
    public static void main(String[] args) {
        String[] strings = {
                "abce", "abcd", "cdx"
        };
        int n = 2;
        System.out.println(Arrays.toString(solution(strings, n)));
    }

    static String[] solution(String[] strings, int n) {
//        String[] answer = {};
//        answer = new String[strings.length];
        // 오름차순 정렬 먼저 해줌
        Arrays.sort(strings);
        // comparator 사용
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Character c1 = o1.charAt(n);
                Character c2 = o2.charAt(n);
                return c1 > c2 ? 1 : (c1 == c2 ? 0 : -1);
            }
        });


//        for (int i = 0; i < strings.length; i++) {
//            answer[i] = strings[i];
//        }

        return strings;
    }
}

// list에 인덱스 값을 add하는 식으로 구현했는데 이렇게 하지말고 i 값을 저장하는 식으로 하면 안되나..?
