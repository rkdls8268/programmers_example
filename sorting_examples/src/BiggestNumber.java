import java.util.Arrays;

public class BiggestNumber {
    // 정렬 - 가장 큰 수
    // Collections.sort() 활용하거나 Arrays.sort() 활용 가능
    public static void main(String[] args) {
        int[] numbers = {0, 0, 0};
        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers) {
        mergeSort(numbers, 0, numbers.length - 1);
        // {0, 0, 0} 케이스
        if (Arrays.stream(numbers).allMatch(t -> t == 0)) {
            numbers = new int[1];
        }
        // 문자열 합칠 때 StringBuilder 사용하면 훨씬 빠름.
        return Arrays.toString(numbers).replaceAll("[^0-9]", "");
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int leftIndex = left;
        int rightIndex = mid + 1;
        int index = left;
        int[] tmpArr = new int[right + 1];

        while (leftIndex <= mid && rightIndex <= right) {
            String intToStrLeft = Integer.toString(arr[leftIndex]);
            String intToStrRight = Integer.toString(arr[rightIndex]);
            int a = Integer.parseInt(String.join("", intToStrLeft, intToStrRight));
            int b = Integer.parseInt(String.join("", intToStrRight, intToStrLeft));
            if (a >= b) {
                tmpArr[index++] = arr[leftIndex++];
            } else {
                tmpArr[index++] = arr[rightIndex++];
            }
        }

        if (leftIndex > mid) {
            for (int i = rightIndex; i <= right; i++) {
                tmpArr[index++] = arr[i];
            }
        } else {
            for (int i = leftIndex; i <= mid; i++) {
                tmpArr[index++] = arr[i];
            }
        }

        for (int i = left; i <= right; i++) {
            arr[i] = tmpArr[i];
        }
    }
}
