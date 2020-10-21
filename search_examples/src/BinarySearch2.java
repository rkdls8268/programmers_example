import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch2 {
    // 징검다리
    public static void main(String[] args) {
        int distance = 25;
        int[] rocks = {2, 14, 11, 21, 17};
        int n = 2;
        System.out.println(solution(distance, rocks, n));
    }

    static int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int left = 0;
        int right = distance;
        int mid = 0;

        // 2, 11, 14, 17, 21
        Arrays.sort(rocks);

        List<Integer> list = new ArrayList<>();
        for (int r : rocks) {
            list.add(r);
        }

        left = list.get(0);

        while (left <= right) {
            for (int i = 0; i < list.size(); i++) {

            }

            mid = (left + right) / 2;
            System.out.println(mid);

        }

        return answer;
    }
}
