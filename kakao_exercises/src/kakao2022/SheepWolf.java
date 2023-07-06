package kakao2022;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SheepWolf {
    public static void main(String[] args) {
        int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
        int[][] edges = {
                {0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}
//                {0,1},{0,2},{1,3},{1,4},{2,5},{2,6},{3,7},{4,8},{6,9},{9,10}
        };

        System.out.println(solution(info, edges));
    }


    public static int solution(int[] info, int[][] edges) {
        int answer = 0;

        int len = info.length;
        int[][] edgeMatrix = new int[len][len];

        for (int[] edge: edges) {
            int a = edge[0];
            int b = edge[1];
            edgeMatrix[a][b] = 1;
            edgeMatrix[b][a] = 1;
        }

        boolean[][] visited = new boolean[len][len];
        answer = bfs(edgeMatrix, info, visited);
        return answer;
    }

    public static void dfs(int[][] edgeMatrix, int[] info, boolean[][] visited, Stack<Integer> stack, int nextNode) {
        if (stack.isEmpty()) {
            return;
        }

        for (int i = 0; i < edgeMatrix[nextNode].length; i++) {
            // 길이 있고 방문한 적 없으면
            if (edgeMatrix[nextNode][i] == 1 && !visited[nextNode][i]) {
                visited[nextNode][i] = true;
                visited[i][nextNode] = true;
                dfs(edgeMatrix, info, visited, stack, i);
                visited[nextNode][i] = false;
                visited[i][nextNode] = false;

            }
        }
    }

    public static int bfs(int[][] edgeMatrix, int[] info, boolean[][] visited) {
        Queue<Integer> queue = new LinkedList<>();
        int maxSheepValue = 0;
        int firstNode = 0;
        int sheep = 1;
        int wolf = 0;
        // 양, 늑대 개수 체크하면서 탐색
        queue.add(firstNode);
        visited[firstNode][firstNode] = true;

        // 경로를 설정하면 되나?
        // 현재 노드와 연결되지 않은 곳도 갈 수 있음

        while (!queue.isEmpty()) {

            int now = queue.poll();
            for (int i = 0; i < edgeMatrix[now].length; i++) {
                int nextWolf = 0;
                int nextSheep = 0;
                // 다음 방문 노드가 늑대라면
                if (info[i] == 1) nextWolf = wolf + 1;
                // 다음 방문 노드가 양이라면
                else nextSheep = sheep + 1;
                if (edgeMatrix[now][i] == 1 && !visited[now][i] && nextSheep > nextWolf) {
                    // 값이 1이고 탐색한적 없고 양의 개수가 늑대보다 많으면
                    queue.add(i);
                    visited[now][i] = true;
                    visited[i][now] = true;
                    wolf = nextWolf;
                    sheep = nextSheep;
                    if (sheep > maxSheepValue) maxSheepValue = sheep;
                }
            }
        }

        return maxSheepValue;
    }
}
