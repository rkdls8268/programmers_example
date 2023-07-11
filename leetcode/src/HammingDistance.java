public class HammingDistance {
    // The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
    // Given two integers x and y, return the Hamming distance between them.
    // hamming distance 는 비트연산의 대표적인 문제
    public static void main(String[] args) {
        int x = 4;
        int y = 1;
        System.out.println(solution(x, y));
    }

    public static int solution(int x, int y) {
        int answer = 0;
//        String binX = Integer.toBinaryString(x);
//        String binY = Integer.toBinaryString(y);
//        int maxLen = Math.max(binX.length(), binY.length());
//        String formattedX = String.format("%0" + maxLen + "d", Long.parseLong(binX));
//        String formattedY = String.format("%0" + maxLen + "d", Long.parseLong(binY));
//
//        // ^ 연산자 -> 피연산자의 값이 서로 다를때만 1을 반환
//        for (int i = 0; i < maxLen; i++) {
//            answer += formattedX.toCharArray()[i] ^ formattedY.toCharArray()[i];
//        }
        
        // x, y의 비트별 xor 연산
        int xor = x ^ y;
        for (int i = 0; i < 32; i++) {
            answer += (xor >> i) & 1;
        }
        return answer;
    }
}
