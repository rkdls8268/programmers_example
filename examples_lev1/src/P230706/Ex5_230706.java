package P230706;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex5_230706 {
    // 대충 만든 자판
    public static void main(String[] args) {
        String[] keymap = {"AA", "ACD"};
        String[] targets = {"B", "AC"};
        System.out.println(Arrays.toString(solution(keymap, targets)));
    }

    public static int[] solution(String[] keymap, String[] targets) {
        List<Integer> answer = new ArrayList<>();
        for (String target : targets) {
            int sumIdx = 0;
            for (char c : target.toCharArray()) {
                int minIdx = 0;
                for (String key : keymap) {
                    if (key.contains(String.valueOf(c))) {
                        int idx = key.indexOf(String.valueOf(c)) + 1;
                        if (minIdx == 0) minIdx = idx;
                        else minIdx = Math.min(minIdx, idx);
                    }
                }
                if (minIdx == 0) {
                    // 목표 문자열 작성 못할 경우 -1
                    sumIdx = -1;
                    break;
                }
                else sumIdx += minIdx;
            }
            answer.add(sumIdx);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
