public class World124 {
    // 124나라
    /*
    3이 쓰이는 3진수라고 할 수 있다. (3일 때 바로 자리올림하지 않는 특이한 3진수)
    바이너리 트리에서 경로를 따라가며 레이블링 하는 것처럼
    자식을 3개 갖는 ternary tree를 따라가며 레이블링하는 것이라고 한다...^^
     */
    public static void main(String[] args) {
        int n = 15;
        System.out.println(solution(n));
    }

    static String solution(int n) {
        String answer = "";
        String[] numbers = {"4", "1", "2"};
        while (n > 0) {
            int remainder = n % 3;
            n /= 3;
            if (remainder == 0) {
                n--;
            }
            answer = numbers[remainder] + answer; // reverse 안해도 됨
        }
        return answer;
    }
}
