import java.util.*;
public class offset_lev5{
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int[][] arr = new int[7][7];
        for (int[] a : arr) {
            Arrays.fill(a, 10);
        }
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                if (arr[i][j] < arr[i-1][j]
                        && arr[i][j] < arr[i+1][j]
                        && arr[i][j] < arr[i][j-1]
                        && arr[i][j] < arr[i][j+1]) {
                    System.out.print("* ");
                }
                else {
                    System.out.print(arr[i][j]+" ");
                }
            }
            System.out.println("");
        }

    }
}