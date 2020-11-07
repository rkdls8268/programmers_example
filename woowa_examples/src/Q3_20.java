public class Q3_20 {
    // 마틴게일 베팅법
    // 첫 판에 무조건 100원 걸기
    public static void main(String[] args) {
        int money = 1000;
        String[] expected = {"H", "T", "H", "T", "H", "T", "H"};
        String[] actual = {"T", "T", "H", "H", "T", "T", "H"};
        System.out.println(solution(money, expected, actual));
    }

    static int solution(int money, String[] expected, String[] actual) {
        int answer = -1;

        int bettingMoney = 100;

        for (int i = 0; i < expected.length; i++) {
            // 베팅 성공 시
            if (expected[i].equals(actual[i])) {
                money += bettingMoney;
                bettingMoney = 100;
            } else {
                // 베팅 실패 시
                if (money < bettingMoney) break;
                money -= bettingMoney;
                bettingMoney *= 2;
                if (bettingMoney > money) {
                    bettingMoney = money;
                }
            }
        }
        answer = money;

        return answer;
    }
}
