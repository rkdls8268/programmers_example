import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Ex1_230707 {
    public static void main(String[] args) {
        int[] queue1 = {1, 1};
        int[] queue2 = {1, 5};
        System.out.println(solution(queue1, queue2));
    }

    public static int solution(int[] queue1, int[] queue2) {
        // 각 큐의 원소합 같게 만들기
        int answer = 0;
        Queue<Integer> q1 = Arrays.stream(queue1).boxed().collect(Collectors.toCollection(LinkedList::new));
        Queue<Integer> q2 = Arrays.stream(queue2).boxed().collect(Collectors.toCollection(LinkedList::new));
        long queue1Sum = Arrays.stream(queue1).sum();
        long queue2Sum = Arrays.stream(queue2).sum();
        long totalSize = q1.size() + q2.size();
        if ((queue1Sum + queue2Sum) % 2 == 1) return -1;
        else {
            while (queue1Sum != queue2Sum) {
                // queue 가 빌 경우 -1 반환
                if (q1.isEmpty() || q2.isEmpty()) return -1;
                // 각 큐의 원소합 같게 만들 수 없는 경우 -1 반환
                if (answer >= totalSize * 2) return -1;
                if (queue1Sum > queue2Sum) {
                    int pop = q1.poll();
                    q2.add(pop);
                    queue1Sum -= pop;
                    queue2Sum += pop;
                    answer++;
                } else if (queue1Sum < queue2Sum) {
                    int pop = q2.poll();
                    q1.add(pop);
                    queue1Sum += pop;
                    queue2Sum -= pop;
                    answer++;
                }
            }
        }
        return answer;
    }
}
