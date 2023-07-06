package P230706;

import java.util.*;
import java.util.stream.Collectors;

public class Ex3_230706 {
    // 폰켓몬
    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,4};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        Set<Integer> numberSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return Math.min(numberSet.size(), nums.length / 2);
    }
}
