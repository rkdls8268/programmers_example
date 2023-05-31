import java.util.ArrayList;
import java.util.List;

public class BruteForce1 {
    // 프로그래머스 완전탐색 최소 직사각형
    public static void main(String[] args) {
        int[][] sizes = {
                {14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}
        };
        System.out.println(solution(sizes));
    }

    public static int solution(int[][] sizes) {
        List<Integer> widthList = new ArrayList<>();
        List<Integer> heightList = new ArrayList<>();
        for (int[] size : sizes) {

            if (size[0] < size[1]) {
                // swap
                int temp;
                temp = size[0];
                size[0] = size[1];
                size[1] = temp;
            }
            widthList.add(size[0]);
            heightList.add(size[1]);
        }

        int width = widthList.stream().mapToInt(x -> x).max().orElseThrow();
        int height = heightList.stream().mapToInt(x -> x).max().orElseThrow();

        return width * height;
    }
}
