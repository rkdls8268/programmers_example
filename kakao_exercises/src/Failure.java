import java.util.*;

public class Failure {
    // 실패율
    public static void main(String[] args) {
        int N = 5; // 전체 스테이지 개수
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3}; // 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열
        System.out.println(Arrays.toString(solution(N, stages)));

    }

    static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        // 실패율 = 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
        // stages 배열 중 N+1 은 마지막까지 다 클리어한 사용자
        // 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하기
//        int challenger = stages.length;
//        Arrays.sort(stages);
//        // 배열을 list로 변환하는 거 asList 써서 못하나?
//        List<Integer> list = new ArrayList<>();
//        for (int s : stages) {
//            list.add(s);
//        }
//
//        Double[] failureRate = new Double[N];
////        List<Double>
//
//        int c = list.size();
////        System.out.println(list);
//        for (int i = 1; i < N + 1; i++) {
//            int fail = 0;
//            for (int j = 0; j < list.size(); j++) {
//                j = 0;
////                System.out.println("i: "+i);
//                if (list.get(j) == i) {
////                    System.out.println("j: "+j);
//                    fail++;
//                    // 사용자 수 감소
//                    list.remove(j);
////                    System.out.println("removedList: "+list);
//                } else break;
//            }
////            System.out.println(fail);
////            System.out.println(list);
//
//            failureRate[i-1] = (double) fail / (double) list.size();
////            hm.put(i, (double) fail / list.size());
//        }

        // 새로운 코드
        Stage[] sts = new Stage[N];

        // stage 초기화
        for (int i = 0; i < N; i++) {
            sts[i] = new Stage(i + 1);
        }

        // stage 에 유저 넣기 (최대 스테이지를 통과한 사람은 넣지 않음)
        for (int userStage : stages) {
            if (userStage <= N) {
                sts[userStage - 1].count++;
            }
            // 1, 3, 2, 1, 0 차례로 들어감
        }

        // 전체 user 수 구해서 Stage에 통과한 user 수 넣기
        int userCount = stages.length;
        for (Stage stage : sts) {
            // 실패율을 구하는 과정에서 0으로 나누는 경우 예외가 발생하므로 꼭 예외처리 해주기!!
            if (stage.count == 0 || userCount == 0) {
                stage.failureRate = 0.0;
            } else {
                stage.failureRate = (double) stage.count / userCount;
                userCount -= stage.count;
            }
        }

        // compareTo 오버라이딩 했으므로 내가 정한 기준대로 정렬됨
        Arrays.sort(sts);

        for (int i = 0; i < N; i++) {
            answer[i] = sts[i].stageNum;
        }

        return answer;
    }

    static class Stage implements Comparable {
        int stageNum;
        int count;
        double failureRate;

        public Stage(int stage) {
            this.stageNum = stage;
        }

        /* 이건 또 다른 코드 -> Stage 클래스 말고 solution 클래스에서 만들어줌
        public int compare(fail o1, fail o2) {
                if(o1.rate != o2.rate) {
                    return -Double.compare(o1.rate, o2.rate);
                }
                return o1.num - o2.num;
            }
         */

        @Override
        public int compareTo(Object o) {
            Stage otherStage = (Stage) o;
            if (this.failureRate == otherStage.failureRate) {
                return Integer.compare(this.stageNum, otherStage.stageNum);
            }
            return -Double.compare(this.failureRate, otherStage.failureRate);
        }
    }

}
