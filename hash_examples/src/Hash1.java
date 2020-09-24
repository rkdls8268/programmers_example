import javax.sound.midi.SysexMessage;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Hash1 {
    // 완주하지 못한 선수
    // 참가자 중에는 동명이인이 있을 수 있음.
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden", "leo"};
        String[] completion = {"eden", "kiki", "leo"};
        System.out.println("\nanswer: " + solution(participant, completion));
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> hm = new HashMap<>();

        // getOrDefault(): 찾는 키가 존재하면 해당 키의 값을 반환하고 없으면 기본값을 반환함.

        // value 값을 참가자의 수로 지정하고 완주자는 -1 을 해주는 식으로 하면 된다. 마지막에 0이 아닌 참가자 즉, 1 이상이면 그 사람은 완주를 못한 것
        for (String p : participant) {
            hm.put(p, hm.getOrDefault(p, 0) + 1);
            System.out.println(hm.values()); // 값 출력하는 메서드
        }
        System.out.println("keyset: "+hm.keySet()); // 키 출력하는 메서드

        for (String c : completion) {
            hm.put(c, hm.get(c) - 1);
            System.out.println(hm.values());
        }

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0) {
                answer = key;
            }
        }

        return answer;
    }
}
