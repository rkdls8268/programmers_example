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

        // 각각의 심사대에서 걸리는 시간(times[i]) 계산해서 right 보다 크면 t에 대입
        for (int t : times) {
            if (t > right)
                right = t;
            System.out.println(right);
        }

        // 입국심사 기다리는 사람 수 n
        System.out.println(n);
        // right 이 탐색해야 될 수 중 가장 큰 수이므로 (가장 긴 시간 * 기다리는 사람)을 일단 최대로 잡아 둠
        right *= n;

        System.out.println("left: "+left+", right: "+right);

        // 이진 탐색
        while (left <= right) {
            long done = 0;
            // 중간 수
            mid = (left + right) / 2;
            System.out.println("mid: "+ mid);
            for (int time : times) {
                done += mid / time;
                System.out.println("time: "+time+", done:" +done);
            }

            if (done < n) {
                // 해당 시간동안 심사를 다 하지 못한 경우
                left = mid + 1;
            } else {
                // 시간이 여유있거나, 딱 맞는 경우
                if (mid < answer) {
                    // 가장 타이트한 시간을 찾아야 하므로
                    answer = mid;
                    System.out.println("answer:" +answer);
                }
                System.out.println("mid>=answer done: "+done);
                right = mid - 1;
            }
        }

        return answer;
    }
}
