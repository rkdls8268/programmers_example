import java.util.Stack;

public class Crane {
    // 크레인 인형뽑기 게임
    public static void main(String[] args) {
        int[][] board = {
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}
        };
        int[] moves = {
                1, 5, 3, 5, 1, 2, 1, 4
        };
        System.out.println(solution(board, moves));
    }

    static int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for (int k : moves) {
            int move = k - 1;
//            System.out.println("move:"+move);
            for (int[] b : board) {
                if (b[move] != 0) {
                    if (!stack.isEmpty() && stack.peek() == b[move]) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(b[move]);
                    }
                    b[move] = 0;
                    break;
                }
            }
//            System.out.println("stack: "+stack);
        }
        return answer;
    }
}
