import java.util.*;

public class SQ2 {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
//        int[] answer = {};
//        answer = new int[3];

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            queue.add(
                    (100-progresses[i]) % speeds[i] == 0 ?
                    (100-progresses[i]) / speeds[i] :
                    (100-progresses[i]) / speeds[i] + 1
            );
        }

        System.out.println(queue);

        ArrayList<Integer> list = new ArrayList<>();
        int front = queue.poll();
        System.out.println(front);
        int cnt = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.println("cur:" +cur);
            if (front >= cur) {
                cnt++;
            } else {
                list.add(cnt);
                cnt = 1;
                front = cur;
            }
            System.out.println("outCur: " + cur);
            System.out.println("cnt:" + cnt);
        }

        list.add(cnt);
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
