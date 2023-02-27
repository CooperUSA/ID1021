import java.util.*;

public class Task2 {
    public static void main(String[] args) { 
        int n = 2000;
        int loops = 10; 
        double average = 0;

        for(int i=0; i < loops; i++){
            average += access(n);
        }
        average = average/loops;
        System.out.println("Average time to find random keys: " + average + " ns.");
    }

    private static double access(int n) {
        int k = 100;
        int m = 10000;
        long t_total = 0;

        Random rnd = new Random();

        int[] keys = new int[m];
        int[] array = new int[n];
        for (int j = 0; j < k; j++) {
            // fill the keys array with random number from 0 to 10*n
            for (int i = 0; i < m; i++){
                keys[i] = rnd.nextInt(10*n);
            }
            // fill the array with with random number from 0 to 10*n
            for (int i = 0; i < n; i++){
                array[i] = rnd.nextInt(10*n);
            }

            int sum = 0;
            long t0 = System.nanoTime();
                for (int ki = 0; ki < m; ki++) {
                int key = keys[ki];
                    for (int i = 0; i < n ; i++) {
                        if (array[i] == key) {
                        sum++;
                        break;
                    }
                }
            }
            t_total += (System.nanoTime() - t0);
        }
        return ((double)(t_total))/((double)k*(double)m);
    }
}
