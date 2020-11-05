import java.util.*;

public class Q4_19 {
    /*
    포비와 크롱이 페이지 번호가 1부터 시작되는 400 페이지의 책을 주워왔다.
    책을 살펴보니 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수 번호이고 모든 페이지에는 번호가 적혀있다.
    책이 마음에 든 포비와 크롱은 페이지 번호 게임을 통해 게임에서 이긴 사람이 책을 갖기로 합니다.
    페이지 번호 게임의 규칙은 아래와 같다.
    1. 책을 임의로 펼친다.
    2. 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
    3. 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
    4. 2-3 과정에서 가장 큰 수를 본인의 점수로 한다.
    5. 점수를 비교해 가장 높은 사람이 게임의 승자
    6. 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
    포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0, 예외사항은 -1로 return
     */
    public static void main(String[] args) {
        int[] pobi = {100, 101};
        int[] crong = {211, 212};
        System.out.println(solution(pobi, crong));
    }

    static int solution(int[] pobi, int[] crong) {
        int answer = 0;
        boolean flag = true;
        List<Integer> pobiResult = new ArrayList<>();
        List<Integer> crongResult = new ArrayList<>();
        for (int i = 0; i < pobi.length; i++) {
            // 예외사항
            if (!(pobi[1] - 1 == pobi[0]) || !(crong[1] - 1 == crong[0])){
                flag = false;
                break;
            }
            int temp = pobi[i];
            int temp2 = crong[i];
            int resP = 0, resM = 0;
            if (temp >= 100) {
                resP = (temp / 100) + ((temp % 100) / 10) + ((temp % 100) % 10);
                resM = (temp / 100) * ((temp % 100) / 10) * ((temp % 100) % 10);
            } else {
                resP = (temp / 10) + (temp % 10);
                resM = (temp / 10) * (temp % 10);
            }
            pobiResult.add(resP);
            pobiResult.add(resM);


            if (temp2 >= 100) {
                resP = (temp2 / 100) + ((temp2 % 100) / 10) + ((temp2 % 100) % 10);
                resM = (temp2 / 100) * ((temp2 % 100) / 10) * ((temp2 % 100) % 10);
            } else {
                resP = (temp2 / 10) + (temp2 % 10);
                resM = (temp2 / 10) * (temp2 % 10);
            }
            crongResult.add(resP);
            crongResult.add(resM);
        }
//        System.out.println(pobiResult);
//        System.out.println(crongResult);

        if (flag) {
            int pobiMax = Collections.max(pobiResult);
            int crongMax = Collections.max(crongResult);
//            System.out.println(pobiMax + ", "+crongMax);
            answer = pobiMax > crongMax ? 1 : (pobiMax == crongMax ? 0 : 2);
        } else {
            answer = -1;
        }
        return answer;
    }
}
