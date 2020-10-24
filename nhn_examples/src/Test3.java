import java.util.Scanner;
import java.util.Stack;

class Test3 {
    private static void solution(int numOfOrder, String[] orderArr) {
        // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.

        String str = "";
        Stack<String> stack = new Stack<>();
        String num = "";
        for (String o : orderArr) {
            for (int i = 0; i < o.length(); i++) {
                if (o.substring(i, i + 1).matches("[1-9]")) {
                    num = o.substring(i, i + 1);
                    stack.push(num);
                }
                if (o.charAt(i) == '(') {
                    str += recursion(i, o, stack);
                }
            }
            System.out.println(str);
        }

    }

    private static String recursion(int i, String o, Stack<String> stack) {
        String str = "";
        for (int j = i+1; j < o.length(); j++) {
            System.out.println(o.charAt(j));
            if (o.substring(j, j + 1).matches("[1-9]")) {
                String num = o.substring(j, j +1);
                stack.push(num);
            }
            if (o.charAt(j) == ')') break;
            if (o.charAt(j) == '(') {
                str += recursion(j, o, stack);
            }
            str += o.substring(j, j + 1);
            System.out.println("str: "+str);
        }
        return str;
    }

    private static class InputData {
        int numOfOrder;
        String[] orderArr;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.numOfOrder = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.orderArr = new String[inputData.numOfOrder];
            for (int i = 0; i < inputData.numOfOrder; i++) {
                inputData.orderArr[i] = scanner.nextLine().replaceAll("\\s+", "");
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.numOfOrder, inputData.orderArr);
    }
}