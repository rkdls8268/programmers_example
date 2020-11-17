import java.util.Stack;

public class DartGame {
    // 다트 게임 2018 1차
    public static void main(String[] args) {
        String dartResult = "1S2D*3T";
        System.out.println(solution(dartResult));
    }

    static int solution(String dartResult) {
        int answer = 0;
        // S: single, D: double, T: triple
        // *: twice, #: minus

        Stack<Character> stack = new Stack<>();
        Stack<Integer> st = new Stack<>();

        for (char s : dartResult.toCharArray()) {
            if (s == 'S') {
                int n = (int) stack.pop();
                st.push(n);
            } else if (s == 'D') {
                int n = (int) stack.pop();
                st.push(n * n);
            } else if (s == 'T') {
                int n = (int) stack.pop();
                st.push(n * n * n);
            } else if (s == '*') {

            }

            stack.push(s);

        }



        return answer;
    }
}
