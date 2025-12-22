package Hash;

import java.util.HashMap;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
// 문자열 -> 정수 로 변환
// 해시(Hash.Hash): 임의의 길이를 가진 데이터를 고정된 길이의 값으로 변환하는 알고리즘 또는 그
// Java에는 복잡한 해시를 직접 구현할 필요없이 쉽게 사용할 수 있도록 해주는 자료형인 HashMap, HashSet 등이 있다.

// 라빈카프 알고리즘
public class Hash {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();

//    System.out.println(solution(30, 1000, "abcd"));
    System.out.println(solution2(30, 1000, "abcd"));

    long finishTime = System.currentTimeMillis();
    long elapsedTime = finishTime - startTime;
    System.out.println(startTime);
    System.out.println(finishTime);
    System.out.println(elapsedTime);
  }

  public static long solution2(int x, int m, String myStr) {
    long answer = 0;
    long square = 1;
    for (int i = myStr.length() - 1; i >=0; i--) {
      long alphaNum = myStr.charAt(i) - 'a' + 1;
      answer += alphaNum * square % m;
      square = square * x % m;
    }
    return answer % m;
  }

  // 오답
  public static int solution(int x, int m, String myStr) {
//    HashMap<Character, Long> alphaNumMap = new HashMap<>();

    // 'a' = 97
//    for (int i = 'a'; i <= 'z'; i++) {
//      alphaNumMap.put((char)i, (long)i - 96);
////      System.out.println(alphaNumMap.get((char)i));
//    }
//    System.out.println("a: " + alphaNumMap.get('a'));

    // 자리수 / 해시값 (변환된 값)
    HashMap<Integer, Integer> map = new HashMap<>();
    char[] charArray = myStr.toCharArray();
    int len = charArray.length;
    for (int i = 0; i < len; i++) {
      long changedNum = charArray[i] - 'a' + 1; // a~z => 1~26 에 대응
      map.put(len - i, (int) (changedNum * Math.pow(x, len-i-1) % m));
//      System.out.println(map.get(len-i));
    }

    int total = 0;
    for (int i = 0; i < len; i++) {
      total += map.get(len - i);
    }

    return total % m;
//    return 28 % 100;
  }
}