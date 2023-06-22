import java.util.*;

public class ShuttleBus {
    public static void main(String[] args) {
        int n = 10;
        int t = 25;
        int m = 1;
        String[] timetable = {"09:00", "09:10" ,"09:20" ,"09:30" ,"09:40" ,"09:50",
                "10:00", "10:10" ,"10:20" ,"10:30" ,"10:40" ,"10:50"};
        System.out.println(solution(n, t, m, timetable));
    }

    public static String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        // 시간 순 정렬
        Arrays.sort(timetable);
        String currentBusTime = "09:00";
        List<String> getOn = new ArrayList<>();
        int cnt = 1;

        for (int i = 0; i < timetable.length; i++) {
            if (cnt == n) {
                // 현재 버스가 마지막일 경우
                if (isEarlier(timetable[i], currentBusTime, true)) {
                    // 탑승 인원 아직 안찼다면
                    if (getOn.size() == m - 1) {
                        // 탑승 인원 한자리 남았다면
                        answer = minusOneMinute(timetable[i]);
                        i = timetable.length;
                    } else if (getOn.size() < m) {
                        getOn.add(timetable[i]);
                    }
                } else {
                    // 현재 버스에 탈 수 없으므로 반복문 끝내기
                    i = timetable.length;
                }
            } else {
                // 현재 버스에 탈 수 있는 사람이면
                if (isEarlier(timetable[i], currentBusTime, true)) {
                    // 탑승 인원 아직 안찼다면
                    if (getOn.size() < m) {
                        getOn.add(timetable[i]);
                    } else {
                        // 탑승 인원 다 찼다면
                        currentBusTime = addMinute(currentBusTime, t);
                        cnt++;
                        getOn.clear();
                        i--;
                    }
                } else {
                    // 현재 버스에 탈 수 없는 사람이면
                    currentBusTime = addMinute(currentBusTime, t);
                    cnt++;
                    getOn.clear();
                    i--;
                }
            }
        }

        if (cnt < n) {
            // 아직 남아있는 버스가 더 있다면 가장 늦게 오는 버스 타고 가기
            answer = addMinute(currentBusTime, (n - cnt) * t);
        }

        // 반복문을 다 돌았는데도 answer 가 안나왔으면 버스 출발 시각에 나와도 탈 수 있다
        if (answer.equals("")) answer = currentBusTime;

        return answer;
    }

    // 시간 더하는 함수
    public static String addMinute(String time, int m) {
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]);
        int min = Integer.parseInt(split[1]);
        min += m;
        if (min >= 60) {
            hour += (min / 60);
            min -= (min / 60) * 60;
        }
        if (hour >= 24) {
            hour -= 24;
        }
        String formattedHour = String.format("%02d", hour);
        String formattedMin = String.format("%02d", min);
        return formattedHour + ":" + formattedMin;
    }

    public static String minusOneMinute(String time) {
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]);
        int min = Integer.parseInt(split[1]);

        min -= 1;
        if (min < 0) {
            hour -= 1;
            min += 60;
        }
        if (hour < 0) {
            hour += 24;
        }

        String formattedHour = String.format("%02d", hour);
        String formattedMin = String.format("%02d", min);
        return formattedHour + ":" + formattedMin;
    }

    public static boolean isEarlier(String time1, String time2, boolean equal) {
        String timeStr1 = String.join("", time1.split(":"));
        String timeStr2 = String.join("", time2.split(":"));
        if (equal) {
            return Integer.parseInt(timeStr1) <= Integer.parseInt(timeStr2);
        } else {
            return Integer.parseInt(timeStr1) < Integer.parseInt(timeStr2);

        }
    }
}
