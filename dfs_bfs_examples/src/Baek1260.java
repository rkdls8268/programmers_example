import java.util.*;

public class Baek1260 {
    static int n;
    static LinkedList<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int m = in.nextInt();
        int start = in.nextInt();

        list = new LinkedList[n+1];

        for (int i = 1; i < n + 1; i++) {
            list[i] = new LinkedList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();

            // 양방향
            list[u].add(v);
            list[v].add(u);
        }

        for (int i = 1; i < n + 1; i++) {
            Collections.sort(list[i]);
        }

        visited = new boolean[n+1];
        DFS(start);

    }

    static void DFS(int start) {
        if (visited[start]) {
            return;
        }
        visited[start] = true;
        System.out.print(start + " ");
        for (int i : list[start]) {
            if (!visited[i]) DFS(i);
        }
    }
}
