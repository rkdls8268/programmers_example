public class AddDigit {
    // 자릿수 더하기
    public static void main(String[] args) {
        int n = 123;
        System.out.println(solution(n));
        System.out.println(solution2(n));
    }

    static int solution(int n) {
        int answer = 0;
        String s = "";
        s += n;
        for (int i = 0; i < s.length(); i++) {
            answer += Integer.parseInt(s.substring(i, i + 1));
        }
        return answer;
    }

    static int solution2(int n) {
        int answer = 0;
        while (n > 0) {
            answer += (n % 10);
            n = n / 10;
        }
        return answer;
    }
}
