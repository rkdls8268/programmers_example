import java.util.Set;
import java.util.HashSet;

class PrimeNumber {
    public int solution(String numbers) {
        int answer = 0;
        String[] sub = new String[numbers.length()];

        for (int i = 0; i < numbers.length(); i++) {
            String subStr = numbers.substring(i,i+1);
            sub[i] = subStr;
        }

        HashSet<Integer> set = new HashSet<>();

        for (int i = 1; i <= sub.length; i++) {
            permutation(sub, 0, i, set);
        }
        answer = set.size();
        return answer;
    }

    static void permutation(String[] arr, int depth, int n, Set set) {
        if (depth == n) {
            print(arr, n, set);
            return;
        }

        for (int i = depth; i < arr.length; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, set);
            swap(arr, depth, i);
        }
    }

    static void swap(String[] arr, int depth, int i) {
        String temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    static void print(String[] arr, int k, Set set) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < k; i++) {
            s.append(arr[i]);
        }

        primeNum(set, s);
    }

    static void primeNum(Set set, StringBuilder s) {
        int num = Integer.parseInt(String.valueOf(s));
        boolean isPrime = true;

        if (num <= 1) {
            return;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime) {
            set.add(num);
        }
    }
}