public class SortAlgorithm {
    protected static <T extends Comparable<? super T>> void exchange(T[] a, int i, int j) {
        T tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
