public class ex1 {
    public static void main(String[] args) {
        String s = "PM 10:58:01";
        int n = 100000;
        System.out.println(solution(s, n));
    }

    public static String solution(String p, int n) {
        // p: 시간, n: 초
        String answer = null;

        int newSec = Integer.parseInt(p.substring(9, 11));
        int newMin = Integer.parseInt(p.substring(6, 8));
        int newHr = Integer.parseInt(p.substring(3, 5));
        if (p.substring(0,2).equals("PM") && !p.substring(3, 5).equals("12")) newHr += 12;
        if (p.substring(0, 2).equals("AM") && p.substring(3, 5).equals("12")) newHr -= 12;

//        System.out.println(n/(60*60));
        newHr += n/(60*60);
        if (n/(60*60) > 0) {
            n -= n/(60*60)*60*60;
//            System.out.println(n);
        }
        newMin += n/60;
        newSec += n%60;

//        System.out.println(newHr +": "+newMin+": "+newSec);

//        if (newSec / 60 > 0) {
//            newMin += newSec/60;
//        }

//        if (n/60 > 0) {
////            int modSec = n%60;
//            newSec += n%60;
//            int minSec = n/60;
//            if (minSec >= 60) {
//                int hrMin = minSec/60;
//                newHr += hrMin;
//            }
////        }
//        int modSec = n%60;
//        int minSec = n/60;
////        int min
//        int hrMin = minSec/60;
//
//        System.out.println(modSec +", "+ minSec);

//        newSec += n;


        if (newSec/60 > 0) {
            newMin += newSec/60;
            newSec -= (newSec/60)*60;
        }
        if (newMin/60 > 0) {
            newHr += newMin/60;
            newMin -= (newMin/60)*60;
        }
        if (newHr/24 > 0) {
            newHr -= (newHr/24)*24;
        }

        String hr = newHr < 10 ? "0" + newHr : ""+newHr;
        String min = newMin < 10 ? "0" + newMin : ""+newMin;
        String sec = newSec < 10 ? "0" + newSec : ""+newSec;

        answer = hr + ":" + min + ":" + sec;
        return answer;
    }
}
