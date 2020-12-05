import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Truck {
    // 다리를 지나는 트럭: 스택/큐
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};
        System.out.println(solution(bridge_length, weight, truck_weights));
    }

    static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; // 걸린 최소 시간
        Queue<Integer> queue = new LinkedList<>();
        // queue 의 길이가 bridge_length 만 해야 함 (queue.size() == bridge_length)
        int sum = 0;
        for (int t : truck_weights) {
            while (true) {
                // queue가 비어있는 경우
                if (queue.isEmpty()) {
                    queue.add(t);
                    sum += t;
                    answer++;
                    break;
                } else if (queue.size() == bridge_length) {
                    // queue 가 가득 차 있는 경우
                    sum -= queue.poll();
                } else {
                    // 트럭이 다리 위에 있지만 queue 가 가득 차 있지 않은 상태
                    if (sum + t > weight) {
                        queue.add(0); // 0을 넣어주는 게 포인트!!! * 어차피 더해도 값에 변화 없으니까
                        answer++;
                    } else {
                        queue.add(t);
                        sum += t;
                        answer++;
                        break;
                    }
                }
            }
        }
        return answer + bridge_length;
    }
}
