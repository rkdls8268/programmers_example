import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort1 {
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
        // 초기화는 항상 for문 밖에서^^
        answer = new int[commands.length];

        List<Integer> arrayList = new ArrayList<>();
        for (Integer a : array) {
            arrayList.add(a);
        }

        for (int i = 0; i < commands.length; i++) {
            // 배열을 추출하기 위해 list 로 바꿔서 subList 해주고
            List<Integer> subArrayList = arrayList.subList(commands[i][0]-1, commands[i][1]);
            int[] temp = new int[subArrayList.size()];
            int j = 0;
            for (Integer s : subArrayList) {
                temp[j++] = s;
            }

            // 정렬을 위해 다시 arrays로 바꿔준다..?!
            Arrays.sort(temp);
//            System.out.println(Arrays.toString(temp));
//            System.out.println("ans:"+temp[commands[i][2]-1]);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }
}

