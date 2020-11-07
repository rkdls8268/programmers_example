import java.util.Arrays;

public class Q2_20 {
    public static void main(String[] args) {
        String s = "1234";
        String op = "+";
        System.out.println(Arrays.toString(solution(s, op)));
    }

    static long[] solution(String s, String op) {
        long[] answer = {};
        answer = new long[s.length() - 1];

        for (int i = 1; i < s.length(); i++) {
            if (op.equals("+")) {
                answer[i-1] = Integer.parseInt(s.substring(0, i)) + Integer.parseInt(s.substring(i));
            } else if (op.equals("-")) {
                answer[i-1] = Integer.parseInt(s.substring(0, i)) - Integer.parseInt(s.substring(i));
            } else if (op.equals("*")) {
                answer[i-1] = Integer.parseInt(s.substring(0, i)) * Integer.parseInt(s.substring(i));
            } else {
                answer[i-1] = Integer.parseInt(s.substring(0, i)) / Integer.parseInt(s.substring(i));
            }
        }

        return answer;
    }
}
