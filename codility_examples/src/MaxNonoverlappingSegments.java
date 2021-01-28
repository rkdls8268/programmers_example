import java.util.*;

public class MaxNonoverlappingSegments {
    public static void main(String[] args) {
        int[] A = {1, 3, 7, 9, 9, 11, 12, 12, 15, 16};
        int[] B = {5, 6, 8, 9, 10, 12, 15, 16, 16, 18};
        int[] A1 = {0};
        int[] B1 = {0};
        System.out.println(solution(A, B));
        System.out.println(solution(A1, B1));
    }

    static int solution(int[] A, int[] B) {
        int len = A.length;
        ArrayList<Integer> list = new ArrayList<>();

        if (len > 0) list.add(0);
        for (int i = 0, j = 0; i < len-1; i++) {
            // overlap 부분이 없으면 list에 추가
            int last = list.get(list.size()-1);
            if (A[i+1] > B[last]) {
                list.add(i+1);
            }
        }
        return list.size();
    }
}
