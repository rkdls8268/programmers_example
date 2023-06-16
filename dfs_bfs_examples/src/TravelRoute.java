import java.util.*;

public class TravelRoute {
    // dfs/bfs - 여행 경로
    public static void main(String[] args) {
        String[][] tickets = {
//                {"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}
//                {"ICN", "AAA"}, {"ICN", "CCC"}, {"CCC", "DDD"}, {"AAA", "BBB"}, {"AAA", "BBB"}, {"DDD", "ICN"}, {"BBB", "AAA"}
                {"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}
        };
        System.out.println(Arrays.toString(solution(tickets)));
    }
    public static String[] solution(String[][] tickets) {
        String firstDeparture = "ICN";
        List<String> answer = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String[] ticket : tickets) {
            Collections.addAll(set, ticket);
        }
        int n = set.size();
        List<String> airports = new ArrayList<>(set);
        airports.sort(Comparator.naturalOrder());
        int[][] ticketNodes = new int[n][n];

        for (String[] ticket : tickets) {
            int departure = airports.indexOf(ticket[0]);
            int destination = airports.indexOf(ticket[1]);
            ticketNodes[departure][destination] += 1;
        }

        boolean[][] visited = new boolean[n][n];
        answer.add(firstDeparture);
        dfs(airports, ticketNodes, visited, answer, firstDeparture, 0, tickets.length);
        return answer.toArray(new String[0]);
    }

    public static void bfs(List<String> airports, int[][] ticketNodes, List<String> answer, String firstDeparture) {
        int len = airports.size();
        Queue<String> queue = new LinkedList<>();
        queue.add(firstDeparture);
        answer.add(firstDeparture);

        while (!queue.isEmpty()) {
            int now = airports.indexOf(queue.poll());
            for (int i = 0; i < len; i++) {
                if (ticketNodes[now][i] == 1) {
                    ticketNodes[now][i] -= 1; // 항공권 사용 -> 중복티켓 x
                    answer.add(airports.get(i)); // 여행 경로 설정
                    queue.add(airports.get(i)); // 목적지 queue 에 저장
                    break;
                } else if (ticketNodes[now][i] > 1) {
                    ticketNodes[now][i] -= 1; // 항공권 사용 -> 중복티켓 x
                    answer.add(airports.get(i)); // 여행 경로 설정
                    queue.add(airports.get(i)); // 목적지 queue 에 저장
                    break;
                }
            }
        }
    }

    public static void dfs(List<String> airports, int[][] ticketNodes, boolean[][] visited, List<String> answer, String departure, int depth, int ticketNumbers) {
        if (ticketNumbers == depth) {
            return;
        }
        int idx = airports.indexOf(departure);
        for (int i = 0; i < airports.size(); i++) {
            if (ticketNodes[idx][i] > 0 && !visited[idx][i]) {
                // 탐색
                if (ticketNodes[idx][i] == 1) visited[idx][i] = true;
                ticketNodes[idx][i] -= 1;
                String nextDeparture = airports.get(i);
                answer.add(nextDeparture);
                dfs(airports, ticketNodes, visited, answer, nextDeparture, depth + 1, ticketNumbers);
                // 더 이상 경로 설정할 필요 없으면 아래 로직 수행 안해도 됨
                if (answer.size() == ticketNumbers + 1) return;
                visited[idx][i] = false;
                ticketNodes[idx][i] += 1;
                answer.remove(answer.size() - 1);
            }
        }
    }
}
