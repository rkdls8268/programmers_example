import java.util.HashMap;

public class Hash1 {
    // 완주하지 못한 선수
    // 참가자 중에는 동명이인이 있을 수 있음.
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden", "leo"};
        String[] completion = {"eden", "kiki", "leo"};
        System.out.println(solution(participant, completion));
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        int val = 0;

        //
        HashMap<String, Integer> hm = new HashMap<>();
        int i = 0;

        for (String p : participant) {
            hm.put(p, i++);
            System.out.println(hm.get(p));
//            System.out.println(hm.get("eden"));

        }

        // 향상된 for 문: foreach 문
        for (String c : completion) {
            val = hm.get(c);
            System.out.println("val: " + val);
            System.out.println(hm.put(c,val));
        }

        // 인덱스를 활용해주자

        for (String key : hm.keySet()) {
            System.out.println(key);
            if (hm.get(key) == 1) {
                answer = key;
            }
        }
        System.out.println(hm.keySet());

        return answer;
    }
}
