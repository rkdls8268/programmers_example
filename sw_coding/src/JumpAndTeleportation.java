import java.util.LinkedList;
import java.util.Queue;

public class JumpAndTeleportation {
    public static void main(String[] args) {
        int n = 5000;
        System.out.println(solution(n));
    }

    static int solution(int n) {
        int answer = 0;

        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
            }
            else {
                n -= 1;
                answer++;
            }
        }
        return answer;
    }
}

// bfs 로 풀어야 할까?

// +) 그럴 필요 없이 top-down 방식으로 푸니까 바로 해결됨.. 매우 쉬웠다..