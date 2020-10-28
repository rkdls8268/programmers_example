import java.util.HashSet;
import java.util.Set;

public class MakePrimeNum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 6, 4};
        System.out.println(solution(nums));
    }

    static int solution(int[] nums) {
        int answer = 0;
        int sum = 0;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
//                if (nums[i] == nums[j]) continue;
                for (int k = j+1; k < nums.length; k++) {
//                    if (nums[j] == nums[k] || nums[i] == nums[k]) continue;
                    sum = nums[i] + nums[j] + nums[k];
                    System.out.println("i:"+nums[i]+", j:"+nums[j]+", k:"+nums[k]);
                    System.out.println(sum);
                    if (isPrime(sum)) answer++;
//                    set.add(sum);
                }
            }
        }

//        System.out.println(set);
//        for (int s : set) {
//            if (isPrime(s)) answer++;
//        }

        return answer;
    }

    static Boolean isPrime(int n) {
        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
