import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Words {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution(begin, target, words));
    }

    public static int solution(String begin, String target, String[] words) {
        if (Arrays.stream(words).noneMatch(t -> Objects.equals(t, target))) return 0;
        else {
            boolean[] visited = new boolean[words.length];
            int[] shortcut = new int[words.length];
            bfs(words, begin, target, visited, shortcut);
            int idx = Arrays.asList(words).indexOf(target);
            return shortcut[idx];
        }
    }

    public static void bfs(String[] words, String begin, String target, boolean[] visited, int[] shortcut) {
        Queue<String> queue = new LinkedList<>();
        queue.add(begin);
        while (!queue.isEmpty()) {
            String tempTarget = queue.poll();
            int tmp = Arrays.asList(words).contains(tempTarget) ? shortcut[Arrays.asList(words).indexOf(tempTarget)] : 0;

            for (int i = 0; i < words.length; i++) {
                if (isOneDifferentString(tempTarget, words[i])
                    && !visited[i]
                ) {
                    shortcut[i] = tmp + 1;
                    if (words[i].equals(target)) return;
                    queue.add(words[i]);
                    visited[i] = true;
                }
            }
        }
    }

    public static boolean isOneDifferentString(String begin, String target) {
        int cnt = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != target.charAt(i)) cnt++;
        }
        return cnt == 1;
    }
}
