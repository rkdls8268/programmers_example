import java.util.HashSet;

public class HashSetSolution {

  public static void main(String[] args) {
    int[] queries = {1,2,1,2};
    System.out.println(solution(queries));
  }

  public static int solution(int[] queries) {
    int answer = 0;

    HashSet<Integer> set = new HashSet<>();
    for (int num : queries) {
      if (set.contains(num)) {
        set.remove(num);
      } else {
        set.add(num);
      }
    }

    answer = set.size();
    return answer;
  }
}
