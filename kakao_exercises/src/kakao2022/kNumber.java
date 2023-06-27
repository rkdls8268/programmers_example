package kakao2022;

public class kNumber {
    public static void main(String[] args) {
        int n = 4095;
        int k = 2;
        System.out.println(solution(n, k));
    }

    public static int solution(int n, int k) {
        int answer = 0;

        String target = Integer.toString(n, k);

        String[] list = target.split("0");

        for (String str : list) {
            if (!str.isBlank()) {
                long num = Long.parseLong(str);
                if (isPrime(num)) answer++;
            }
        }

        return answer;
    }

    public static boolean isPrime(long num) {
        if (num == 1) return false;
        if (num == 2) return true;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
