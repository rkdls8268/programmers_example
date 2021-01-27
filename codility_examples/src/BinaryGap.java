// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class BinaryGap {
    public static void main(String[] args) {
        int N = 1041;
        System.out.println(solution(N));
    }
    static int solution(int N) {
//        String binNum = "";
        ArrayList<Integer> list = new ArrayList<>();

        while (N > 0){
//            binNum += (N % 2);
            list.add(N % 2);
            N /= 2;
        }
//        System.out.println(list);
        ArrayList<Integer> list2 = new ArrayList<>();
        int len = list.size();
        for (int i = 0; i < len; i++) {
            if (list.get(i) == 1) {
                list2.add(i);
            }
        }
//        System.out.println(list2);
        int len2 = list2.size();
        int max = 0;

        for (int i = len2 - 1 ; i > 0; i--) {
            int res = list2.get(i) - list2.get(i-1) - 1;
            if (i == len2 - 1) {
                max = res;
            }
            else {
                if (max < res) {
                    max = res;
                }
            }
        }

        return max;
    }
}
