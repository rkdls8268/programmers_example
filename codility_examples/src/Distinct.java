import java.util.HashSet;

public class Distinct {
    public static void main(String[] args) {
        int[] A = {2, 1, 1, 2, 3, 1};
        System.out.println(solution(A));
    }

    static int solution (int[] A) {
        HashSet<Integer> hs = new HashSet<>();

        for (int i : A) {
            hs.add(i);
        }

        return hs.size();
    }
}
