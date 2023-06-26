package kakao2018;

import java.util.Arrays;

public class SecretMap2 {
    public static void main(String[] args) {
        int n = 16;
        int[] arr1 = {46000, 3300, 65000 ,22000, 31000, 50000, 46000, 3300, 65000 ,22000, 31000, 50000, 46000, 3300, 65000 ,22000};
        int[] arr2 = {27000, 56000, 19000, 14000, 14000, 10000, 27000, 56000, 19000, 14000, 14000, 10000, 27000, 56000, 19000, 14000};
        System.out.println(Arrays.toString(solution(n, arr1, arr2)));
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            // 비트연산 사용 시 둘 중 하나라도 1인 경우 1로 표현된다.
            String binaryString = Integer.toBinaryString(arr1[i] | arr2[i]);
            answer[i] = String.format("%0"+ n +"d", Long.parseLong(binaryString));
            answer[i] = answer[i].replaceAll("1", "#");
            answer[i] = answer[i].replaceAll("0", " ");
        }
        return answer;
    }

}
