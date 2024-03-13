package oy.tol.tra;

public class Algorithms {

    public static <T extends Comparable<T>> int binarySearch(T value, T[] arr, int from, int toIndex) {
        if (from <= toIndex) {
            int mid = from + (toIndex - from) / 2;
            int compareResult = arr[mid].compareTo(value);
            if (compareResult < 0) {
                return binarySearch(value, arr, mid + 1, toIndex);
            } else if (compareResult == 0) {
                return mid;
            } else {
                return binarySearch(value, arr, from, mid - 1);
            }
        }
        return -1;
    }

    public static <T extends Comparable<T>> void sort(T[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static <T extends Comparable<T>> void quickSort(T[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int partitionIndex = partition(arr, left, right);
        quickSort(arr, left, partitionIndex - 1);
        quickSort(arr, partitionIndex + 1, right);
    }

    private static <T extends Comparable<T>> int partition(T[] arr, int left, int right) {
        T pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        T temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;
        return i + 1;
    }
}
