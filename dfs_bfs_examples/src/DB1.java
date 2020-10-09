public class DB1 {
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1, 1, 1};
        int target = 3;

        System.out.println(solution(numbers, target));
    }

    // dfs 알고리즘을 활용하여 재귀함수로 구현
    // 재귀로 모든 경우의 수(더하고, 빼고)로 다 넣어서 구한다. 만들어진 최종 값이 target 과 동일한 경우
    // 1을 리턴하고 이 값을 누적한 것이 결과 값이다.
    public static int solution(int[] numbers, int target) {
        int answer = 0;
        int current = numbers[0];
        answer += dfs(current, 1, numbers, target);
        answer += dfs(-current, 1, numbers, target);
        return answer;
    }

    public static int dfs(int prev, int index, int[] numbers, int target) {

        if (index >= numbers.length) {
            if (target == prev) {
                return 1;
            } return 0;
        }

        int cur1 = prev + numbers[index];
        int cur2 = prev - numbers[index];

        int answer = 0;
        answer += dfs(cur1, index + 1, numbers, target);
        answer += dfs(cur2, index + 1, numbers, target);

        return answer;
    }
}
