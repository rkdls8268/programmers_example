import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 9, 2, 7, 8, 6, 1, 4};
        int[] tmpArr = new int[arr.length];
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, tmpArr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int[] tmpArr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, tmpArr, left, mid);
            mergeSort(arr, tmpArr, mid + 1, right);
            merge(arr, tmpArr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int[] tmpArr, int left, int mid, int right) {
        int leftIndex = left;
        int rightIndex = mid + 1;
        int index = leftIndex;

        // 둘 중 하나라도 정렬 끝나면 반복문 종료
        while (leftIndex <= mid && rightIndex <= right) {
            if (arr[leftIndex] < arr[rightIndex]) {
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
