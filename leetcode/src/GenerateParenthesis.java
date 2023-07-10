import java.util.*;

public class GenerateParenthesis {
    // backtracking
    // ~ recursion / termination check
    public static void main(String[] args) {
        // Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
        int n = 6;
        System.out.println(solution(n));
    }

    public static List<String> solution(int n) {
        List<String> list = new ArrayList<>();
        int numOpen = 0;
        int numClosed = 0;
        dfs(n, numOpen, numClosed, "", list);

        return list;
    }

    public static void dfs(int n, int numOpen, int numClosed, String str, List<String> answer) {
        // termination check
        if (numOpen == n && numClosed == n) {
            answer.add(str);
            return;
        }

        // recursion
        if (numOpen < n) {
            dfs(n, numOpen + 1, numClosed, str + "(", answer);
        }
        if (numOpen > numClosed) {
            dfs(n, numOpen, numClosed + 1, str + ")", answer);
        }
    }
}
