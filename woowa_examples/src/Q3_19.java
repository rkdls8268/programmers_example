import java.util.Arrays;
import java.util.Comparator;

public class Q3_19 {
    /*
    어느 연못에 엄마 말씀을 좀처럼 듣지 않는 청개구리가 살고 있었다.
    청개구리는 엄마가 하는 말은 무엇이든 반대로 말하였다.
    엄마 말씀 word가 매개변수로 주어질 때, 아래 청개구리 사전을 참고해 반대로 변환하여 return
     */
    public static void main(String[] args) {
        String word = "I love you";
        System.out.println(solution(word));
    }

    static String solution(String word) {
        String answer = "";
        int[] first = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        int[] second = {'Z', 'Y', 'X', 'W', 'V', 'U', 'T','S', 'R', 'Q', 'P', 'O', 'N', 'M', 'L', 'K', 'J', 'I', 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A'};
        Arrays.sort(first);
        System.out.println(Arrays.toString(first));

//        for (int i = 0; i < word.length(); i++) {
//            if (word.charAt(i) >= 'A' || word.charAt(i) <= 'M') {
//                for ()
//            }
//
//        }

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 65 && word.charAt(i) <= 90) {
//                System.out.println(word.charAt(i));
                for (int j = 0; j < first.length; j++) {
                    if (word.charAt(i) == first[j]) answer += (char) second[j];
                }
            } else if (word.charAt(i) >= 97 && word.charAt(i) <= 122) {
//                System.out.println(word.charAt(i));
                for (int j = 0; j < first.length; j++) {
                    if (word.charAt(i) == first[j] + 32) answer += (char) (second[j] + 32);
                }
            } else { // 공백
                answer += word.charAt(i);
            }
        }


        return answer;
    }
}

// 시간 개 오래 걸릴거같음...
