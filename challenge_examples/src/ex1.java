import java.util.*;

public class ex1 {
    // 두 개 뽑아서 더하기
    public static void main(String[] args) {
        int[] numbers = {2, 1, 3, 4, 1};
        System.out.println(Arrays.toString(solution(numbers)));
    }

    static int[] solution(int[] numbers) {
        int[] answer = {};

        // Set은 중복을 허용하지 않는 데이터의 집합!
        // HashSet: 데이터의 순서를 전혀 보장하지 않음
        // LinkedHashSet: 추가된 순서에 따라 저장
        // TreeSet: 자동으로 정렬(default는 오름차순)해서 저장
        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                int sum = numbers[i]+numbers[j];
                set.add(sum);
            }
        }

        answer = new int[set.size()];
        int i = 0;
        for (int s : set) {
            answer[i] = s;
            i++;
        }
        return answer;
    }
}
