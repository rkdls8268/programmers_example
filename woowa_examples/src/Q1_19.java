import java.util.Arrays;

public class Q1_19 {
    /*
    계좌에 들어있는 돈 일부를 은행에서 출금하고자 합니다.
    돈 담을 지갑이 최대한 가볍도록 큰 금액의 화폐 위주로 받습니다.
    돈은 액수 money가 매개변수로 주어질 때, 오만원, 만원, 오천원, 천원, 오백원, 백원, 오십원, 십원, 일원
    각 몇개로 변환된느지 금액이 큰 순서대로 배열에 담아 return
    */
    public static void main(String[] args) {
        int money = 50237;
        System.out.println(Arrays.toString(solution(money)));
    }

    static int[] solution(int money) {
        int[] answer = new int[9];
        int[] m = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int i = 0; i < answer.length-1; i++) {
            answer[i] = money / m[i];
            money -= (answer[i] * m[i]);
        }
        answer[8] = money;

        return answer;
    }
}

// 근데 효율성이 떨어질 수도 있음..
