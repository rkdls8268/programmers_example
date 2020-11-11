import java.util.Arrays;

public class SecretMap {
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        System.out.println(Arrays.toString(solution(n, arr1, arr2)));
    }

    static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        // 공백은 0, #은 1
        /*String[][] aaa = new String[n][n];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                aaa[i][j] = binaryNum(n, arr1[i]).substring(j, j+1);
            }
        }


        for (int i = 0; i < arr2.length; i++) {
            String replace = "";
            for (int j = 0; j < arr2.length; j++) {
                if (aaa[i][j].equals("1")) {
                    replace += "#";
                    continue;
                }
                aaa[i][j] = binaryNum(n, arr2[i]).substring(j, j+1);
                if (aaa[i][j].equals("1")) replace += "#";
                else replace += " ";
            }
            answer[i] = replace;
        }*/

        for (int i = 0; i < n; i++) {
            answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]); // 개쩐다..^^
            System.out.println(answer[i]);
            answer[i] = String.format("%"+n+"s", answer[i]); // 자릿수 맞춰주기 위함인 듯
            System.out.println(answer[i]);
            answer[i] = answer[i].replaceAll("1", "#");
            answer[i] = answer[i].replaceAll("0", " ");
        }

        return answer;
    }

    static String binaryNum(int n, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        while (k / 2 > 0) {
            sb.append(k % 2);
            k /= 2;
        }
        sb.append(k);
        while (sb.length() != n) {
            sb.append('0');
        }
        answer = sb.reverse().toString();
        return answer;
    }
}
