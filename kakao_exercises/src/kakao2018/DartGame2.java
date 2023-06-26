package kakao2018;

import java.util.Stack;

public class DartGame2 {
    public static void main(String[] args) {
        String dartResult = "1D#2S*3S";
        System.out.println(solution(dartResult));
    }

    public static int solution(String dartResult) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        char[] dartArray = dartResult.toCharArray();
        boolean isLastCharNum = false;
        for (char c : dartArray) {
            if (Character.isDigit(c)) {
                if (isLastCharNum) {
                    String n = stack.pop().toString();
                    int nextNum = Integer.parseInt(n.concat(Character.toString(c)));
                    stack.push(nextNum);
                } else {
                    stack.push(Character.getNumericValue(c));
                }
                isLastCharNum = true;
            } else if (Character.isAlphabetic(c)) {
                // S, D, T
                int num = stack.pop();
                if (c == 'S') stack.push(num);
                else if (c == 'D') stack.push(num * num);
                else if (c == 'T') stack.push(num * num * num);
                isLastCharNum = false;
            } else {
                // *, #
                int last = stack.pop();
                if (stack.size() > 0) {
                    if (c == '*') {
                        int first = stack.pop();
                        stack.push(first * 2);
                        stack.push(last * 2);
                    }
                } else {
                    if (c == '*') {
                        stack.push(last * 2);
                    }
                }
                if (c == '#') {
                    stack.push(last * (-1));
                }
                isLastCharNum = false;
            }
        }
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }
        return answer;
    }
}
