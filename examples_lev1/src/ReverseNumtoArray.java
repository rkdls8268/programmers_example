import java.util.Arrays;

public class ReverseNumtoArray {
    public static void main(String[] args) {
        long n = 12345;
        System.out.println(Arrays.toString(solution(n)));
    }

    static public int[] solution(long n) {
        int[] answer = {};
        // floor(log10(n)+1);

        String str = Long.toString(n);
        // System.out.println(Math.floor(Math.log10(n)));
        // int len = (int)(Math.floor(Math.log10(n))) + 1; // str.length() 잘된다,^^
        int len = str.length();
        answer = new int[len];
        for (int i = 0, j = len-1; i < len; i++, j--) {
            String subStr = str.substring(i, i+1);
            int res = Integer.parseInt(subStr);
            answer[j] = res;
        }

        return answer;
    }
}
