package oy.tol.tra;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class Algorithms {
    // 交换数组中两个元素的位置
    public static <T> void swap(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    // 快速排序
    public static <K extends Comparable<K>, V>  void fastSort(Pair<K, V>[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static <K extends Comparable<K>, V>  void quickSort(Pair<K, V>[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
    }
    // 反转数组
    public static <T> void reverse(T[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            swap(array, left, right);
            left++;
            right--;
        }
    }

    // 二分查找
    public static <T extends Comparable<T>> int binarySearch(T value, T[] array, int fromIndex, int toIndex) {
        while (fromIndex <= toIndex) {
            int mid = fromIndex + (toIndex - fromIndex) / 2;
            int cmp = value.compareTo(array[mid]);
            if (cmp > 0) {
                fromIndex = mid + 1;
            } else if (cmp < 0) {
                toIndex = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    // 归并排序
    public static <K extends Comparable<K>, V>void mergeSort(Pair<K, V>[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        @SuppressWarnings("unchecked")
        Pair<K, V>[] sorted = new Pair[arr.length];
        mergeSort1(arr, sorted, 0, arr.length - 1);
    }

    private static<K extends Comparable<K>, V> void mergeSort1(Pair<K, V>[] arr, Pair<K, V>[] sorted, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort1(arr, sorted, start, mid);
            mergeSort1(arr, sorted, mid + 1, end);
            merge(arr, sorted, start, mid, end);
        }
    }

    private static  <K extends Comparable<K>, V> void merge(Pair<K, V>[] arr, Pair<K, V>[] sorted, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = start;

        while (i <= mid && j <= end) {
            if (arr[i].getKey().compareTo(arr[j].getKey()) <= 0) {
                sorted[k++] = arr[i++];
            } else {
                sorted[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            sorted[k++] = arr[i++];
        }

        while (j <= end) {
            sorted[k++] = arr[j++];
        }

        for (k = start; k <= end; k++) {
            arr[k] = sorted[k];
        }
    }


//
    private static <E extends Comparable<E>> int partition(E[] array, int begin, int end) {
        E pivot = array[begin];
        int left = begin;
        int right = end;
        while (left < right) {
            while (left < right && array[right].compareTo(pivot) > 0) {
                right--;
            }
            while (left < right && array[left].compareTo(pivot) <= 0) {
                left++;
            }
            if (left < right) {
                swap(array, left, right);
            }
        }
        array[begin] = array[left];
        array[left] = pivot;
        return left;
    }


    // 按照规则对数组进行分区
    public static <T> int partitionByRule(T[] pairs, int count, Predicate<T> judgeNullPredicate) {
        int left = 0;
        int right = count - 1;

        while (left <= right) {
            while (left <= right && !judgeNullPredicate.test(pairs[left])) {
                left++;
            }

            while (left <= right && judgeNullPredicate.test(pairs[right])) {
                right--;
            }

            if (left < right) {
                swap(pairs, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

        // 使用自定义比较器进行排序
        public static <T> void sortWithComparator(T[] array, Comparator<? super T> comparator) {
            Arrays.sort(array, comparator);
        }
    
}
