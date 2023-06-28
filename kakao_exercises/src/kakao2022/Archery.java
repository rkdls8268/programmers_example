package kakao2022;

import java.util.Arrays;
import java.util.Stack;

public class Archery {
    public static void main(String[] args) {
        // 화살의 개수
        int n = 10;
        // 어피치가 맞힌 과녁 점수의 개수를 10점부터 0점까지 순서대로 담은 정수 배열
        int[] info = {0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3};
        System.out.println(Arrays.toString(solution(n, info)));
    }
    static int maxSub = 0;

    public static int[] solution(int n, int[] info) {
        int[] answer;
        Stack<int[]> stack = new Stack<>();
        int[] ryanInfo = new int[info.length];
        int[] apeachInfo = Arrays.copyOf(info, info.length);
        boolean[] visited = new boolean[info.length];

        dfs(n, info, ryanInfo, apeachInfo, visited, stack);

        if (maxSub <= 0) {
            return new int[]{-1};
        } else {
            answer = stack.pop();
        }
        return answer;
    }

    public static void dfs(int n, int[] info, int[] ryanInfo, int[] apeachInfo, boolean[] visited, Stack<int[]> stack) {
        if (n == 0) {
            int[] ryanInfo2 = Arrays.copyOf(ryanInfo, ryanInfo.length);
            int appeach = 0;
            int ryan = 0;
            for (int i = 0; i < apeachInfo.length; i++) {
                if (apeachInfo[i] > 0) {
                    appeach += 10 - i;
                }
            }
            for (int i = 0; i < ryanInfo2.length; i++) {
                if (ryanInfo2[i] > 0) {
                    ryan += 10 - i;
                }
            }
            if (ryan > appeach) {
                // 더 차가 심한 경우의 수가 나오면
                if (maxSub <= ryan - appeach) {
                    maxSub = ryan - appeach;
                    // 라이언이 가장 큰 점수 차이로 우승할 수 있는 방법이 여러 가지 일 경우, 가장 낮은 점수를 더 많이 맞힌 경우를 return 해주세요.
                    if (!stack.isEmpty()) {
                        int[] last = stack.pop();
                        for (int i = ryanInfo2.length - 1; i >= 0; i--) {
                            // 가장 낮은 점수가 업데이트 될 인포가 더 크기만 한 경우
                            if (ryanInfo2[i] > last[i]) {
                                stack.push(ryanInfo2);
                                i = 0; // 반복문 나가기
                            }
                        }
                    }
                    stack.push(ryanInfo2);
                }
            }
            return;
        }
        for (int i = 0; i < info.length; i++) {
            if (n > 0 && !visited[i]) {
                if (i == info.length - 1) {
                    // 마지막에 다왔는데 n 남아있으면 마지막에 채워넣기
                    if (apeachInfo[i] < n) {
                        apeachInfo[i] = 0;
                    }
                    ryanInfo[i] = n;
                    n -= n;
                    visited[i] = true;
                    dfs(n, info, ryanInfo, apeachInfo, visited, stack);
                    n += info[i] + 1;
                    ryanInfo[i] = 0;
                    apeachInfo[i] = info[i];
                    visited[i] = false;

                } else if (n > info[i]) {
                    // 어피치 이기기 위해서 1발 더 쏴야 함
                    n -= info[i] + 1;
                    // apeach 점수 합산용
                    apeachInfo[i] = 0;
                    // 라이언 점수 합산용
                    ryanInfo[i] = info[i] + 1;
                    visited[i] = true;
                    dfs(n, info, ryanInfo, apeachInfo, visited, stack);
                    n += info[i] + 1;
                    ryanInfo[i] = 0;
                    apeachInfo[i] = info[i];
                    visited[i] = false;
                }

            }
        }
    }
}
