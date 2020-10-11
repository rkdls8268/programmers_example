public class BPSearch2 {
    public static void main(String[] args) {
        String numbers = "17";
        System.out.println(solution(numbers));
    }

    public static int solution(String numbers) {
        int answer = 0;

        String[] sub = new String[numbers.length()];

        for (int i = 0; i < numbers.length(); i++) {
            String subStr = numbers.substring(i,i+1);
            sub[i] = subStr;
        }

        int len = sub.length;

        len*(len-1)*

        return answer;
    }
}
