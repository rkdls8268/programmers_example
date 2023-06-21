import java.util.*;

public class NewsClustering {
    public static void main(String[] args) {
        String str1 = "e=m=c";
        String str2 = "e=m_c";
        System.out.println(solution(str1, str2));

    }
    // 두 집합이 모두 공집합인 경우 J(A, B) = 1

    public static int solution(String str1, String str2) {
        int answer;
        int numToTime = 65536;
        List<String> s1 = new ArrayList<>();
        List<String> s2 = new ArrayList<>();
        HashMap<String, Integer> hm1 = new HashMap<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            String sub = str1.substring(i, i + 2);
            if (sub.matches("^[a-zA-Z]*$")) s1.add(sub.toLowerCase());
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            String sub = str2.substring(i, i + 2);
            if (sub.matches("^[a-zA-Z]*$")) s2.add(sub.toLowerCase());
        }

        // 두 집합이 모두 공집합인 경우 1
        if (s1.size() == 0 && s2.size() == 0) {
            answer = numToTime;
        } else {
            // 그렇지 않은 경우
            for (String key : s1) {
                hm1.put(key, hm1.getOrDefault(key, 0) + 1);
            }
            List<String> intersection = new ArrayList<>();
            for (String s : s2) {
                if (hm1.containsKey(s)) {
                    if (hm1.get(s) > 0) {
                        intersection.add(s);
                        hm1.put(s, hm1.get(s) - 1);
                    }
                }
            }
            int intersectionSize = intersection.size();
            int unionSize = s1.size() + s2.size() - intersectionSize;
            answer = (int) ((double) intersectionSize / unionSize * numToTime);
        }
        return answer;
    }
}
