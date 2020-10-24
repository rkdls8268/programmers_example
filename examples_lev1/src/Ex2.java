import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex2 {
    // 나누어 떨어지는 숫자 배열
    public static void main(String[] args) {
        int[] arr = {5, 9, 7, 10};
        int[] arr1 = {2, 36, 1, 3};
        int divisor = 5;
        int divisor1 = 1;
        System.out.println(Arrays.toString(solution(arr, divisor)));
        System.out.println(Arrays.toString(solution2(arr1, divisor1)));
    }

    static int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();

        for (int a : arr) {
            if (a % divisor == 0) list.add(a);
        }
        if (list.isEmpty()) list.add(-1);

        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);

        return answer;
    }

    static int[] solution2(int[] arr, int divisor) {
        // stream API 사용 가능!!
        int[] answer = Arrays.stream(arr).filter(e -> e % divisor == 0).toArray();
        if (answer.length == 0){
            answer = new int[1];
            answer[0] = -1;
        }
        Arrays.sort(answer);
        return answer;
    }
}
