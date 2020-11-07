import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q6_20 {
    // logs 의미: "수험번호 문제번호 받은점수"
    public static void main(String[] args) {
        String[] logs = {
                "0001 3 95", "0001 5 90", "0001 5 100", "0002 3 95", "0001 7 80",
                "0001 8 80", "0001 10 90", "0002 10 90", "0002 7 80", "0002 8 80",
                "0002 5 100", "0003 99 90"
        };
        System.out.println(Arrays.toString(solution(logs)));
    }

    static String[] solution(String[] logs) {
        String[] answer = {};
        List<String> log = new ArrayList<>();
        List<List<String>> logList = new ArrayList<>();
        System.out.println(log);
        for (int i = 0; i < logs.length; i++) {
            String num = logs[i].substring(0, 4);
            String score = logs[i].substring(5);
            for (int j = 0; j < logs.length; j++) {
//                if (logList[j].log[0].contains(num)) {
//                    log.add(score);
//                } else {
//
//                }
            }
        }
        return answer;
    }
}
