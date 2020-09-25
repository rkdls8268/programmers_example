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

        // 스택에 거꾸로 삽입
        for (int i = prices.length - 1; i >= 0; i--) {
            stack.push(prices[i]);
        }
//        for (int i = 0; i < prices.length; i++) {
//            stack.push(prices[i]);
//        }
        System.out.println(stack);

//        for (Integer p : prices) {
//
//            stack.push(p);
////            if (!stack.contains(p)) {
////                stack.push(p);
////            } else {
////                System.out.println("p: "+p+", search: "+stack.search(p));
////                stack.push(stack.search(p) - 1);
////            }
//        }

        int cnt = 0;

        for (int i = 0; i < len; i++) {
            int cur = stack.pop();
            System.out.println("cur:" + cur);
            for (int j = i + 1; j < len; j++) {
                if (cur <= prices[j]) {
                    cnt++;
                } else if (cur > prices[j]){
//                    System.out.println(stack.peek());
//                    answer[i] = stack.search(stack.peek());
//                    stack.pop();
                    cnt++;
                    break;
                }

            }
            answer[i] = cnt;
            cnt = 0;
        }

        return answer;
    }
}
