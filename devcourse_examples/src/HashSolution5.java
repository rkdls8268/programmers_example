import java.util.Arrays;
import java.util.HashSet;

public class HashSolution5 {

  public static void main(String[] args) {
    String[] strs = {"aaa","bbb","abbc"};
    System.out.println(solution(strs));
  }

  public static String solution(String[] strs) {
    // 알파벳 소문자만큼 공간 확보 -> 인덱스에 해당하는 소문자 +1 (but 중복 허용 X)
    int[] alphas = new int[26];

    for (String str : strs) {
      HashSet<Character> seen = new HashSet<>();
      StringBuilder sb = new StringBuilder();
      for (char ch : str.toCharArray()) {
        if (seen.add(ch)) { // true 면 seen에 값이 없었다는 뜻. false 면 이미 들어가있다는 뜻
          sb.append(ch);
        }
      }

      for (char ch : sb.toString().toCharArray()) {
        // a -> 1
        int idx = ch - 'a';
        alphas[idx] += 1;
      }
    }

    int maxValue = Arrays.stream(alphas).max().getAsInt();

    StringBuilder answerSb = new StringBuilder();
    for (int i = 0; i < alphas.length; i++) {
      if (alphas[i] == maxValue) {
        answerSb.append((char) (i + 'a'));
      }
    }

    return answerSb.toString();
  }
}
