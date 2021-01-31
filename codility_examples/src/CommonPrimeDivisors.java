public class CommonPrimeDivisors {
    public static void main(String[] args) {
        int[] A = {15, 10, 3};
        int[] B = {75, 30, 5};
        System.out.println(solution(A, B));
    }

    static int solution(int[] A, int[] B) {
        int cnt = 0;
        int len = A.length;
        int GCD = 1;

        for (int i = 0; i < len; i++) {
            int a = Math.max(A[i], B[i]), b = Math.min(A[i], B[i]);
            if (a == b) { // 미리 같은 것은 제외해두면 최대공약수 계산 등 할 필요 없음
                cnt++;
                continue;
            }

            while (true) {
                int r = a % b;
                if (r == 0) {
                    GCD = b;
                    break;
                }
                a = b;
                b = r;
            }
            if (GCD != 1) { // GCD 가 1이면 무조건 다른 소수인 공약수 있음
                int k = 0;
                if (A[i] > B[i]) k = A[i] / GCD;
                else k = B[i] / GCD;
                if (k >= GCD) {
                    if (k % GCD == 0) cnt++;
                } else {
                    if (GCD % k == 0) cnt++;
                }
            }
        }
        return cnt;
    }
}
