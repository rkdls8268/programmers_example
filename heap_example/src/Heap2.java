import java.util.LinkedList;
import java.util.Queue;

public class Heap2 {
    // 디스크 컨트롤러
    public static void main(String[] args) {
        int[][] jobs = {
                {0, 3}, {1, 9}, {2, 6}
        };
        System.out.println(solution(jobs));
    }

    public static int solution(int[][] jobs) {
        int answer = 0;

        // 큐 사용?!
        Queue<Integer> queue = new LinkedList<>();

        // 스레드 사용? sleep 해서 일초에 한 번씩 부르는거


        return answer;
    }
}
