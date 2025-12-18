import java.util.Arrays;
import java.util.HashSet;

public class HashSolution4 {

  public static void main(String[] args) {
    int[] arr = {0, 1,1,2,3,4, 5, 6};
    System.out.println(solution2(arr));
  }

  public static int solution(int[] arr) {
    int answer = 0;

    HashSet<Integer> set = new HashSet<>();

    for (int num : arr) {
      set.add(num);
    }

    for (int i = 0; i < set.size(); i++) {
      if (set.contains(answer)) {
        // 다음 숫자 확인
        answer++;
      } else {
        // 그대로 return
        return answer;
      }
    }

    return answer;
  }

  public static int solution2(int[] arr) {
    int[] arr1 = new int[1000001];

    for (int i : arr) {
//      arr1[i] = 1;
      arr1[i] += 1; // 중복되는 개수 있을 수 있으므로??
    }

    for (int i = 0; i < arr1.length; i++) {
      if (arr1[i] == 0) {
        return i;
      }
    }
    return 0;
  }

}
