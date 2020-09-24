import java.util.HashMap;

public class Hash2 {
    // 전화번호 목록
    public static void main(String[] args) {
        String[] phone_book = {"123", "12456", "256"};
        System.out.println(solution(phone_book));
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        HashMap<String, Integer> hm = new HashMap<>();

        // 123 , 123456

        for (String pb : phone_book) {
            hm.put(pb, hm.getOrDefault(pb, 0) + 1);
        }

        for (String key : hm.keySet()) {
            System.out.println("key: "+key);

            for (String itr : hm.keySet()) {
                System.out.println(itr);
                if (key.startsWith(itr)) {
                    hm.put(key, hm.get(key) - 1);
                }
            }

            System.out.println(hm.values());
            if (hm.get(key) < 0) {
                answer = false;
            }
        }

        return answer;
    }
}
