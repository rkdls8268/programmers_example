import java.util.Arrays;

public class PermMissingElem {
    public static void main(String[] args) {
        int[] A = {2, 3, 1, 5};
        System.out.println(solution(A));
    }

    static int solution(int[] A) {
        int answer = 0;
        int len = A.length;
        Boolean[] arr = new Boolean[len+1];
        Arrays.fill(arr, false);

        for (int i : A) {
            arr[i-1] = true;
        }

        for (int i = 0; i < len+1; i++) {
            if (!arr[i]) answer = i+1;
        }

        return answer;
    }
}
