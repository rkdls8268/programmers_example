import java.util.*;

public class WC1 {
    public static void main(String[] args) {
        int n = 6;
        int[][] delivery = {
                {1, 3, 1}, {3, 5, 0}, {5, 4, 0}, {2, 5, 0}
        };
        int n1 = 7;
        int[][] delivery1 = {
                {5,6,0},{1,3,1},{1,5,0},{7,6,0},{3,7,1},{2,5,0}
        };
        System.out.println(solution(n, delivery));
        System.out.println(solution(n1, delivery1));
    }

    static String solution(int n, int[][] delivery) {
        String answer = "";
        String[] arr = new String[n];
        Arrays.fill(arr, "?");

        Set<Integer> OSet = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        Set<Integer> XSet = new HashSet<>();

//        for (int i = 0; i < n; i++) {
//            set.add(i+1);
//        }

        for (int[] d : delivery) {
            int a = d[0];
            int b = d[1];
            int c = d[2];
            if (c == 1) {
                OSet.add(a);
                OSet.add(b);
            } else {
                if (OSet.contains(a)) {
                    XSet.add(b);
                }
                else if (OSet.contains(b)) {
                    XSet.add(a);
                } else {
                    if (XSet.contains(a)) set.add(b);
                    if (XSet.contains(b)) set.add(a);
                    if (!XSet.contains(a) && !XSet.contains(b)) {
                        set.add(a);
                        set.add(b);
                    }
                }

            }
            System.out.println("O: "+OSet);
            System.out.println("X: "+XSet);
            System.out.println("?: "+set);
        }

        for (int a : OSet) {
            arr[a-1] = "O";
        }
        for (int b : XSet) {
            arr[b - 1] = "X";
        }

        for (String s : arr) {
            answer += s;
        }

        return answer;
    }
}
