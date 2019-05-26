public class ShellSort extends SortAlgorithm {
    public static <T extends Comparable<? super T>> void shellSort(T[] a) {
        int h = 1;
        while (3 * h + 1 < a.length) h = 3 * h + 1;
        while (h > 0) {
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h && a[j - h].compareTo(a[j]) > 0; j -= h) {
                    exchange(a, j - h, j);
                }
            }
            h /= 3;
        }
    }
}
