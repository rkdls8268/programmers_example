import java.util.*;

public class MakeBiggestNum {
    // 큰 수 만들기
    public static void main(String[] args) {
        String number = "1924";
        String number2 = "4177252841";
        int k = 2;
        int k2 = 4;
        System.out.println(solution(number, k));
        System.out.println(solution(number2, k2));
    }

    static String solution(String number, int k) {
        String answer = "";
        // String 을 char[] 로 저장
        char[] nums = number.toCharArray();

        // 스택에 저장되는 수는 작은 수 일수록 나중에 저장됨
        Stack<Character> temp = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            // 스택에 마지막의 저장된 수가 현재 숫자보다 작으면 pop 시키고 현재 숫자 push
            while (!temp.empty() && k > 0 && temp.peek() < nums[i]) {
                k--;
                temp.pop();
            }
            temp.push(nums[i]);
//            System.out.println(temp);
        }

        // k 개를 삭제하지 못했을 경우 뒤에서부터 삭제
        StringBuilder sb = new StringBuilder();
        while (!temp.empty()) {
            if (k != 0) {
                temp.pop();
                k--;
            } else {
                sb.append(temp.pop());
            }
        }
        return sb.reverse().toString();
    }
}
