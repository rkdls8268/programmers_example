import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordChain {
    // 영어 끝말잇기
    public static void main(String[] args) {
        int n = 2;
        String[] words = {
//            "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"
//                "hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"
                "hello", "one", "even", "never", "now", "world", "draw"
        };
        System.out.println(Arrays.toString(solution(n, words)));
    }

    static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        // 포함되는 단어나 끝말잇기가 제대로 안 된 경우 -> 실패(그 사람 인덱스, 몇회째에 실패했는지)
        int idx = 0;
        int cnt = 0;

        List<String> list = new ArrayList<>();
        list.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if ((words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0))
                    || list.contains(words[i])) {
                idx = (i % n) + 1;
                cnt = (i / n) + 1;
                break;
            }
            list.add(words[i]);
        }

        answer[0] = idx;
        answer[1] = cnt;
        return answer;
    }
}
