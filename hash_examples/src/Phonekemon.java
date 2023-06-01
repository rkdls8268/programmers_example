import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class Phonekemon {
    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 2, 2, 2};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        LinkedHashSet<Integer> hashSet = Arrays
                .stream(nums)
                .boxed()
                .collect(Collectors.toCollection(LinkedHashSet::new));
        return Math.min(hashSet.size(), nums.length / 2);
    }
}
