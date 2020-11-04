import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Q4 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        int[][] arr = new int[4][5];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int n = random.nextInt(40)+1;
                if (list.contains(n)) {
//                    System.out.println("n1: "+n);
                    do {
                        n = random.nextInt(40)+1;
                    } while (!list.contains(n));
                }
                list.add(n);
//                System.out.println(list);
                arr[i][j] = n;
            }
        }

        System.out.println(Arrays.deepToString(arr));
    }

    static int[] solution(int[] numbers) {
        int[] answer = {};
        return answer;
    }
}
