package kakao2022;

import java.util.*;

public class Report {
    public static void main(String[] args) {
        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3; // k번 이상 신고 당할 시 이용 정지
        System.out.println(Arrays.toString(solution(id_list, report, k)));
    }
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        List<String> idList = new ArrayList<>(Arrays.asList(id_list));
        Map<String, Set<String>> hm = new HashMap<>();
        for (String id : idList) {
            hm.put(id, new HashSet<>());
        }
        for (String r : report) {
            String[] fromTo = r.split(" ");
            String from = fromTo[0];
            String to = fromTo[1];

            // 누가 누구를 신고했는지도 가지고 있어야 함
            hm.get(to).add(from);
            hm.put(to, hm.get(to));
        }

        for (Map.Entry<String, Set<String>> entry : hm.entrySet()) {
            Set<String> list = entry.getValue();
            if (list.size() >= k) {
                // 신고한 사람이 k명 이상이면 이용정지
                for (String from : list) {
                    int idx = idList.indexOf(from);
                    answer[idx]++;
                }
            }
        }

        // 메일 처리 결과 리턴 (이용 정지 당한 유저를 신고한 사람만 메일을 받는다) 즉 muzi는 2건을 받아야 함
        return answer;
    }
}
