import java.util.LinkedList;
import java.util.Queue;

public class Network {
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {
                {1, 0, 0}, {0, 1, 0}, {0, 0, 1}
        };
        System.out.println(solution(n, computers));
    }

    static int cnt = 0;

    public static int solution(int n, int[][] computers) {
        boolean[][] visited = new boolean[n + 1][n + 1];
        boolean[] nodeCheck = new boolean[n + 1];
        bfs(computers, n, visited, nodeCheck);
        return cnt;
    }

    public static void bfs(int[][] computers, int n, boolean[][] visited, boolean[] check) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (!check[i]) {
                cnt++; // check 되지 않은 경우 cnt 증가
                queue.add(i); // 아직 체크되지 않았을 경우 큐에 저장
                visited[i][i] = true; // 방문여부 true (visited 는 n+1 길이 배열이니까 그대로 저장)
                check[i] = true;
            }
            while (!queue.isEmpty()) { // 큐에 더 이상 노드가 없을 때 까지 검사
                int node = queue.poll(); // 검사할 노드 가져오기
                for (int j = 0; j < n; j++) { // computers 인덱스가 노드값이랑 다르므로 0부터 시작
                    if (!visited[node][j + 1]
                            && computers[node - 1][j] == 1
                            && (node - 1) != j
                    ) {
                        queue.add(j + 1);
                        visited[node][j + 1] = true;
                        visited[i + 1][node] = true;
                        check[j + 1] = true;
                    }
                }
            }
        }
    }
}
