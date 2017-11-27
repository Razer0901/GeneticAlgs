package first;

public class Main {
    // 4, 5, 0.285
    // 5, 6, 0.27

    public static int mutateRange = 5, popSize = 5;
    public static double mutateChance = 0.285;

    public static void main(String[] args) {
        for (int j = 0; j < 50; j++) {
            run("Hello, World!");
        }

    }

    public static long run(String target){
        int count = 100000;
        long time = 0;
        long sum = 0;

        Population population = null;

        for (int i = 0; i < count; i++) {
//            first.Population genPop = new first.Population(target, first.Main.popSize);
//            sum += genPop.generation();

            population = new Population(target, Main.popSize);
            long startTime = System.nanoTime();
            population.generation();
            time += System.nanoTime() - startTime;
        }
        System.out.println(population);

        System.out.println("AvgTime: " + time/count + "ns AvgGens: "+ sum/count);
        return time/count;
    }

}