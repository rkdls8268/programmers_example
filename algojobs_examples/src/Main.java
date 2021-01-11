import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main{
    public static void main(String[] args){

        // Please Enter Your Code Here
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            int M = in.nextInt();
            int[][] arr = new int[N][M];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    arr[j][k] = in.nextInt();
                }
            }
            System.out.println(commute(i, arr, N, M));
        }
    }

    static String commute(int T, int[][] arr, int N, int M) {
        Stack<Integer> stack = new Stack<>();
        Boolean[][] isVisited = new Boolean[N][M];
        for (int i = 0; i < T; i++) {
            Arrays.fill(isVisited[i], false);
        }
//        System.out.print(isVisited[0][0]);
        for (int i = 0; i < N; i++) {
            for (int j = i; j < M; j++) {
                if (stack.contains(arr[i][j])) {
                    break;
                }
                stack.push(arr[i][j]);
                isVisited[i][j] = true;
            }
        }

        return "#" + (T+1);
    }
}