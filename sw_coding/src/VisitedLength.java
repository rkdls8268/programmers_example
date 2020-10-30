public class VisitedLength {
    // 방문 길이: 캐릭터가 처음 걸어본 길의 길이 구하기
    public static void main(String[] args) {
        String dirs = "ULURRDLLU";
        String dirs1 = "LULLLLLLU";
        System.out.println(solution(dirs));
        System.out.println(solution(dirs1));
    }

    static int solution(String dirs) {
        int answer = 0;
        // (x1, y1) -> (x2, y2)로 이동한 적 있는지 체크하는 사차원 배열
        boolean[][][][] isVisited = new boolean[11][11][11][11];
        int x, y, x2, y2; // 현재 좌표 x,y 와 이동할 좌표 x2, y2
        int[] dx = {0, 0, -1, 1}; // 상하좌우
        int[] dy = {1, -1, 0, 0};

        x = 5; y = 5; x2 = 5; y2 = 5; // 0,0 좌표

        for (char d : dirs.toCharArray()) {
            x = x2;
            y = y2;
            if (d == 'U') { // 상
                x2 = x + dx[0];
                y2 = y + dy[0];
            } else if (d == 'D') { // 하
                x2 = x + dx[1];
                y2 = y + dy[1];
            } else if (d == 'L') { // 좌
                x2 = x + dx[2];
                y2 = y + dy[2];
            } else { // 우
                x2 = x + dx[3];
                y2 = y + dy[3];
            }

            // 주어진 좌표를 넘어가는 자리는 움직이지 않는다.
            if (x2 < 0 || x2 > 10 || y2 < 0 || y2 > 10) {
                // 이동하기 전 좌표로 바꿔주기
                x2 = x;
                y2 = y;
                continue;
            }
            // 이미 지나간 자리는 더하지 안는다 -> 첫방문이면 답 + 1
            if (!isVisited[x][y][x2][y2]) {
                isVisited[x][y][x2][y2] = true; // (0,1)에서 (1,1) 방문과
                isVisited[x2][y2][x][y] = true; // (1,1)에서 (0,1) 방문은 같은 것
                answer++;
            }
        }
        return answer;
    }
}
