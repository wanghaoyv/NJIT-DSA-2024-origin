package oy.tol.tra;

public class Algorithms {
    public static <T extends Comparable<T>> void sort(T[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        for (int i = 1; i < array.length; i++) {
            T current = array[i];
            int j = i - 1;

            while (j >= 0 && array[j].compareTo(current) > 0) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = current;
        }
    }

    public static <T> void reverse(T[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            T temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

}