package first.original;

public class OrigMain {
    public static void main(String[] args) {
        int count = 10000;
        long time = 0;
        double sum = 0;

        for (int i = 0; i < count; i++) {
            OrigPopulation population = new OrigPopulation("", 20);

            long startTime = System.nanoTime();
            population.generation();
            time += System.nanoTime() - startTime;

            sum += population.generation();
        }
        System.out.println("TIME PER RUN: " + time/count);
        System.out.println("GEN COUNT:  " + sum/count);
    }

}