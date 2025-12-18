import java.util.Arrays;
import java.util.HashSet;

public class HashSolution3 {

  public static void main(String[] args) {
    String str1 = "aabcddd";
    String str2 = "bbcdeee";
    System.out.println(solution(str1, str2));
  }

  public static int solution(String str1, String str2) {
    int answer = 0;

    HashSet<Character> str1Set = new HashSet<>();
    for (char alpha : str1.toCharArray()) {
      str1Set.add(alpha);
    }

    HashSet<Character> str2Set = new HashSet<>();
    for (char alpha : str2.toCharArray()) {
      str2Set.add(alpha);
    }

    for (char ch2 : str2Set) {
      if (str1Set.contains(ch2)) {
        str1Set.remove(ch2);
      } else {
        str1Set.add(ch2);
      }
    }

    answer = str1Set.size();
    return answer;
  }

}
