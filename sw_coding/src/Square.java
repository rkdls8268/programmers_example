public class Square {
    // 멀쩡한 사각형
    public static void main(String[] args) {
        int w = 8;
        int h = 12;
        System.out.println(solution(w, h));
    }

    static long solution(int w, int h) {
        long answer = w*h;
        long max = Math.max(w, h);
        long min = Math.min(w, h);

        long gcd = gcd(max, min);

        long cannotUse = w+h-gcd;
        // 기울기
//        float gradient = (float)h/(float)w;

//        for (int i = 1; i < w; i++) {
//            System.out.println(i*n);
//            if ((i*gradient)%1 == 0) cannotUse--;
//        }
        answer -= cannotUse;
        return answer;
    }

    static long gcd(long max, long min) {
        // 유클리드 호제법
        // max, min 을 미리 계산해주면 swap 안해줘도 됨!
//        if (w < h) {
//            long temp = w;
//            w = h;
//            h = temp;
//        }
        while (!(min==0)) {
            long r = max % min;
            max = min;
            min = r;
        }
        return max;
    }
}
