import java.util.*;

public class ex1 {
    public static void main(String[] args) {
        int N = 10;
        System.out.println(Arrays.toString(solution(N)));
    }

    public static int[] solution(int N) {
        int[] answer = {};
        answer = new int[2];
        List<Integer> list = new ArrayList<>();
        int S = 0;
        int realNum = N;
        String num = "";
        int sum = 0;
        for (int i = 9; i > 1; i--) {
//            System.out.println("i: " + i);
            while (N > 0) {
                num = (N % i) + num;
//                System.out.println(num);
                N /= i;
//                System.out.println(N);
            }
            if (num.contains("0")) {
//                System.out.println(num);
                num = num.replaceAll("0", "1");
//                System.out.println(num);
            }

            sum = 1;
            for (int s= 0; s < num.length(); s++) {
//                System.out.println("substring: "+num.substring(s, s+1));
//                System.out.println("sub: "+sub);

                sum *= Integer.parseInt(num.substring(s, s+1));

//                if (S != 0) {
//                    if (list.get(0) < sum) {
//                        list.remove(0);
//                        list.add(sum);
//                        answer[0] = i;
//                        answer[1] = sum;
////                        max = i;
//                    }
//                } else {
//                    list.add(sum);
//                    answer[0] = i;
////                    max = i;
//                    answer[1] = sum;
//                }

                if (!list.isEmpty()) {
                    if (list.get(0) < sum) {
                        list.remove(0);
                        list.add(sum);
                        answer[0] = i;
                        answer[1] = sum;
//                        max = i;
                    }
                } else {
                    list.add(sum);
                    answer[0] = i;
//                    max = i;
                    answer[1] = sum;
                }
            }

            System.out.println("sum: "+answer[1]+", max: "+answer[0]);
            num = "";
            N = realNum;
        }
        return answer;
    }
}
