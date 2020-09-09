import java.util.ArrayList;
import java.util.Scanner;

public class number1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(solution(str));
    }

    // static 처리 안해줬더니 오류 남
    public static int solution(String s) {
        ArrayList<String> strList = new ArrayList<>();
        // 문자열 길이는 length() 사용
        strList.add(s.substring(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.substring(i-1) != s.substring(i)) {
                strList.add(s.substring(i));
            }
//            if (s.substring(i, i+1))

            System.out.println(strList);
        }
        int answer = 0;
        return answer;
    }
}
