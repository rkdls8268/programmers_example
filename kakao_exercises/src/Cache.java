import java.util.LinkedList;
import java.util.Queue;

public class Cache {
    public static void main(String[] args) {
        int cacheSize = 0;
        String[] cities = {"la", "b", "la"};
        System.out.println(solution(cacheSize, cities));
    }

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        int cacheMiss = 5;
        int cacheHit = 1;
        Queue<String> queue = new LinkedList<>();
        for (String city : cities) {
            city = city.toLowerCase();
            if (cacheSize == 0) {
                answer = cacheMiss * cities.length;
                break;
            }
            if (queue.isEmpty()) {
                queue.add(city);
                answer += cacheMiss;
            } else {
                int size = queue.size();
                if (queue.contains(city)) {
                    answer += cacheHit;
                    queue.remove(city);
                    queue.add(city); // 가장 최신으로 추가
                } else {
                    answer += cacheMiss;
                    if (size == cacheSize) {
                        queue.poll(); // 가장 오래된 것 빼고
                        queue.add(city); // 가장 최신으로 추가
                    } else {
                        queue.add(city);
                    }
                }
            }
        }
        return answer;
    }
}
