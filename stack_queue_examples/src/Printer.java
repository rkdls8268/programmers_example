import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Printer {
    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        System.out.println(solution(priorities, location));
    }

    static int solution(int[] priorities, int location) {
        int[] num = {location, priorities[location]}; // 인덱스, 해당 인덱스의 값

        /*
        1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
        2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
        3. 그렇지 않으면 J를 인쇄합니다.
        */
        // 우선순위 큐 사용?
//        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int len = priorities.length;
        for (int priority : priorities) {
//            queue.add(priorities[i]);
            list.add(priority);
        }

        for (int i = 0; i < len; i++) {
//            int n = queue.element(); // 첫 번째 원소 값
            int n = list.get(i); // 원소 값
            for (int j = i; j < len; j++) {
                if (n < list.get(j)) {
                    list.remove(i);
                    list.add(n);
                    if (n == num[1]) num[0] = len-1;
                    else {
                        num[0] -= 1;
                    }
                    break;
                }
            }
        }

        return num[0];
    }
}
