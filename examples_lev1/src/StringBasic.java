public class StringBasic {
    // 문자열 다루기 기본
    public static void main(String[] args) {
        String s = "a234";
        String s1 = "1234";
        System.out.println(solution(s));
        System.out.println(solution(s1));
    }

    static boolean solution(String s) {
        boolean answer = true;
        // 정규식: [0-9]* -> 숫자가 0개 이상인 패턴
        answer = (s.length() == 4 || s.length() == 6) && s.matches("[0-9]*");
        return answer;
    }
}

// 정규식 정리하기~~