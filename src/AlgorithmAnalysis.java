import java.util.*;

public class AlgorithmAnalysis {
    private int scenarioN;
    private ArrayList<Long> ascendantScenarioResults;
    private ArrayList<Long> descendantScenarioResults;
    private ArrayList<Long> randomScenarioResults;
    private ArrayList<Long> randomRepeatedScenarioResults;
    private SortAlgorithm selectedAlgorithm;

    public AlgorithmAnalysis(int scenarioN, SortAlgorithm selectedAlgorithm) {
        this.scenarioN = scenarioN;
        this.selectedAlgorithm = selectedAlgorithm;
        ascendantScenarioResults = new ArrayList<>();
        descendantScenarioResults = new ArrayList<>();
        randomScenarioResults = new ArrayList<>();
        randomRepeatedScenarioResults = new ArrayList<>();
    }

    public void init() {
        Integer[] arrayWithNonRepeatingRandomNumbers = generateRandomNonRepeatingArray(scenarioN);
        Integer[] arrayWithRepeatingRandomNumbers = generateRandomRepeatingArray(scenarioN);

        Integer[] ascendantScenarioArray = arrayWithNonRepeatingRandomNumbers.clone();
        Arrays.sort(ascendantScenarioArray); // O array é colocado em forma ascendente para a ordenação

        Integer[] descendantScenarioArray = arrayWithNonRepeatingRandomNumbers.clone();
        Arrays.sort(descendantScenarioArray, Collections.reverseOrder()); // O array é colocado em forma descendente para a ordenação

        Integer[] randomScenarioArray = arrayWithNonRepeatingRandomNumbers.clone(); // Ver descrição do método "generateRandomNonRepeatingArray"

        Integer[] randomRepeatingScenarioArray = arrayWithRepeatingRandomNumbers.clone(); // Ver descrição do método "generateRandomRepeatingArray"

        for (int i = 0; i < 10; i++) {
            ascendantScenarioResults.add(sortScenario(ascendantScenarioArray));
            descendantScenarioResults.add(sortScenario(descendantScenarioArray));
            randomScenarioResults.add(sortScenario(randomScenarioArray));
            randomRepeatedScenarioResults.add(sortScenario(randomRepeatingScenarioArray));
        }
    }

    // Gera um array com valores distintos não repetidos com tamanho "n"
    private static Integer[] generateRandomNonRepeatingArray(int scenarioN) {
        HashSet<Integer> integerSet = new HashSet<>();

        while (integerSet.size() < scenarioN) {
            int random;
            do {
                random = new Random().nextInt();
            } while (integerSet.contains(random));
            integerSet.add(random);
        }

        Object[] object = integerSet.toArray();
        Integer[] result = new Integer[object.length];

        for(int i = 0; i < object.length; i++) {
            result[i] = (Integer)object[i];
        }

        return result;
    }

    // Gera um array com valores repeatido a uma proporção (inteira) de 5% do tamanho de "n"
    // tendo o length de "n"
    private static Integer[] generateRandomRepeatingArray(int scenarioN) {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        int timesRepeating = (int)(scenarioN * 0.05);

        while (integerArrayList.size() < scenarioN) {
            int random;
            do {
                random = new Random().nextInt();
            } while (integerArrayList.contains(random));
            for (int i = 0; i < timesRepeating && integerArrayList.size() < scenarioN; i++) {
                integerArrayList.add(random);
            }
        }

        Collections.shuffle(integerArrayList);

        Object[] object = integerArrayList.toArray();
        Integer[] result = new Integer[object.length];

        for (int j = 0; j < object.length; j++) {
            result[j] = (Integer)object[j];
        }

        return result;
    }

    private long sortScenario(Integer[] scenarioRelatedArray) {
        if (this.selectedAlgorithm instanceof BubbleSort) {
            return runBubbleSort(scenarioRelatedArray);
        }
        else if (this.selectedAlgorithm instanceof InsertionSort) {
            return runInsertionSort(scenarioRelatedArray);
        }
        else if (this.selectedAlgorithm instanceof  SelectionSort) {
            return runSelectionSort(scenarioRelatedArray);
        }
        else if (this.selectedAlgorithm instanceof HeapSort) {
            return runHeapSort(scenarioRelatedArray);
        }
        else if (this.selectedAlgorithm instanceof ShellSort) {
            return runShellSort(scenarioRelatedArray);
        }
        return 0;
    }

    private long runBubbleSort(Integer[] arr) {
        long start = System.nanoTime();
        ((BubbleSort) this.selectedAlgorithm).bubbleSort(arr);
        long end = System.nanoTime() - start;
        return end;
    }

