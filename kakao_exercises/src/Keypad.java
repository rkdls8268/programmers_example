import java.util.Arrays;

public class Keypad {
    // [카카오 인턴] 키패드 누르기
    public static void main(String[] args) {
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";
        System.out.println(solution(numbers, hand));
    }

    static String solution(int[] numbers, String hand) {
        String answer = "";
        int[][] keypad = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {-1, 0, -2}
        };
        // 1, 4, 7 은 왼쪽
        // 3, 6, 9 는 오른쪽
        // 2, 5, 8, 은 더 가까운 쪽에 있는 손이, 거리가 같으면 왼손잡이는 왼손, 오른손잡이는 오른손

        int[] prevLeft = {3, 0}; // * 왼손 처음 키패드
        int[] prevRight = {3, 2}; // # 오른손 처음 키패드

        int[] toGo = new int[2]; // 누를 키패드

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer += "L";
//                System.out.println("prev: "+Arrays.toString(prevLeft));
                toGo[0] = numbers[i] / 3;
                toGo[1] = 0;
//                System.out.println("prevLeft: "+Arrays.toString(prevLeft));
                prevLeft[0] = toGo[0];
                prevLeft[1] = toGo[1];
//                System.out.println("after: "+Arrays.toString(prevLeft));
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answer += "R";
                toGo[0] = numbers[i] / 3 - 1;
                toGo[1] = 2;
//                System.out.println("prevRight: "+Arrays.toString(prevRight));
                prevRight[0] = toGo[0];
                prevRight[1] = toGo[1];
//                System.out.println("after: "+Arrays.toString(prevRight));
            } else {
//                System.out.println("else");
                if (numbers[i] == 0) toGo[0] = 3;
                else {
                    toGo[0] = numbers[i] / 3;
                }
                toGo[1] = 1;
//                System.out.println(toGo[0]-prevLeft[0]);
                // 거리 계산해서 더 가까운 손으로 누르기 만약 거리가 같으면 왼손잡이는 왼손으로 오른손잡이는 오른손으로 누르기
                int l = Math.abs(toGo[0]-prevLeft[0]) + Math.abs(toGo[1]-prevLeft[1]);
                int r = Math.abs(toGo[0]-prevRight[0]) + Math.abs(toGo[1]-prevRight[1]);
                if (l > r ) {
                    answer += "R";
                    prevRight[0] = toGo[0];
                    prevRight[1] = toGo[1];
                } else if (l < r) {
                    answer += "L";
                    prevLeft[0] = toGo[0];
                    prevLeft[1] = toGo[1];
                } else {
                    System.out.println("1:" + hand);
                    if (hand.equals("right")) {
                        answer += "R";
                        prevRight[0] = toGo[0];
                        prevRight[1] = toGo[1];
                    } else {
                        answer += "L";
                        prevLeft[0] = toGo[0];
                        prevLeft[1] = toGo[1];
                    }
                }
            }
        }

        return answer;
    }
}
