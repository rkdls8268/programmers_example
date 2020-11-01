public class WC2 {
    /*
    평문을 암호화시키는 알고리즘
    평문 'hellopython'에서 key에 해당하는 숫자만큼 더하고 rotation 시키면 암호화된 문장(encrypted_text)가 나온다.
    이 때 암호화된 문장을 다시 평문으로 바꾸는 알고리즘 구현해라
     */
    public static void main(String[] args) {
        String encrypted_text = "qyyigoptvfb";
        String key = "abcdefghijk";
        int rotation = 3;
        System.out.println(solution(encrypted_text, key, rotation));
    }

    static String solution(String encrypted_text, String key, int rotation) {
        String answer = "";
        String s = "";

        if (-rotation > 0) {
            int idx = -rotation % encrypted_text.length();
            System.out.println(idx);
            s = encrypted_text.substring(encrypted_text.length() - idx) + encrypted_text.substring(0, encrypted_text.length() - idx);
//            System.out.println(answer.substring(answer.length()-idx));
//            System.out.println(answer.substring(0, answer.length()-idx));
        } else {
            int idx = rotation % encrypted_text.length();
            s = encrypted_text.substring(idx) + encrypted_text.substring(0, idx);
//            System.out.println(answer.substring(answer.length()-idx));
//            System.out.println(answer.substring(0, answer.length()-idx));
        }

        for (int i = 0; i < s.length(); i++) {
            int alpha = (s.charAt(i) - (key.charAt(i) - 96));
            if (alpha < 97) alpha = alpha % 97 + 26;
            answer += (char)alpha;
        }

//        System.out.println((int)'z'); // 122
//        int a = 127;
//        a = a % 122 + 96;
//        System.out.println(a);

        return answer;
    }
}
