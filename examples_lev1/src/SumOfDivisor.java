import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SumOfDivisor {
    // 약수의 합
    /*
    정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수
     */
    public static void main(String[] args) {
        int n = 12;
        System.out.println(solution(n));
        System.out.println(solution2(n));
    }

    static int solution(int n) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        if (n == 0) {
            return 0;
        } else {
            set.add(1); // 1과 맨 뒤에서 자기 자신 추가
            for (int i = 2; i < n / 2; i++) {
                if (n % i == 0) {
                    set.add(i);
                    set.add(n / i);
                }
                System.out.println(set);
            }
            set.add(n);
            for (int l : set) {
                answer += l;
            }
        }
        return answer;
    }

    static int solution2(int n) {
        int answer = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) answer +=i;
        }
        return answer + n;
    }
}

// 나는 뭔 set에 중복되는 수 포함안되게 하는 짓까지 했는데 이렇게 간단하게도 작성할 수 있는거였다..^^
// 특히 n/2를 하니까 마지막에 자기자신만 더해주면 되는 거였음!!! 굳!!!!