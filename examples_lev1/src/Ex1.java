import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex1 {
    // 같은 숫자는 싫어
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        System.out.println(Arrays.toString(solution(arr)));
    }

    static int[] solution(int[] arr) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (list.isEmpty()) {
                list.add(arr[i]);
                continue;
            }
            if (list.get(list.size()-1) == arr[i]) continue;
            list.add(arr[i]);
        }
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
            // intValue() 안해줘도 auto boxing 됨
        }
        return answer;
    }
}
