import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class BinarySearch1 {
    // 입국심사
    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};
        System.out.println(solution(n, times));
    }

    static long solution(int n, int[] times) {
        long answer = 0;
        answer = Long.MAX_VALUE;
        long left = 0;
        long right = 0;
        long mid;

        for (int t : times) {
            if (t > right)
                right = t;
        }

        right *= n;

        // 이진 탐색
        while (left <= right) {
            long done = 0;
            mid = (left + right) / 2;
            for (int time : times) {
                done += mid / time;
            }

            if (done < n) {
                // 해당 시간동안 심사를 다 하지 못한 경우
                left = mid + 1;
            } else {
                // 시간이 여유있거나, 딱 맞는 경우
                if (mid < answer) {
                    // 가장 타이트한 시간을 찾아야 하므로
                    answer = mid;
                }
                right = mid - 1;
            }
        }

        return answer;
    }

    static int binarySearch(int[] times, int n) {
        long low = 0;
        long high = times[times.length-1] * n; // 2*10 이런 식으로
        long mid = 0;
        long ans = Long.MAX_VALUE;

        while (low <= high) {
            mid = (high + low) / 2;
//            if (times[])
        }
        return 0;
    }
}
