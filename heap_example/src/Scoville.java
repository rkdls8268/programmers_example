import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

class Scoville {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 1;
        System.out.println(solution(scoville, K));
    }
    public static int solution(int[] scoville, int K) {
        int answer = 0;

        // 1. scoville 우선순위 큐 선언
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.addAll(Arrays.stream(scoville).boxed().collect(Collectors.toList()));
//        if (pq.element() == K) return -1;


        // 2. 1번 노드와 2번 노드의 값을 가져와서 1 + 2*2 의 값이 K보다 클때까지 작업
        int sum;
        while (pq.peek() < K) {
            if (pq.size() == 1) return -1;
//                System.out.println(Arrays.toString(pq.toArray()));
            int first = pq.poll();
            int second = pq.poll();
            sum = first + (second * 2);
            pq.add(sum);
//                System.out.println(Arrays.toString(pq.toArray()));
            answer++;
        }

        return answer;
    }
}