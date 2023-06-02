import java.util.HashMap;

public class Marathon {
    public static void main(String[] args) {
        String[] participant = {"leo", "jerry", "chris", "leo"};
        String[] completion = {"leo", "jerry", "chris"};
        System.out.println(solution(participant, completion));
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String p: participant) {
            hm.put(p, hm.getOrDefault(p, 0) + 1);
        }
        for (String c: completion) {
            hm.replace(c, hm.get(c) - 1);
        }
        for (String key: hm.keySet()) {
            if (hm.get(key) > 0) answer = key;
        }
//        for (Map.Entry<String, Integer> entry : hm.entrySet()) {
//            if (entry.getValue().equals(1)) answer = entry.getKey();
//        }
        return answer;
    }
}
