package kakao2022;

import java.util.*;

public class ParkingTime {
    public static void main(String[] args) {
//        [120, 0, 60, 591]	["16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"]
        int[] fees = {180, 5000, 10, 1000};
        String[] records = {
                "05:59 0000 IN", "05:59 1111 IN"
        };
        System.out.println(Arrays.toString(solution(fees, records)));
    }

    public static int[] solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();
        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> minuteMap = new TreeMap<>();
        Map<String, String> timeMap = new HashMap<>();
        String lastTime = "23:59";

        for (String record : records) {
            String[] info = record.split(" ");
            String time = info[0];
            String carNumber = info[1];
            String status = info[2];
            if (status.equals("IN")) {
                // 차 번호 큐에 저장
                queue.add(carNumber);
                timeMap.put(carNumber, time);
            } else {
                // 이미 입차한 기록이 있다면
                String in = timeMap.get(carNumber);
                int subMinute = getSubOfTime(in, time);
                minuteMap.put(carNumber, minuteMap.getOrDefault(carNumber, 0) + subMinute);
                // 출차
                queue.remove(carNumber);
            }
        }
        while (!queue.isEmpty()) {
            String carNumber = queue.poll();
            String inTime = timeMap.get(carNumber);
            int subMinute = getSubOfTime(inTime, lastTime);
            minuteMap.put(carNumber, minuteMap.getOrDefault(carNumber, 0) + subMinute);
        }

        for (Map.Entry<String, Integer> entry : minuteMap.entrySet()) {
            int min = entry.getValue();
            if (min > defaultTime) {
                int finalFee = defaultFee + (int) (Math.ceil(((double)min - (double)defaultTime) / (double)unitTime) * unitFee);
                answer.add(finalFee);
            } else answer.add(defaultFee);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int getSubOfTime(String in, String out) {
        String[] inTime = in.split(":");
        String[] outTime = out.split(":");
        int inHour = Integer.parseInt(inTime[0]);
        int outHour = Integer.parseInt(outTime[0]);
        int inMin = Integer.parseInt(inTime[1]);
        int outMin = Integer.parseInt(outTime[1]);

        int minSub;
        if (outMin - inMin < 0) {
            outHour -= 1;
            outMin += 60;
        }
        minSub = outMin - inMin;
        minSub += (outHour - inHour) * 60;

        return minSub;
    }
}
