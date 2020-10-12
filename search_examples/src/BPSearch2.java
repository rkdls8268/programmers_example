import java.util.*;

public class BPSearch2 {
    public static void main(String[] args) {
        String numbers = "011";
        System.out.println(solution(numbers));
    }

    static int solution(String numbers) {
        int answer = 0;

        String[] sub = new String[numbers.length()];

        for (int i = 0; i < numbers.length(); i++) {
//            int subStr = Integer.parseInt(numbers.substring(i,i+1));
            String subStr = numbers.substring(i,i+1);
            sub[i] = subStr;
        }
//        System.out.println("sub:" +Arrays.toString(sub));

        HashSet<Integer> set = new HashSet<>();

        for (int i = 1; i <= sub.length; i++) {
            permutation(sub, 0, i, set);
        }
        answer = set.size();

        return answer;
    }

    // 순열 코드
    // 순서 없이 n개 중에서 r개를 뽑는 경우
    static void permutation(String[] arr, int depth, int n, Set set) {
        if (depth == n) {
//            System.out.println(Arrays.toString(arr));
            print(arr, n, set);
//            String str = "";
//            for (int i = 0; i < arr.length; i++) {
//                str += arr[i];
//            }
//            System.out.println(str);
            return;
        }

       for (int i = depth; i < arr.length; i++) {
           swap(arr, depth, i);
//           System.out.println("1: "+Arrays.toString(arr));
           permutation(arr, depth + 1, n, set);
//           System.out.println("2: " +Arrays.toString(arr));
           swap(arr, depth, i);
//           System.out.println("3: "+Arrays.toString(arr));

       }
    }

    static void swap(String[] arr, int depth, int i) {
        String temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
//        String temp = arr[depth];
//        arr[i] += temp;
    }

    // 숫자 연결
    static void print(String[] arr, int k, Set set) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < k; i++) {
            s.append(arr[i]);
        }

        primeNum(set, s);
    }

    static void primeNum(Set set, StringBuilder s) {
//        System.out.println("set: "+set+ "s: "+s);

        int num = Integer.parseInt(String.valueOf(s));
        boolean isPrime = true;

        if (num <= 1) {
            return;
        }
        for (int i = 2; i < Math.sqrt(num); i++) {
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
