public class TieRopes {
    public static void main(String[] args) {
        int K = 4;
        int[] A = {1,2,3,4,1,1,3};
        System.out.println(solution(K, A));
    }

    static int solution(int K, int[] A) {
        int sum = 0, cnt = 0;
        for (int j : A) {
            sum += j;
//            System.out.println(sum);
            if (sum >= K) {
                cnt++;
                sum = 0;
            }
        }
        return cnt;
    }
}
