public class T1 {
    public static void main(String[] args) {
        String t = "MSSLS";
        System.out.println(solution(t));
    }

    static String solution(String T) {
        String answer = "";
        int len = T.length();
        int numOfS  = 0, numOfM = 0, numOfL = 0;
        for (int i = 0; i < len; i++) {
            if (T.charAt(i) == 'S') numOfS++;
            else if (T.charAt(i) == 'M') numOfM++;
            else if (T.charAt(i) == 'L') numOfL++;
        }

        for (int i = 0; i < numOfS; i++) {
            answer += "S";
        }
        for (int i = 0; i < numOfM; i++) {
            answer += "M";
        }
        for (int i = 0; i < numOfL; i++) {
            answer += "L";
        }
        return answer;
    }
}
