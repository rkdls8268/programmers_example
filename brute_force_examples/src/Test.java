import java.util.*;

public class Test {
    // 프로그래머스 완전탐색 모의고사
    public static void main(String[] args) {
        int[] answers = {1,3,2,4,2};
        System.out.println(Arrays.toString(solution(answers)));
    }

    public static int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();

        int[] student1 = {1, 2, 3, 4, 5}; // 5마다 반복
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5}; // 8
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10

        Map<Integer, Integer> studentMap = new HashMap<>();
        studentMap.put(1, 0);
        studentMap.put(2, 0);
        studentMap.put(3, 0);

        for (int i = 0; i < answers.length; i++) {
            int currentAnswer = answers[i];
            if (currentAnswer == student1[i % student1.length]) studentMap.replace(1, studentMap.get(1) + 1);
            if (currentAnswer == student2[i % student2.length]) studentMap.replace(2, studentMap.get(2) + 1);
            if (currentAnswer == student3[i % student3.length]) studentMap.replace(3, studentMap.get(3) + 1);
        }

        int maxValue = Collections.max(studentMap.values());

        for (Map.Entry<Integer, Integer> entry : studentMap.entrySet()) {
            if(entry.getValue() == maxValue) answer.add(entry.getKey());
        }

        return answer.stream().mapToInt(x -> x).toArray();
    }
}
