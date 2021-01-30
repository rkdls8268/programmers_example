public class CountDiv {
    public static void main(String[] args) {
        int A = 0;
        int B = Integer.MAX_VALUE;
        int K = Integer.MAX_VALUE;
        System.out.println(solution(A, B, K));
    }

    // 정수 [A...B] 범위 내에서 K로 나눌 수 있는 정수의 수를 반환
    static int solution (int A, int B, int K) {
        int start = (A % K) == 0 ? (A/K) : (A/K)+1;
        int end = B / K;

        return end - start + 1;
    }
}
