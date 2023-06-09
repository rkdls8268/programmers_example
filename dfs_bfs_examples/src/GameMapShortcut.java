// Point 클래스 제공
import java.awt.*;
import java.util.*;

public class GameMapShortcut {
    // 프로그래머스 DFS/BFS - 게임 맵 최단거리
    public static void main(String[] args) {
        int[][] maps = {
//                {1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}
                {1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,0}, {0,0,0,0,1}
        };
        System.out.println(solution(maps));
    }

    public static int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        // 상하좌우 이동을 위해 필요
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] shortcut = new int[n+1][m+1];
        boolean[][] visited = new boolean[n+1][m+1];
        bfs(maps, shortcut, visited, dx, dy);
//        for (int[] s : shortcut) {
//            System.out.println(Arrays.toString(s));
//        }
        if (shortcut[n][m] > 0) return shortcut[n][m];
        else return -1;
    }


    public static void bfs(int[][] maps, int[][] shortcut, boolean[][] visited, int[] dx, int[] dy) {
        Queue<Point> queue = new LinkedList<>();
        // 현재 위치: (1, 1), 상대팀 진영 (n, m)
        // n, m 에 도달하면 종료. 해당 값이 최소값
        // 정수 배열 대신 Point 클래스를 사용
        int x = 1; int y = 1;
        Point first = new Point(x, y);
        queue.add(first);
        visited[x][y] = true;
        shortcut[x][y] = 1;

        int n = maps.length;
        int m = maps[0].length;

        while (!queue.isEmpty()) {
            Point tmp = queue.poll();
            // 인접한 좌표 값 큐에 저장 (동서남북)
            for (int i = 0; i < dx.length; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx >= 1 && nx <= n && ny >= 1 && ny <= m // map 인덱스 안에 들어오는지 확인
                    && maps[nx-1][ny-1] > 0 // 길인지 벽인지 확인. 길일 경우에만 이동
                    && !visited[nx][ny] // 가지 않은 길로만 이동
                ) {
                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                    shortcut[nx][ny] = shortcut[tmp.x][tmp.y] + 1; // 최단거리 구하기
                }
            }
        }
    }
}

//class Point {
//    int x;
//    int y;
//    Point(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//}

