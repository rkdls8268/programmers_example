import java.util.*;

public class Pirodo {
    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {
                {80, 20}, {50, 40}, {30, 10}
        };
        System.out.println(solution(k, dungeons));
    }

    static int MAX = 0; // 전역변수 사용해서 count 값 갱신

    public static int solution(int k, int[][] dungeons) {
        int len = dungeons.length;
        boolean[] visited = new boolean[len];
        dfs(dungeons, k, visited);
        return MAX;
    }

    public static void dfs(int[][] dungeons, int k, boolean[] visited) {
        int count = 0;
        for (boolean v: visited) {
            if (v) count++;
        }
        if (count > MAX) {
            MAX = count;
        }
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i]) {
                if (k >= dungeons[i][0]
                        && k >= dungeons[i][1]) {
                    visited[i] = true;
                    k -= dungeons[i][1];
                    dfs(dungeons, k, visited);
                    k += dungeons[i][1]; // k의 값도 다시 원상복구 시켜줘야 함!!!
                    visited[i] = false;
                }
            }
        }
    }
}
