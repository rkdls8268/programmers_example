package kakao2018;

import java.util.*;

public class FriendsBlock {
    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        String[] board = {"BBCA", "AACA", "FCEE", "CCDD", "BBKK", "AAKK"};
        System.out.println(solution(m, n, board));
    }

    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        String[][] boards = new String[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boards[i][j] = Character.toString(board[i].toCharArray()[j]);
            }
//            System.out.println(Arrays.toString(boards[i]));
        }

        Set<int[]> cordSet = new HashSet<>();
        int cnt = 1;
        while (cnt > 0) {
            cnt = 0;
            for (int i = m - 1; i > 0; i--) {
                int secondX = m - 1;
                for (int j = n - 1; j > 0; j--) {
                    HashMap<String, int[]> cordMap = getCordOfSameCharacter(boards, i, j, secondX);
                    if (cordMap.size() > 0) {
                        i = cordMap.get("first")[0] - 1;
                        secondX = cordMap.get("third")[0] - 1;
                        cordSet.addAll(cordMap.values());
                        cnt++;
                    }
                }
            }
            for (int[] cord : cordSet) {
                int x = cord[0];
                int y = cord[1];
                boards[x][y] = "#";
            }
            cordSet.clear();
        }

        for (String[] b : boards) {
            answer += Arrays.stream(b).filter(t -> t.equals("#")).toArray().length;
        }

        return answer;
    }

    // List<int[]> cordList = # 으로 바꿀 좌표 저장할 리스트
    // String lastBlock = 같은 block 인지 확인

    public static HashMap<String, int[]> getCordOfSameCharacter(String[][] boards, int dx, int dy, int secondX) {
        HashMap<String, int[]> cordList = new HashMap<>();
        String first = boards[dx][dy]; // 우하단
        String second = boards[dx][dy - 1]; // 좌하단
        String third = boards[dx - 1][dy]; // 우상단
        String fourth = boards[dx - 1][dy - 1]; // 좌상단
        int[] firstCord = {dx, dy};
        int[] secondCord = {dx, dy - 1};
        int[] thirdCord = {dx - 1, dy};
        int[] fourthCord = {dx - 1, dy - 1};

        if (first.equals("#")) { // 이거 검사 안해도 되지 않나 ?
            // 그 다음줄 검사
            for (int i = dx - 1; i > 0; i--) {
                if (first.equals("#")) {
                    first = boards[i - 1][dy];
                    firstCord[0] = i - 1;
                    thirdCord[0] = i - 2;
                } else {
                    break;
                }
            }
        }

        if (second.equals("#")) {
            for (int i = secondX; i > 0; i--) {
                if (second.equals("#")) {
                    second = boards[i - 1][dy - 1];
                    secondCord[0] = i - 1;
                    fourthCord[0] = i - 2;
                } else {
                    break;
                }
            }
        }
        // 만약 첫블록이랑 두번째 블록이랑 다를 경우 리턴
        // 밑에 두 블록이 #일 경우 그 다음줄 블록 확인
        if (third.equals("#")) {
            for (int i = thirdCord[0]; i > 0; i--) {
                if (third.equals("#")) {
                    third = boards[i - 1][dy];
                    thirdCord[0] = i - 1;
                } else {
                    break;
                }
            }
        }
        if (fourth.equals("#")) {
            for (int i = fourthCord[0]; i > 0; i--) {
                if (fourth.equals("#")) {
                    fourth = boards[i - 1][dy - 1];
                    fourthCord[0] = i - 1;
                } else {
                    break;
                }
            }
        }

        if (first.equals(second)
                && first.equals(third)
                && first.equals(fourth)
        ) {
            if (!first.equals("#")) {
                cordList.put("first", firstCord);
                cordList.put("second", secondCord);
                cordList.put("third", thirdCord);
                cordList.put("fourth", fourthCord);
            }
        }
        return cordList;
    }
}
