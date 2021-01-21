public class Permutation {
    public static void main(String[] args) {
        // 순열
        int n, r;
        char[] result = new char[100];
        boolean[] checked = new boolean[100]; // checked[i] == true -> 알파벳 i가 이미 나왔음.
        int count = 0;
        System.out.println(getResult(0, 4, 3, result, checked, count));
    }

    static int getResult(int x, int n, int r, char[] result, boolean[] checked, int count) {
        // x번째 for 문을 돌려야 함.
        if (x >= r) {
            for (int i = 0; i < r; i++) {
                System.out.printf("%c ", result[i]);
            }
            count++;
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                char alpha = (char) (i + 'a');
                if (!checked[i]) {
                    result[x] = alpha;
                    checked[i] = true;
                    getResult(x+1, n, r, result, checked, count); // 그 다음 for 문 실행시키기
                    // x 번째에 i를 넣는 모든 경우를 이미 다 고려했음. getResult()가 반환되었으므로
                    checked[i] = false; // result 에서 뺄거니까 없었던 것처럼 만들어 줘야 함.
                    result[x] = 0;
                }
            }
        }
        return count;
    }
}
