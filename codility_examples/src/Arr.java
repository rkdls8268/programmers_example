import java.util.*;
public class Arr {
    public static void main(String[] args) {
        int[] A = {9, 3, 9, 3, 9, 7, 9};
        System.out.println(solution(A));
    }

    static int solution(int[] A) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int len = A.length;
        for (int i : A) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }
        System.out.println(hm);
        int answer = 0;
        for (int i : hm.keySet()) {
            if (hm.get(i) % 2 == 1) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}
