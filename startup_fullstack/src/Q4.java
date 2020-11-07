import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q4 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        int[][] arr = new int[4][5];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int n = random.nextInt(40)+1;
                while (list.contains(n)) {
//                    System.out.println("n1: "+n);
                    // 1~40까지의 범위의 난수 발생
//                    n = random.nextInt(40)+1;
                    // or Math.random() 사용
                    n = (int) (Math.random() * 40 + 1);
                }
                // 순차적으로 나올 경우 예외처리 하는 건 어떻게 할까..
                list.add(n);
//                System.out.println(list);
                arr[i][j] = n;
            }
        }

//        list = IntStream.range(1, 41).boxed().collect(Collectors.toCollection(ArrayList::new));
//        Collections.shuffle(list);
//        list.subList(0, 5).forEach(System.out::println);


        System.out.println(Arrays.deepToString(arr));
    }

    static int[] solution(int[] numbers) {
        int[] answer = {};
        return answer;
    }
}
