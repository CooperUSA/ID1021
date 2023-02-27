package Uppgift9;

public class Main {
    public static void main(String[] args) {
        int loop = 1;
        int size = 52000;
        int mod = 12345;

        Zip data = new Zip("C:/Users/Samuel Sendek/Desktop/Skola/År2Per1/ID1021 Algoritmer och datastruktur/Uppgifter/Uppgift9/postnummer.csv");
        ZipBucket buckets = new ZipBucket(mod, "C:/Users/Samuel Sendek/Desktop/Skola/År2Per1/ID1021 Algoritmer och datastruktur/Uppgifter/Uppgift9/postnummer.csv");
        ZipCopy dataCopy = new ZipCopy(size, mod, "C:/Users/Samuel Sendek/Desktop/Skola/År2Per1/ID1021 Algoritmer och datastruktur/Uppgifter/Uppgift9/postnummer.csv");
        System.out.println("Double array. Steps from hash index: " + buckets.lookup(93733));
        System.out.println("Single array. Steps from hash index: " + dataCopy.lookup(93733));

        data.collisions(12345);
        //dataCopy.print();
        /* Benchmark for first task
        // long t0 = System.nanoTime();
        // for(int i = 0; i < loop; i++){
        //     data.lookup(11115);
        // }
        // long lTime1 = (System.nanoTime() - t0)/loop;

        // t0 = System.nanoTime();
        // for(int i = 0; i < loop; i++){
        //     data.lookup(99499);
        // }
        // long lTime2 = (System.nanoTime() - t0)/loop;

        // System.out.println("Integer binary lookup runtime for 115 15: " + lTime1 + " ns");
        // System.out.println("Integer binary lookup runtime for 994 99: " + lTime2 + " ns");
         */
    }
}
