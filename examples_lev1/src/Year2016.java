public class Year2016 {
    // 2016년
    public static void main(String[] args) {
        int a = 5;
        int b = 24;
        System.out.println(solution(a, b));
    }

    static String solution(int a, int b) {
        String answer = "";
//        String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        // SUN 부터 말고 FRI 부터 시작해도 됨!
        String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};

        int[] numOfDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int first = 0;
        for (int i = 0; i < a-1; i++) {
            first += numOfDays[i];
//            if (first > 0) System.out.println(day[first-1]);
//            else System.out.println(day[first - 1 + 7]);
        }
        first += (b - 1);
//        if (first > 0) {
//            answer = day[first - 1];
//        } else {
//            answer = day[first - 1 + 7];
//        }
        answer = day[first % 7];

        // 미리 first 에서 1을 빼주면 굳이 if-else 로 나눠서 할 필요 없음.

        return answer;
    }
}
