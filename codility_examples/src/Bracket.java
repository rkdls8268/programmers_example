import java.util.Stack;

public class Bracket {
    public static void main(String[] args) {
        String s = "{[()()]}";
        String s1 = "{([])}";
        System.out.println(solution(s));
    }

    static int solution(String s) {
        int answer = 1;
        int len = s.length();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (stack.isEmpty()) stack.push(s.substring(i, i + 1));
            if (stack.peek().equals("{")){
                if (s.charAt(i) == '}') stack.pop();
                else {
                    answer = 0;
                    break;
                }
            }
            else if (stack.peek().equals("[")) {
                if (s.charAt(i) == ']') stack.pop();
                else {
                    answer = 0;
                    break;
                }
            }
            else if (stack.peek().equals("(")) {
                if (s.charAt(i) == ')') stack.pop();
                else {
                    answer = 0;
                    break;
                }
            }
            System.out.println(stack);
        }
//        for (int i = 0; i < len / 2; i++) {
//            stack.push(s.substring(i, i + 1));
//            System.out.println(stack);
//        }
//        for (int i = len / 2; i < len; i++) {
//            if (!stack.pop().equals(s.substring(i, i + 1))) {
//                answer = 0;
//                break;
//            }
//        }
        return answer;
    }
}
