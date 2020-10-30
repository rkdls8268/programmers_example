import java.util.*;

public class Delivery {
    // 배달 -> 다익스트라 알고리즘 사용하면 쉽게 풀림!!!
    public static void main(String[] args) {
        int N = 5;
        int[][] road = {
                {1,2,1}, {2,3,3}, {5,2,2},
                {1,4,2}, {5,3,1}, {5,4,2}};
        int K = 3;
        System.out.println(solution(N, road, K));
    }

    static int solution(int N, int[][] road, int K) {
        int answer = 0;
        int MAX = 1000000;
        int V = N; // 정점
        int E = road.length; // 간선
        int[][] adj = new int[V][V]; // 인접 행렬
        for (int[] a : adj) {
            Arrays.fill(a, MAX);
        }
        for (int[] ints : road) {
            int a = ints[0] - 1;
            int b = ints[1] - 1;
            int c = ints[2];

            if (c < adj[a][b]) adj[a][b] = adj[b][a] = c;
        }

        // 가장 짧은 거리
        int[] D = new int[V];
        Arrays.fill(D, Integer.MAX_VALUE); // 가장 큰 수로 일단 배열 채우기
        boolean[] visited = new boolean[V];

        D[0] = 0;
        for (int i = 0; i < V - 1; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int j = 0; j < V; j++) {
                // 아직 처리하지 않았으면서, 가장 짧은 거리라면
                if (!visited[j] && min > D[j]) {
                    index = j;
                    min = D[j];
                }
            }
            for (int j = 0; j < V; j++) {
                // 아직 처리하지 않았으면서 경로가 존재하고, index까지의 거리 + Index부터 j까지의 거리가 D[j]보다 작다면
                if (!visited[j] && adj[index][j] != 0 && D[index] != Integer.MAX_VALUE
                        && D[index] + adj[index][j] < D[j]) {
                    D[j] = D[index] + adj[index][j];
                }
            }
            visited[index] = true;
        }
        System.out.println(Arrays.toString(D));
        for (int j : D) {
            if (j <= K) answer++;
        }
        return answer;
    }
}
