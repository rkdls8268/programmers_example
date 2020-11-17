public class Ceaser {
    // 시저 암호
    /*
    어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방
     */
    public static void main(String[] args) {
        String s = "a B z";
        int n = 4;
        System.out.println(solution(s, n));
    }

    static String solution(String s, int n) {
        String answer = "";
//        System.out.println((int)'A');
//        System.out.println((int)'Z');
//        System.out.println((int)'a');
//        System.out.println((int)'z');

        // n = n % 26; // 27하고 1은 똑같으니까

        for (char c : s.toCharArray()) {
            int num = c + n;
//            if (Character.isLowerCase(c)) & if (Character.isUpperCase(c)) 사용 가능
            if (c >= 'a' && c <= 'z') {
                if (num > 'z') { // 'z' 를 포함시킬 필요 없음
//                    num = (num % 122) + 96;
                    num -= 26;
                }
//                System.out.println(num);
//                System.out.println((char) (num));
                answer += (char) num;
            } else if (c >= 'A' && c <= 'Z') {
//                System.out.println("2:" + c);
                if (num > 'Z') {
//                    num = ((c + n) % 90) + 64;
                    num -= 26;
                }
                answer += (char) num;
            } else {
                answer += c;
            }
        }

        return answer;
    }
}
