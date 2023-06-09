public class TargetNumber {
    public static void main(String[] args) {
        int[] numbers = {4, 1, 2, 1};
        int target = 4;
        System.out.println(solution(numbers, target));
    }

    static int answer = 0;

    public static int solution(int[] numbers, int target) {
        int cnt = 0;
        int depth = 0;
        int len = numbers.length;
        // +, - 로 이루어진 배열 numbers.length 만큼
        int[][] nums = new int[len][2];
        for (int i = 0; i < len; i++) {
            nums[i][0] = numbers[i];
            nums[i][1] = -numbers[i];
        }
        dfs(nums, target, cnt, len, depth);
        return answer;
    }

    public static void dfs(int[][] numbers, int target, int cnt, int len, int depth) {
        if (depth == len) {
            if (cnt == target) answer += 1;
            return;
        }
        for (int i = 0; i < 2; i++) {
            cnt += numbers[depth][i];
            dfs(numbers, target, cnt, len, depth + 1);
            cnt -= numbers[depth][i];
        }
    }
}
