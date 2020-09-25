import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class SQ1 {
    // 주식 가격
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(solution(prices)));
    }

    public static int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];

        // 스택으로 처리

        Stack<Integer> stack = new Stack<>();
        for (int i = prices.length - 1; i >= 0; i--) {
            stack.push(prices[i]);
        }
//        for (int i = 0; i < prices.length; i++) {
//            stack.push(prices[i]);
//        }
        System.out.println(stack);

        for (Integer p : prices) {

            stack.push(p);
//            if (!stack.contains(p)) {
//                stack.push(p);
//            } else {
//                System.out.println("p: "+p+", search: "+stack.search(p));
//                stack.push(stack.search(p) - 1);
//            }
        }

        int cnt = 0;

        for (int i = 0; i < len; i++) {
            System.out.println(stack.peek());
            if (!stack.contains(stack.peek())) {
                answer[i] = cnt;
                stack.pop();
            } else {
                answer[i] = stack.search(stack.peek());
                stack.pop();
            }
        }

        return answer;
    }
}
