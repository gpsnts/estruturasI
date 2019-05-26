public class SelectionSort extends SortAlgorithm {
    public static <T extends Comparable<? super T>> void selectionSort(T[] a) {
        for (int min, i = 0; i < a.length; i++) {
            min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].compareTo(a[min]) < 0) {
                    min = j;
                }
            }
            exchange(a, min, i);
        }
    }
}
