public class InsertionSort extends SortAlgorithm {
    public static <T extends Comparable<? super T>> void insertionSort(T[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && a[j - 1].compareTo(a[j]) > 0; j--) {
                exchange(a, j - 1, j);
            }
        }
    }
}
