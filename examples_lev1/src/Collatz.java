public class Collatz {
    // 콜라츠 추측
    public static void main(String[] args) {
        long n = 626331;
        System.out.println(solution(n));
    }

    static int solution(long num) {
        int answer = 0;
        // 입력된 수가 짝수라면 2로 나누기
        // 입력된 수가 홀수라면 3을 곱하고 1을 더하기
        // 1이 될 때까지 반복
        // 작업 횟수 리턴. 500번 이상 반복해도 안되면 -1 반복

        while (num != 1) {
            if (answer >= 500) {
                return -1;
            }
            if (num % 2 == 0) { // 짝수
                num /= 2;
            } else { // 홀수
                num = (num * 3) + 1;
            }
            answer++;
        }

//        for (int i = 0; i < 500; i++) {
//            if (num == 1) break;
//            if (num % 2 == 0) {
//                num /= 2;
//            } else {
//                num = num * 3 + 1;
//            }
//            answer++;
//        }
//
//        if (num != 1) answer = -1;

        return answer;
    }
}

// 626331의 경우 int의 범위를 넘어섯 계속 오류가 났었음. long으로 바꿔주니 해결!