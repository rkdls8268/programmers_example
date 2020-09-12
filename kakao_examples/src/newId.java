import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class newId {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
//        System.out.println(newid(str));
        System.out.println(solution(str));
    }

    public static String newid(String new_id) {
        String answer = "";

//        ...!@BaT#*..y.abcdefghijklm

        answer += new_id;

        // 대문자를 소문자로
        answer = answer.toLowerCase();
        System.out.println("answer 1:"+answer);

        // 특수문자 제거 (-, _, .) 만 사용 가능, 알파벳소문자, 숫자 // 95, 45, 46, 48-57, 97-122

        answer = answer.replaceAll("[^-_.0-9a-z]", "");
        System.out.println("answer 2:"+answer);

//        for (int i = 0; i < answer.length(); i++) {
//            if (answer.matches("[0-9a-z]")) {
//                System.out.println("here with "+ answer.charAt(i));
//            }
////            if (!(answer.contains("-") && answer.contains("_") && answer.contains(".") && answer.contains("[^a-z]"))) {
////                System.out.println("here with "+ answer.charAt(i));
////                answer = sb.deleteCharAt(i).toString();
////            }
//        }
//        System.out.println("answer 2:"+answer);


        // ... 및 .. 이 . 하나로

        StringBuffer sb = new StringBuffer(answer);
        ArrayList deleteList = new ArrayList();

        for (int i = 1; i < answer.length(); i++) {
            if (answer.charAt(i) == '.' && answer.charAt(i) == answer.charAt(i-1)) {
                deleteList.add(i);
            }
        }
        Collections.reverse(deleteList);
        deleteList.forEach(e -> {
            sb.deleteCharAt((Integer) e);
        });
        answer = sb.toString();
        System.out.println("answer 3:"+answer);



        StringBuffer sb2 = new StringBuffer(answer);

        // 아이디의 처음과 끝에 위치한 . 제거

        answer = answer.startsWith(".") ? sb2.deleteCharAt(0).toString() : answer;

//        System.out.println(sb2.deleteCharAt(answer.length()));
        answer = answer.endsWith(".") ? sb2.deleteCharAt(answer.length()-1).toString() : answer;

        System.out.println("answer 4:" + answer);

        // 아이디가 빈 문자열이면 a 대입

        if (answer.isEmpty()) {
            answer = "a";
        }
        System.out.println("answer 5:"+answer);

        // 아이디 길이 16자 이상이면 15자로 자르기

        if (answer.length() > 14) {
            answer = answer.substring(0, 15);

            StringBuffer sb3 = new StringBuffer(answer);
            answer = answer.endsWith(".") ? sb3.deleteCharAt(answer.length()-1).toString() : answer;
        }

        // 아이디의 길이가 2자 이하면 마지막 문자를 반복

        if (answer.length() < 3) {
            System.out.println("length:"+answer.length());
//            System.out.println("2:"+answer.substring(answer.length()-1));
            String last = answer.substring(answer.length()-1);
            for (int i = answer.length(); i < 3; i++) {
                System.out.println(answer.length());
                answer = answer.concat(last);
            }
        }

        System.out.println(answer);

//        String answer = answer;
        return answer;
    }

    public static String solution(String newID) {
        String answer = "";

        answer += newID;

        // 대문자를 소문자로
        answer = answer.toLowerCase();

        // 특수문자 제거 (-, _, .) 만 사용 가능, 알파벳소문자, 숫자 // 95, 45, 46, 48-57, 97-122

        answer = answer.replaceAll("[^-_.0-9a-z]", "");

        // ... 및 .. 이 . 하나로

        StringBuffer sb = new StringBuffer(answer);
        ArrayList deleteList = new ArrayList();

        for (int i = 1; i < answer.length(); i++) {
            if (answer.charAt(i) == '.' && answer.charAt(i) == answer.charAt(i-1)) {
                deleteList.add(i);
            }
        }
        Collections.reverse(deleteList);
        deleteList.forEach(e -> {
            sb.deleteCharAt((Integer) e);
        });
        answer = sb.toString();

        // 아이디의 처음과 끝에 위치한 . 제거

        StringBuffer sb2 = new StringBuffer(answer);

        answer = answer.startsWith(".") ? sb2.deleteCharAt(0).toString() : answer;
        answer = answer.endsWith(".") ? sb2.deleteCharAt(answer.length()-1).toString() : answer;

        // 아이디가 빈 문자열이면 a 대입

        if (answer.isEmpty()) {
            answer = "a";
        }

        // 아이디 길이 16자 이상이면 15자로 자르기

        if (answer.length() > 14) {
            answer = answer.substring(0, 15);

            StringBuffer sb3 = new StringBuffer(answer);
            answer = answer.endsWith(".") ? sb3.deleteCharAt(answer.length()-1).toString() : answer;
        }

        // 아이디의 길이가 2자 이하면 마지막 문자를 반복

        if (answer.length() < 3) {
            String last = answer.substring(answer.length()-1);
            for (int i = answer.length(); i < 3; i++) {
                System.out.println(answer.length());
                answer = answer.concat(last);
            }
        }

        return answer;
    }
}
