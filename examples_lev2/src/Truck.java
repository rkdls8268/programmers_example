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
        for (int t : truck_weights) {
            queue.add(t);
        }
        System.out.println(queue);
        Stack<Integer> stack = new Stack<>();
        // TODO: stack에 차례대로 넣고 만약 무게 < weight 이면 건너가게 아니면 빼고

        int len = truck_weights.length;
        int first = 0;
        while (!queue.isEmpty()) {
            if (stack.isEmpty()) stack.push(truck_weights[first]);
//            for (stack.peek())
        }
        return answer;
    }
}
