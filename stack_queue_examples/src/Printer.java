import java.util.*;

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

        int answer = 0;
        Queue<Print> q = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) { // print큐에 인덱스번호, 우선순위 삽입
            q.offer(new Print(i, priorities[i]));
        }

        while (!q.isEmpty()) {

            boolean flag = false;
            int com = q.peek().prior;
            for (Print p : q) {
                if (com < p.prior) { // 맨앞의 수보다 큰 숫자가 존재하면
                    flag = true;
                }
            }

            if (flag) {
                q.offer(q.poll());
            } else {// 현재 맨앞의 숫자가 가장 클 때
                if (q.poll().location == location) {
                    answer = priorities.length - q.size();
                }
            }
        }
        return answer;
    }

    static class Print {
        int location;
        int prior;

        Print(int location, int prior) {
            this.location = location;
            this.prior = prior;
        }
    }

}
