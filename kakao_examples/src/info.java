import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class info {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] info = {
                "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"
        };

        String[] query = {
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"
        };

        System.out.println(solution(info, query));

    }
    public static int[] solution(String[] info, String[] query) {
        int[] answer = {};

        int length = info.length;

//        HashMap<String, Integer> lang = new HashMap<>();
//        lang.put("cpp", 1);
//        lang.put("java", 2);
//        lang.put("python", 3);
//
//        HashMap<String, Integer> field = new HashMap<>();
//        lang.put("backend", 1);
//        lang.put("frontend", 2);
//
//        HashMap<String, Integer> level = new HashMap<>();
//        lang.put("junior", 1);
//        lang.put("senior", 2);
//
//        HashMap<String, Integer> food = new HashMap<>();
//        lang.put("chicken", 1);
//        lang.put("pizza", 2);

//        String[] lang = {"c++", "java", "python"};
//        String[] field = {"backend", "frontend"};
//        String[] level = {"junior", "senior"};
//        String[] food = {"chicken", "pizza"};


        ArrayList aLang = new ArrayList();
        ArrayList aField = new ArrayList();
        ArrayList aLevel = new ArrayList();
        ArrayList aFood = new ArrayList();
        ArrayList aScore = new ArrayList();


        for (String s : info) {
            String lang = s.split(" ")[0];
            aLang.add(lang);
        }

        for (String s : info) {
            String field = s.split(" ")[1];
            aField.add(field);
        }

        for (String s : info) {
            String level = s.split(" ")[2];
            aLevel.add(level);
        }

        for (String s : info) {
            String food = s.split(" ")[3];
            aFood.add(food);
        }

        for (String s : info) {
            String score = s.split(" ")[4];
            aScore.add(score);
        }

        System.out.println(aLang);
        System.out.println(aField);
        System.out.println(aLevel);
        System.out.println(aFood);
        System.out.println(aScore);

        ArrayList qLang = new ArrayList();
        ArrayList qField = new ArrayList();
        ArrayList qLevel = new ArrayList();
        ArrayList qFood = new ArrayList();
        ArrayList qScore = new ArrayList();

        String q1 = query[0];
//        q1.formatted();

        for (String s : query) {
            String lang = s.split(" and ")[0];

            if (s.split(" and ").length > 7) {
                break;
            }
            qLang.add(lang);
        }

        for (String s : query) {
            String field = s.split(" and ")[1];
            qField.add(field);
        }

        for (String s : query) {
            String level = s.split(" and ")[2];
            qLevel.add(level);
        }

        for (String s : query) {
            String food = s.split(" and ")[3];
            qFood.add(food);
        }

        for (String s : query) {
            String score = s.split(" ")[4];
            qScore.add(score);
        }

        System.out.println(qLang);
        System.out.println(qField);
        System.out.println(qLevel);
        System.out.println(qFood);
        System.out.println(qScore);


//        int[][] array = {
//                {},
//                {}
//        };

        return answer;
    }
}
