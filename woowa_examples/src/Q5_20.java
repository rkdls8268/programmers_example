import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q5_20 {
    public static void main(String[] args) {
        String penter = "10";
        String pexit = "11";
        String pescape = "00";
        String data = "00011011";
        System.out.println(solution(penter, pexit, pescape, data));
    }

    static String solution(String penter, String pexit, String pescape, String data) {
        String answer = "";
        int len = penter.length();
        List<String> dataList = new LinkedList<>();
        for (int i = 0; i < data.length(); i += len) {
            dataList.add(data.substring(i, i+len));
        }
//        System.out.println(dataList);
        int[] numOfPescape = new int[dataList.size()];

        for (int i = 0; i < dataList.size(); i++) {
            if (dataList.get(i).equals(penter) || dataList.get(i).equals(pexit) || dataList.get(i).equals(pescape)) {
                numOfPescape[i]++;
            }
        }
//        System.out.println(dataList);
//        System.out.println(Arrays.toString(numOfPescape));
        String newData = "";
        for (int i = 0; i < dataList.size(); i++) {
            if (numOfPescape[i] == 1) {
                newData += pescape + dataList.get(i);
            } else {
                newData += dataList.get(i);
            }
        }
        answer = penter + newData + pexit;
        return answer;
    }
}
