public class StringToInt {
    // 문자열을 정수로 바꾸기
    public static void main(String[] args) {
        String s = "1234";
        String s1 = "-1234";
        System.out.println(solution(s));
        System.out.println(solution(s1));
    }

    static int solution(String s) {
        int answer = 0;

//        if (s.startsWith("-")) {
//            int a = Integer.parseInt(s.substring(1));
//            answer -= a;
//        } else {
//            answer = Integer.parseInt(s);
//        }
        answer = Integer.parseInt(s);

        return answer;
    }
}
