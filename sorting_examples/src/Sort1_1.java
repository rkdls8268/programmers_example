import java.util.Arrays;

public class Sort1_1 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };
        System.out.println(Arrays.toString(solution(array, commands)));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] subArray = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
//            System.out.println(Arrays.toString(subArray));
            Arrays.sort(subArray);
            answer[i] = subArray[commands[i][2]-1];
        }

        return answer;
    }
}
