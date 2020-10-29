public class Square {
    public static void main(String[] args) {
        int w = 8;
        int h = 12;
        System.out.println(solution(w, h));
    }

    static long solution(int w, int h) {
        long answer = w*h;
        long cannotUse = 0;



        answer -= cannotUse;
        return answer;
    }
}
