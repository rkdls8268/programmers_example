import java.util.Arrays;
import java.util.Comparator;

public class SkillTree {
    // 스킬트리: 유저가 스킬을 배울 순서
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {
                "BACDE", "CBADF", "AECB", "BDA"
        };
        System.out.println(solution(skill, skill_trees));
    }

    static int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        int beforeIdx = 0, currentIdx = 0;

        for (String s : skill_trees) {
            // 첫 번째 skill을 beforeIdx에 담아둔다
            // indexOf 를 활용!!! 굳
            beforeIdx = s.indexOf(skill.charAt(0));
            if (beforeIdx == -1){
                answer--;
                continue;
            }
//            System.out.println("out before:"+beforeIdx);

            for (int i = 1; i < skill.length(); i++) {
//                System.out.println("before:"+beforeIdx);
                currentIdx = s.indexOf(skill.charAt(i));
//                System.out.println("current: "+currentIdx);
                // 앞에 나온 스킬이 현재 스킬보다 선행스킬이 아니고 현재 스킬이 skill 에 있는 경우
                // 혹은 앞에 나온 스킬이 skill 에 없는 스킬이고 현재 스킬이 skill 에 있는 스킬인 경우
                if ((beforeIdx > currentIdx && currentIdx != -1) || (beforeIdx == -1 && currentIdx != -1)) {
                    answer--;
                    break;
                }
                beforeIdx = currentIdx;
            }
        }
        return answer;
    }
}
