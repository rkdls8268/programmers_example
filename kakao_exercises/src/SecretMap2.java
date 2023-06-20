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
            String binary1 = Integer.toBinaryString(arr1[i]);
            String binary2 = Integer.toBinaryString(arr2[i]);
            String str1 = String.format("%0"+ n +"d", Long.parseLong(binary1));
            String str2 = String.format("%0"+ n +"d", Long.parseLong(binary2));
            StringBuilder result = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (str1.toCharArray()[j] == '1') result.append("#");
                if (str1.toCharArray()[j] == '0') result.append(" ");
                if (str2.toCharArray()[j] == '1') result.replace(j, j + 1, "#");
            }
            answer[i] = result.toString();
        }
        return answer;
    }

}
