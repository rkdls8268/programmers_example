import java.util.LinkedList;
import java.util.Queue;

public class ElectricNetwork {
    public static void main(String[] args) {
        int n = 7;
        // [[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]
        // [[1,2],[2,7],[3,7],[3,4],[4,5],[6,7]]
        int[][] wires = {
                {1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}
        };
        System.out.println(solution(n, wires));
    }

    public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        int[][] matrix = new int[n][n];
        for (int[] wire : wires) {
            // 간선 채우기
            matrix[wire[0]-1][wire[1]-1] = 1;
            matrix[wire[1]-1][wire[0]-1] = 1;
        }

        for (int[] wire : wires) {
            // 간선 하나씩 끊기 -> 인접행렬 값 0으로 변경
            int nodeA = wire[0] - 1;
            int nodeB = wire[1] - 1;
            matrix[nodeA][nodeB] = 0;
            matrix[nodeB][nodeA] = 0;

            answer = Math.min(answer, bfs(matrix, n, nodeA));

            // 다시 되돌리기
            matrix[nodeA][nodeB] = 1;
            matrix[nodeB][nodeA] = 1;
        }

        return answer;
    }

    public static int bfs(int[][] matrix, int n, int node) {
        // 트리 순회해서 각 구역의 노드 개수 구해서 최소의 절댓값 차 구하기
        int cnt = 1;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true; // 인접행렬이라 자기 자신 참조할 가능성 있으므로 차단
        while (!queue.isEmpty()) {
            // 큐가 빌 때까지 반복
            int now = queue.poll();
            for (int i = 0; i < n; i++) {
                if (matrix[now][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    cnt++;
                }
            }
        }
        // 한 구역의 노드 개수(cnt) 구하면 다른 구역의 노드 개수 자동으로 (n-cnt) 이므로 이 차의 절댓값 구해줌
        return Math.abs(n - (2 * cnt));
    }

}
