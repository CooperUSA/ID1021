import java.util.*;

public class Task3 {
    public static void main(String[] args) { 
        int n = 40000;
        int loops = 10; 
        double average = 0;
        double min = Integer.MAX_VALUE;
        double current = 0;

        for(int i=0; i < loops; i++){
            current = access(n);

            if(current < min){
                min = current;
            }
            average += current;
              
        }
        average = average/loops;
        System.out.println("Average time to find random keys: " + average + " ns.");
        System.out.println("Minimum time to find random keys: " + min + " ns.");
    }

    private static double access(int n) {
        int k = 100;
        long t_total = 0;

        Random rnd = new Random();

        int[] keys = new int[n];
        int[] array = new int[n];
        for (int j = 0; j < k; j++) {
            for (int i = 0; i < n; i++){
                keys[i] = rnd.nextInt(10*n);
            }
            for (int i = 0; i < n; i++){
                array[i] = rnd.nextInt(10*n);
            }

            int sum = 0;
            long t0 = System.nanoTime();
            for (int ki = 0; ki < n; ki++) {
            int key = keys[ki];
                for (int i = 0; i < n ; i++) {
                    if (array[i] == key) {
                        sum++;
                    }
                }
            }
            t_total += (System.nanoTime() - t0);
        }
        return ((double)(t_total)/(double)k);
    }
}

