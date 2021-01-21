import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class AlphaYutA {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int n = 4;
        int r = 10;
        int[] result = new int[r];
        ArrayList<int[]> results = new ArrayList<>();
//        int count = 0;

        getResult(0, n, r, result, results, k);
        // 순열의 개수 세는 거 어떻게 하지? 우선은 list에 result 값 넣어주는 것의 사이즈로 계산
    }

    static String getResult(int x, int n, int r, int[] result, ArrayList<int[]> results, int k) {
        if (x >= r) {
//            System.out.println(Arrays.toString(result));
            results.add(result);
            if (results.size() == k) {
                for (int i = 0; i < r; i++) {
                    System.out.printf("%d ", result[i]);
                }
                System.out.println();
                return "";
            }
        } else {
            for (int i = 1; i <= n; i++) {
                result[x] = i;
                getResult(x+1, n, r, result, results, k);
//                result[x] = 0; // 꼭 바꿔야 되나? -> 안해도 됨.!
            }
        }
        return Arrays.toString(result);
    }
}