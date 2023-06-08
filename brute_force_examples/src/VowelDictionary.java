import java.util.ArrayList;
import java.util.List;

public class VowelDictionary {
    public static void main(String[] args) {
        String word = "AAE";
        System.out.println(solution(word));
    }

    public static int solution(String word) {
        List<String> dictionary = new ArrayList<>();
        String[] vowels = {"A", "E", "I", "O", "U"};
        int depth = 0;
        int len = vowels.length;
        String[] wordList = new String[len];
        dfs(dictionary, wordList, vowels, depth, len);
        return dictionary.indexOf(word) + 1;
    }

    public static void dfs(List<String> dictionary, String[] wordList, String[] vowels, int depth, int len) {
        if (depth == len) {
            // 더 내려갈 깊이가 없음. 새로운 분기로 가야함
            return;
        }

        for (int i = 0; i < len; i++) {
            wordList[depth] = vowels[i];
            String newWord = String.join("", wordList).substring(0, depth+1);
            dictionary.add(newWord);
            dfs(dictionary, wordList, vowels, depth + 1, len);
        }
//        재귀함수라 여기서 return 해도 결국 다 돌때까지 기다려야 함
//        if (dictionary.contains(word)) {
//            return dictionary.indexOf(word) + 1;
//        }
    }
}