    private long runInsertionSort(Integer[] arr) {
        long start = System.nanoTime();
        ((InsertionSort) this.selectedAlgorithm).insertionSort(arr);
        long end = System.nanoTime() - start;
        return end;
    }

    private long runSelectionSort(Integer[] arr) {
        long start = System.nanoTime();
        ((SelectionSort) this.selectedAlgorithm).selectionSort(arr);
        long end = System.nanoTime() - start;
        return end;
    }

    private long runHeapSort(Integer[] arr) {
        long start = System.nanoTime();
        ((HeapSort) this.selectedAlgorithm).heapSort(arr);
        long end = System.nanoTime() - start;
        return end;
    }

    private long runShellSort(Integer[] arr) {
        long start = System.nanoTime();
        ((ShellSort) this.selectedAlgorithm).shellSort(arr);
        long end = System.nanoTime() - start;
        return end;
    }

    public String generateResults() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("\nValor do \"n\": %d\n", this.scenarioN));
        stringBuilder.append("\n---ASCENDENTE---\n");
        stringBuilder.append(String.format("Média: %.3f\n", calculateAverageRate(ascendantScenarioResults)));
        stringBuilder.append(String.format("Variância: %.3f\n", calculateVarianceRate(ascendantScenarioResults)));
        stringBuilder.append(String.format("Desvio Padrão: %.3f\n", calculateStandardDeviation(ascendantScenarioResults)));
        stringBuilder.append(String.format("Média final: %.3f\n", calculateFinalAvarageRate(ascendantScenarioResults)));
        stringBuilder.append("\n---DESCENDENTE---\n");
        stringBuilder.append(String.format("Média: %.3f\n", calculateAverageRate(descendantScenarioResults)));
        stringBuilder.append(String.format("Variância: %.3f\n", calculateVarianceRate(descendantScenarioResults)));
        stringBuilder.append(String.format("Desvio Padrão: %.3f\n", calculateStandardDeviation(descendantScenarioResults)));
        stringBuilder.append(String.format("Média final: %.3f\n", calculateFinalAvarageRate(descendantScenarioResults)));
        stringBuilder.append("\n---RANDÔMICOS---\n");
        stringBuilder.append(String.format("Média: %.3f\n", calculateAverageRate(randomScenarioResults)));
        stringBuilder.append(String.format("Variância: %.3f\n", calculateVarianceRate(randomScenarioResults)));
        stringBuilder.append(String.format("Desvio Padrão: %.3f\n", calculateStandardDeviation(randomScenarioResults)));
        stringBuilder.append(String.format("Média final: %.3f\n", calculateFinalAvarageRate(randomScenarioResults)));
        stringBuilder.append("\n---RANDÔMICOS REPETIDOS---\n");
        stringBuilder.append(String.format("Média: %.3f\n", calculateAverageRate(randomRepeatedScenarioResults)));
        stringBuilder.append(String.format("Variância: %.3f\n", calculateVarianceRate(randomRepeatedScenarioResults)));
        stringBuilder.append(String.format("Desvio Padrão: %.3f\n", calculateStandardDeviation(randomRepeatedScenarioResults)));
        stringBuilder.append(String.format("Média final: %.3f\n", calculateFinalAvarageRate(randomRepeatedScenarioResults)));
        return stringBuilder.toString();
    }

    private double calculateAverageRate(ArrayList<Long> scenarioResult) {
        double tmp = scenarioResult.stream().reduce(0L, (accumulator, actual) -> accumulator + actual);
        return tmp/scenarioResult.size();
    }

    private double calculateVarianceRate(ArrayList<Long> scenarioResult) {
        int nMinusOne = scenarioResult.size() - 1;
        double averageRate = calculateAverageRate(scenarioResult);
        double sum = 0;

        for(long result: scenarioResult) {
            sum += Math.pow(result - averageRate, 2);
        }

        return sum/nMinusOne;
    }

    private double calculateStandardDeviation(ArrayList<Long> scenarioResult) {
        return Math.sqrt(calculateVarianceRate(scenarioResult));
    }

    private double calculateFinalAvarageRate(ArrayList<Long> scenarioResult) {
        ArrayList<Long> resultArr = new ArrayList<>();
        double AverageRateMinusStandardDeviation = calculateAverageRate(scenarioResult) - calculateStandardDeviation(scenarioResult);
        double AverageRatePlusStandardDeviation = calculateAverageRate(scenarioResult) + calculateStandardDeviation(scenarioResult);
        double sum = 0;

        scenarioResult.stream()
                .filter(el -> el >= AverageRateMinusStandardDeviation && el <= AverageRatePlusStandardDeviation)
                .forEach(el -> resultArr.add(el));

        sum = resultArr.stream()
                .reduce(0L, (accumulator, actual) -> accumulator + actual);

        return sum/resultArr.size();
    }
}