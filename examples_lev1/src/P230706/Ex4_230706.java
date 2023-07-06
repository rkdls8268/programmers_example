package P230706;

import java.util.*;

public class Ex4_230706 {
    // 오픈채팅방
    public static void main(String[] args) {
        String[] record = {
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
        };

        System.out.println(Arrays.toString(solution(record)));
    }

    public static String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        Map<String, String> idNameMap = new HashMap<>();
        for (String r : record) {
            String[] split = r.split(" ");
            String status = split[0];
            String id = split[1];
            String name;
            switch (status) {
                case "Enter" -> {
                    name = split[2];
                    idNameMap.put(id, name);
                }
                case "Leave" -> {}
                case "Change" -> {
                    name = split[2];
                    idNameMap.replace(id, name);
                }
            }
        }
        for (String r : record) {
            String[] split = r.split(" ");
            String status = split[0];
            String id = split[1];
            if (status.equals("Change")) continue;
            answer.add(getMessage(status, idNameMap.get(id)));
        }
        return answer.toArray(new String[0]);
    }

    public static String getMessage(String status, String name) {
        String statusKor = "";
        if (status.equals("Enter")) statusKor = "들어왔습니다.";
        if (status.equals("Leave")) statusKor = "나갔습니다.";
        return name + "님이 " + statusKor;
    }
}
