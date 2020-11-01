public class NumOfChars {
    // 문자열 내 p와 y의 개수
    public static void main(String[] args) {
        String s = "pPoooyY";
        System.out.println(solution(s));
    }

    static boolean solution(String s) {
        boolean answer = true;
        s = s.toLowerCase();

        // 람다식
//        answer = s.chars().filter(e -> 'p' == e).count() == s.chars().filter(e -> 'y' == e).count();

        int numOfP = 0, numOfY = 0;
        for (Character c : s.toCharArray()) {
            if (c == 'p') numOfP++;
            if (c == 'y') numOfY++;
        }

        // +) 변수를 하나로 설정해서 p일 경우는 +, y일 경우는 - 해도 됨. 둘을 더해서 0이 되면 개수가 같음
        // +) s.equalsIgnoreCase 도 사용 가능

        answer = numOfP == numOfY;
        return answer;
    }
}
