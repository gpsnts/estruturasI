public class BubbleSort extends SortAlgorithm {
    public static <T extends Comparable<? super T>> void bubbleSort(T[] a) {
        boolean exchange;
        do {
            exchange = false;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i].compareTo(a[i + 1]) > 0) {
                    exchange(a, i, i + 1);
                    exchange = true;
                }
            }
        } while (exchange);
    }
}
