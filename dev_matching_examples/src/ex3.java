import java.util.*;

public class ex3 {
    public static void main(String[] args) {
        String[] votes = {
                "AVANT", "PRIDO", "SONATE",
                "RAIN", "MONSTER", "GRAND", "SONATE",
                "AVANT", "SONATE", "RAIN", "MONSTER", "GRAND",
                "SONATE", "SOULFUL", "AVANT", "SANTA"
        };
        int k = 5;
        System.out.println(solution(votes, k));
    }

    public static String solution(String[] votes, int k) {
        String answer = "";

        HashMap<String, Integer> hm = new HashMap<>();
        for (String v : votes) {
            hm.put(v, hm.getOrDefault(v, 0) + 1);
        }
        System.out.println(hm.keySet() + ", " + hm.values());

        // 가장 큰 값 구하고
//        int[] values = new int[hm.values().size()];
//        for (int i = 0; i < values.length; i++) {
////            values[i] = hm.get()
//        }

        Integer[] hmArray = hm.values().toArray(new Integer[0]);
        Arrays.sort(hmArray);
        System.out.println(hmArray);

        return answer;
    }
}
