import java.util.HashSet;

public class FrogRiverOne {
    public static void main(String[] args) {
        int X = 5;
        int[] A = {1};
        System.out.println(solution(X, A));
    }

    static int solution(int X, int[] A) {
        HashSet<Integer> hs = new HashSet<>();
        int cnt = -1;
        for (int i : A) {
            hs.add(i);
            cnt++;
            if (hs.size() == X) break;
        }
        if (hs.size() != X) cnt = -1;
        return cnt;
    }
}

//ArrayList.contains 메서드 쓰다가 HashSet 사용하니까 복잡도가 O(n^2) -> O(n)으로 줄었다.