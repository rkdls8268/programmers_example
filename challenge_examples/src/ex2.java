public class ex2 {
    // 3진법 뒤집기
    public static void main(String[] args) {
        int n = 1000000000;
        System.out.println(solution(n));
    }

    static int solution(int n) {
        int answer = 0;
        String num = "";

        while (n / 3 > 0) {
            num += (n % 3);
            n /= 3;
        }
        num += n;

        // 아래 방식으로 하면 NumberFormatException 발생
//        int n1  = 0;
//        try {
//            n1 = Integer.parseInt(num);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
////        System.out.println(n1);
//
//        String s = "";
//        s += n1;
//
        for (int i = num.length()-1, j = 0; i >= 0; i--, j++) {
//            System.out.println("s:"+num.charAt(i));
            answer += (Integer.parseInt(num.substring(i, i+1))*Math.pow(3, j));
        }
        return answer;
    }
}