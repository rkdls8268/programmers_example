import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] count = new int[3];

        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int cnt1 = 0, cnt2 = 0, cnt3 = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == p1[i%p1.length]) {
                cnt1++;
                count[0] = cnt1;
            }
            if (answers[i] == p2[i%p2.length]) {
                cnt2++;
                count[1] = cnt2;
            }
            if (answers[i] == p3[i%p3.length]) {
                cnt3++;
                count[2] = cnt3;
            }
        }

        int max = 0;
        int current = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < count.length; i++) {
            current = count[i];
            if (i == 0) {
                max = count[i];
                list.add(i + 1);
            } else {
                if (current > max) {
                    max = current;

                    list.clear();
                    list.add(i + 1);

                } else if (current == max) {
                    list.add(i+1);
                }
            }
        }
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}