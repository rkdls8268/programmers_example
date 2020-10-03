import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Heap1 {
    public static void main(String[] args) {
        int[] scoville= {1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(solution(scoville, K));
    }

    public static int solution(int[] scoville, int K) {

        // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + 두 번째로 맵지 않은 음식의 스코빌 지수 * 2
        int answer = 0;

        int len = scoville.length;

        ArrayList<Integer> heap = new ArrayList<>();
        for (Integer s : scoville) {
            heap.add(s);
        }
        System.out.println(heap);

        int temp = 0;
        for (int i = 0; i < heap.size(); i++) {
            System.out.println("i: "+i);
            if (heap.get(i) < K) {
                temp = heap.get(i) + (heap.get(i + 1) * 2);
                System.out.println("i: "+heap.get(i) + ", i+1: "+heap.get(i+1));
//                heap.remove(i);
                System.out.println(heap.remove(i+1));
                System.out.println(heap.remove(i));
//                heap.remove(i+1);
                heap.add(0, temp);
                System.out.println(heap);
                answer++;
                i=-1;
            }
            Collections.sort(heap);
        }

        if (answer == len) answer = -1;
        return answer;
    }

}
