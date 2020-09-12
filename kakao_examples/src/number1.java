import java.util.ArrayList;
import java.util.Scanner;

public class number1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(solution(str));
    }

    // static 처리 안해줬더니 오류 남
    public static int solution(String s) {
        int answer = Integer.MAX_VALUE;

        for (int len = 1; len <= s.length(); ++len) {
            String compressed = ""; // 압축된 문자열
            String target = ""; // 목표 문자열
            String current = ""; // 현재 문자열
            int cnt = 1;

            // 첫 번째 단위 지정
            for (int i = 0; i < len; ++i) {
                target += s.charAt(i);
            }
            System.out.println("target: "+target);

            // 단위만큼 잘랐을 때의 각 부분의 시작 인덱스
            for (int i = len; i < s.length(); i += len) {
                current = "";
                for (int j = i; j < i + len; ++j) {
                    if (j >= s.length()) break;
                    current += s.charAt(j);
                }
                System.out.println("current: "+current);
                if (target.equals(current)) {
                    cnt++;
                } else {
                    if (cnt > 1) {
                        compressed += cnt + target;
                    } else {
                        compressed += target;
                    }
                    cnt = 1;
                    target = current;
                }
                System.out.println("compressed: "+compressed);
            }

            if (cnt > 1) {
                compressed += cnt + target;
            } else {
                compressed += target;
            }

            int length = compressed.length();
            answer = answer > length ? length : answer;
            System.out.println("len: "+len);
        }

//        ArrayList<String> strList = new ArrayList<>();
//        // 문자열 길이는 length() 사용
//        strList.add(s.substring(0));
//        for (int i = 1; i < s.length(); i++) {
//            if (s.substring(i-1) != s.substring(i)) {
//                strList.add(s.substring(i));
//            }
//            if (s.substring(i, i+1))
//
//            System.out.println(strList);
//        }
        if (answer == Integer.MAX_VALUE) answer = 1;
        return answer;
    }
}
