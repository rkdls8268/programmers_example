import java.util.Arrays;
import java.util.List;

public class SeoulKim {
    // 서울에서 김서방 찾기
    public static void main(String[] args) {
        String[] seoul = {"Jane", "Kim"};
        System.out.println(solution(seoul));
    }

    static String solution(String[] seoul) {
        String answer = "김서방은 ";
        List<String> list = Arrays.asList(seoul);
        answer += list.indexOf("Kim") + "에 있다";
//        answer = answer.formatted("김서방은 %d에 있다", list.indexOf("Kim"));
        // formatted 는 대체 어떻게 쓰는거지?

        return answer;
    }
}
