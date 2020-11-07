import java.util.Arrays;
import java.util.List;

public class Q1_20 {
    // 우테코 20 첫 번째 문제
    public static void main(String[] args) {
        String[] grades = {"A+","D+","F","C0"};
        int[] weights = {2, 5, 10, 3};
        int threshold = 50;
        System.out.println(solution(grades, weights, threshold));
    }

    static int solution(String[] grades, int[] weights, int threshold) {
        int answer = -1234567890;

        String[] allGrades = {"A+", "A0", "B+", "B0","C+", "C0", "D+","D0","F"};
        List<String> gradesList = Arrays.asList(allGrades);
        int[] weightsOfGrades = {10, 9, 8, 7, 6, 5, 4, 3, 0};

        int graduation = 0;
        for (int i = 0; i < grades.length; i++) {
//            System.out.println("g:"+weightsOfGrades[gradesList.indexOf(grades[i])]);
            graduation += (weightsOfGrades[gradesList.indexOf(grades[i])] * weights[i]);
//            System.out.println(graduation);
        }
//        System.out.println(graduation);
        answer = graduation - threshold;

        return answer;
    }
}
