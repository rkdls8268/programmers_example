import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class T3 {
    public static void main(String[] args) {
        int[] A = {1, 2, 2, 6, 6, 6, 7, 8};
        System.out.println(solution2(A));
    }

    static int solution(int[] A) {
        int answer = 0;
        int len = A.length;
        ArrayList<Integer> list = new ArrayList<>();

        // 우선 falseSet 을 1~N 까지의 숫자로  채운다.
        HashSet<Integer> falseSet = new HashSet<>();
        for (int i = 0; i < len; i++) {
            falseSet.add(i+1);
        }
//        System.out.println(falseSet);

        for (int i = 0; i < len; i++) {
            // A[i]가 겹치는 숫자이면
            if (!falseSet.contains(A[i])) {
                // 이미 빠져나갔으므로 포함하지 않게 됨
                list.add(A[i]);
            } else { // 겹치지 않는 숫자이면
//                System.out.println(falseSet);
                falseSet.remove(A[i]);
            }
        }
//        System.out.println(falseSet); // 없는 리스트
//        System.out.println(list); // 중복된 값 -> 이거 변형해주면 됨

        // 다 크거나 작으면 sort 필요 없음. -> 어떻게 구현할까... 이거 구현하면서 시간 더 잡아먹을수도 있을 것 같다..
        Collections.sort(list); // 컬렉션 정렬
//        System.out.println(list);

        int k = 0;
        for (int i : falseSet) {
            answer += Math.abs(list.get(k) - i);
            k++;
        }

        if (answer > 1000000000) answer = -1;

        return answer;
    }

    static int solution2(int[] A) {
        int answer = 0;
        int len = A.length;
        Arrays.sort(A);

        // 우선 falseSet 을 1~N 까지의 숫자로  채운다.
        HashSet<Integer> falseSet = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            falseSet.add(i+1);
            set.add(i + 1);
        }
//        System.out.println(falseSet);
//        System.out.println(Arrays.toString(A));

        ArrayList<Integer> list = new ArrayList<>();
        int k = 0;
        for (int i : set) {
            if (i == A[k]) {
                falseSet.remove(i);
            } else {
                list.add(A[k]);
            }
            k++;
        }

        int j = 0;
        for (int i : falseSet) {
            answer += Math.abs(list.get(j) - i);
            j++;
        }

        if (answer > 1000000000) answer = -1;

        return answer;
    }
}
