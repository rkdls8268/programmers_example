import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class PrimeNum {
    public static void main(String[] args) {
        String numbers = "011";
        System.out.println(solution(numbers));
    }

    public static int solution(String numbers) {
        int answer = 0;
        List<Integer> numberList = new ArrayList<>();
        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        for (char n: numbers.toCharArray()) {
            numberList.add(Integer.parseInt(String.valueOf(n)));
        }

        int[] arr = numberList.stream().mapToInt(x -> x).toArray();
        int n = arr.length;
        boolean[] visited = new boolean[n];
        int depth = 0;
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i < n + 1; i++) {
            int[] output = new int[i];
            set.addAll(permutation(arr, output, result, visited, depth, n, i));
        }
        for (int r: set) {
            if (isPrimeNumber(r)) answer++;
        }
        return answer;
    }

    public static List<Integer> permutation(int[] arr, int[] output, List<Integer> result, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            String str = Arrays.toString(output);
            int num = Integer.parseInt(str.substring(1, str.length() - 1).replace(", ", ""));
            result.add(num);
            return result;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                permutation(arr, output, result, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
        return result;
    }

    public static boolean isPrimeNumber(int num) {
        // 소수 판별 함수
        boolean isPrime = true;
        if (num == 0 || num == 1) return false;
        if (num == 2 || num == 3) return true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return isPrime;
    }
}
