package HashMap;

import java.util.Arrays;
import java.util.HashMap;

public class HashMapSolution2 {

  public static void main(String[] args) {
    String[][] genres = {
      {"horror", "drama", "SF"},
      {"horror", "detective", "suspense"},
      {"SF","fantasy","-"}
    };
    String[] queries = {"SF", "drama", "fantasy","romance"};
    System.out.println(Arrays.toString(solution(genres, queries)));
  }

  public static int[] solution(String[][] genres, String[] queries) {
    int[] answer = new int[queries.length];

    HashMap<String, Integer> map = new HashMap<>();

    for (String[] genreArray : genres) {
      for (String genre : genreArray) {
        if (map.containsKey(genre)) {
          map.replace(genre, map.get(genre) + 1);
        } else {
          map.put(genre, 1);
        }
      }
    }

    for (int i = 0; i < queries.length; i++) {
      answer[i] = map.getOrDefault(queries[i], 0);
    }

    return answer;
  }
}
