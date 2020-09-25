import java.util.Arrays;

public class SQ1_1 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(solution(prices)));
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        // 배열로 처리
        // prices 배열 앞에 담겨있는 값들은 하나의 주식 가격이 올라갔다 내려가는 것임!!!

        int cnt = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if (prices[i] <= prices[j]) {
                    cnt++;
                }

                else if (prices[i] > prices[j]) {
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
