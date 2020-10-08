import java.util.*;

public class Heap1 {
    public static void main(String[] args) {
        int[] scoville= {1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(solution(scoville, K));
    }

    public static int solution(int[] scoville, int K) {

        // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + 두 번째로 맵지 않은 음식의 스코빌 지수 * 2
        int answer = 0;

        Queue<Integer> pq = new PriorityQueue<>();
        for (Integer s : scoville) {
            pq.add(s);
        }

        int temp = 0;
        for (int i = 0; pq.peek() < K; i++) {
//            System.out.println(pq);
            if (pq.size() == 1) return -1;

            int first = pq.poll();
            int second = pq.poll();
            temp = first + (second * 2);
            pq.add(temp);
            answer++;

        }
        return answer;
    }

}
