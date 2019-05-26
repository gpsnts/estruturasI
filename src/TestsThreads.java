public class TestsThreads {
    public void runAlgorithmTests(SortAlgorithm sortAlgorithm) {
        if (sortAlgorithm instanceof BubbleSort)
            System.out.println("Bubble Sort");
        else if (sortAlgorithm instanceof InsertionSort)
            System.out.println("Insertion Sort");
        else if (sortAlgorithm instanceof SelectionSort)
            System.out.println("Selection Sort");
        else if (sortAlgorithm instanceof HeapSort)
            System.out.println("HeapSort");
        else if (sortAlgorithm instanceof ShellSort)
            System.out.println("Shell Sort");

        AlgorithmAnalysis n128 = new AlgorithmAnalysis(128, sortAlgorithm);
        AlgorithmAnalysis n256 = new AlgorithmAnalysis(256, sortAlgorithm);
        AlgorithmAnalysis n512 = new AlgorithmAnalysis(512, sortAlgorithm);
        AlgorithmAnalysis n1024 = new AlgorithmAnalysis(1024, sortAlgorithm);
        AlgorithmAnalysis n2048 = new AlgorithmAnalysis(2048, sortAlgorithm);
        AlgorithmAnalysis n8192 = new AlgorithmAnalysis(8192, sortAlgorithm);
        AlgorithmAnalysis n16384 = new AlgorithmAnalysis(16384, sortAlgorithm);
        AlgorithmAnalysis n32768 = new AlgorithmAnalysis(32768, sortAlgorithm);
        AlgorithmAnalysis n65536 = new AlgorithmAnalysis(65536, sortAlgorithm);

        System.out.println("Início dos cenários de teste com \"n\" valores");

        System.out.println("\"n\" = 128 Iniciado");
        n128.init();
        System.out.println("\"n\" = 256 Iniciado");
        n256.init();
        System.out.println("\"n\" = 512 Iniciado");
        n512.init();
        System.out.println("\"n\" = 1024 Iniciado");
        n1024.init();
        System.out.println("\"n\" = 2048 Iniciado");
        n2048.init();
        System.out.println("\"n\" = 8192 Iniciado");
        n8192.init();
        System.out.println("\"n\" = 16384 Iniciado");
        n16384.init();
        System.out.println("\"n\" = 32768 Iniciado");
        n32768.init();
        System.out.println("\"n\" = 65536 Iniciado");
        n65536.init();

        System.out.println("Fim dos cenários de teste");
    }

}
