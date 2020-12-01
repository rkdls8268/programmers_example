public class MixedString {
    public static void main(String[] args) {
        String s = "try hello world";
        System.out.println(solution(s));
    }

    static String solution(String s) {
        String answer = "";
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                answer += s.substring(i, i + 1);
                n = 0;
            } else {
                if (n % 2 == 0) {
                    answer += s.substring(i, i + 1).toUpperCase();
                } else {
                    answer += s.substring(i, i + 1).toLowerCase();
                }
                n++;
            }
        }
        return answer;
    }
}
