import java.util.*;

public class BPSearch1 {
    // Brute-Force Search: 완전 탐색
    public static void main(String[] args) {
        int[] answers = {2, 1, 1, 1};
        int[] answers2 = {1, 3, 2, 4, 2};
        System.out.println(Arrays.toString(solution(answers)));
        System.out.println(Arrays.toString(solution(answers2)));
    }

    public static int[] solution(int[] answers) {
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

//        int realCount = 1;
        int max = 0;
        int current = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < count.length; i++) {
            current = count[i];
            if (i == 0) {
//                System.out.println("current: "+current);
                max = count[i];
                list.add(i + 1);
//                System.out.println("1 list: "+list);
            } else {
                if (current > max) {
//                    System.out.println("current: "+current);
//                    realCount = 1;
                    max = current;
//                    System.out.println("before 2 list: "+list);

                    list.clear();
                    list.add(i + 1);
//                    System.out.println("after 2 list: "+list);

                } else if (current == max) {
//                    System.out.println("current(=max): "+current);
//                    realCount++;
                    list.add(i+1);
//                    System.out.println("3 list: "+list);
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
