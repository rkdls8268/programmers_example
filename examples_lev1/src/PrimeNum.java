public class PrimeNum {
    // 소수찾기
    public static void main(String[] args) {
        int n = 20;
        System.out.println(solution(n));
    }

    static int solution(int n) {
        int answer = n-1;
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    answer--;
                    break;
                }
            }
        }

        return answer;
    }
}
