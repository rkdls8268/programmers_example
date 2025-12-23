package HashMap;

// HashMap => (key, value) 로 이루어진 딕셔너리 형태
// 추가: put()
// 조회: get()
// 수정: replace()

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HashMapSolution1 {

  public static void main(String[] args) {
    String[] folderNames = {"bfs", "sort", "bruteforce", "hash", "bfs", "dfs", "sort", "sort"};
    System.out.println(Arrays.toString(solution(folderNames)));
  }

  public static String[] solution(String[] folder_names) {
    List<String> answerList = new ArrayList<>();
    // 바로 String[] 을 활용할 수 있음

    HashMap<String, Integer> map = new HashMap<>();
    for (String folderName : folder_names) {
      if (map.containsKey(folderName)) {
        // 키 값 이미 있으면 폴더 2개 이상
        int numOfNewFolder = map.get(folderName) + 1;
        map.replace(folderName, numOfNewFolder);
        String newFolderName = folderName + "_" + numOfNewFolder;
        answerList.add(newFolderName);
      } else {
        // 없으면 처음
        map.put(folderName, 0);
        answerList.add(folderName);
      }
    }

    return answerList.toArray(new String[0]);
  }
}
